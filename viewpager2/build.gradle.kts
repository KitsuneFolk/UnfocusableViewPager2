plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.unfocusableviewpager2.viewpager2"
    compileSdk = 33

    defaultConfig {
        minSdk = 16
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.recyclerview:recyclerview:1.3.1")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.collection:collection-ktx:1.2.0")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.pandacorp"
            artifactId = "unfocusableviewpager2"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}