package com.code.a0016_modifier_demo.composables

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TextWithYellowBackground(
    text: String,
    modifier: Modifier
) {

    Text(text = text, modifier = modifier.background(Color.Yellow))

}