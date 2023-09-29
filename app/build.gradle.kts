plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.movieslist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.movieslist"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kapt {
        correctErrorTypes = true
    }
    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val retrofitVersion = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-scalars:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    implementation("io.reactivex.rxjava2:rxjava:2.2.20")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")
    implementation("com.jakewharton.rxbinding3:rxbinding:3.1.0")
    implementation("com.jakewharton.rxbinding3:rxbinding-core:3.1.0")

    implementation("com.google.code.gson:gson:2.8.9")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")

    val lifecycleVersion = "2.6.2"
    implementation("androidx.lifecycle:lifecycle-reactivestreams:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    //Live data ktx
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    //Androidx - ktx
    implementation("androidx.core:core-ktx:1.12.0")

    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")
    kapt("com.google.dagger:dagger-android-processor:2.48")
    kapt("com.google.dagger:dagger-compiler:2.48")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    implementation("androidx.datastore:datastore-preferences:1.1.0-alpha05")

    val dagger2Version = "2.38.1"
    implementation("com.google.dagger:dagger-android:$dagger2Version")
    implementation("com.google.dagger:dagger-android-support:$dagger2Version")
    implementation("com.google.dagger:dagger-android:$dagger2Version")

}
