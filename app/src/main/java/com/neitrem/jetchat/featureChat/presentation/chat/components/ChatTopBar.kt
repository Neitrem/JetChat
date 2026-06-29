package com.neitrem.jetchat.featureChat.presentation.chat.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview()
@Composable
fun ChatTopBar(
    chatTitle: String = "Test title",
    membersAmount: Int = 1,
) {
    TopAppBar(
        title = {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    maxLines = 1,
                    text = chatTitle,
                    style =
                        TextStyle(
                            platformStyle =
                                PlatformTextStyle(
                                    includeFontPadding = false,
                                ),
                        ),
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 16.sp,
                )
                Text(
                    maxLines = 1,
                    text = "Участников: $membersAmount",
                    style =
                        TextStyle(
                            platformStyle =
                                PlatformTextStyle(
                                    includeFontPadding = false,
                                ),
                        ),
                    color = MaterialTheme.colorScheme.tertiary,
                    fontSize = 14.sp,
                )
            }
        },
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.onBackground,
            ),
        navigationIcon = {
            IconButton(
                onClick = { /* TODO add action */ },
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(30.dp),
                )
            }
        },
        actions = {
            IconButton(onClick = { /* TODO add action */ }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(25.dp),
                )
            }
            IconButton(onClick = { /* TODO add action */ }) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(25.dp),
                )
            }
        },
    )
}