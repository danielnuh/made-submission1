import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.HILT)
}

android{
    compileSdk = ConfigData.compileSdkVersion
}

dependencies {
    implementation(Dependencies.CORE_KTX)

    implementation(Dependencies.HILT)
    annotationProcessor (AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.COUROUTINES_CORE)
    implementation(Dependencies.COUROUTINES_ANDROID)
}