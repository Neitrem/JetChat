package com.neitrem.jetchat.feature_chat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.neitrem.jetchat.feature_chat.presentation.chat.ChatScreen
import com.neitrem.jetchat.ui.theme.JetChatTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetChatTheme {
                ChatScreen()
            }
        }
    }
}