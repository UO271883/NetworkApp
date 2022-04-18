package es.uniovi.networkapp.model

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

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
    val modelo : String) {

    companion object DIFF_CALLBACK : DiffUtil.ItemCallback<Llegada>() {
        override fun areItemsTheSame(oldItem: Llegada, newItem: Llegada): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Llegada, newItem: Llegada): Boolean {
            return oldItem === newItem
        }
    }
}