package com.code.a0021_viewmodel_demo01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.code.a0021_viewmodel_demo01.ui.theme._0021_viewmodel_demo01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*_0021_viewmodel_demo01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
            */
            ViewModelDemo()
        }
    }
}

@Composable
@Preview
fun ViewModelDemo() {

    val state1 = remember {
        mutableStateOf("Hello #1")
    }

    val state2 = rememberSaveable {
        mutableStateOf("Hello #2")
    }

    val viewModel: MyViewModel = viewModel() //ViewModel

    val state3 =
        viewModel.text.observeAsState(viewModel.text.value) as State<String> //Observes value as state

    state3.value?.let {
        Column(modifier = Modifier.fillMaxWidth()) {
            MyTextField(state1) { state1.value = it }
            MyTextField(state2) { state2.value = it }
        }
    }
}

@Composable
fun MyTextField(
    value: State<String?>,
    onValueChange: (String) -> Unit
) {
    value.value?.let {
        TextField(
            value = it,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _0021_viewmodel_demo01Theme {
        Greeting("Android")
    }
}










