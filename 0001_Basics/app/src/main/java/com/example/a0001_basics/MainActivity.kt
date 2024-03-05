package com.example.a0001_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderDemo()
            //Greeting(name = "Jorgevc")
        }
    }

    @Preview
    @Composable
    fun OrderDemo() {
        var color by remember { mutableStateOf(Color.Blue) }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .border(BorderStroke(width = 2.dp, color = color))
            .background(Color.LightGray)
            .clickable {
                color = if (color == Color.Blue)
                    Color.Red
                else
                    Color.Blue
            }
        )
    }

    //another composable
    @Composable
    fun TextWithYellowBackground(text: String, modifier: Modifier = Modifier) {
        Text(text = text, modifier = modifier.background(Color.Yellow))
    }

    @Composable
    private fun Greeting(name: String) {
        Column(modifier = Modifier
            .padding(24.dp)
            .background(color = Color.Red)
        ) {
            Text(text = "Hello, ")
            Text(text = name)
        }
    }
}