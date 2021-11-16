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
    /*defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentalRunner
    }


    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }*/

}

dependencies {
    implementation(project(BuildModules.Libraries.CORE))
    implementation(project(BuildModules.Libraries.DOMAIN))
    implementation(project(BuildModules.Libraries.DATA))

    implementation(project(BuildModules.APP))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation("androidx.recyclerview:recyclerview:1.2.1")

    implementation(Dependencies.HILT)
    kapt(AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.COUROUTINES_CORE)
    implementation(Dependencies.COUROUTINES_ANDROID)
    implementation(Dependencies.LIFECYCLE_LIVEDATA_KTX)
    val nav_version = "2.3.5"

    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")


}