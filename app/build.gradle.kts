import org.jetbrains.kotlin.kapt3.base.Kapt

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = AndroidSdk.applicationId
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = AndroidSdk.testInstrumentRunner
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildTypes {
        getByName("debug"){
            isDebuggable = true
//            buildConfigField("String","BASE_URL","\"https://www.google.com/\"")
        }
        getByName("release") {
            isMinifyEnabled = false
//            buildConfigField("String","BASE_URL","\"https://www.google.com/\"")
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}


dependencies {
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.design)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.recyclerview)

    implementation(Libraries.kotlinCoroutineCore)
    implementation(Libraries.kotlinCoroutineAndroid)

//    implementation(Libraries.retrofit)
//    implementation(Libraries.retrofitGsonConverter)
//    implementation(Libraries.gson)
//    implementation(Libraries.loggingInterceptor)

    implementation(Libraries.dagger)
    implementation(Libraries.daggerAndroid)
    implementation(Libraries.daggerAndroidSupport)
    kapt(Libraries.daggerCompiler)
    kapt(Libraries.daggerAndroidProcessor)

    implementation(Libraries.roomRunTime)
    implementation(Libraries.roomKtx)
    kapt(Libraries.roomAnnotationProcessor)

    implementation(Libraries.glide)
    kapt(Libraries.glideCompiler)

    implementation(Libraries.hawk)
}
