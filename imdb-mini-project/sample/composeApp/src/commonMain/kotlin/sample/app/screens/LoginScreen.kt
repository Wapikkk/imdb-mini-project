package sample.app.screens
import sample.app.components.ButtonAuth
import sample.app.components.InputFieldAuth

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import com.wapekk.imdb.viewModel.ViewModelAuth

@Composable
fun LoginScreen (
    viewModel: ViewModelAuth,
    onLoginSuccess: () -> Unit,
    onRegisterClicked: () -> Unit
) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ){
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
            Text(
                "Masuk ke IMDb",
                style = MaterialTheme.typography.h4
            )
            Spacer(modifier = Modifier.height(32.dp))

            InputFieldAuth(
                value = email,
                onValueChange = {email = it},
                label = "Email"
            )

            InputFieldAuth(
                value = password,
                onValueChange = {password = it},
                label = "Password",
                isPassword = true
            )

            if (message.isNotEmpty()) {
                Text(text = message, color = Color.Red, modifier = Modifier.padding(top = 8.dp))
            }

            Spacer(modifier = Modifier.height(32.dp))

            ButtonAuth(
                text = "Masuk",
                onClick = {
                    viewModel.login(email, password)
                },
                isLoading = isLoading
            )

            TextButton(
                onClick = onRegisterClicked
            ) {
                Text("Belum punya akun? Daftar Di sini")
            }
        }
    }
}