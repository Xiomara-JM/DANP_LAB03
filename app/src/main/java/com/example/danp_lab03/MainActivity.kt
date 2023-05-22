package com.example.danp_lab03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.danp_lab03.ui.theme.DANP_LAB03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DANP_LAB03Theme {
                // lista en la cual se guardaran los registros de tipo Asistente
                var listaAsistentes = remember { mutableStateListOf<Asistente>() }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AsistentesCRUD(listaAsistentes)
                }
            }
        }
    }
}

@Composable
fun AsistentesCRUD(listaAsistentes: MutableList<Asistente>) {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var fechaInscripcion by remember { mutableStateOf("") }
    var tiposangre by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    var editandoRegistro by remember { mutableStateOf(false) }
    var textoBoton by remember { mutableStateOf("Agregar Asistente") }

    Column ( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        horizontalAlignment  =  Alignment.CenterHorizontally,
    ) {
        Text( modifier = Modifier.padding(8.dp), text = "Asistentes al Congreso" )
        Formulario(
            nombre = nombre,
            funNombre = { nombre = it },
            apellidos = apellidos,
            funApellidos = { apellidos = it },
            fechaInscripcion = fechaInscripcion,
            funFechaInscripcion = { fechaInscripcion = it },
            tipoSangre = tiposangre,
            funTipoSangre = { tiposangre = it },
            telefono = telefono,
            funTelefono = { telefono = it },
            correo = correo,
            funCorreo = { correo = it },
            monto = monto,
            funMonto = { monto = it },
            editandoRegistro = editandoRegistro,
            funEditandoRegistro = { editandoRegistro = false },
            textoBoton = textoBoton,
            funTextoBoton = { textoBoton = it },
            listaAsistentes = listaAsistentes,
            limpiarCampos = {
                nombre = ""
                apellidos = ""
                fechaInscripcion = ""
                tiposangre = ""
                telefono = ""
                correo = ""
                monto = ""
            }
        )
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
        ){
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ){
                items(listaAsistentes){
                    asistente -> CardAsistente(
                    funNombre = { nombre = it },
                    funApellidos = { apellidos = it },
                    funFechaInscripcion = { fechaInscripcion = it },
                    funTipoSangre = { tiposangre = it },
                    funTelefono = { telefono = it },
                    funCorreo = { correo = it },
                    funMonto = { monto = it },
                    funTextoBoton = { textoBoton = it },
                    funEditandoRegistro = { editandoRegistro = it },
                    funEliminarAsistente = { eliminarAsistente(it, listaAsistentes) },
                    asistente = asistente,
                    )
                }
            }

        }
    }
}

fun agregarAsistente(
    nombre: String,
    apellidos: String,
    fechaInscripcion: String,
    tipoSangre: String,
    telefono: String,
    correo: String,
    monto: String,
    listaAsistentes: MutableList<Asistente>,
){
    listaAsistentes.add(
        Asistente(nombre, apellidos, fechaInscripcion, tipoSangre, telefono, correo, monto)
    )
}

fun editarAsistente(
    nombre: String,
    apellidos: String,
    fechaInscripcion: String,
    tipoSangre: String,
    telefono: String,
    correo: String,
    monto: String,
    listaAsistentes: MutableList<Asistente>,
){
    listaAsistentes.forEach(){
        asistente ->
        if (asistente.correo == correo) {
            asistente.nombre = nombre
            asistente.apellidos = apellidos
            asistente.fechaInscripcion = fechaInscripcion
            asistente.tipoSangre = tipoSangre
            asistente.telefono = telefono
            asistente.monto = monto
        }
    }
}

fun eliminarAsistente(correo: String, listaAsistentes: MutableList<Asistente>){
    listaAsistentes.forEach{
        asistente ->
        if(asistente.correo == correo){
            listaAsistentes.remove(asistente)
        }
    }
}

/*
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DANP_LAB03Theme {
        AsistentesCRUD()
    }
}*/
