package com.example.conventions

enum class AppBuildType(val suffix: String? = null) {
    DEBUG(".debug"),
    RELEASE()
}