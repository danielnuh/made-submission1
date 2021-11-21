import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(BuildPlugins.ANDROID_DYNAMIC_FEATURE)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.HILT)
}
android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig{
        minSdk = ConfigData.minSdkVersion
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    implementation(project(BuildModules.Libraries.CORE))
    implementation(project(BuildModules.Libraries.DOMAIN))
    implementation(project(BuildModules.Libraries.DATA))

    implementation(project(BuildModules.APP))
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.RECYCLER_VIEW)

    implementation(Dependencies.GLIDE)
    kapt(AnnotationProcessorsDependencies.GLIDE)


    implementation(Dependencies.HILT)
    kapt(AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.COUROUTINES_CORE)
    implementation(Dependencies.COUROUTINES_ANDROID)
    implementation(Dependencies.LIFECYCLE_LIVEDATA_KTX)

    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_DYNAMIC_FEATURES)
}