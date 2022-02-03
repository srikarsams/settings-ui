package com.srikarsams.settingsui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.srikarsams.settingsui.ui.theme.HintSettingsItem
import org.junit.Rule
import org.junit.Test

class HintsSettingItemTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun title_Displayed() {
        val title = "Show Hints"
        composeTestRule.setContent {
            HintSettingsItem(
                title = title,
                checked = true,
                onToggleHintSettings = {}
            )
        }
        composeTestRule
            .onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun setting_Checked() {
        composeTestRule.setContent {
            HintSettingsItem(
                title = "Show Hints",
                checked = true,
                onToggleHintSettings = {}
            )
        }
        composeTestRule
            .onNodeWithTag(Tags.TAG_CHECK_ITEM)
            .assertIsOn()
    }
}