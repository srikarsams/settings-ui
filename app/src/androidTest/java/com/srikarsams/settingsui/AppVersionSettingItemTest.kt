package com.srikarsams.settingsui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.srikarsams.settingsui.ui.theme.AppVersionSettingItem
import org.junit.Rule
import org.junit.Test

class AppVersionSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun app_Version_Displayed() {
        val version = "1.0.4"
        composeTestRule.setContent {
            AppVersionSettingItem(appVersion = version)
        }
        composeTestRule
            .onNodeWithText(version)
            .assertIsDisplayed()
    }
}