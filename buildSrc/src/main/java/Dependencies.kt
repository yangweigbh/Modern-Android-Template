import Versions.hilter_version
import Versions.lifecycle_version
import Versions.nav_version
import Versions.retrofit_version
import Versions.viewmodel_hilter_version

object Versions {
    val kotlin = "1.3.72"
    val ktlint = "0.38.1"
    val detekt = "1.13.0"
    val spotless = "5.5.1"
    val nav_version = "2.3.0"
    val lifecycle_version = "2.2.0"
    val hilter_version = "2.28-alpha"
    val viewmodel_hilter_version = "1.0.0-alpha01"
    val retrofit_version = "2.9.0"
}

object Libs {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val androidx_core = "androidx.core:core-ktx:1.3.1"
    val appcompat = "androidx.appcompat:appcompat:1.2.0"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.1"
    val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:$nav_version"
    val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:$nav_version"
    val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    val hilt_android = "com.google.dagger:hilt-android:$hilter_version"
    val hilt_android_compiler = "com.google.dagger:hilt-android-compiler:$hilter_version"
    val hilt_lifecycle_viewmodel = "androidx.hilt:hilt-lifecycle-viewmodel:$viewmodel_hilter_version"
    val androidx_hilt_compiler = "androidx.hilt:hilt-compiler:$viewmodel_hilter_version"
    val retrofit = "com.squareup.retrofit2:retrofit:$retrofit_version"
}

object TestLibs {
    val junit = "junit:junit:4.12"
    val androidx_junit = "androidx.test.ext:junit:1.1.2"
    val androidx_espresso = "androidx.test.espresso:espresso-core:3.3.0"
}