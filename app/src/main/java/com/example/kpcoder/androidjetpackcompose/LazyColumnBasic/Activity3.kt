package com.example.kpcoder.androidjetpackcompose.LazyColumnBasic.repository

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kpcoder.androidjetpackcompose.LazyColumnBasic.CustomItem

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun Lazy3() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val sections = listOf("A", "B", "C", "D", "E", "F", "G")

        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            sections.forEach { section ->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(12.dp),
                        text = "Section $section"
                    )
                }
                items(10){
                    Text(modifier = Modifier.padding(12.dp),
                        text = "Item $it from the section $section")
                }
            }
        }

    }

}