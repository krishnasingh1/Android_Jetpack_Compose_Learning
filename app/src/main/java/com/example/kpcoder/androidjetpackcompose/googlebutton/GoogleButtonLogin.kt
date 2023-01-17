package com.example.kpcoder.androidjetpackcompose.googlebutton

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kpcoder.androidjetpackcompose.R
import com.example.kpcoder.androidjetpackcompose.ui.theme.Shapes

@Preview
@Composable
fun GoogleButtonLogin() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        GoogleButton(
            onClicked = {
                Log.d("Google Button Clicked", "Clicked")
            }
        )

    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleButton(
    text: String = "Sigh Up with Google ",
    loadingText: String = "Creating Account...",
    icon: Painter = painterResource(id = R.drawable.ic_google_logo),
    shape : Shape = Shapes.medium,
    borderColor : Color = Color.LightGray,
    backgroundColor : Color = MaterialTheme.colors.surface,
    progressIndicatorColor : Color = MaterialTheme.colors.primary,
    onClicked : () ->  Unit
) {

    var clicked by remember { mutableStateOf(false) }

    Surface(
        onClick = { clicked = !clicked },
        shape = shape,
        border = BorderStroke(width = 1.dp, color =borderColor),
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = icon,
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (clicked) loadingText else text)
            Spacer(modifier = Modifier.width(8.dp))
            if (clicked) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )

            }
        }

    }
}

@Preview
@Composable
fun GoogleButtonDefaultPreview() {
    GoogleButton(onClicked =  {
        Log.d("Google Button Clicked", "Clicked")
    })
    
}