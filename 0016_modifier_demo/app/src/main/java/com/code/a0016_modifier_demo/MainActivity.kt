package com.code.a0016_modifier_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code.a0016_modifier_demo.ui.theme._0016_modifier_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _0016_modifier_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    OrderDemo()
                }
            }
        }
    }
}

@Composable
fun OrderDemo() {
    var color by remember { mutableStateOf(Color.Blue) }

    /*
    Here you cand add or remove modifiers and apply to a compose view
    
     */

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .background(Color.LightGray)
            .border(BorderStroke(2.dp, color))
            .clickable {
                if (color == Color.Blue)
                    color = Color.Red
                else
                    color = Color.Blue
            }
    )
}

