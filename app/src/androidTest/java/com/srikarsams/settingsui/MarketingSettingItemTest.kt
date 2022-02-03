package com.srikarsams.settingsui

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.srikarsams.settingsui.model.MarketingOption
import com.srikarsams.settingsui.ui.theme.MarketingSettingItem
import org.junit.Rule
import org.junit.Test

class MarketingSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun marketing_Option_Selected() {
        val option = MarketingOption.NOT_ALLOWED
        composeTestRule.setContent {
            MarketingSettingItem(
                selectedOption = option,
                onOptionSelected = { }
            )
        }
        composeTestRule
            .onNodeWithTag(Tags.TAG_MARKETING_OPTION + option.id)
            .assertIsSelected()
    }
}