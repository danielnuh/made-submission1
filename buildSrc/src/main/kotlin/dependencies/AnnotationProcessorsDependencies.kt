package dependencies

object AnnotationProcessorsDependencies {
    const val ROOM = "androidx.room:room-compiler:${Versions.ROOM}"
    const val GLIDE = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    const val HILT = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_JETPACK = "androidx.hilt:hilt-compiler:${Versions.HILT_JETPACK}"
    const val DATA_BINDING = "com.android.databinding:compiler:${Versions.DATA_BINDING}"
}
