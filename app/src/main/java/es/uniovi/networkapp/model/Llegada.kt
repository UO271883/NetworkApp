package es.uniovi.networkapp.model

data class Llegada(
    val idlinea : Int,
    val idtrayecto : Int,
    val idautobus : Int,
    val horaactualizacion : String,
    val fechaactualizacion : String,
    val idparada : Int,
    val minutos : Int,
    val distancia : Int,
    val matricula : String,
    val modelo : String
)
