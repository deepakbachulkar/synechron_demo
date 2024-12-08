package com.demo.synetest.ui.screen.details_item

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demo.synetest.ui.LabelText
import com.demo.synetest.ui.TopTitle
import com.demo.synetest.ui.ValueText
import com.demo.synetest.ui.capitalizeWords
import com.demo.synetest.ui.screen.list_items.viewmodel.ListItemsViewModel

@Composable
fun ItemDetailsScreen(viewModel: ListItemsViewModel, dbn: String) {
    val itemDetailsFlow by viewModel._itemDetailsFlow.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    val size by animateDpAsState(if (expanded) 400.dp else 200.dp)

    LaunchedEffect(Unit) {
        viewModel.getDetailsItem(dbn)
    }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp),
        tonalElevation = 8.dp) {
        Column {
            if (itemDetailsFlow.isEmpty())
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            else {
                Column(
                    modifier = Modifier
                        .size(size)
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable { expanded = !expanded },

                ) {
                    TopTitle(title = "School Sat Details", false)
                    if (itemDetailsFlow.isNotEmpty()) {
                        Spacer(modifier = Modifier.padding(10.dp))
                        Column(
                            modifier = Modifier
                                .padding(10.dp)
                        ) {
                            LabelText(text = "School Name: ")
                            ValueText(text = itemDetailsFlow[0].school_name.capitalizeWords())
                        }
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LabelText(text = "Sat Test takers: ")
                            ValueText(text = itemDetailsFlow[0].num_of_sat_test_takers ?: "")
                        }
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LabelText(text = "Sat critical reading average score: ")
                            ValueText(
                                text = itemDetailsFlow[0].sat_critical_reading_avg_score ?: ""
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LabelText(text = "Sat writing average score: ")
                            ValueText(text = itemDetailsFlow[0].num_of_sat_test_takers ?: "")
                        }
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LabelText(text = "Sat maths average score: ")
                            ValueText(text = itemDetailsFlow[0].sat_math_avg_score ?: "")
                        }
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            LabelText(text = "Sat writing average score: ")
                            ValueText(text = itemDetailsFlow[0].sat_writing_avg_score ?: "")
                        }

                    }
                }
            }
        }
    }

}