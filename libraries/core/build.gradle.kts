import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies


plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.HILT)
}

android{
    compileSdk = ConfigData.compileSdkVersion
}

dependencies {
    implementation(project(BuildModules.Libraries.DOMAIN))
    implementation(project(BuildModules.Libraries.DATA))

    implementation(Dependencies.HILT)
    kapt(AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.COUROUTINES_CORE)
    implementation(Dependencies.COUROUTINES_ANDROID)
}