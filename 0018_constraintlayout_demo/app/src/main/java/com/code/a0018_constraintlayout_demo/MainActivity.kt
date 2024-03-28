package com.code.a0018_constraintlayout_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.code.a0018_constraintlayout_demo.composes.CheckboxWithLabel
import com.code.a0018_constraintlayout_demo.ui.theme._0018_constraintlayout_demoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _0018_constraintlayout_demoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ConstraintLayoutDemo()
                }
            }
        }
    }
}

@Composable
fun ConstraintLayoutDemo() {

    /*
    1.- create los mutablestates
    */
    val red = remember { mutableStateOf(true) }
    val blue = remember { mutableStateOf(true) }
    val green = remember { mutableStateOf(true) }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val (cbRed, cbGreen, cbBlue, boxRed, boxGreen, boxBlue) = createRefs()

        CheckboxWithLabel(
            label = stringResource(id = R.string.red),
            state = red,
            modifier = Modifier.constrainAs(cbRed) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            }
        )

        CheckboxWithLabel(
            label = stringResource(id = R.string.green),
            state = green,
            modifier = Modifier.constrainAs(cbGreen) {
                top.linkTo(cbRed.bottom)
                start.linkTo(parent.start)
            }
        )

        CheckboxWithLabel(
            label = stringResource(id = R.string.blue),
            state = blue,
            modifier = Modifier.constrainAs(cbBlue) {
                start.linkTo(parent.start)
                top.linkTo(cbGreen.bottom)
            }
        )

        Box(modifier = Modifier
            //.padding(16.dp)  //Aplying margin in all sides
            .constrainAs(boxRed) {
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
                top.linkTo(cbBlue.bottom)
                bottom.linkTo(parent.bottom, margin = 16.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
            .background(Color.Red)
            .clickable {

            }) {

        }

        Box(modifier = Modifier
            //.padding(16.dp)  //Aplying margin in all sides
            .constrainAs(boxBlue) {
                start.linkTo(parent.start, margin = 32.dp)
                end.linkTo(parent.end, margin = 32.dp)
                top.linkTo(cbBlue.bottom, margin = 16.dp)
                bottom.linkTo(parent.bottom, margin = 32.dp)
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }
            .background(Color.Blue)
            .clickable {

            })
    }
}



























