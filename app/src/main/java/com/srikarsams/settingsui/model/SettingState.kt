package com.srikarsams.settingsui.model

data class SettingState(
    val notificationsEnabled: Boolean = false,
    val hintsEnabled: Boolean = false,
    val marketingOption: MarketingOption = MarketingOption.ALLOWED,
    val themeOption: Theme = Theme.DARK
)