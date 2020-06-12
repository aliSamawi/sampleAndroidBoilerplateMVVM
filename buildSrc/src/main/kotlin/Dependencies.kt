const val kotlinVersion = "1.3.60"
object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.5.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlinVersion}"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
}

object AndroidSdk {
    const val min = 19
    const val compile = 29
    const val buildTool = "29.0.2"
    const val target = compile

    const val versionCode = 1
    const val versionName = "0.0.1"

    const val applicationId = "com.sama.useradmin"
    const val testInstrumentRunner = "android.support.test.runner.AndroidJUnitRunner"
}

object Libraries {
    object Versions {
        val appcompat = "1.1.0"
        val design = "1.0.0"
        val cardview = "1.0.0"
        val recyclerview = "1.0.0"

        val ktx = "1.2.0"
        val constraintLayout = "1.1.3"
        val coroutines = "1.1.1"

        val androidxLifeCycle = "2.2.0"

        val retrofit = "2.6.0"
        val retrofitGson = "2.4.0"
        val gson = "2.8.5"
        val retrofitCoroutines = "0.9.2"
        val loggingInterceptor = "4.0.0"

        val room = "2.2.5"
        val glide = "4.11.0"

        val dagger = "2.27"

        val googlePlayServiceLocation = "17.0.0"

        val hawk = "2.0.1"
    }

    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"

    val androidxLifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidxLifeCycle}"

//    val annotationLibrary = "androidx.annotation:annotation:1.1.0@jar"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVersion}"
    val kotlinCoroutineAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    val googlePlayServiceLocation = "com.google.android.gms:play-services-location:${Versions.googlePlayServiceLocation}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
//    val retrofitCoroutineAdapter =
//            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"


    val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"

    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomAnnotationProcessor = "androidx.room:room-compiler:${Versions.room}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val hawk = "com.orhanobut:hawk:${Versions.hawk}"
}
