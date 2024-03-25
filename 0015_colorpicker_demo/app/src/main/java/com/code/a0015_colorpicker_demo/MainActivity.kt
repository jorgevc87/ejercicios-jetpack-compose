package com.code.a0015_colorpicker_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.code.a0015_colorpicker_demo.ui.theme._0015_colorpicker_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _0015_colorpicker_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val color = remember { mutableStateOf(Color.Magenta) }

                    //Greeting("Android")
                    ColorPicker(color = color)
                }
            }
        }
    }
}

@Composable
fun ColorPicker(color: MutableState<Color>) {

    val green = color.value.green
    val red = color.value.red
    val blue = color.value.blue

    Column {
        Text(text = "Red", modifier = Modifier.padding(12.dp))

        Slider(value = red, onValueChange = {
            color.value = Color(it, green, blue)
        })

        Text(text = "Green", modifier = Modifier.padding(12.dp))

        Slider(value = green, onValueChange = {
            color.value = Color(red, it, blue)
        })

        Text(text = "blue", modifier = Modifier.padding(12.dp))

        Slider(value = blue, onValueChange = {
            color.value = Color(red, green, it)
        })
    }
}

@Composable
fun sss() {
    Column(
        modifier = Modifier.width(min(400.dp, ))
    ) {

    }
}







