package com.example.kpcoder.androidjetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kpcoder.androidjetpackcompose.R


@Composable
fun TextComposableFun() {

}


@Preview(showBackground = true)
@Composable
fun Text1() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello Android!",
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(16.dp)
        )

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(16.dp)
        )

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(16.dp),
            color = Color.White,
            fontSize = 20.sp

        )
        Text(
            text = "Hello Krishna!",
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .padding(16.dp)
                .width(200.dp),
            color = Color.White,
            fontSize = MaterialTheme.typography.h5.fontSize,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        CustomText()
        CustomText2()
        CustomText3()
        CustomText4()
        
        
    }
}

@Composable
fun CustomText() {
    Text(
        text = "Hello Krishna!",
        modifier = Modifier
            .background(MaterialTheme.colors.onPrimary)
            .padding(16.dp)
            .width(200.dp),
        color = Color.White,
        fontSize = MaterialTheme.typography.h5.fontSize,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
    
}

@Composable
fun CustomText2() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            ){
                append("A")
            }

            append("B")
            append("C")
            append("D")
        }
    )
}

@Composable
fun CustomText3() {
    Text(
        buildAnnotatedString {
           withStyle(
                style = ParagraphStyle(
                    textAlign = TextAlign.Center
                )
            ) {
                withStyle(
                    style = SpanStyle(
                        color =Color.Blue,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("A")
                }

                append("B")
                append("C")
                append("D")
            }
        }, modifier = Modifier.width(200.dp)
    )
}

@Composable
fun CustomText4() {
    Text(text = "Hello Krishna!".repeat(20), maxLines = 2, overflow = TextOverflow.Ellipsis)


}



