import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}
val apiKeyPropertiesFile = rootProject.file("key.properties")
val apiKeyProperties = Properties()
apiKeyProperties.load(apiKeyPropertiesFile.inputStream())

android {
    namespace = "ir.hoseinahmadi.frenchpastry"
    compileSdk = 34


    defaultConfig {
        applicationId = "ir.hoseinahmadi.frenchpastry"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        buildConfigField("String", "KEY", apiKeyProperties.getProperty("KEY"))
        buildConfigField("String", "IV", apiKeyProperties.getProperty("IV"))

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources =true
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
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material3:material3-android:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("androidx.navigation:navigation-compose:2.7.7")

    implementation("com.airbnb.android:lottie-compose:6.3.0")


    //pager
    implementation("com.google.accompanist:accompanist-pager:0.12.0")


    //add Room
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-rxjava3:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")


    implementation("com.github.bumptech.glide:compose:1.0.0-beta01")

// retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")



    //hilt di
    val hiltVersion = "2.48.1"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    implementation("androidx.datastore:datastore-preferences:1.1.0")


    implementation("io.coil-kt:coil-compose:2.0.0-rc01")

    //swipe refresh
    implementation("com.google.accompanist:accompanist-swiperefresh:0.27.0")

//system ui controller
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0")


    //Accompanist-Pager
    implementation("com.google.accompanist:accompanist-pager:0.29.0-alpha")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.29.0-alpha")

    //paging3
    implementation("androidx.paging:paging-compose:3.3.0-beta01")

    //chart
    implementation("com.patrykandpatrick.vico:compose:1.13.0")

    implementation("androidx.compose.material:material-icons-extended:1.6.6")



}