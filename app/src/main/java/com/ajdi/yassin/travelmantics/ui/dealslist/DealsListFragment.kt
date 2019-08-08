package com.ajdi.yassin.travelmantics.ui.dealslist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajdi.yassin.travelmantics.databinding.FragmentDealsListBinding
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 *
 */
class DealsListFragment : Fragment() {

    private lateinit var binding: FragmentDealsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        binding = FragmentDealsListBinding.inflate(inflater, container, false)
        setupListAdapter()
        return binding.root
    }

    private fun setupListAdapter() {
        Timber.d("setupListAdapter")
        val viewModel = ViewModelProviders.of(this).get(DealsListViewModel::class.java)
        val travelDealsLiveData = viewModel.getTravelDeals()
        // setup RecyclerView
        val recyclerView = binding.recyclerDealList
        val dealsAdapter = TravelDealsAdapter()
        recyclerView.adapter = dealsAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        // observe deals list
        travelDealsLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                Timber.d("travelDealsLiveData:data not null")
                Timber.d(it.data?.get(1)?.item.toString())
                // update the UI here with values in the snapshot
                dealsAdapter.submitList(it.data)
            }
        })
    }

}
