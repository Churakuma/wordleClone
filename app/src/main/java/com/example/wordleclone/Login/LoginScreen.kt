package com.example.wordleclone.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wordleclone.ui.theme.WordleCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel? = null
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.loginError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Wordle",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )

        if (isError){
            Text(
                text = loginUiState?.loginError ?: "Unknown Error",
                color = Color.Red
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = loginUiState?.userName?: "",
            onValueChange = { loginViewModel?.onUserNameChange(it) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = loginUiState?.password?: "",
            onValueChange = { loginViewModel?.onPasswordChange(it) },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = null) },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign In")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Don't have an Account?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Sign Up")
            }
        }

        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        // TODO: Finish Navigation
        /**LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if(loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }*/
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel? = null
) {
    val loginUiState = loginViewModel?.loginUiState
    val isError = loginUiState?.signUpError != null
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold
        )

        if (isError){
            Text(
                text = loginUiState?.loginError ?: "Unknown Error",
                color = Color.Red
            )
        }

        OutlinedTextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = loginUiState?.userNameSignUp?: "",
            onValueChange = { loginViewModel?.onUserNameSignUpChange(it) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
            },
            label = {
                Text(text = "Email")
            },
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = loginUiState?.passwordSignUp?: "",
            onValueChange = { loginViewModel?.onPasswordSignUpChange(it) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = loginUiState?.confirmPasswordSignUp?: "",
            onValueChange = { loginViewModel?.onConfirmPasswordSignUpChange(it) },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
            },
            label = {
                Text(text = "Confirm Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError
        )

        Button(onClick = { loginViewModel?.createUser(context) }) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.size(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Already have an Account?")
            Spacer(modifier = Modifier.size(8.dp))
            //TODO: Finish Navigation
            /** TextButton(onClick = { onNavToLoginPage.invoke() }) {
                Text(text = "Sign In")
            }*/
        }

        if (loginUiState?.isLoading == true) {
            CircularProgressIndicator()
        }

        //TODO: Finish Navigation
        /**LaunchedEffect(key1 = loginViewModel?.hasUser) {
            if(loginViewModel?.hasUser == true) {
                onNavToHomePage.invoke()
            }
        }*/
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen() {
    WordleCloneTheme {
        LoginScreen()
    }
}

@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen() {
    WordleCloneTheme {
        SignUpScreen()
    }
}