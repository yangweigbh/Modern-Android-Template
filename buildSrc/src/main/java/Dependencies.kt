
object Versions {
    val kotlin = "1.4.0"
    val ktlint = "0.38.1"
    val detekt = "1.13.0"
    val spotless = "5.5.1"
    val navigationComponent = "2.3.0"
    val lifecycle = "2.2.0"
    val hilter = "2.28-alpha"
    val viewmodelHilter = "1.0.0-alpha01"
    val retrofit = "2.9.0"
    val compose = "1.0.0-alpha01"
    val androidGradlePlugin = "4.0.0"
    val hiltAndroidPlugin = "2.28-alpha"
}

object Libs {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val androidx_core = "androidx.core:core-ktx:1.3.1"
    val appcompat = "androidx.appcompat:appcompat:1.2.0"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.1"
    val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationComponent}"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:${Versions.navigationComponent}"
    val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val hilt_android = "com.google.dagger:hilt-android:${Versions.hilter}"
    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilter}"
    val hilt_lifecycle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.viewmodelHilter}"
    val androidx_hilt_compiler = "androidx.hilt:hilt-compiler:${Versions.viewmodelHilter}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val compose_runtime = "androidx.compose.runtime:runtime:${Versions.compose}"
    val compose_ui = "androidx.compose.ui:ui:${Versions.compose}"
    val compose_foundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    val compose_foundation_layout = "androidx.compose.foundation:foundation-layout:${Versions.compose}"
    val compose_material = "androidx.compose.material:material:${Versions.compose}"
    val compose_ui_viewbinding = "androidx.compose.ui:ui-viewbinding:${Versions.compose}"
    val compose_ui_tooling = "androidx.ui:ui-tooling:${Versions.compose}"
    val compose_runtime_livedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
}

object TestLibs {
    val junit = "junit:junit:4.12"
    val androidx_junit = "androidx.test.ext:junit:1.1.2"
    val androidx_espresso = "androidx.test.espresso:espresso-core:3.3.0"
}