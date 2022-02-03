package com.srikarsams.settingsui

import androidx.annotation.StringRes
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.srikarsams.settingsui.ui.theme.Settings
import org.junit.Rule
import org.junit.Test

class SettingsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun enable_Notifications_Setting_Is_Displayed() {
        assertSettingIsDisplayed(R.string.setting_enable_notifications)
    }

    @Test
    fun show_Hints_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_show_hints
        )
    }

    @Test
    fun view_Subscription_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_manage_subscription
        )
    }

    @Test
    fun app_Version_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_app_version_title
        )
    }

    @Test
    fun theme_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_option_theme
        )
    }

    @Test
    fun marketing_Options_Setting_Is_Displayed() {
        assertSettingIsDisplayed(
            R.string.setting_option_marketing
        )
    }

    @Test
    fun enable_Notifications_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithTag(Tags.TAG_TOGGLE_ITEM).assertIsOff()
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(
                R.string.setting_enable_notifications
            )
        ).performClick()
        composeTestRule.onNodeWithTag(Tags.TAG_TOGGLE_ITEM).assertIsOn()
    }

    @Test
    fun show_Hints_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithTag(Tags.TAG_CHECK_ITEM).assertIsOff()
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(
                R.string.setting_show_hints
            )
        ).performClick()
        composeTestRule.onNodeWithTag(Tags.TAG_CHECK_ITEM).assertIsOn()
    }

    @Test
    fun marketing_Options_Toggles_Selected_State() {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithTag(
            Tags.TAG_MARKETING_OPTION + 0
        ).assertIsSelected()
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation()
                .targetContext.resources.getStringArray(
                    R.array.setting_options_marketing_choice
                )[1]
        ).performClick()
        composeTestRule.onNodeWithTag(
            Tags.TAG_MARKETING_OPTION + 1
        ).assertIsSelected()
    }

    private fun assertSettingIsDisplayed(@StringRes title: Int) {
        composeTestRule.setContent {
            Settings()
        }
        composeTestRule.onNodeWithText(
            InstrumentationRegistry.getInstrumentation().targetContext.getString(title)
        ).assertIsDisplayed()
    }
}