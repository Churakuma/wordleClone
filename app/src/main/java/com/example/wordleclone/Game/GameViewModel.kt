package com.example.wordleclone.Game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private lateinit var currentWord: String

    var gameUiState by mutableStateOf(GameUiState())

    var userGuess by mutableStateOf("")
        private set

    private fun pickRandomWord() {
        //TODO: Pick random word from wordList
    }

}