package com.srikarsams.settingsui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.srikarsams.settingsui.ui.theme.NotificationSettings
import org.junit.Rule
import org.junit.Test

class NotificationSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun title_Displayed() {
        val title = "Enable Notifications"
        composeTestRule.setContent {
            NotificationSettings(
                title = title,
                checked = true,
                onToggleNotificationSettings = { }
            )
        }
        composeTestRule
            .onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun setting_Checked() {
        composeTestRule.setContent {
            NotificationSettings(
                title = "Enable Notifications",
                checked = true,
                onToggleNotificationSettings = { }
            )
        }
        composeTestRule
            .onNodeWithTag(Tags.TAG_TOGGLE_ITEM)
            .assertIsOn()
    }
}