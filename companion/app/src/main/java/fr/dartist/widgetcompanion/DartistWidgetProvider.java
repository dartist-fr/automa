package fr.dartist.widgetcompanion;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DartistWidgetProvider extends AppWidgetProvider {
    @Override public void onUpdate(Context context, AppWidgetManager manager, int[] ids) {
        for (int id : ids) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dartist_widget);
            String json = context.getSharedPreferences("dartist_widgets", Context.MODE_PRIVATE).getString("pending_config", null);
            String title = "DARTIST";
            try {
                if (json != null) {
                    org.json.JSONObject obj = new org.json.JSONObject(json);
                    org.json.JSONObject model = obj.optJSONObject("model");
                    if (model != null) title = model.optString("name", title).toUpperCase(Locale.ROOT);
                }
            } catch (Exception ignored) {}
            views.setTextViewText(R.id.widget_title, title);
            views.setTextViewText(R.id.widget_time, new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date()));
            views.setTextViewText(R.id.widget_date, new SimpleDateFormat("EEEE d MMMM", Locale.getDefault()).format(new Date()));
            manager.updateAppWidget(id, views);
        }
    }
}
