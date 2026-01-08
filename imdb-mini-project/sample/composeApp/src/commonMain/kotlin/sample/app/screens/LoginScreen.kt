package sample.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import com.wapekk.imdb.viewModel.ViewModelAuth

@Composable
fun LoginScreen (
    viewModel: ViewModelAuth,
    onLoginSuccess: () -> Unit,
    onRegisterClicked: () -> Unit
) {
    var email by remember {(mutableStateOf(""))}
    var password by remember {(mutableStateOf(""))}

    val isLoading by viewModel.isLoading.collectAsState()
    val isSuccess by viewModel.isSuccess.collectAsState()
    val message by viewModel.message.collectAsState()

    LaunchedEffect(isSuccess) {
        if(isSuccess) {
            onLoginSuccess()
            viewModel.resetState()
        }
    }

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

        if (message.isNotEmpty()) {
            Text(text = message, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {viewModel.login(email, password)},
            modifier = Modifier.fillMaxWidth(),
            enabled = !isLoading
        ){
            if (isLoading) {
                CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
            }else{
                Text("Masuk")
            }
        }

        TextButton(
            onClick = onRegisterClicked
        ) {
            Text("Belum punya akun? Daftar Di sini")
        }
    }
}