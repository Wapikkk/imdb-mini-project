package sample.app.screens
import sample.app.components.InputFieldAuth
import sample.app.components.ButtonAuth

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import com.wapekk.imdb.viewModel.ViewModelAuth

@Composable
fun RegisterScreen(
    viewModel: ViewModelAuth,
    onLoginSuccess: () -> Unit,
    onRegisterSuccess: () -> Unit
) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ){
        var name by remember { mutableStateOf("") }
        var phone by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }

        val isLoading by viewModel.isLoading.collectAsState()
        val message by viewModel.message.collectAsState()
        val isSuccess by viewModel.isSuccess.collectAsState()

        LaunchedEffect(isSuccess) {
            if(isSuccess) {
                onRegisterSuccess()
                viewModel.resetState()
            }
        }

        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("Buat Akun Baru", style = MaterialTheme.typography.h5)

            InputFieldAuth(
                value = name,
                onValueChange = { name = it },
                label = "Nama Lengkap"
            )

            InputFieldAuth(
                value = phone,
                onValueChange = { phone = it },
                label = "Nomor Hp"
            )

            InputFieldAuth(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )

            InputFieldAuth(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                isPassword = true
            )

            InputFieldAuth(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = "Konfirmasi Password",
                isPassword = true
            )

            if (message.isNotEmpty()) {
                Text(
                    text = message,
                    color = if (isSuccess) Color.Green else Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            ButtonAuth(
                text = "Daftar",
                onClick = {
                    viewModel.register(name, phone, email, password, confirmPassword)
                },
                isLoading = isLoading
            )

            TextButton(
                onClick = onLoginSuccess
            ) {
                Text(
                    "Sudah punya akun? Login",
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}