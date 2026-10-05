# Chat

An Android chat app — Kotlin, Jetpack Compose and Material 3.

> **Status: scaffold milestone.** The project builds and runs; the chat UI
> (conversation list, message bubbles, composer) lands next.

## Stack

| Piece | Version |
| --- | --- |
| Kotlin | 2.4.20 |
| Jetpack Compose | BOM 2026.09.00 |
| Android Gradle Plugin | 9.3.3 (built-in Kotlin) |
| Gradle | 9.6.0 |
| AndroidX Core | 1.19.0 |
| Lifecycle | 2.11.0 |
| Activity Compose | 1.13.0 |
| compileSdk / targetSdk | 37 |
| minSdk | 24 (Android 7.0) |
| JDK | 17+ (toolchain target is 17) |

Kotlin compilation uses AGP 9's **built-in Kotlin** support, so the
`org.jetbrains.kotlin.android` plugin is not applied anywhere. The Kotlin
version is pinned on the root buildscript classpath, and the Compose compiler
plugin tracks the same version.

## Requirements

- **Android Studio Quail 3 (2026.1.3) or newer** — AGP 9.3 requires it.
- JDK 17 or newer (Android Studio's bundled JDK is fine).
- Android SDK Platform 37 + Build Tools 36.0.0.

## Build & run

```bash
./gradlew assembleDebug        # build the debug APK
./gradlew installDebug         # install on a connected device/emulator
open -a "Android Studio" .     # or just File ▸ Open the project folder
```

The debug APK lands in `app/build/outputs/apk/debug/`.

## Project layout

```
app/src/main/java/com/asandroiddeveloper/chat/
├── MainActivity.kt              # single-activity entry point (edge-to-edge)
└── ui/
    ├── HomeScreen.kt            # placeholder scaffold screen + Compose previews
    └── theme/                   # brand palette, Material 3 colour schemes, typography
```

## Continuous integration

`.github/workflows/android.yml` runs on every push and pull request:

1. sets up JDK 21 + the Android SDK (platform 37, build-tools 36.0.0),
2. prints the latest published AndroidX versions for reference,
3. runs `./gradlew assembleDebug`,
4. uploads the debug APK as a build artifact.

## Roadmap

- [x] Project scaffold: Compose, Material 3 theme, launcher icon, CI
- [ ] Conversation list with search
- [ ] Chat thread: message bubbles, timestamps, delivery states
- [ ] Composer: text input, send, attachments, emoji
- [ ] Attachments & image messages
- [ ] Data layer (local persistence + networking)
