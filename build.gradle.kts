
buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath (com.marvel.buildScript.BuildPlugins.androidGradlePlugin)
        classpath (com.marvel.buildScript.BuildPlugins.kotlinGradlePlugin)
        classpath (com.marvel.buildScript.BuildPlugins.navGradlePlugin)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()

    }
}

tasks.register("clean").configure {
    delete("build")
}