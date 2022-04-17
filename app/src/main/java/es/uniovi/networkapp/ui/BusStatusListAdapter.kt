package es.uniovi.networkapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import es.uniovi.networkapp.R
import es.uniovi.networkapp.model.Llegada

class BusStatusListAdapter: ListAdapter<Llegada, BusStatusViewHolder>(Llegada.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusStatusViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.simple_list_item, parent, false )
        return BusStatusViewHolder(view)
    }

    override fun onBindViewHolder(holder: BusStatusViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}