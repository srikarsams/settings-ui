package com.srikarsams.settingsui.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srikarsams.settingsui.R
import com.srikarsams.settingsui.Tags
import com.srikarsams.settingsui.model.MarketingOption
import com.srikarsams.settingsui.ui.theme.Spacer

@Composable
fun MarketingSettingItem(
    modifier: Modifier = Modifier,
    selectedOption: MarketingOption,
    onOptionSelected: (MarketingOption) -> Unit
) {
    val options = stringArrayResource(id = R.array.setting_options_marketing_choice)
    SettingsItem(modifier = modifier) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(id = R.string.setting_option_marketing))
            Spacer(modifier = Modifier.height(8.dp))
            options.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .testTag(Tags.TAG_MARKETING_OPTION + index)
                        .selectable(
                            selected = index === selectedOption.id,
                            onClick = {
                                val option = if (index === MarketingOption.ALLOWED.id) {
                                    MarketingOption.ALLOWED
                                } else {
                                    MarketingOption.NOT_ALLOWED
                                }
                                onOptionSelected(option)
                            },
                            role = Role.RadioButton
                        )
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    RadioButton(
                        selected = index === selectedOption.id,
                        onClick = null
                    )
                    Text(text = option, modifier = Modifier.padding(start = 18.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun MarketingPreview() {
    MaterialTheme {
        MarketingSettingItem(selectedOption = MarketingOption.ALLOWED) {

        }
    }
}