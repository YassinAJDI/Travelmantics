package com.ajdi.yassin.travelmantics.ui.dealslist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajdi.yassin.travelmantics.HomeActivity
import com.ajdi.yassin.travelmantics.R
import com.ajdi.yassin.travelmantics.databinding.FragmentDealsListBinding
import com.ajdi.yassin.travelmantics.utils.EventObserver
import timber.log.Timber

class DealsListFragment : Fragment() {

    private lateinit var viewModel: DealsListViewModel
    private lateinit var binding: FragmentDealsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        binding = FragmentDealsListBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProviders.of(this).get(DealsListViewModel::class.java)
        viewModel = HomeActivity.obtainViewModel(activity)
        setupListAdapter()
        setupNavigation()
        return binding.root
    }

    private fun setupNavigation() {
        viewModel.getOpenDealEvent().observe(viewLifecycleOwner, EventObserver {
            val bundle = bundleOf("deal_id" to it)
            findNavController().navigate(R.id.action_deals_fragment_dest_to_insert_fragment_dest, bundle)
        })
    }

    private fun setupListAdapter() {
        Timber.d("setupListAdapter")
        // setup RecyclerView
        val recyclerView = binding.recyclerDealList
        val dealsAdapter = TravelDealsAdapter(viewModel)
        recyclerView.adapter = dealsAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // observe deals list
        viewModel.getTravelDeals().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Timber.d("travelDealsLiveData:data not null")
                Timber.d(it.data?.get(1)?.item.toString())
                // update the UI here with values in the snapshot
                dealsAdapter.submitList(it.data)
            }
        })
    }

}
