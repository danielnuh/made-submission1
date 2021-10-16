// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
//        maven { url = uri("https://jitpack.io") }
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
//        maven { url = uri("https://jitpack.io") }
    }
}
tasks.register("clean",Delete::class){
    delete(rootProject.buildDir)
}