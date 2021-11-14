plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-android")

}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {
    implementation(Dependencies.androidCore + Versions.androidCore)
    implementation( Dependencies.androidCompat + Versions.androidCompat)
    implementation( Dependencies.androidMaterial + Versions.androidMaterial)

    implementation( Dependencies.constraintLayout + Versions.constraintLayout)

    implementation( Dependencies.jUnit + Versions.jUnit)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("com.google.assistant.appactions:suggestions:1.0.0-beta01")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // Kotlin
    implementation(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.KOTLIN_COROUTINES)

    //UI
    implementation(Dependencies.AndroidX.ACTIVITY_KTX)
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.AndroidX.FRAGMENT_KTX)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.RECYCLER_VIEW)
    implementation(Dependencies.AndroidX.SWIPE_REFRESH)
    implementation(Dependencies.AndroidX.GRID_LAYOUT)
    implementation(Dependencies.PROGRESS_BUTTON)

    implementation(Dependencies.VIEW_BINDING_DELEGATE)

    implementation(Dependencies.TIMBER)

    implementation(Dependencies.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Dependencies.LIFECYCLE_LIVE_DATA_KTX)
    implementation(Dependencies.LIFECYCLE_RUNTIME)

    implementation(Dependencies.NAVIGATION_UI_KTX)
    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.INSETTER)

    // Koin for Kotlin
    implementation ("io.insert-koin:koin-core:2.2.3")
    implementation ("io.insert-koin:koin-core-ext:2.2.3")
    implementation ("io.insert-koin:koin-androidx-scope:2.2.3")
    implementation ("io.insert-koin:koin-androidx-viewmodel:2.2.3")
    implementation ("io.insert-koin:koin-androidx-fragment:2.2.3")
    implementation ("io.insert-koin:koin-androidx-workmanager:2.2.3")
    implementation ("io.insert-koin:koin-androidx-ext:2.2.3")


    // Glide
    implementation(Dependencies.GLIDE)
    implementation(Dependencies.GLIDE_OKHTTP)
    kapt(Dependencies.GLIDE_COMPILER)

    // Network
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON)
    implementation(Dependencies.RETROFIT_SCALARS)
    implementation(Dependencies.GSON)
    implementation(Dependencies.NETWORK_RESPONSE)
    implementation(Dependencies.OKHTTP)
    implementation(Dependencies.OKHTTP_LOGGING_INTERCEPTOR)

    //Epoxy
    implementation(Dependencies.EPOXY)
    kapt(Dependencies.EPOXY_PROCESSOR)
    implementation(Dependencies.EPOXY_PAGING)

    //ROOM
    implementation(Dependencies.ROOM.KTX)
    implementation(Dependencies.ROOM.RUNTIME)
    kapt(Dependencies.ROOM.COMPILER)
}