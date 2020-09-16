// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("com.diffplug.spotless") version Versions.spotless
    id("io.gitlab.arturbosch.detekt") version Versions.detekt
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

spotless {
    format ("kotlin") {
        target("**/*.kt")
        (this as? com.diffplug.gradle.spotless.KotlinExtension)?.apply {
            ktlint(Versions.ktlint).userData(mapOf("max_line_length" to "100"))
        }
    }
}