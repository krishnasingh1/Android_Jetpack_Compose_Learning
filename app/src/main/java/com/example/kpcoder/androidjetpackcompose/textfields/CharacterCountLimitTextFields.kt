package com.example.kpcoder.androidjetpackcompose.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyComposable() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CharacterCountTextFields()
    }

}

@Preview(showBackground = true)
@Composable
fun CharacterCountTextFields() {
    Column {
        var name by remember {
            mutableStateOf("")
        }
        val maxChar = 10

        OutlinedTextField(
            value =name,
            onValueChange ={
                if (it.length <= maxChar){
                    name = it
                }
            },
            label = { Text(text = "Name") },
            placeholder = { Text(text = "Enter your name") },
            maxLines = 1
        )

    }

}