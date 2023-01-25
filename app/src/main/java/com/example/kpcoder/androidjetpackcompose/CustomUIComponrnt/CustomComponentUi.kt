package com.example.kpcoder.androidjetpackcompose.CustomUIComponrnt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun CustomComponentUi() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp).background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var value by remember {
            mutableStateOf(0)
        }
        CircularIndicator(
            indicatorValue = value,
            // Customize Default values
            maxIndicatorValue = 1000,
            backgroundIndicatorStrokeWidth = 50f, //50f, 20f
            foregroundIndicatorStrokeWidth = 50f, // 20f
            bigTextSuffix = "MB",
        )

        TextField(
            value = value.toString(),
            onValueChange = {
                value = if (it.isNotEmpty()) {
                    it.toInt()
                } else {
                    0
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
        )

    }
}