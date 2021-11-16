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
            isMinifyEnabled = false
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

//    setDynamicFeatures(mutableSetOf(":features:favorite"))
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

//    testImplementation(TestDependencies.JUNIT)
//    androidTestImplementation(TestAndroidDependencies.EXT_JUNIT)
//    androidTestImplementation(TestAndroidDependencies.ESPRESSO)


    val nav_version = "2.3.5"

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")


    val paging_version = "3.0.1"

    implementation("androidx.paging:paging-runtime:$paging_version")

    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
}