import com.sun.jna.platform.win32.OaIdl.DATE
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName
import java.text.DateFormat
import java.text.SimpleDateFormat


plugins {
    kotlin("kapt")
    id("kotlin-kapt")
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")

}

fun getDateTime(): String? {
    val df: DateFormat = SimpleDateFormat("yyyyMMddHHmm")
    return df.format(DATE())
}

android {
    namespace = "com.tvr.androidtemplate"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tvr.androidtemplate"
        minSdk = 24
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
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    flavorDimensions.add("baseDimension")

    productFlavors {
        create("Production") {
            dimension = "baseDimension"
            versionCode = 1
            versionName = "1.0.0"
            resValue("string", "app_name", "Test")
            resValue( "string", "package_name", namespace!!)
            resValue("string", "db_name", "test_db")
            resValue( "string", "default_server_url", "http://test.com/")
        }

        create("Qa") {
            dimension = "baseDimension"
            versionCode = 1
            versionName = "1.0.0"
            resValue("string", "app_name", "Test")
            resValue( "string", "package_name", namespace!!)
            resValue("string", "db_name", "test_db")
            resValue( "string", "default_server_url", "http://test.com/")
        }

        create("Dev") {
            dimension = "baseDimension"
            versionCode = 1
            versionName = "1.0.0"
            resValue("string", "app_name", "Test")
            resValue( "string", "package_name", namespace!!)
            resValue("string", "db_name", "test_db")
            resValue( "string", "default_server_url", "https://jsonplaceholder.typicode.com")
        }
    }

    /*applicationVariants.all { variant ->
        variant.outputs.all {
            archivesName.set("")
        }
    }*/
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    //okhttp
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("androidx.multidex:multidex:2.0.1")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //Room
    implementation("androidx.room:room-runtime:2.5.1")
    implementation("androidx.cardview:cardview:1.0.0")
    annotationProcessor("androidx.room:room-compiler:2.5.1")
    kapt("androidx.room:room-compiler:2.5.1")
    implementation("androidx.room:room-ktx:2.5.1")

    //hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.47")
    implementation("androidx.activity:activity-ktx:1.8.2")

    //coroutins
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    //glide
    implementation("com.github.bumptech.glide:glide:4.14.2")
    kapt("com.github.bumptech.glide:compiler:4.11.0")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //flipper
    val flipper_version = "0.243.0"
    debugImplementation("com.facebook.flipper:flipper:$flipper_version")
    debugImplementation("com.facebook.soloader:soloader:0.10.5")
    debugImplementation("com.facebook.flipper:flipper-network-plugin:$flipper_version")

    releaseImplementation("com.facebook.flipper:flipper-noop:$flipper_version")

}

kapt {
    correctErrorTypes = true
}