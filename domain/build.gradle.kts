plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation("io.reactivex.rxjava2:rxjava:2.2.20")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-core:3.1.0")

    implementation("com.google.code.gson:gson:2.8.9")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}