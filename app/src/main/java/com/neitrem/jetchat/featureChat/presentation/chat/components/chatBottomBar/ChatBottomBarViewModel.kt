package com.neitrem.jetchat.featureChat.presentation.chat.components.chatBottomBar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.String
import kotlin.reflect.typeOf

@HiltViewModel(assistedFactory = ChatBottomBarViewModel.Factory::class)
class ChatBottomBarViewModel
    @AssistedInject
    constructor(
        @Assisted private val initialText: String,
    ) : ViewModel() {
        private val _textFieldState = mutableStateOf(initialText)

        @AssistedFactory
        interface Factory {
            fun create(initialText: String): ChatBottomBarViewModel
        }

        val textFieldState: State<String> = _textFieldState

        fun updateTextMethod(text: String) {
            _textFieldState.value = text
        }
    }

@Suppress("UNCHECKED_CAST")
class ChatBottomBarViewModelFactory(
    private val initialText: String,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        ChatBottomBarViewModel(initialText) as T
}