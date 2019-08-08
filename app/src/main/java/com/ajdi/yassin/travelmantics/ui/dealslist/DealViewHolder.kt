package com.ajdi.yassin.travelmantics.ui.dealslist

import androidx.recyclerview.widget.RecyclerView
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.databinding.ItemDealBinding

/**
 * @author Yassin Ajdi
 * @since 8/8/2019.
 */
class DealViewHolder(private val binding: ItemDealBinding, private val viewModel: DealsListViewModel) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(deal: TravelDeal) {
        binding.textTitle.text = deal.title
        binding.root.setOnClickListener {
            viewModel.openDealEvent(deal.id)
        }
        binding.executePendingBindings()
    }
}