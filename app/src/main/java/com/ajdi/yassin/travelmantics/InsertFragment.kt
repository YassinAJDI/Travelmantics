package com.ajdi.yassin.travelmantics


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.ajdi.yassin.travelmantics.databinding.FragmentInsertDealBinding
import com.ajdi.yassin.travelmantics.ui.dealslist.DealsListViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_insert_deal.*
import timber.log.Timber

/**
 * @author Yassin AJDI
 *
 */
class InsertFragment : Fragment() {

    private lateinit var viewModel: DealsListViewModel
    private lateinit var binding: FragmentInsertDealBinding
    private val database = FirebaseDatabase.getInstance()
    private val travelDeals = database.getReference("travel_deals")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertDealBinding.inflate(inflater, container, false)
        viewModel = HomeActivity.obtainViewModel(activity)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // retrieve passed arguments
        val dealId = arguments?.getString("deal_id")
        if (savedInstanceState == null && dealId != null) {
            // fill data form with deal details
            populateUI(viewModel.selectedDeal)
        }

        // add/edit deal button
        binding.buttonSave.setOnClickListener {
            saveDeal(dealId)
            Toast.makeText(activity, "Deal saved", Toast.LENGTH_LONG).show()
//            cleanForm()
            backToDealsList()
        }
        // delete deal
        binding.buttonDelete.setOnClickListener {
            deleteDeal(dealId)
            Toast.makeText(activity, "Deal deleted", Toast.LENGTH_LONG).show()
            backToDealsList()
        }
    }

    private fun backToDealsList() {
        findNavController().navigateUp()
    }

    private fun populateUI(deal: TravelDeal) {
        Timber.d(deal.toString())
        edit_title.editText?.setText(deal.title)
        edit_title.editText?.requestFocus()
        edit_description.editText?.setText(deal.description)
        edit_price.editText?.setText(deal.price)
    }

    private fun cleanForm() {
        edit_title.editText?.setText("")
        edit_title.editText?.requestFocus()
        edit_description.editText?.setText("")
        edit_price.editText?.setText("")
    }

    private fun saveDeal(dealId: String?) {
        // Write a message to the database
        val travelDeal = TravelDeal(
            "",
            edit_title.editText?.text.toString(),
            edit_description.editText?.text.toString(),
            edit_price.editText?.text.toString(),
            ""
        )
        if (dealId != null) {
            // edit deal
            travelDeals.child(dealId).setValue(travelDeal)
        } else {
            // add new deal
            travelDeals.push().setValue(travelDeal)
        }
    }

    private fun deleteDeal(dealId: String?) {
        if (dealId != null) {
            travelDeals.child(dealId).removeValue()
        }
    }

}
