package com.example.wordleclone.Game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wordleclone.R
import com.example.wordleclone.ui.theme.WordleCloneTheme

@Composable
fun HomeScreen(
    gameViewModel: GameViewModel? = null
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Wordle",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(16.dp))

        OutlinedButton(
            modifier = Modifier,
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Logout")
        }
    }
}

@Composable
fun GameLayout(
    modifier: Modifier = Modifier,
    isGuessWrong: Boolean,
    lastGuessedWord: String,
    userGuess: String,
    guessCount: Int,
) {

}

@Composable
fun accuracyCard(accuracy: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.Accuracy, accuracy),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevGameScreen() {
    WordleCloneTheme {
        HomeScreen()
    }
}