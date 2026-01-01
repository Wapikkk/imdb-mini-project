package sample.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*

@Composable
fun LoginScreen (
    onLoginSuccess: () -> Unit,
    onRegisterClicked: () -> Unit
) {
    var email by remember {(mutableStateOf(""))}
    var password by remember {(mutableStateOf(""))}

    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text("Masuk ke IMDb", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(value = email, onValueChange = {email = it}, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password, onValueChange = {password = it}, label = { Text("Password") }, visualTransformation =  PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(32.dp))

        TextButton(
            onClick = onRegisterClicked
        ) {
            Text("Belum punya akun? Daftar Di sini")
        }
    }
}