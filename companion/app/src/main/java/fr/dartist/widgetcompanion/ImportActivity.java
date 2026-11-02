package fr.dartist.widgetcompanion;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;

public class ImportActivity extends Activity {
    private String configJson;
    private String widgetName = "Widget Dartist";

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        handleIntent(getIntent());
        showScreen();
    }

    @Override protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
        showScreen();
    }

    private void handleIntent(Intent intent) {
        try {
            String raw = null;
            if (Intent.ACTION_VIEW.equals(intent.getAction())) {
                Uri uri = intent.getData();
                if (uri != null) {
                    String encoded = uri.getQueryParameter("data");
                    if (encoded != null) raw = new String(Base64.decode(encoded, Base64.URL_SAFE | Base64.NO_WRAP), StandardCharsets.UTF_8);
                }
            } else if (Intent.ACTION_SEND.equals(intent.getAction())) {
                Object extra = intent.getParcelableExtra(Intent.EXTRA_STREAM);
                if (extra instanceof Uri) {
                    try (java.io.InputStream in = getContentResolver().openInputStream((Uri) extra)) {
                        if (in != null) raw = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                    }
                }
                if (raw == null) raw = intent.getStringExtra(Intent.EXTRA_TEXT);
            }
            if (raw != null) {
                JSONObject obj = new JSONObject(raw);
                if (!"dartist-widget-v1".equals(obj.optString("schema"))) throw new Exception("Format de configuration non reconnu");
                configJson = obj.toString();
                widgetName = obj.optJSONObject("model") == null ? "Widget Dartist" : obj.optJSONObject("model").optString("name", "Widget Dartist");
                getSharedPreferences("dartist_widgets", MODE_PRIVATE).edit().putString("pending_config", configJson).apply();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Configuration impossible à importer : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        if (configJson == null) configJson = getSharedPreferences("dartist_widgets", MODE_PRIVATE).getString("pending_config", null);
    }

    private void showScreen() {
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(48, 64, 48, 48);
        root.setBackgroundColor(0xFF10151B);
        TextView title = new TextView(this);
        title.setText("Dartist Widgets");
        title.setTextColor(0xFFFFFFFF);
        title.setTextSize(26);
        root.addView(title);
        TextView info = new TextView(this);
        info.setText(configJson == null ? "Ouvre une configuration depuis le Studio Widgets." : "Configuration reçue : " + widgetName + "\n\nTu peux maintenant demander à Android de placer le widget sur ton écran d’accueil.");
        info.setTextColor(0xFFD0D7DE);
        info.setTextSize(16);
        info.setPadding(0, 32, 0, 32);
        root.addView(info);
        Button add = new Button(this);
        add.setText("Ajouter à l’écran d’accueil");
        add.setEnabled(configJson != null);
        add.setOnClickListener(v -> pinWidget());
        root.addView(add);
        setContentView(root);
    }

    private void pinWidget() {
        AppWidgetManager manager = getSystemService(AppWidgetManager.class);
        ComponentName provider = new ComponentName(this, DartistWidgetProvider.class);
        if (Build.VERSION.SDK_INT >= 26 && manager.isRequestPinAppWidgetSupported()) {
            manager.requestPinAppWidget(provider, null, null);
            Toast.makeText(this, "Valide la demande affichée par Android.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Ton lanceur Android ne prend pas en charge l’ajout direct. Ajoute le widget Dartist depuis le sélecteur de widgets.", Toast.LENGTH_LONG).show();
        }
    }
}
