package com.srikarsams.settingsui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.srikarsams.settingsui.ui.theme.ManageSubscriptionSettingItem
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock

class ManageSubscriptionSettingItemTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun title_displayed() {
        val title = "Manage Subscription"
        composeTestRule.setContent {
            ManageSubscriptionSettingItem(
                title = title,
                onSettingsClicked = { }
            )
        }
        composeTestRule
            .onNodeWithText(title)
            .assertIsDisplayed()
    }

    @Test
    fun on_Setting_Clicked_Triggered() {
        val title = "Manage Subscription"
        val onSettingClicked: () -> Unit = mock()
        composeTestRule.setContent {
            ManageSubscriptionSettingItem(
                title = title,
                onSettingsClicked = onSettingClicked
            )
        }
        composeTestRule
            .onNodeWithText(title)
            .performClick()
        verify(onSettingClicked).invoke()
    }
}