package com.example.wordleclone.Game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wordleclone.R
import com.example.wordleclone.ui.theme.WordleCloneTheme

@Composable
fun HomeScreen(
    gameViewModel: GameViewModel
) {
    val gameUiState = gameViewModel.gameUiState
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(mediumPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Wordle",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.padding(16.dp))


        GameLayout(
            onUserGuessChanged = { /*TODO*/ },
            onKeyboardDone = { /*TODO*/ },
            isGuessWrong = gameUiState.isGuessWrong,
            lastGuessedWord = gameUiState.lastGuessedWord,
            userGuess = gameViewModel.userGuess,
            guessCount = gameUiState.guessCount,
            gameCount = gameUiState.gameCount
        )

        OutlinedButton(
            modifier = Modifier,
            onClick = { /*TODO*/ }
        ) {
            Text(text = "Logout")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameLayout(
    modifier: Modifier = Modifier,
    onUserGuessChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    isGuessWrong: Boolean,
    lastGuessedWord: String,
    userGuess: String,
    guessCount: Int,
    gameCount: Int
) {
    val mediumPadding = dimensionResource(id = R.dimen.padding_medium)

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(mediumPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(mediumPadding)
        ) {
            Text(
                modifier = modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = stringResource(id = R.string.guessCount, guessCount),
                style = typography.titleMedium
            )
            Text(
                modifier = modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.Start),
                text = stringResource(id = R.string.gameCount, gameCount),
                style = typography.titleMedium
            )
            Text(
                text = lastGuessedWord,
                style = typography.displayMedium
            )
            Text(
                text = stringResource(R.string.instructions),
                textAlign = TextAlign.Center,
                style = typography.titleMedium
            )
            OutlinedTextField(
                value = userGuess,
                singleLine = true,
                shape = shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = onUserGuessChanged,
                label = { if (isGuessWrong) {
                    Text(stringResource(id = R.string.wrong_guess))
                } else {
                    Text(stringResource(id = R.string.enter_your_word))
                }
                },
                isError = isGuessWrong,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { onKeyboardDone() }
                )
            )
        }
    }
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
        HomeScreen(gameViewModel = )
    }
}