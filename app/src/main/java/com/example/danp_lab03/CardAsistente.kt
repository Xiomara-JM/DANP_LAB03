package com.example.danp_lab03

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CardAsistente(
    funNombre: (String) -> Unit,
    funApellidos: (String) -> Unit,
    funFechaInscripcion: (String) -> Unit,
    funTipoSangre: (String) -> Unit,
    funTelefono: (String) -> Unit,
    funCorreo: (String) -> Unit,
    funMonto: (String) -> Unit,
    funTextoBoton: (String) -> Unit,
    funEditandoRegistro: (Boolean) -> Unit,
    funEliminarAsistente: (String) -> Unit,
    asistente: Asistente,
){
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ){
        Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(
                modifier = Modifier.weight(0.76f)
            ) {
                Text(text = "Nombre: ${asistente.nombre} ${asistente.apellidos}")
                Text(text = "Correo: ${asistente.correo}")
                Text(text = "Inscripcion: ${asistente.fechaInscripcion}")
            }
                IconButton(
                    modifier = Modifier.weight(0.12f),
                    onClick = {
                        funNombre(asistente.nombre)
                        funApellidos(asistente.apellidos)
                        funFechaInscripcion(asistente.fechaInscripcion)
                        funTipoSangre(asistente.tipoSangre)
                        funTelefono(asistente.telefono)
                        funCorreo(asistente.correo)
                        funMonto(asistente.monto)
                        funTextoBoton("Editar Asistente")
                        funEditandoRegistro(true)
                    }
                ) {
                    Icon(Icons.Filled.Edit, contentDescription = "Editar")
                }
                IconButton( modifier = Modifier.weight(0.12f), onClick = { funEliminarAsistente(asistente.correo) }) {
                    Icon(Icons.Filled.Delete, contentDescription = "Eliminar")
                }
        }
    }
}