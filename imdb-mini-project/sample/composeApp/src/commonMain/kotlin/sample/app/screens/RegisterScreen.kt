package sample.app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.*
import moe.tlaster.precompose.viewmodel.viewModel

@Composable
fun RegisterScreen(onRegisterSuccess: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState())
    ){
        Text("Buat Akun Baru", style = MaterialTheme.typography.h5)

        OutlinedTextField(value = name, onValueChange = {name = it}, label = {Text ("Nama Lengkap")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = phone, onValueChange = {phone = it}, label = {Text ("Nomor Hp")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = email, onValueChange = {email = it}, label = {Text("Email")}, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = password, onValueChange = {password = it}, label = {Text("Password")}, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = confirmPassword, onValueChange = {confirmPassword = it}, label = {Text("Konfirmasi Password")}, visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text ("Daftar")
        }
    }
}