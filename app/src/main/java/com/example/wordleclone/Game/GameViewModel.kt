package com.example.wordleclone.Game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.wordleclone.Data.allWords

class GameViewModel: ViewModel() {
    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()

    var gameUiState by mutableStateOf(GameUiState())

    var userGuess by mutableStateOf("")
        private set


    /**
     * Function to pick a random word from the given words in allWords
     */
    private fun pickRandomWord(): String {
        currentWord = allWords.random()
        if (usedWords.contains(currentWord)) {
            return pickRandomWord()
        } else {
            usedWords.add(currentWord)
            return currentWord
        }
    }

}