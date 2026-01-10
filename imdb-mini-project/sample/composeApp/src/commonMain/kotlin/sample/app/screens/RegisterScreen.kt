package sample.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.graphics.*
import androidx.compose.material.icons.*
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
        var passwordVisible by remember { mutableStateOf(false) }
        var confirmPasswordVisible by remember { mutableStateOf(false) }

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

            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {Text ("Nama Lengkap")},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = phone,
                onValueChange = {phone = it},
                label = {Text ("Nomor Hp")},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = {Text("Email")},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                label = {Text("Password")},
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
                    }
                }
            )
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = {Text("Konfirmasi Password")},
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if(confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val image =
                        if (confirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Icon(
                            imageVector = image,
                            contentDescription = "Toggle Confirm Password Visibility"
                        )
                    }
                }
            )

            if (message.isNotEmpty()) {
                Text(
                    text = message,
                    color = if (isSuccess) Color.Green else Color.Red,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    viewModel.register(name, phone, email, password, confirmPassword)
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !isLoading
            ) {
                if (isLoading) {
                    CircularProgressIndicator(color = Color.White, modifier = Modifier.size(20.dp))
                } else {
                    Text ("Daftar")
                }
            }

            TextButton(
                onClick = onLoginSuccess
            ) {
                Text("Sudah punya akun? Login")
            }
        }
    }
}