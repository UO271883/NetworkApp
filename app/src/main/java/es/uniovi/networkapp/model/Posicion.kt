package es.uniovi.networkapp.model

data class Posicion(
    val idlinea : Int,
    val idtrayecto : Int,
    val idautobus : Int,
    val utmx : Int,
    val utmy : Int,
    val horaactualizacion : String,
    val fechaactualizacion : String,
    val idparada : Int,
    val minutos : Int,
    val distancia : Int,
    val matricula : String,
    val modelo : String,
    val ordenparada : Int,
    val idsiguienteparada : Int
)
