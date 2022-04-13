package es.uniovi.networkapp.ui

import es.uniovi.networkapp.model.Llegadas
import es.uniovi.networkapp.state.AppStatus

sealed class StopsUIState (val state: AppStatus) {
    data class Success (val llegadas: Llegadas): StopsUIState(AppStatus.SUCCESS)
    data class Error (val message: String): StopsUIState(AppStatus.ERROR)
}
