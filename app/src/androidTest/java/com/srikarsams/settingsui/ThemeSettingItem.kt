package com.srikarsams.settingsui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import com.srikarsams.settingsui.model.Theme
import com.srikarsams.settingsui.ui.theme.ThemeSettingItem
import org.junit.Rule
import org.junit.Test

class ThemeSettingsItem {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun selected_Theme_Displayed() {
        val option = Theme.DARK
        composeTestRule.setContent {
            ThemeSettingItem(
                selectedTheme = option,
                onThemeSelected = { }
            )
        }
        composeTestRule
            .onNodeWithText(
                InstrumentationRegistry.getInstrumentation()
                    .targetContext.getString(option.label)
            )
            .assertIsDisplayed()
    }

    @Test
    fun theme_Options_Displayed() {
        composeTestRule.setContent {
            ThemeSettingItem(
                selectedTheme = Theme.DARK,
                onThemeSelected = { }
            )
        }
        composeTestRule
            .onNodeWithTag(Tags.TAG_SELECT_THEME)
            .performClick()
        Theme.values().forEach {
            composeTestRule
                .onNodeWithTag(
                    Tags.TAG_THEME_OPTION + InstrumentationRegistry
                        .getInstrumentation().targetContext.getString(
                            it.label
                        )
                )
                .assertIsDisplayed()
        }
    }
}