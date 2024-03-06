package com.example.navcontroler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navcontroler.ui.theme.NavControlerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavControlerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "pagina1") {
                    composable("pagina1") {
                        Pagina1(
                            onNavigateToPagina2 = { navController.navigate("pagina2") }
                        ) { navController.navigate("pagina3") }
                    }
                    composable("pagina2") {
                        Pagina2(
                            onNavigateToPagina1 = { navController.navigate("pagina1") }
                        ) { navController.navigate("pagina3") }
                    }
                    composable("pagina3") {
                        Pagina3(
                            onNavigateToPagina1 = { navController.navigate("pagina1") }
                        ) { navController.navigate("pagina2") }
                    }
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pagina1(
    onNavigateToPagina2: () -> Unit,
    onNavigateToPagina3: () -> Unit
): Unit {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.paddingFromBaseline(
            top = 40.dp
        )){
            IconButton(onClick = onNavigateToPagina2 ,
                modifier = Modifier.size(75.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "IMG",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(modifier = Modifier.weight(1F)){
            Text(text = "Pagina 2")
        }
        Row(modifier = Modifier.paddingFromBaseline(
            top = 40.dp
        )){
            IconButton(onClick = onNavigateToPagina3 ,
                modifier = Modifier.size(75.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "IMG",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(modifier = Modifier.weight(1F)){
            Text(text = "Pagina 3")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pagina2(
    onNavigateToPagina1: () -> Unit,
    onNavigateToPagina3: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.paddingFromBaseline(
            top = 40.dp
        )){
            IconButton(onClick = onNavigateToPagina1 ,
                modifier = Modifier.size(75.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "IMG",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(modifier = Modifier.weight(1F)){
            Text(text = "Pagina 1")
        }
        Row(modifier = Modifier.paddingFromBaseline(
            top = 40.dp
        )){
            IconButton(onClick = onNavigateToPagina3 ,
                modifier = Modifier.size(75.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "IMG",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(modifier = Modifier.weight(1F)){
            Text(text = "Pagina 3")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pagina3(
    onNavigateToPagina1: () -> Unit,
    onNavigateToPagina2: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.paddingFromBaseline(
            top = 40.dp
        )){
            IconButton(onClick = onNavigateToPagina1 ,
                modifier = Modifier.size(75.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "IMG",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(modifier = Modifier.weight(1F)){
            Text(text = "Pagina 1")
        }
        Row(modifier = Modifier.paddingFromBaseline(
            top = 40.dp
        )){
            IconButton(onClick = onNavigateToPagina2 ,
                modifier = Modifier.size(75.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "IMG",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Row(modifier = Modifier.weight(1F)){
            Text(text = "Pagina 2")
        }
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
    NavControlerTheme {
        Greeting("Android")
    }
}