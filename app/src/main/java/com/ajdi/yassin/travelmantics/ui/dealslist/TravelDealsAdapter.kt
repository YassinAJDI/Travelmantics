package com.ajdi.yassin.travelmantics.ui.dealslist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajdi.yassin.travelmantics.data.model.TravelDeal


/**
 * @author Yassin Ajdi
 * @since 8/8/2019.
 */
class TravelDealsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var deals: List<TravelDeal>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        deals.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        holder.
    }

    fun submitList(deals: List<TravelDeal>) {
        this.deals = deals
        notifyDataSetChanged()
    }
}