plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    //kotlin("plugin.serialization") version "2.0.20"

}

android {
    namespace = "com.example.testproject"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testproject"
        minSdk = 27
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")

   // implementation("com.android.volley:volley:1.2.1")

    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.gridlayout:gridlayout:1.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

   // implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")

    implementation ("com.squareup.okhttp3:okhttp:4.9.3") // OkHttp3
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2") // kotlinx.serialization

    implementation ("com.google.code.gson:gson:2.8.9")
}