package com.srikarsams.settingsui.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srikarsams.settingsui.R
import com.srikarsams.settingsui.Tags
import com.srikarsams.settingsui.model.SettingState
import com.srikarsams.settingsui.model.SettingsViewModel

@Composable
fun HintSettingsItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onToggleHintSettings: () -> Unit
) {
    val showHintsState = if (checked) {
        stringResource(id = R.string.cd_hints_enabled)
    } else {
        stringResource(id = R.string.cd_hints_disabled)
    }
    SettingsItem(modifier = modifier) {
        Row(
            modifier = Modifier
                .testTag(Tags.TAG_CHECK_ITEM)
                .toggleable(
                    value = checked,
                    onValueChange = { onToggleHintSettings() },
                    role = Role.Checkbox
                )
                .semantics { stateDescription = showHintsState }
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title, modifier = Modifier
                    .weight(1f)
            )
            Checkbox(checked = checked, onCheckedChange = null)
        }
    }
}


@Preview
@Composable
fun HintSettingsPreview() {
    MaterialTheme {
        HintSettingsItem(
            checked = false,
            title = "Show Hints"
        ) {

        }
    }
}