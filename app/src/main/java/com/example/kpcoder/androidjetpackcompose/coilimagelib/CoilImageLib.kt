package com.example.kpcoder.androidjetpackcompose.coilimagelib

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.State
import coil.ImageLoader
import coil.compose.*
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation


@Preview
@Composable
fun CoilImageLib() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CoilImage()

    }

}

@Preview
@Composable
fun CoilImage() {

    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(com.example.kpcoder.androidjetpackcompose.R.drawable.new_image)
                .error(com.example.kpcoder.androidjetpackcompose.R.drawable.ic_launcher_background)
                .placeholder(com.example.kpcoder.androidjetpackcompose.R.drawable.icon3085)
                .crossfade(1000)
                .transformations(

                    //CircleCropTransformation()
                    RoundedCornersTransformation(50f)
                )
                .build(),
            //placeholder = painterResource(com.example.kpcoder.androidjetpackcompose.R.drawable.ic_google_logo)
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo Image" )
//        if (painterState is AsyncImagePainter.State.Loading) {
//            CircularProgressIndicator()
//        }
    }

}