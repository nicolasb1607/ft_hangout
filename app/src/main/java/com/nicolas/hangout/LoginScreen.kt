package com.nicolas.hangout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LogoIcon() {
    Image(painter = painterResource(id = R.drawable.hangouts), contentDescription = "Logo")
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginInputFIelds() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("")  }
    var passwordVisible by remember { mutableStateOf(false)}
    Text(
        text = "Login",
        fontSize = 24.sp

    )
    OutlinedTextField(
        value = text,
        singleLine = true,
        onValueChange = { text = it },
        label = { Text(text = "UserName") }
    )
    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val imageIcon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}) {
                Icon(imageVector  = imageIcon, description)
            }
        },
        label = { Text(text = "Password") }
    )
}


@Composable
fun FilledButton(textValue: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { null },
        modifier = modifier
    ) {
        Text( text = textValue)
    }
}

@Preview(showSystemUi = true)
@Composable
fun LoginArea() {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        LogoIcon()
        Spacer(Modifier.padding(100.dp))
        LoginInputFIelds()
        Spacer(Modifier.padding(10.dp))
        FilledButton("continue", Modifier.width(280.dp))
        Text(text = "Sign up")
    }
}