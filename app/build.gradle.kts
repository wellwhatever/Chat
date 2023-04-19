plugins {
    id("chat.android.application")
    id("chat.android.application.compose")
    id("chat.android.hilt")
    with(libs.plugins){
        alias(kotlin.kapt)
    }
}

android {
    namespace = "com.example.chat"

    defaultConfig {
        applicationId = "com.example.chat"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(projects.core.common)
    with(libs) {
        implementation(bundles.compose)
    }
}