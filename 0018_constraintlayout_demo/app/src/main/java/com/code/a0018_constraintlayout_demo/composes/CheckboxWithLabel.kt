package com.code.a0018_constraintlayout_demo.composes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun CheckboxWithLabel(
    label: String,
    state: MutableState<Boolean>,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier.clickable { //Here we are saying the constraintlayout is clickabe
            state.value = !state.value
        }
    ) {

        /*
        1.- Create the refs
        2.- Assing to the views
        3.- Apply constraints
        */

        val (checkbox, text) = createRefs()

        Checkbox(checked = state.value, onCheckedChange = {
            state.value = it
        }, modifier = Modifier.constrainAs(checkbox) {
            /*
            Here we handle the constraints to this view
            */


        })

        Text(text = label, modifier = Modifier.constrainAs(text) {
            top.linkTo(parent.top)
            start.linkTo(checkbox.end)
            bottom.linkTo(parent.bottom)
        })

    }
}
























