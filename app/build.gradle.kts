import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.HILT)
}
android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        buildToolsVersion = ConfigData.buildToolsVersion
        multiDexEnabled = ConfigData.isMultiDexEnabled

        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.testInstrumentalRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11

        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    dynamicFeatures.addAll(
        mutableSetOf(
            BuildModules.Features.FAVORITE
        )
    )
}

dependencies {
    implementation(project(BuildModules.Libraries.CORE))
    implementation(project(BuildModules.Libraries.DOMAIN))
    implementation(project(BuildModules.Libraries.DATA))

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.CONSTRAINT_LAYOUT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.SDP_ANDROID)
    implementation(Dependencies.MULTI_DEX)

    implementation(Dependencies.HILT)
    kapt(AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.LIFECYCLE_LIVEDATA_KTX)

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Dependencies.KOTLIN_STDLIB)

    implementation(Dependencies.GLIDE)
    kapt(AnnotationProcessorsDependencies.GLIDE)
    implementation("androidx.core:core-splashscreen:1.0.0-alpha01")

    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_DYNAMIC_FEATURES)

    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.4")
}