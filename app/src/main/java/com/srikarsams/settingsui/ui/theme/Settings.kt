package com.srikarsams.settingsui.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.srikarsams.settingsui.R
import com.srikarsams.settingsui.model.SettingState
import com.srikarsams.settingsui.model.SettingsViewModel

@Composable
fun Settings() {
    val viewModel = SettingsViewModel()
    MaterialTheme {
        val state = viewModel.uiState.collectAsState().value
        SettingsList(state = state, viewModel = viewModel)
    }
}

@Composable
fun SettingsList(
    modifier: Modifier = Modifier,
    state: SettingState,
    viewModel: SettingsViewModel
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.surface,
            contentPadding = PaddingValues(start = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(R.string.cd_go_back),
                tint = MaterialTheme.colors.onSurface
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.title_settings),
                color = MaterialTheme.colors.onSurface,
                fontSize = 18.sp
            )
        }
        NotificationSettings(
            title = stringResource(id = R.string.setting_enable_notifications),
            checked = state.notificationsEnabled,
            onToggleNotificationSettings = viewModel::toggleNotificationSettings,
            modifier = Modifier.fillMaxWidth()
        )
        Divider()
        HintSettingsItem(
            title = stringResource(id = R.string.setting_show_hints),
            checked = state.hintsEnabled,
            onToggleHintSettings = viewModel::toggleHintSettings,
            modifier = Modifier.fillMaxWidth()
        )
        Divider()
        ManageSubscriptionSettingItem(
            title = stringResource(id = R.string.setting_manage_subscription),
            modifier = Modifier.fillMaxWidth()
        ) {
            // Leave this blank
        }
        Divider()
        SectionSpacer(modifier = Modifier.fillMaxWidth())
        MarketingSettingItem(
            selectedOption = state.marketingOption,
            onOptionSelected = viewModel::setMarketingSettings,
            modifier = Modifier.fillMaxWidth()
        )
        Divider()
        ThemeSettingItem(selectedTheme = state.themeOption, onThemeSelected = viewModel::setTheme)
        SectionSpacer(modifier = Modifier.fillMaxWidth())
        AppVersionSettingItem(appVersion = stringResource(id = R.string.setting_app_version))
        Divider()
    }
}

@Preview
@Composable
fun SettingsListPreview() {
    MaterialTheme {
        Settings()
    }
}