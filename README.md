# Chat

An Android chat app — Kotlin, Jetpack Compose and Material 3.

[![Android CI](https://github.com/asandroiddeveloper/chat/actions/workflows/android.yml/badge.svg)](https://github.com/asandroiddeveloper/chat/actions/workflows/android.yml)

> **Status: scaffold milestone.** The project builds and the CI produces a
> working debug APK. The chat UI itself (conversation list, message bubbles,
> composer) is the next milestone.

## Stack

| Piece | Version |
| --- | --- |
| Kotlin | 2.4.20 |
| Jetpack Compose | BOM 2026.09.00 |
| Android Gradle Plugin | 9.4.1 (built-in Kotlin) |
| Gradle | 9.6.0 |
| AndroidX Core | 1.19.1 |
| Lifecycle | 2.11.0 |
| Activity Compose | 1.13.0 |
| compileSdk / targetSdk | 37 (Android 17) |
| minSdk | 24 (Android 7.0) |
| JDK | 17+ (compilation targets JVM 17) |

Kotlin compilation uses AGP 9's **built-in Kotlin** support, so the
`org.jetbrains.kotlin.android` plugin is not applied anywhere. The Kotlin
version is pinned on the root buildscript classpath, and the Compose compiler
plugin tracks that same version.

## Requirements

- **Android Studio Quail 4 (2026.1.4) or newer** — required by AGP 9.4.
- JDK 17 or newer (Android Studio's bundled JDK is fine).
- Android SDK Platform 37 + Build Tools 36.0.0 (installed automatically by the
  IDE/Gradle once the SDK licences are accepted).

## Build & run

```bash
./gradlew assembleDebug     # debug APK -> app/build/outputs/apk/debug/
./gradlew installDebug      # install on a connected device or emulator
```

Or open the folder in Android Studio and hit Run.

## Project layout

```
app/src/main/java/com/asandroiddeveloper/chat/
├── MainActivity.kt               # single-activity entry point (edge-to-edge)
└── ui/
    ├── HomeScreen.kt             # placeholder scaffold screen + Compose previews
    └── theme/                    # brand palette, Material 3 colour schemes, typography
```

`HomeScreen.kt` ships two `@Preview`s (light and dark) — open the file in
Android Studio's Design pane to see the scaffold screen.

## What has been verified

`.github/workflows/android.yml` runs on every push and pull request and:

1. installs JDK 21 and the Android SDK (platform 37, build-tools 36.0.0),
2. reports the latest published AndroidX/AGP versions for reference,
3. runs `./gradlew assembleDebug`,
4. uploads the debug APK as an artifact, and
5. dumps the APK's badging (package, label, launcher activity, SDK levels).

Latest run results: `com.asandroiddeveloper.chat`, version `0.1.0`,
`compileSdk 37`, `targetSdk 37`, label **Chat**, launcher activity
`MainActivity`.

## Roadmap

- [x] Project scaffold: Compose, Material 3 theme, launcher icon, CI
- [ ] Conversation list with search
- [ ] Chat thread: message bubbles, timestamps, delivery states
- [ ] Composer: text input, send, attachments, emoji
- [ ] Attachments & image messages
- [ ] Data layer (local persistence + networking)
