# Automa

Application Android de widgets personnalisables pour regrouper les informations utiles directement sur l’écran d’accueil.

> **État du projet :** en développement. Les fonctionnalités disponibles dépendent de la version du code et de l’APK installé. Les intégrations Santé Connect et montres connectées doivent être considérées comme expérimentales tant qu’une version publiée n’a pas été compilée et testée sur un appareil.

[![GitHub repo](https://img.shields.io/badge/GitHub-dartist--fr%2Fautoma-181717?logo=github)](https://github.com/dartist-fr/automa)
[![Issues](https://img.shields.io/github/issues/dartist-fr/automa)](https://github.com/dartist-fr/automa/issues)
[![License](https://img.shields.io/github/license/dartist-fr/automa)](https://github.com/dartist-fr/automa)

## Sommaire

- [Présentation](#-présentation)
- [Fonctionnalités](#-fonctionnalités)
- [Téléchargement](#-téléchargement)
- [Installation Android](#-installation-android)
- [Compiler depuis les sources](#-compiler-depuis-les-sources)
- [Widgets et personnalisation](#-widgets-et-personnalisation)
- [Santé Connect et montres connectées](#-santé-connect-et-montres-connectées)
- [Confidentialité et permissions](#-confidentialité-et-permissions)
- [Dépannage](#-dépannage)
- [Signaler un bug ou proposer une idée](#-signaler-un-bug-ou-proposer-une-idée)
- [Contribuer](#-contribuer)
- [Licence](#-licence)

## 📱 Présentation

Automa est un projet Android qui vise à proposer un catalogue de widgets pour personnaliser l’écran d’accueil : affichage de l’heure, de la date, de la batterie et d’autres informations utiles, avec une présentation visuelle configurable.

L’objectif est de développer progressivement davantage de types de widgets et de réglages visuels, ainsi que des intégrations avec les données de santé et les appareils connectés compatibles.

## ✨ Fonctionnalités

### Widgets actuellement présents dans l’interface

- **Horloge numérique**
- **Calendrier / date**
- **Horloge analogique**
- **Batterie**
- Catalogue de modèles à ajouter à l’écran d’accueil
- Personnalisation visuelle déjà proposée par l’application, notamment les couleurs, la transparence, l’arrondi et l’effet « verre »

La disponibilité réelle de chaque option dépend de la version installée. Consultez les [versions publiées](https://github.com/dartist-fr/automa/releases) pour savoir ce qui a effectivement été livré.

### Évolutions envisagées

Ces éléments ne doivent pas être considérés comme disponibles tant qu’ils ne figurent pas dans une version publiée et testée :

- Choix de typographies et réglage fin de la taille du texte
- Catalogue enrichi de widgets (météo, tâches, agenda, minuteur, stockage et autres informations système)
- Widgets alimentés par les données Santé Connect
- Informations compatibles provenant de montres connectées et d’autres appareils

## ⬇️ Téléchargement

- **[Voir les versions et téléchargements disponibles](https://github.com/dartist-fr/automa/releases)**
- [Télécharger les sources ZIP](https://github.com/dartist-fr/automa/archive/refs/heads/main.zip)
- [Parcourir le code source](https://github.com/dartist-fr/automa)
- [Consulter les problèmes connus et signaler un bug](https://github.com/dartist-fr/automa/issues)

**À propos de l’APK :** un lien vers la page Releases est fourni ci-dessus. Si aucune version avec un fichier `.apk` n’y est publiée, cela signifie qu’aucun APK officiel n’est disponible au téléchargement depuis les Releases à ce moment-là. Ne considérez pas l’archive des sources ZIP comme une application installable.

## 📲 Installation Android

Si un APK est disponible dans la section [Releases](https://github.com/dartist-fr/automa/releases) :

1. Téléchargez le fichier APK depuis une version publiée du dépôt.
2. Sur votre téléphone Android, ouvrez le fichier téléchargé.
3. Si Android le demande, autorisez temporairement l’installation depuis cette source dans les paramètres affichés.
4. Confirmez l’installation, puis ouvrez Automa.
5. Pour placer un widget sur l’écran d’accueil, ouvrez le catalogue de widgets de l’application et suivez les instructions affichées.

**Conseil de sécurité :** installez de préférence les APK provenant des Releases de ce dépôt. Android peut afficher un avertissement pour une application installée hors du Play Store. N’installez pas un APK dont vous ne connaissez pas la provenance.

## 🛠️ Compiler depuis les sources

Les instructions ci-dessous correspondent à un projet Android Gradle classique. Les noms des modules et les versions des outils peuvent varier selon l’état du dépôt.

### Prérequis

- Un ordinateur Windows, macOS ou Linux
- [Android Studio](https://developer.android.com/studio)
- Le SDK Android requis par le projet
- [Git](https://git-scm.com/downloads), facultatif si vous téléchargez directement l’archive ZIP

### 1. Récupérer le code

Avec Git :

```bash
git clone https://github.com/dartist-fr/automa.git
cd automa
```

Ou téléchargez l’[archive ZIP du dépôt](https://github.com/dartist-fr/automa/archive/refs/heads/main.zip), puis extrayez-la.

### 2. Ouvrir le projet

1. Lancez Android Studio.
2. Choisissez **Open** et sélectionnez le dossier du projet.
3. Attendez la synchronisation Gradle.
4. Installez les composants du SDK Android si Android Studio le demande.

### 3. Générer un APK de test

Dans Android Studio, utilisez **Build → Build Bundle(s) / APK(s) → Build APK(s)** (le libellé exact peut varier selon la version).

Après une compilation réussie, Android Studio affiche un lien vers le fichier généré. Pour un projet Android standard, l’APK de débogage se trouve souvent sous :

```text
app/build/outputs/apk/debug/app-debug.apk
```

Ce chemin est indicatif : vérifiez l’emplacement annoncé par Android Studio. Un APK de débogage est destiné aux essais et n’équivaut pas à une version de production signée pour distribution.

### 4. Installer sur un téléphone

- Transférez l’APK de test sur le téléphone, puis ouvrez-le, ou
- Connectez le téléphone en USB, activez les options développeur et le débogage USB, puis lancez l’application depuis Android Studio.

En cas d’échec de synchronisation, vérifiez la connexion Internet, la version de JDK utilisée par Gradle et les versions du SDK demandées par le projet.

## 🎨 Widgets et personnalisation

Le catalogue présente les modèles de widgets disponibles dans l’application. La personnalisation visible dépend du modèle et de la version installée.

Les axes d’amélioration prévus comprennent :

- Taille du texte ajustable
- Différentes polices de caractères
- Couleurs et arrière-plans personnalisés
- Transparence, coins arrondis et effets visuels
- Formats et tailles de widgets variés

Une option mentionnée dans cette liste n’est pas une garantie qu’elle soit déjà implémentée : consultez les notes de version et les issues pour connaître l’état actuel.

## ❤️ Santé Connect et montres connectées

[Health Connect](https://health.google/health-connect-android/) est la plateforme Android qui permet, avec l’autorisation de l’utilisateur, de partager des données de santé et de forme physique entre applications compatibles.

Le projet vise à exploiter ces données pour proposer des widgets dédiés, par exemple les pas, la distance, les calories, la fréquence cardiaque et le sommeil. La disponibilité de chaque donnée dépend des applications sources, des appareils utilisés, des autorisations accordées et de la mise en œuvre dans la version installée.

- [Présentation officielle de Health Connect](https://health.google/health-connect-android/)
- [Documentation développeur Android — Health Connect](https://developer.android.com/health-and-fitness/guides/health-connect)
- [Types de données pris en charge](https://developer.android.com/health-and-fitness/guides/health-connect/data-types)

**Important :** la présence d’un écran ou de code d’intégration ne garantit pas que la synchronisation fonctionne sur tous les appareils. L’intégration doit être compilée, testée et autorisée sur le téléphone avant de pouvoir être annoncée comme opérationnelle. Une montre ou des écouteurs ne fournissent pas automatiquement toutes leurs données à Automa : il faut qu’une application compatible les transmette à une source accessible, ou qu’une intégration spécifique soit développée.

## 🔐 Confidentialité et permissions

Les données de santé sont particulièrement sensibles. Avant d’accorder une autorisation :

- Vérifiez quelles données l’application demande et pourquoi.
- N’accordez que les permissions nécessaires aux fonctionnalités que vous utilisez.
- Consultez les informations de confidentialité des applications qui transmettent les données à Health Connect.
- Retirez les autorisations inutilisées dans les paramètres de Health Connect.

Automa ne doit être présenté comme ne transmettant aucune donnée à un serveur que si cela a été vérifié dans le code et dans les échanges réseau de la version concernée. Ce README ne constitue pas une certification de sécurité ni une garantie d’absence de collecte.

## 🧰 Dépannage

### L’APK ne s’installe pas

- Vérifiez que l’APK est compatible avec votre version d’Android.
- Si une version plus ancienne est installée, une signature différente peut empêcher la mise à jour. Sauvegardez vos données avant toute désinstallation.
- Téléchargez de nouveau le fichier depuis la page officielle des [Releases](https://github.com/dartist-fr/automa/releases).

### Android Studio ne synchronise pas Gradle

- Vérifiez la connexion Internet.
- Acceptez l’installation des composants SDK demandés.
- Consultez la fenêtre **Build** pour lire l’erreur complète.
- Utilisez une version de JDK compatible avec le Gradle Wrapper du projet.

### Un widget ne s’actualise pas ou n’affiche aucune donnée

- Vérifiez que l’application dispose des permissions nécessaires.
- Pour les données de santé, vérifiez les autorisations accordées dans Health Connect et qu’une application compatible y écrit effectivement des données.
- Certains fabricants limitent l’activité en arrière-plan : vérifiez les paramètres de batterie du téléphone.
- Reproduisez le problème et joignez la version d’Automa, le modèle du téléphone et la version Android à votre rapport.

## 🐛 Signaler un bug ou proposer une idée

Avant de créer un rapport, vérifiez que le problème n’a pas déjà été signalé :

- [Consulter les issues ouvertes](https://github.com/dartist-fr/automa/issues)
- [Créer une nouvelle issue](https://github.com/dartist-fr/automa/issues/new)

Pour faciliter le diagnostic, indiquez :

- La version d’Automa
- Le modèle du téléphone et la version Android
- Les étapes pour reproduire le problème
- Le résultat attendu et le résultat observé
- Des captures d’écran ou des journaux expurgés de toute donnée personnelle

Ne publiez jamais de données de santé, de mots de passe, de jetons d’accès ou d’autres informations privées dans une issue publique.

## 🤝 Contribuer

Les contributions sont les bienvenues.

1. Forkez le dépôt.
2. Créez une branche dédiée à votre modification.
3. Faites des changements ciblés et testez-les sur un appareil ou un émulateur.
4. Décrivez clairement les changements et les tests réalisés.
5. Ouvrez une Pull Request vers le dépôt principal.

Pour une nouvelle fonctionnalité, ouvrez d’abord une issue afin de discuter de son utilité et de son approche. Pour toute modification liée à la santé, demandez uniquement les permissions strictement nécessaires et documentez les limites de la fonctionnalité.

## 📄 Licence

Consultez le fichier [LICENSE](https://github.com/dartist-fr/automa/blob/main/LICENSE) ou [LICENSE.txt](https://github.com/dartist-fr/automa/blob/main/LICENSE.txt) s’il existe dans le dépôt. Si aucun fichier de licence n’est présent, les conditions de réutilisation du code ne sont pas clairement définies : contactez le propriétaire avant de redistribuer ou de réutiliser le projet.

---

**Liens utiles :** [Dépôt GitHub](https://github.com/dartist-fr/automa) · [Releases](https://github.com/dartist-fr/automa/releases) · [Issues](https://github.com/dartist-fr/automa/issues) · [Archive ZIP](https://github.com/dartist-fr/automa/archive/refs/heads/main.zip)
