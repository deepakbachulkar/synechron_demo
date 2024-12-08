package com.demo.synetest.ui.screen.list_items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.synetest.ui.TopTitle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.demo.synetest.data.model.Item
import com.demo.synetest.ui.screen.list_items.viewmodel.ListItemsViewModel

@Composable
fun ListItemsScreen(viewModel: ListItemsViewModel, onClickShow: (String)-> Unit) {
    val itemsFlow by viewModel._itemsFlow.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getListItem()
    }

    Surface {
        Column(modifier = Modifier.fillMaxWidth().fillMaxWidth()) {
            if(itemsFlow.isEmpty())
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            else {
                TopTitle(title = "Header", false)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(itemsFlow) {
                        ListItem(it, onClickShow)
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(item: Item,  onClickShow: (String)-> Unit) {
    Card() {
        Column( modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            Text(item.school_name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black,
                fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(item.location?:"", color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Light)
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                   onClickShow(item.dbn)
                }) {
                Text(text = "View Details")
            }
        }
    }
}