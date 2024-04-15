package com.example.a0019_statefull_stateless_demo01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a0019_statefull_stateless_demo01.ui.theme._0019_stateFull_stateLess_demo01Theme
import java.util.Date
import java.util.SimpleTimeZone
import kotlin.properties.Delegates
import kotlin.random.Random

/*
State -> Value/Data that change over time,
when it´s change then the UI is notified

To achieve this, compose uses observable patter
*/

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _0019_stateFull_stateLess_demo01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //SimpleStateDemo1()
                    //RememberWithKeyDemo()
                    //SimpleStatelessComposable()

                    val mText = remember {
                        derivedStateOf { "Helloooo mtfck" }
                    }

                    SimpleStateLessComposable2(mText)
                }
            }
        }

        for (i in 0..3) counter = i
    }


    var counter by Delegates.observable(-1) { _, oldValue, newValue ->
        println("oldValue: $oldValue -> newValue: $newValue")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _0019_stateFull_stateLess_demo01Theme {
        Greeting("Android")
    }
}

@Composable
@Preview(showBackground = true)
fun SimpleStateDemo1() {
    val num = remember { mutableStateOf(Random.nextInt(0, 10)) }

    Text(text = num.value.toString())
}


/*
statefull function, hold states for example
key and date
*/
/*
@Composable
@Preview(showBackground = true)
fun RememberWithKeyDemo() {

    var key by remember {
        mutableStateOf(false)
    }

    val date by remember(key) { mutableStateOf(Date()) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(date.toString())

        Button(onClick = { key = !key }) {
            Text(text = "Click")
        }
    }
}
*/

/*
example of stateless function
*/
@Composable
@Preview(showBackground = true)
fun SimpleStatelessComposable() {
    Text(text = "Hello Compose")
    /*
    Does not receive parameters and it always calls Text() with
    the same parameters
    */
}

@Composable
fun SimpleStateLessComposable2(text: State<String>) {
    Text(text = text.value)
    /*
    While it receives state through the text parameter, it does not
    store it, and it does not remember other state. Consequently,
    SimpleStateLessComposable2 is stateless.
    */
}







































