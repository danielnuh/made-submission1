import dependencies.Dependencies
import dependencies.AnnotationProcessorsDependencies

plugins {
    id(BuildPlugins.ANDROID_LIBRARY)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.HILT)
}

android {
    compileSdk = ConfigData.compileSdkVersion

    buildTypes.forEach {
        it.buildConfigField("String", "BASE_URL", project.property("baseUrl").toString())
        it.buildConfigField("String", "HOST_NAME", project.property("hostname").toString())
        it.buildConfigField("String", "IMAGE_URL", project.property("imageUrl").toString())
        it.buildConfigField("String", "KEY_URL", project.property("keyUrl").toString())

        it.buildConfigField("String", "CERTIFICATE_KEY1", project.property("certificateKey1").toString())
    }
}

dependencies {
    implementation(project(BuildModules.Libraries.DOMAIN))

    implementation(Dependencies.CORE_KTX)

    api(Dependencies.RETROFIT)
    api(Dependencies.RETROFIT_CONVERTER_GSON)
    api(Dependencies.OK_HTTP_LOGGING)
    api(Dependencies.OK_HTTP)

    api(Dependencies.ROOM)
    kapt(AnnotationProcessorsDependencies.ROOM)

    implementation(Dependencies.HILT)
    kapt(AnnotationProcessorsDependencies.HILT)

    implementation(Dependencies.COUROUTINES_CORE)
    implementation(Dependencies.COUROUTINES_ANDROID)

    implementation("net.zetetic:android-database-sqlcipher:4.4.0")
}