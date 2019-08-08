package com.ajdi.yassin.travelmantics.ui.dealslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.databinding.ItemDealBinding
import com.ajdi.yassin.travelmantics.utils.QueryItem
import timber.log.Timber


/**
 * @author Yassin Ajdi
 * @since 8/8/2019.
 */
class TravelDealsAdapter : ListAdapter<QueryItem<TravelDeal>, DealViewHolder>(
    object : DiffUtil.ItemCallback<QueryItem<TravelDeal>>() {
        override fun areItemsTheSame(oldItem: QueryItem<TravelDeal>, newItem: QueryItem<TravelDeal>): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: QueryItem<TravelDeal>, newItem: QueryItem<TravelDeal>): Boolean {
            return oldItem.item == newItem.item
        }
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealViewHolder {
        Timber.d("onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDealBinding.inflate(inflater, parent, false)
        return DealViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DealViewHolder, position: Int) {
        Timber.d("onBindViewHolder")
        holder.bind(getItem(position).item)
    }

    //    private lateinit var deals: List<TravelDeal>
}