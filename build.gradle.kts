buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.BUILD_GRADLE}")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}