package com.marvel.buildScript

const val kotlinVersion = "1.3.21"

/**
 * id da Aplicação
 * */

object ApplicationId {

    val APPLICATION_ID = "com.marvel"
}


/**
 * Módulos da aplicação
 * */

object Modules {
    val MODULE_APP = ":app"
    val MODULE_COMMON = ":common"
    val MODULE_CORE = ":core"
    val FEATURE_HOME = ":featurehome"
    val FEATURE_DETAILS_CHARACTER = ":detailcharacter"
    val MODULE_NAVIGATION = ":navigation"
}

/**
 * Controlador de versionamento de builds
 * */
object Releases {

    val VERSION_CODE = 1
    val VERSION_NAME = "1.0"
}


/**
 * Versões das bibliotecas utilizadas pela aplicação
 * */

object Version {
    val KOTLIN_VERSION = "1.3.61"
    val GRADLE_VERSION = "3.5.3"
    val COMPILE_SDK_VERSION = 29
    val MIN_SDK_VERSION = 19
    val TARGET_SDK_VERSION = 29
    val APP_COMPAT_VERSION = "1.1.0"
    val CORE_KTX_VERSION = "1.1.0"
    val CONSTRAINT_LAYOUT_VERSION = "1.1.3"
    val KOIN_ANDROID_VERSION = "2.0.1"
    val KOIN_ANDROID_SCOPE_VERSION = "2.0.1"
    val KOIN_ANDROID_VIEWMODEL_VERSION = "2.0.1"
    val LOTTIE_VERSION = "3.3.1"
    val STATUS_BAR_UTIL_VERSION = "1.5.1"
    const val NAVIGATION_VERSION = "2.1.0"
    val CIRCLE_IMAGE_VIEW_VERSION = "3.0.1"
    val SHIMMER_VERSION = "0.5.0"

    val MATERIAL_VERSION = "1.2.0-alpha03"
    val RETROFIT_VERSION = "2.6.2"
    val LOGGING_INTERCEPTOR_VERSION = "4.2.1"
    val RETROFIT_GSON_VERSION = "2.6.2"
    val COROUTINES_VERSION = "1.3.3"
    val VIEWMODEL_KTX_VERSION = "2.2.0-rc03"
    val COIL_VERSION = "0.9.5"
    val PLAY_CORE_VERSION = "1.6.4"

    val JUNIT_VERSION = "4.12"
    val ANDROID_TEST_JUNIT_VERSION = "1.1.1"
    val ANDROID_TEST_ESPRESSO_VERSION = "3.2.0"
}

/**
 * Bibliotecas gerais utilizadas pela aplicação
 */
object Libraries {

    val KOIN_IMPL = "org.koin:koin-android:${Version.KOIN_ANDROID_VERSION}"
    val KOIN_ANDROID_SCOPE_IMPL =
        "org.koin:koin-android-scope:${Version.KOIN_ANDROID_SCOPE_VERSION}"
    val KOIN_ANDROID_VIEWMODEL_IMPL =
        "org.koin:koin-android-viewmodel:${Version.KOIN_ANDROID_VIEWMODEL_VERSION}"

    val RETROFIT_IMPL = "com.squareup.retrofit2:retrofit:${Version.RETROFIT_VERSION}"

    val LOGGING_INTERCEPTOR_IMPL =
        "com.squareup.okhttp3:logging-interceptor:${Version.LOGGING_INTERCEPTOR_VERSION}"


    val RETROFIT_GSON_IMPL =
        "com.squareup.retrofit2:converter-gson:${Version.RETROFIT_GSON_VERSION}"

    val COIL_IMPL = "io.coil-kt:coil:${Version.COIL_VERSION}"

    val LOTTIE_IMPL = "com.airbnb.android:lottie:${Version.LOTTIE_VERSION}"

    val STATUS_BAR_UTIL_IMPL = "com.jaeger.statusbarutil:library:${Version.STATUS_BAR_UTIL_VERSION}"
    val CIRCLE_IMAGE_VIEW_IMPL =
        "de.hdodenhof:circleimageview:${Version.CIRCLE_IMAGE_VIEW_VERSION}"

    val SHIMMER_IMPL =
        "com.facebook.shimmer:shimmer:${Version.SHIMMER_VERSION}"
}

/**
 * Bibliotecas utilizadas pelo kotlin
 * */
object KotlinLibraries {

    val KOTLIN_IMPL =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.KOTLIN_VERSION}"
}

/**
 * Biliotecas Android - Nativas
 * */

object AndroidLibraries {

    val KOTLIN_COROUTINES_IMPL =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.COROUTINES_VERSION}"

    val APP_COMPAT_IMPL = "androidx.appcompat:appcompat:${Version.APP_COMPAT_VERSION}"

    val CORE_KTX_IMPL = "androidx.core:core-ktx:${Version.CORE_KTX_VERSION}"

    val CONSTRAINT_LAYOUT_IMPL =
        "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT_VERSION}"

    val LIFECYCLE_ANDROID_IMPL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.VIEWMODEL_KTX_VERSION}"

    val MATERIAL_DESIGN_IMPL = "com.google.android.material:material:${Version.MATERIAL_VERSION}"

    val PLAY_CORE_IMPL = "com.google.android.play:core:${Version.PLAY_CORE_VERSION}"

    val NAVIGATION_FRAGMENT_IMPL =
        "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION_VERSION}"

    val NAVIGATION_UI_IMPL = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION_VERSION}"
}

/**
 * Bibliotecas de Testes
 *
 */

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.1.0-alpha4"
    }
    const val junit4     = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso   = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val JUNIT_IMPL = "junit:junit:${Version.JUNIT_VERSION}"

    val ANDROID_TEST_JUNIT_IMPL =
        "androidx.test.ext:junit:${Version.ANDROID_TEST_JUNIT_VERSION}"

    val ANDROID_TEST_ESPRESSO_IMPL =
        "androidx.test.espresso:espresso-core:${Version.ANDROID_TEST_ESPRESSO_VERSION}"

}


object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.3.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val navGradlePlugin ="androidx.navigation:navigation-safe-args-gradle-plugin:${Version.NAVIGATION_VERSION}"

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val dynamicFeature = "com.android.dynamic-feature"
    const val kapt = "kotlin-kapt"

}