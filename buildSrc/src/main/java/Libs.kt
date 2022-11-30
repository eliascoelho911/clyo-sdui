object Libs {
    // Android
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.androidCoreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    const val lifecycleCommon = "androidx.lifecycle:lifecycle-common:${Versions.lifecycle}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val material3 = "com.google.android.material:material:${Versions.material3}"

    // Kotlin
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val kotlinSerializationJson =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"

    // Koin
    const val koin = "io.insert-koin:koin-android:${Versions.koin}"
}