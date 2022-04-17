package es.uniovi.networkapp.ui

import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import es.uniovi.networkapp.R
import es.uniovi.networkapp.databinding.SimpleListItemBinding
import es.uniovi.networkapp.model.Llegada

class BusStatusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val itemBinding = SimpleListItemBinding.bind(itemView)
    fun bind(llegada: Llegada) {
        itemBinding.text1.text = itemBinding.root.context.getString(
            R.string.itemHolder, llegada.idparada, llegada.idlinea, llegada.minutos)
    }
}