plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.1")

    defaultConfig {
        applicationId = "com.github.yangweigbh.modern_android_template"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }

    composeOptions {
        kotlinCompilerVersion = Versions.kotlin
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.androidx_core)
    implementation(Libs.appcompat)
    implementation(Libs.constraintlayout)
    implementation(Libs.navigation_fragment_ktx)
    implementation(Libs.navigation_ui_ktx)
    implementation(Libs.lifecycle_viewmodel_ktx)
    implementation(Libs.lifecycle_livedata_ktx)
    implementation(Libs.hilt_android)
    implementation(Libs.hilt_lifecycle_viewmodel)
    implementation(Libs.retrofit)

    //Compose
    implementation(Libs.compose_runtime)
    implementation(Libs.compose_ui)
    implementation(Libs.compose_foundation)
    implementation(Libs.compose_foundation_layout)
    implementation(Libs.compose_material)
    implementation(Libs.compose_ui_viewbinding)
    implementation(Libs.compose_ui_tooling)
    implementation(Libs.compose_runtime_livedata)

    kapt(Libs.hilt_android_compiler)
    kapt(Libs.androidx_hilt_compiler)

    testImplementation(TestLibs.junit)

    androidTestImplementation(TestLibs.androidx_junit)
    androidTestImplementation(TestLibs.androidx_espresso)
}