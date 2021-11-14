// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url = "https://jitpack.io")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("io.insert-koin:koin-gradle-plugin:2.2.3")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}