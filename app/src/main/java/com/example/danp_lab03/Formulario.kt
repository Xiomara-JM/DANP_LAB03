package com.example.danp_lab03

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Formulario (
    nombre: String,
    funNombre: (String) -> Unit,
    apellidos: String,
    funApellidos: (String) -> Unit,
    fechaInscripcion: String,
    funFechaInscripcion: (String) -> Unit,
    tipoSangre: String,
    funTipoSangre: (String) -> Unit,
    telefono: String,
    funTelefono: (String) -> Unit,
    correo: String,
    funCorreo: (String) -> Unit,
    monto: String,
    funMonto: (String) -> Unit,
    editandoRegistro: Boolean,
    funEditandoRegistro: () -> Unit,
    textoBoton: String,
    funTextoBoton: (String) -> Unit,
    listaAsistentes: MutableList<Asistente>,
    limpiarCampos: () -> Unit,
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment  =  Alignment.CenterHorizontally,
    ) {
        // Campos del formulario
        TextField(
            modifier = Modifier.padding(10.dp),
            enabled = !editandoRegistro,
            value = correo,
            maxLines = 1,
            onValueChange = { funCorreo(it) },
            label = { Text(text = "Correo") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = nombre,
            maxLines = 1,
            onValueChange = { funNombre(it) },
            label = { Text(text = "Nombre") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = apellidos,
            maxLines = 1,
            onValueChange = { funApellidos(it) },
            label = { Text(text = "Apellidos") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = fechaInscripcion,
            maxLines = 1,
            onValueChange = { funFechaInscripcion(it) },
            label = { Text(text = "Fecha de Inscripcion") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = tipoSangre,
            maxLines = 1,
            onValueChange = { funTipoSangre(it) },
            label = { Text(text = "Tipo de Sangre") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = telefono,
            maxLines = 1,
            onValueChange = { funTelefono(it) },
            label = { Text(text = "Telefono") },
        )
        TextField(
            modifier = Modifier.padding(10.dp),
            value = monto,
            maxLines = 1,
            onValueChange = { funMonto(it) },
            label = { Text(text = "Monto") },
        )
        Button(modifier = Modifier.padding(10.dp), onClick = {
            if(editandoRegistro) {
                editarAsistente(nombre, apellidos, fechaInscripcion, tipoSangre, telefono, correo, monto, listaAsistentes)
                funTextoBoton("Agregar Asistente")
                funEditandoRegistro()
            } else agregarAsistente(nombre, apellidos, fechaInscripcion, tipoSangre, telefono, correo, monto, listaAsistentes)
            limpiarCampos()
        }){
            Text ( text = textoBoton)
        }
    }
}
