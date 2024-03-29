package com.code.a0003_predefinedlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code.a0003_predefinedlayout.ui.theme._0003_PredefinedLayoutTheme

/*
Main axes:
- Horizontal
- Vertical
- stacked
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _0003_PredefinedLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //CheckWithLabel(label = "My Checkbox", state = true)
                    PredefinedLayout()
                }
            }
        }
    }
}

//Pre-defined view
@Composable
fun PredefinedLayout() {
    //Variables to keep the state on run time
    val red = remember { mutableStateOf(true) }
    val green = remember { mutableStateOf(true) }
    val blue = remember { mutableStateOf(true) }

    //Building the layout
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        //Our custom checkboxes
        CheckWithLabel(
            label = "Red",
            state = red
        )

        CheckWithLabel(
            label = "Green",
            state = green
        )

        CheckWithLabel(
            label = "Blue",
            state = blue
        )

        //stacked squares
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            if (red.value) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Red))
            }

            if (green.value) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp)
                    .background(Color.Green))
            }

            if(blue.value){
                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(64.dp)
                    .background(Color.Blue))
            }
        }
    }
}

//Creating el checkbox
@Composable
fun CheckWithLabel(label: String, state: MutableState<Boolean>) {
    Row(
        modifier = Modifier.clickable { state.value = !state.value },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = state.value, onCheckedChange = {
            state.value = it
        })

        Text(text = label, modifier = Modifier.padding(start = 8.dp))
    }
}






