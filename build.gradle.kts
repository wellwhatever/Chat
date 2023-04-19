plugins {
    with(libs.plugins) {
        listOf(
            android.application,
            android.library,
            kotlin.android,
            kotlin.kapt,
            hilt
        ).forEach {
            alias(it) apply false
        }
    }
}