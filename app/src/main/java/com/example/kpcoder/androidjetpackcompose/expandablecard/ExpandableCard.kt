package com.example.kpcoder.androidjetpackcompose.expandablecard

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kpcoder.androidjetpackcompose.ui.theme.Shapes




@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard (
    title : String,
    description : String
) {


    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .animateContentSize(
                animationSpec = tween(
                    // this means that time to open this expended state
                    durationMillis = 300,
                    // this is for linearly slow show
                    easing = LinearOutSlowInEasing
                )
            ),
        // this Shapes.medium already assign in AppTheme
        shape = Shapes.medium,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier
                        .weight(6f),
                    text = title,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(1f)
                        .alpha(ContentAlpha.medium)
                        .rotate(rotationState),
                    onClick = {expandedState = !expandedState
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down Arrow"
                    )
                    
                }
            }
            if (expandedState)  {
                Text(
                    text = description,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

    }

}

@Preview
@Composable
fun ExpandableCardPreview() {
    ExpandableCard(
        title = "My Title",
        description = "In publishing and graphic design, Lorem ipsum " +
                "is a placeholder text commonly used to demonstrate" +
                " the visual form of a document or a typeface without " +
                "relying on meaningful content. Lorem ipsum may be used as " +
                "a placeholder before final copy is available. Wikipedia\n")
}