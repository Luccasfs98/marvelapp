import com.marvel.buildScript.Version.MIN_SDK_VERSION
import com.marvel.buildScript.Version.TARGET_SDK_VERSION

plugins {
    id(com.marvel.buildScript.BuildPlugins.androidApplication)
    id(com.marvel.buildScript.BuildPlugins.kotlinAndroid)
    id(com.marvel.buildScript.BuildPlugins.kotlinAndroidExtensions)
}


android {
    compileSdkVersion(com.marvel.buildScript.Version.COMPILE_SDK_VERSION)

    dynamicFeatures = mutableSetOf(
        com.marvel.buildScript.Modules.FEATURE_DETAILS_CHARACTER
    )

    defaultConfig {
        minSdkVersion(MIN_SDK_VERSION)
        targetSdkVersion(TARGET_SDK_VERSION)
        versionCode
        versionCode = com.marvel.buildScript.Releases.VERSION_CODE
        versionName = com.marvel.buildScript.Releases.VERSION_NAME
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    dataBinding {
        isEnabled = true
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api ("androidx.legacy:legacy-support-v4:1.0.0")


    implementation(com.marvel.buildScript.AndroidLibraries.APP_COMPAT_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.CORE_KTX_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.CONSTRAINT_LAYOUT_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.LIFECYCLE_ANDROID_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.MATERIAL_DESIGN_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.KOTLIN_COROUTINES_IMPL)

    implementation (com.marvel.buildScript.AndroidLibraries.NAVIGATION_FRAGMENT_IMPL)
    implementation (com.marvel.buildScript.AndroidLibraries.NAVIGATION_UI_IMPL)

    implementation(com.marvel.buildScript.KotlinLibraries.KOTLIN_IMPL)


    implementation(com.marvel.buildScript.Libraries.KOIN_IMPL)
    implementation(com.marvel.buildScript.Libraries.KOIN_ANDROID_SCOPE_IMPL)
    implementation(com.marvel.buildScript.Libraries.KOIN_ANDROID_VIEWMODEL_IMPL)
    implementation(com.marvel.buildScript.Libraries.RETROFIT_IMPL)
    implementation(com.marvel.buildScript.Libraries.RETROFIT_GSON_IMPL)
    implementation(com.marvel.buildScript.Libraries.COIL_IMPL)
    implementation(com.marvel.buildScript.Libraries.LOTTIE_IMPL)
    implementation(com.marvel.buildScript.Libraries.STATUS_BAR_UTIL_IMPL)
    implementation(com.marvel.buildScript.Libraries.CIRCLE_IMAGE_VIEW_IMPL)
    implementation(com.marvel.buildScript.Libraries.SHIMMER_IMPL)

    testImplementation(com.marvel.buildScript.TestLibraries.junit4)
    testImplementation(com.marvel.buildScript.TestLibraries.espresso)
    testImplementation(com.marvel.buildScript.TestLibraries.testRunner)

    implementation(project(com.marvel.buildScript.Modules.MODULE_COMMON))
    implementation(project(com.marvel.buildScript.Modules.MODULE_CORE))
    implementation(project(com.marvel.buildScript.Modules.MODULE_NAVIGATION))

    testImplementation (com.marvel.buildScript.TestLibraries.JUNIT_IMPL)
    androidTestImplementation(com.marvel.buildScript.TestLibraries.ANDROID_TEST_JUNIT_IMPL)
    androidTestImplementation(com.marvel.buildScript.TestLibraries.ANDROID_TEST_ESPRESSO_IMPL)



}

