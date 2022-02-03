package com.srikarsams.settingsui.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
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

@Composable
fun NotificationSettings(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
    onToggleNotificationSettings: () -> Unit
) {
    val notificationEnabledState = if (checked) {
        stringResource(id = R.string.cd_notifications_enabled)
    } else {
        stringResource(id = R.string.cd_notifications_disabled)
    }
    SettingsItem(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .testTag(Tags.TAG_TOGGLE_ITEM)
                .toggleable(
                    checked,
                    role = Role.Switch,
                    onValueChange = { onToggleNotificationSettings() }
                )
                .padding(horizontal = 16.dp)
                .semantics { stateDescription = notificationEnabledState }
        ) {
            Text(text = title, modifier = Modifier.weight(1f))
            Switch(checked = checked, onCheckedChange = null)
        }
    }
}

@Preview
@Composable
fun NotificationPreview() {
    MaterialTheme {
        NotificationSettings(title = "Enable Notifications", checked = true) {

        }
    }
}