package com.example.kpcoder.androidjetpackcompose.PasswordInputTextField

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.kpcoder.androidjetpackcompose.R

@Preview
@Composable
fun PasswordInputTextField() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextFieldColors1()

    }

}

@Preview
@Composable
fun TextFieldColors1() {

    Column {
        var password by rememberSaveable {
            mutableStateOf("")
        }

        var passwordVisibility by remember { mutableStateOf(false) }

        val icon = if (passwordVisibility)
            painterResource(id = R.drawable.design_ic_visibility)
        else
            painterResource(id = R.drawable.design_ic_visibility_off)


        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = { Text(text = "Password") },
            label = { Text(text = "Password") },
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "visibility icon"
                    )

                }
            },
            // this is for password visible or not with button visibility
            visualTransformation =
                if (passwordVisibility) VisualTransformation.None
                else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )
    }

}