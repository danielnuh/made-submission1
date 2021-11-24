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
    kapt(AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.COUROUTINES_CORE)
    implementation(Dependencies.COUROUTINES_ANDROID)

    implementation("androidx.paging:paging-runtime:3.0.0-alpha04")

}