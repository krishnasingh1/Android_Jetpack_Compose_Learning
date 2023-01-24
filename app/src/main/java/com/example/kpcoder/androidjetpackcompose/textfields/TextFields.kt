package com.example.kpcoder.androidjetpackcompose.textfields

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun TextFields() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextField()
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextFields()
            Spacer(modifier = Modifier.height(10.dp))
            BasicTextField()
        }

    }
}

@Preview
@Composable
fun SimpleTextField() {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.White)
    ) {
        var text by remember { mutableStateOf("Type here...") }
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            //enabled = true
            //readOnly = false
            label = { Text(text = "Title") },
            singleLine = true,
            //maxLines = 2
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    Log.d("Trailing Icons", "Clicked")
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Check Icon")

                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d("ImeActions", "Clicked")
                }
            )

        )
    }
}

@Preview
@Composable
fun OutlinedTextFields() {

    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.White)
    ) {
        var text by remember { mutableStateOf("Type here...") }
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            //enabled = true
            //readOnly = false
            label = { Text(text = "Title") },
            singleLine = true,
            //maxLines = 2
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")

                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    Log.d("Trailing Icons", "Clicked")
                }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "Check Icon")

                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d("ImeActions", "Clicked")
                }
            )

        )
    }
}

@Preview
@Composable
fun BasicTextField() {

    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(color = Color.White)
    ) {
        var text by remember { mutableStateOf("Type here...") }
        androidx.compose.foundation.text.BasicTextField(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(16.dp),
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            //enabled = true
            //readOnly = false
            // These Functions are not work in Basic text Field
//            label = { Text(text = "Title")},
            singleLine = true,
            //maxLines = 2
//            leadingIcon = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(imageVector = Icons.Default.Email, contentDescription = "Email Icon")
//
//                }
//            },
//            trailingIcon = {
//                IconButton(onClick = {
//                    Log.d("Trailing Icons", "Clicked")
//                }) {
//                    Icon(imageVector = Icons.Default.Check, contentDescription = "Check Icon")
//
//                }
//            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    Log.d("ImeActions", "Clicked")
                }
            )

        )
    }

}