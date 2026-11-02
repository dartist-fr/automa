# Dartist Widget Companion

Application Android compagnon permettant de recevoir une configuration JSON exportée depuis le Studio Widgets et de demander au lanceur Android d’épingler un widget sur l’écran d’accueil.

## Build

Depuis ce dossier, avec JDK 17 et Android SDK 35 :

```bash
gradle assembleDebug
```

APK : `app/build/outputs/apk/debug/app-debug.apk`

Le workflow GitHub Actions construit automatiquement l’APK à chaque modification du dossier `companion/`. Le fichier est disponible dans les artefacts du workflow.

## Transfert depuis le site

Schéma profond : `dartistwidget://import?data=<base64url-json>`

Le JSON doit utiliser le schéma `dartist-widget-v1`. Android demande toujours une confirmation utilisateur pour épingler le widget. Le lanceur peut ne pas prendre en charge la fonction de pinning.
