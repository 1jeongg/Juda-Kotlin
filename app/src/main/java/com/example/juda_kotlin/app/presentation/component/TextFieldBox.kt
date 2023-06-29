package com.example.juda_kotlin.app.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.TextStyle
import com.example.juda_kotlin.ui.theme.TextStyles
import com.example.juda_kotlin.ui.theme.main_gray

@Composable
fun TextFieldBox(
    text: String = "",
    hint: String = "",
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
    isHintVisible: Boolean = true,
    onFocusChange: (FocusState) -> Unit = {},
    textStyle: TextStyle = TextStyles.textSearch
){
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            textStyle = textStyle,
            //keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()}),
            modifier = Modifier.onFocusChanged { onFocusChange(it) }
        )
        if (isHintVisible) {
            Text(
                text = hint,
                style = textStyle,
                color = main_gray,
            )
        }
    }

}