package es.uniovi.networkapp.data

import es.uniovi.networkapp.network.RestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object Repository {
    fun updateBusStatusData() =
        // Se crea un flujo
        flow {
            // Se realiza la petición al servicio
            try {
                // Respuesta correcta
                val busStatus = RestApi.retrofitService.getStatusInfo()
                // Se emite el estado Succes y se incluyen los datos recibidos
                emit(ApiResult.Success(busStatus))
            } catch (e: Exception) {
                // Error en la red
                // Se emite el estado de Error con el mensaje que lo explica
                emit(ApiResult.Error(e.toString()))
            }
            // El flujo se ejecuta en el hilo I/O
        }.flowOn(Dispatchers.IO)
}