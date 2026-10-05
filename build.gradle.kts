// Top-level build file.
//
// Kotlin compilation is provided by AGP 9's *built-in Kotlin* support, so the
// `org.jetbrains.kotlin.android` plugin is intentionally NOT applied anywhere.
// AGP ships with an older Kotlin Gradle Plugin by default; the buildscript
// classpath below pins the Kotlin version used by the build (keep it in sync
// with `kotlin` in gradle/libs.versions.toml — the Compose compiler plugin
// version must always match the Kotlin version).
//
// Reference: https://developer.android.com/build/releases/agp-9-0-0-release-notes#runtime-dependency-on-kotlin-gradle-plugin
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.4.20")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
}
