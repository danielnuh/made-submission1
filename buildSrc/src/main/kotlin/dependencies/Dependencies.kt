package dependencies

import Versions

object Dependencies {
    // CORE
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val MULTI_DEX = "com.android.support:multidex:${Versions.MULTI_DEX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_REACTIVE_STREAM}"
    const val LIFECYCLE_LIVEDATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_REACTIVE_STREAM}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_JETPACK = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_JETPACK}"
    const val RX_JAVA = "io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA}"
    const val RX_JAVA_ANDROID = "io.reactivex.rxjava3:rxandroid:${Versions.RX_JAVA_ANDROID}"
    const val RX_BINDING = "com.jakewharton.rxbinding4:rxbinding:${Versions.RX_BINDING}"
    const val LIFECYCLE_REACTIVE_STREAMS = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.LIFECYCLE_REACTIVE_STREAM}"
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    // View
    const val MATERIAL =
        "com.google.android.material:material:${Versions.MATERIAL}"
    const val SWIPE_REFRESH_LAYOUT =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val RECYCLER_VIEW =
        "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"

    const val SDP_ANDROID = "com.intuit.sdp:sdp-android:${Versions.SDP_ANDROID}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val SHIMMER = "com.facebook.shimmer:shimmer:${Versions.SHIMMER}"
    const val VIEW_PAGER = "androidx.viewpager2:viewpager2:${Versions.VIEW_PAGER}"

    // Jetpack
    const val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_RXJAVA_3 = "androidx.room:room-rxjava3:${Versions.ROOM}"

    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI =
        "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_DYNAMIC_FEATURES =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}"

    const val CAMERA = "androidx.camera:camera-camera2:${Versions.CAMERA}"
    const val CAMERA_LIFECYCLE =
        "androidx.camera:camera-lifecycle:${Versions.CAMERA}"
    const val CAMERA_VIEW = "androidx.camera:camera-view:${Versions.CAMERA_VIEW}"

    const val BIOMETRIC = "androidx.biometric:biometric:${Versions.BIOMETRIC}"

    const val PAGING = "androidx.paging:paging-runtime-ktx:${Versions.PAGING}"
    const val PAGING_RXJAVA = "androidx.paging:paging-rxjava3:${Versions.PAGING}"

    const val PREFERENCE_KTX =
        "androidx.preference:preference-ktx:${Versions.PREFERENCE}"

    // network
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_GSON =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_SCALARS =
        "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT}"
    const val RETROFIT_RXJAVA_ADAPTER =
        "com.squareup.retrofit2:adapter-rxjava3:${Versions.RETROFIT}"
    const val OK_HTTP = "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP}"
    const val OK_HTTP_LOGGING =
        "com.squareup.okhttp3:logging-interceptor:${Versions.OK_HTTP}"
    const val MOSHI = "com.squareup.moshi:moshi:${Versions.MOSHI}"

    // couroutines
    const val COUROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COUROUTINES}"
    const val COUROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COUROUTINES}"

}

