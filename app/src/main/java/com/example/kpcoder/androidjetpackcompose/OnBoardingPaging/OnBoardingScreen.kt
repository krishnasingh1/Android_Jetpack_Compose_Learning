package com.example.kpcoder.androidjetpackcompose.OnBoardingPaging

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kpcoder.androidjetpackcompose.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

// These Dependencies for This Page Design Required
/*
        // pager lib
    implementation "com.google.accompanist:accompanist-pager:0.23.1"
    // pager indicator
    implementation "com.google.accompanist:accompanist-pager-indicators:0.23.1"
    // coil
    implementation("io.coil-kt:coil-compose:2.2.2")
    // system ui controller
    implementation "com.google.accompanist:accompanist-systemuicontroller:0.27.0"
 */

data class HorizontalPagerContent(
    val title : String, @DrawableRes val res : Int, val description : String
)

fun getList() : List<HorizontalPagerContent> {

    return listOf(
        HorizontalPagerContent(
            "Verified",
            R.drawable.first,
            "Verification is an extra or final bit of proof that establishes something is true"
        ),
        HorizontalPagerContent(
            "Make it simple",
            R.drawable.second,
            "We pay attention to all of your payments and find way for saving your money"
        ),
        HorizontalPagerContent(
            "New Banking",
            R.drawable.third,
            "Free Advisory service,mobile banking application,visa"
        ),
        HorizontalPagerContent(
            "Zero Fees",
            R.drawable.fourth,
            "Bank your life,We create something new you have never seen before"
        )
    )

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun IntroScreen() {


    val pagerState = rememberPagerState()
    // this val for data list
    val list = getList()

    // some condition
    val isNextVisible = remember { derivedStateOf { pagerState.currentPage != list.size - 1 } }
    val isPrevVisible = remember { derivedStateOf { pagerState.currentPage != 0 } }

    // tis is for scope perform fo button back state or next state
    val scope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.75f)
        ) {
            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.CenterVertically,
                count = list.size
            ) { currentPage ->
                
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    
                    Text(
                        text = list[currentPage].title,
                        style = MaterialTheme.typography.h4,
                        color = Color.Black,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )

                    AsyncImage(
                        model = list[currentPage].res,
                        contentDescription = null,
                        modifier = Modifier
                            .height(380.dp)
                            .width(300.dp)
                    )

                    Text(
                        text = list[currentPage].description,
                        style = MaterialTheme.typography.body1,
                        color = Color.Gray,
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(.6f)
                            .align(
                                CenterHorizontally
                            )
                    )
                }

            }
        }

        HorizontalPagerIndicator(pagerState = pagerState, modifier = Modifier.padding(26.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {

            if (isPrevVisible.value){
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                    Text(text = "Prev")

                }
            }

            if (isPrevVisible.value && isNextVisible.value) {
                Box(modifier = Modifier.fillMaxWidth(.2f))
            }

            if (isNextVisible.value) {
                Button(onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }) {
                    Text(text = "Next")
                }
            }

        }
    }
}