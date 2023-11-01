package com.fortunetiasasger.exampale.lesson.mvvm.l1

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Light Mode")@Composable
fun ScreenLazyColum(){
    Conversation(SampleData.conversationSample)
}
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}
