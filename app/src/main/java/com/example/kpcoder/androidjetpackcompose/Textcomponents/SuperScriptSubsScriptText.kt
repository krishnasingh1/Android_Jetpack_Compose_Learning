package com.example.kpcoder.androidjetpackcompose.Textcomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun SuperScriptAndSunsScript() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(5.dp)) {

        SuperScriptText(normalText = "Hello", superText = "Krishna!" , superTextFontWeight = FontWeight.Bold)



    }

}

@Composable
fun SuperScriptText(
    normalText : String,
    normalFontSize : TextUnit = MaterialTheme.typography.subtitle1.fontSize,
    superText : String,
    superFontSize : TextUnit = MaterialTheme.typography.overline.fontSize,
    superTextFontWeight : FontWeight = FontWeight.Normal
) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = normalFontSize// this is also work//MaterialTheme.typography.subtitle1.fontSize
            )
        ){
            append(normalText)
        }

        withStyle(
            style = SpanStyle(
                fontSize = superFontSize, // this is also work //MaterialTheme.typography.overline.fontSize,
                fontWeight = superTextFontWeight,// this is also work FontWeight.Normal,
                baselineShift = BaselineShift.Superscript,
               // baselineShift = BaselineShift.Subscript
            )
        ){
            append(superText)
        }
    })
    
}