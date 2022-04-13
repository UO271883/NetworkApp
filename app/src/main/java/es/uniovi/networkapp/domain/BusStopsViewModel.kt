package es.uniovi.networkapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.uniovi.networkapp.data.ApiResult
import es.uniovi.networkapp.data.Repository
import es.uniovi.networkapp.ui.StopsUIState
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class BusStopsViewModel: ViewModel() {
    init{
        getBusStopsList()
    }
    private val _stopsUIStateObservable = MutableLiveData<StopsUIState>()
    val stopsUIStateObservable: LiveData<StopsUIState> get() = _stopsUIStateObservable

    @OptIn(InternalCoroutinesApi::class)
    private fun getBusStopsList(){
        viewModelScope.launch {
            Repository.updateBusStatusData()
                .map { result ->
                    when (result) {
                        is ApiResult.Success<*> -> StopsUIState.Success(result.data?.llegadas!!)
                        is ApiResult.Error -> StopsUIState.Error(result.message!!)
                    }
                }
                /*.collect {
                    _stopsUIStateObservable.value =
                }*/
        }
    }
}

