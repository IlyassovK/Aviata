object Dependencies {
    const val androidCore = "androidx.core:core-ktx:"
    const val androidCompat = "androidx.appcompat:appcompat:"
    const val androidMaterial = "com.google.android.material:material:"

    const val constraintLayout = "androidx.constraintlayout:constraintlayout:"

    const val jUnit = "junit:junit:"

    const val WORK_MANAGER = "androidx.work:work-runtime-ktx:2.5.0"

    const val TINK = "com.google.crypto.tink:tink-android:${Versions.TINK}"
    const val PROTOBUF = "com.google.protobuf:protobuf-javalite:3.10.0"
    const val PROTO_DATASTORE = "androidx.datastore:datastore-core:${Versions.DATASTORE}"

    const val INPUT_MASK = "com.redmadrobot:input-mask-android:6.0.0"
    const val PROGRESS_BUTTON = "com.github.razir.progressbutton:progressbutton:2.1.0"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val KOTLIN_COROUTINES =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_ANDROID}"
    const val KOTLIN_COROUTINES_RX =
        "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.COROUTINES_ANDROID}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"

    const val FIREBASE_BOM = "com.google.firebase:firebase-bom:${Versions.FIREBASE_BOM}"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
    const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
    const val FIREBASE_CONFIG = "com.google.firebase:firebase-config-ktx"
    const val FIREBASE_MESSAGING = "com.google.firebase:firebase-messaging-ktx"

    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    const val GLIDE_OKHTTP = "com.github.bumptech.glide:okhttp3-integration:${Versions.GLIDE}"

    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val NAVIGATION_FRAGMENT_KTX =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_COMPONENT}"
    const val NAVIGATION_UI_KTX =
        "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_COMPONENT}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGING_INTERCEPTOR =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val THREETENABP = "com.jakewharton.threetenabp:threetenabp:${Versions.THREETENABP}"
    const val LIFECYCLE_COMPILER =
        "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME =
        "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVE_DATA_KTX =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEW_MODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"

    const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
    const val BIOMETRIC = "androidx.biometric:biometric:${Versions.BIOMETRIC}"
    const val PIN_VIEW = "com.alimuzaffar.lib:pinentryedittext:2.0.6"
    const val INSETTER = "dev.chrisbanes.insetter:insetter:${Versions.INSETTER}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val VIEWPAGER2 = "androidx.viewpager2:viewpager2:${Versions.VIEWPAGER2}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT_SCALARS =
        "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT}"
    const val NETWORK_RESPONSE =
        "com.github.haroldadmin:NetworkResponseAdapter:${Versions.NETWORK_RESPONSE_VERSION}"

    const val KOIN = "org.koin:koin-android:${Versions.KOIN}"
    const val KOIN_SCOPE = "org.koin:koin-androidx-scope::${Versions.KOIN}"
    const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
    const val KOIN_WORKMANAGER = "org.koin:koin-androidx-workmanager:${Versions.KOIN}"
    const val KOIN_FRAGMENT = "org.koin:koin-androidx-fragment:${Versions.KOIN}"

    const val EPOXY = "com.airbnb.android:epoxy:${Versions.EPOXY}"
    const val EPOXY_PROCESSOR = "com.airbnb.android:epoxy-processor:${Versions.EPOXY}"
    const val EPOXY_PAGING = "com.airbnb.android:epoxy-paging3:${Versions.EPOXY}"

    const val PLAY_CORE = "com.google.android.play:core:${Versions.PLAY_CORE}"
    const val PLAY_CORE_KTX = "com.google.android.play:core-ktx:${Versions.PLAY_CORE}"

    const val ONE_SIGNAL = "com.onesignal:OneSignal:[4.0.0, 4.99.99]"

    const val QR_CODE_SCANNER = "com.budiyev.android:code-scanner:${Versions.QR_CODE_SCANNER}"
    const val QR_GEN = "com.github.kenglxn.QRGen:android:2.6.0"
    const val CARD_SLIDER = "com.github.IslamKhSh:CardSlider:1.0.1"
    const val SKELETON = "com.ethanhua:skeleton:1.1.2"
    const val SHIMMER = "io.supercharge:shimmerlayout:2.1.0"
    const val VIEW_BINDING_DELEGATE =
        "com.github.kirich1409:viewbindingpropertydelegate:${Versions.VIEW_BINDING_DELEGATE}"

    const val LOTTIE = "com.airbnb.android:lottie:${Versions.LOTTIE}"
    const val VIEWPAGER_DOTS = "com.tbuonomo.andrui:viewpagerdotsindicator:4.1.2"

    const val COMPRESSOR = "id.zelory:compressor:3.0.1"

    object ROOM {
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
        const val KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    }

    object AndroidX {
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
        const val SWIPE_REFRESH =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH}"
        const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
        const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val RECYCLER_VIEW =
            "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"
        const val GRID_LAYOUT = "androidx.gridlayout:gridlayout:${Versions.GRID_LAYOUT}"
    }

}