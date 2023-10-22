package com.example.wordleclone.Game

data class GameUiState (
    val accuracy: Int = 0,
    val gameCount: Int = 0,
    val guessCount: Int = 0,
    val hasWon: Boolean = false,
)