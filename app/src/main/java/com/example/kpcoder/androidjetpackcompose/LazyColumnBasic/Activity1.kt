package com.example.kpcoder.androidjetpackcompose.LazyColumnBasic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kpcoder.androidjetpackcompose.LazyColumnBasic.model.Person
import com.example.kpcoder.androidjetpackcompose.LazyColumnBasic.repository.PersonRepository

@Preview
@Composable
fun Lazy1() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val personRepository = PersonRepository()
        val getAllData = personRepository.getAllData()

        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = getAllData) { Person ->
                CustomItem(person = Person)
            }
        }

    }

}