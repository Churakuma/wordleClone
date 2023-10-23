package com.example.wordleclone.Game

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.wordleclone.Data.allWords
import com.example.wordleclone.R

class GameViewModel: ViewModel() {
    private lateinit var currentWord: String
    private var usedWords: MutableSet<String> = mutableSetOf()
    private var guesses: MutableSet<String> = mutableSetOf()

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

    /**
     * Function to validate the user's current guess
     */
    private fun validateUserGuess(
        context: Context,
        userGuess: String,
        guessIsValid: Boolean
    ): Boolean {
        if (userGuess.length != 5) {
            Toast.makeText(context,
                context.getString(R.string.Guess_Invalid_Length), Toast.LENGTH_SHORT).show()
        } else if (guesses.contains(userGuess)) {
            Toast.makeText(context,
                context.getString(R.string.Unique_Guess_Request), Toast.LENGTH_SHORT).show()
        } else if (!allWords.contains(userGuess)) {
            Toast.makeText(context,
                context.getString(R.string.Guess_Valid_Word), Toast.LENGTH_SHORT).show()
        } else {
            guesses.add(userGuess)
            return true // Return true if the guess has been validated
        }
        return validateUserGuess(context, userGuess, guessIsValid)
    }

    public fun startGame() {
        pickRandomWord()
    }

}