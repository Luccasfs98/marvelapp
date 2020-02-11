import com.marvel.buildScript.Version.MIN_SDK_VERSION

plugins {
    id(com.marvel.buildScript.BuildPlugins.androidApplication)
    id(com.marvel.buildScript.BuildPlugins.kotlinAndroid)
    id(com.marvel.buildScript.BuildPlugins.kotlinAndroidExtensions)
}


android {
    compileSdkVersion(com.marvel.buildScript.Version.COMPILE_SDK_VERSION)

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

    defaultConfig {
        minSdkVersion(MIN_SDK_VERSION)
    }
}

dependencies {


    api("androidx.lifecycle:lifecycle-extensions:2.2.0")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")

    implementation(com.marvel.buildScript.AndroidLibraries.APP_COMPAT_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.CORE_KTX_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.CONSTRAINT_LAYOUT_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.LIFECYCLE_ANDROID_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.MATERIAL_DESIGN_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.KOTLIN_COROUTINES_IMPL)
    implementation(com.marvel.buildScript.AndroidLibraries.PLAY_CORE_IMPL)
    implementation(com.marvel.buildScript.KotlinLibraries.KOTLIN_IMPL)

    implementation (com.marvel.buildScript.AndroidLibraries.NAVIGATION_FRAGMENT_IMPL)
    implementation (com.marvel.buildScript.AndroidLibraries.NAVIGATION_UI_IMPL)



    implementation(com.marvel.buildScript.Libraries.KOIN_IMPL)
    implementation(com.marvel.buildScript.Libraries.KOIN_ANDROID_SCOPE_IMPL)
    implementation(com.marvel.buildScript.Libraries.KOIN_ANDROID_VIEWMODEL_IMPL)
    implementation(com.marvel.buildScript.Libraries.RETROFIT_IMPL)
    implementation(com.marvel.buildScript.Libraries.RETROFIT_GSON_IMPL)
    implementation(com.marvel.buildScript.Libraries.LOGGING_INTERCEPTOR_IMPL)
    implementation(com.marvel.buildScript.Libraries.COIL_IMPL)
    implementation(com.marvel.buildScript.Libraries.LOTTIE_IMPL)
    implementation(com.marvel.buildScript.Libraries.STATUS_BAR_UTIL_IMPL)
    implementation(com.marvel.buildScript.Libraries.CIRCLE_IMAGE_VIEW_IMPL)

    testImplementation(com.marvel.buildScript.TestLibraries.junit4)

    implementation(project(com.marvel.buildScript.Modules.MODULE_COMMON))
    implementation(project(com.marvel.buildScript.Modules.MODULE_CORE))
    implementation(project(com.marvel.buildScript.Modules.MODULE_NAVIGATION))


}

