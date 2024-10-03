package com.example.appmusicacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenOrientation()
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Preview(
        showSystemUi = true,
        device = "spec:width=411dp,height=891dp,dpi=420,isRound=false,chinSize=0dp,orientation=landscape"
    )

    @Composable
    fun ScreenOrientation(){
        val configuration = LocalConfiguration.current
        val isLandscape = configuration.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE
        var reproducir by remember { mutableStateOf(false) }
        var cancion2 by remember { mutableStateOf(false) }
        var volume by remember { mutableStateOf(75f) }
        var progresoCancion by remember { mutableStateOf(25f)}

        if (isLandscape){
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    if (cancion2) {
                        Image(
                            painter = painterResource(id = R.drawable.album2),
                            contentDescription = "Album2",
                            modifier = Modifier.size(250.dp)
                        )
                        Text("Avril Lavigne", fontSize = 24.sp, fontFamily = FontFamily.Monospace)
                        Text("Complicated", fontSize = 16.sp, fontFamily = FontFamily.Serif)
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.album1),
                            contentDescription = "Album1",
                            modifier = Modifier.size(250.dp)
                        )
                        Text("Avril Lavigne", fontSize = 24.sp, fontFamily = FontFamily.Monospace)
                        Text("Complicated", fontSize = 16.sp, fontFamily = FontFamily.Serif)
                    }

                    Slider(
                        value = progresoCancion,
                        onValueChange = { progresoCancion = it },
                        modifier = Modifier.width(400.dp)
                    )
                }


                Column (
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 10.dp),
                    horizontalAlignment = AbsoluteAlignment.Left
                ){
                    Image(
                        painter = painterResource(id = R.drawable.listadocanciones),
                        contentDescription = "listadoCanciones",
                        modifier = Modifier.size(100.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.verletra),
                        contentDescription = "verLetra",
                        modifier = Modifier.size(100.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.compartir),
                        contentDescription = "compartir",
                        modifier = Modifier.size(100.dp)
                    )
                }

                Column (
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 10.dp),
                    horizontalAlignment = AbsoluteAlignment.Left
                ){

                    IconButton(onClick = { cancion2 = false }) {
                        Image(painter = painterResource(id = R.drawable.anterior),
                            contentDescription = "Anterior",
                            modifier = Modifier.size(100.dp)
                        )
                    }

                    IconButton(onClick = { reproducir = !reproducir }) {
                        if (reproducir) {
                            Image(painter = painterResource(id = R.drawable.pause),
                                contentDescription = "Pausa",
                                modifier = Modifier.size(100.dp)
                            )
                        } else {
                            Image(painter = painterResource(id = R.drawable.play),
                                contentDescription = "Reproducir",
                                modifier = Modifier.size(100.dp)
                            )
                        }
                    }

                    IconButton(onClick = { cancion2 = true }) {
                        Image(painter = painterResource(id = R.drawable.siguiente),
                            contentDescription = "Siguiente",
                            modifier = Modifier.size(100.dp)
                        )
                    }

                }

                }
        } else {
            MusicScreenVertical()
        }

}

    @Composable
     private fun MusicScreenVertical(){
        var reproducir by remember { mutableStateOf(false) }
        var cancion2 by remember { mutableStateOf(false) }
        var volume by remember { mutableStateOf(75f) }
        var progresoCancion by remember { mutableStateOf(25f)}

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Volumen", fontSize = 20.sp, fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .width(400.dp)
                    .height(30.dp),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Slider( value = volume, onValueChange = {volume = it},
                modifier = Modifier.width(400.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.listadocanciones),
                    contentDescription = "listadoCanciones",
                    modifier = Modifier.size(100.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.verletra),
                    contentDescription = "verLetra",
                    modifier = Modifier.size(100.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.compartir),
                    contentDescription = "compartir",
                    modifier = Modifier.size(100.dp)
                )

            }

            if (cancion2) {
                Image(
                    painter = painterResource(id = R.drawable.album2),
                    contentDescription = "Album2",
                    modifier = Modifier.size(200.dp)
                )
                Text("Avril Lavigne", fontSize = 24.sp, fontFamily = FontFamily.Monospace)
                Text("Complicated", fontSize = 16.sp, fontFamily = FontFamily.Serif)
            } else {
                Image(
                    painter = painterResource(id = R.drawable.album1),
                    contentDescription = "Album1",
                    modifier = Modifier.size(300.dp)
                )
                Text("Avril Lavigne", fontSize = 24.sp, fontFamily = FontFamily.Monospace)
                Text("Complicated", fontSize = 16.sp, fontFamily = FontFamily.Serif)
            }

            Slider(
                value = progresoCancion,
                onValueChange = { progresoCancion = it },
                modifier = Modifier.width(400.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = { cancion2 = false }) {
                    Image(painter = painterResource(id = R.drawable.anterior),
                        contentDescription = "Anterior",
                        modifier = Modifier.size(50.dp)
                    )
                }
                IconButton(onClick = { reproducir = !reproducir }) {
                    if (reproducir) {
                        Image(painter = painterResource(id = R.drawable.pause), contentDescription = "Pausa")
                    } else {
                        Image(painter = painterResource(id = R.drawable.play), contentDescription = "Reproducir")
                    }
                }
                IconButton(onClick = { cancion2 = true }) {
                    Image(painter = painterResource(id = R.drawable.siguiente), contentDescription = "Siguiente")
                }
            }

        }


    }
}