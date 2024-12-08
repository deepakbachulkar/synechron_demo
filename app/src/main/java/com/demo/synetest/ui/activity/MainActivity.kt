package com.demo.synetest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.demo.synetest.ui.screen.AppNavigationGraph
import com.demo.synetest.ui.screen.list_items.viewmodel.ListItemsViewModel
import com.demo.synetest.ui.theme._1DemoMvvmTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class ListItemsActivity : ComponentActivity() {
    val viewModel: ViewModel by viewModels<ListItemsViewModel>()
    val viewModelMainTest :MainViewMode by viewModels<MainViewMode>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            _1DemoMvvmTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppShow(
                        name = "Android App",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

    }

    @Composable
    fun AppShow(name: String, modifier: Modifier = Modifier) {
        Column {
            AppNavigationGraph(viewModel = viewModel)
//            CounterScreen()
//            HoistingCounter()
//            launchedEffectTimer()
        }
    }


    @Composable
    fun CounterScreen() {
//    var count by remember { mutableStateOf(0) }
        val count by viewModelMainTest.count.collectAsState()
        Column {
            Text(text = "Count: $count")
            Button(onClick = {
                viewModelMainTest.increment()
            }) {
                Text("Increment")
            }
        }
    }

    @Composable
    fun HoistingCounter(){
        var count by remember { mutableIntStateOf(0) }
        HoistingChildCounter(count) {
            count++
        }
    }
    @Composable
    fun HoistingChildCounter(count:Int, onIncrement: ()->Unit){
            Column {
                Text(text = "Count:= $count")
                Button(onClick = {
                    onIncrement()
                }) {
                    Text(text = "Increment")
                }

            }
        }

    @Composable
    fun launchedEffectTimer(){
        var time by remember { mutableStateOf(0) }
        LaunchedEffect(Unit) {
            while (true){
                delay(1000)
                time++
            }
        }
        Text(text = "Time: $time seconds")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _1DemoMvvmTheme {
    }
}


