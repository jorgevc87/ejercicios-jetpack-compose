package com.example.a0001_basics.providers

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class HelloProvider : PreviewParameterProvider<String> {

    override val values: Sequence<String>
        get() = listOf("PreviewParameterProvider").asSequence()
}