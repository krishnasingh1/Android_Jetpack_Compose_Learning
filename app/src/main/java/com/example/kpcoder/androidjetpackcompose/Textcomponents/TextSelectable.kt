package com.example.kpcoder.androidjetpackcompose.Textcomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TextSelectionCont() {
    Column(modifier = Modifier.padding(12.dp).fillMaxSize().background(Color.White)) {
        TextSelectable()

    }

}

@Composable
fun TextSelectable() {
    // this SelectionContainer  for all text are selectable
    SelectionContainer {

        Column {
            Text(text = "Hello Krishna!")
            // this DisableSelection for Text not selectable
            DisableSelection {
                Text(text = "Hello Ram!")
            }
           Text(text = "Hello World!")
        }
    }
}