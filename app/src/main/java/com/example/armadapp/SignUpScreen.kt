package com.example.armadapp

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(
    name: MutableState<String> = mutableStateOf(""),
    userName: MutableState<String> = mutableStateOf(""),
    userEmail: MutableState<String> = mutableStateOf(""),
    password: MutableState<String> = mutableStateOf(""),
    modifier: Modifier = Modifier
) {
    //TODO: SignUpScreen UI using composables and Database
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    )
    {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("Name") },
            placeholder = { Text("Name") },
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = userEmail.value,
            onValueChange = { userEmail.value = it },
            label = { Text("SIT Email") },
            placeholder = { Text("SIT Email") },
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = userName.value,
            onValueChange = { userName.value = it },
            label = { Text("User Name") },
            placeholder = { Text("User Name") },
            modifier = Modifier.padding(16.dp)
        )

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            placeholder = { Text("Password") },
            modifier = Modifier.padding(16.dp)
        )

        Button(
            onClick = {
                //backend code to access db
            },
            enabled = userName.value.isNotEmpty()
                    && userEmail.value.isNotEmpty()
                    && password.value.isNotEmpty(),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Sign Up")
        }

    }

}