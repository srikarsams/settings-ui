package com.srikarsams.settingsui.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.srikarsams.settingsui.R
import com.srikarsams.settingsui.Tags
import com.srikarsams.settingsui.model.Theme

@Composable
fun ThemeSettingItem(
    modifier: Modifier = Modifier,
    selectedTheme: Theme,
    onThemeSelected: (Theme) -> Unit
) {
    SettingsItem() {
        var isExpanded by remember {
            mutableStateOf(false)
        }
        Row(
            modifier = Modifier
                .clickable(
                    onClick = {
                        isExpanded = !isExpanded
                    },
                    onClickLabel = stringResource(id = R.string.cd_select_theme)
                )
                .padding(horizontal = 16.dp)
                .testTag(Tags.TAG_SELECT_THEME),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.setting_option_theme),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = stringResource(id = selectedTheme.label),
                modifier = Modifier.testTag(Tags.TAG_THEME)
            )
        }
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = {
                isExpanded = false
            },
            offset = DpOffset(16.dp, 0.dp)
        ) {
            Theme.values().forEach { theme ->
                DropdownMenuItem(
                    onClick = {
                        onThemeSelected(theme)
                        isExpanded = false
                    },
                    modifier = Modifier.testTag(Tags.TAG_THEME_OPTION + stringResource(id = theme.label))
                ) {
                    Text(text = stringResource(id = theme.label))
                }
            }
        }
    }
}


@Preview
@Composable
fun ThemeSettingsPreview() {
    MaterialTheme {
        ThemeSettingItem(selectedTheme = Theme.SYSTEM) {

        }
    }
}