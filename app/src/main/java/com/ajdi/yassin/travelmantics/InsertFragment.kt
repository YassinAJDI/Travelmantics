package com.ajdi.yassin.travelmantics


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ajdi.yassin.travelmantics.data.model.TravelDeal
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_insert_deal.*
import kotlinx.android.synthetic.main.fragment_insert_deal.view.*

/**
 * @author Yassin AJDI
 *
 */
class InsertFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_insert_deal, container, false)

        view.button_save.setOnClickListener {
            saveDeal()
            Toast.makeText(activity, "Deal saved", Toast.LENGTH_LONG).show()
            cleanForm()
        }
        return view
    }

    private fun cleanForm() {
        edit_title.editText?.setText("")
        edit_title.editText?.requestFocus()
        edit_description.editText?.setText("")
        edit_price.editText?.setText("")
    }

    private fun saveDeal() {
        // Write a message to the database
        val travelDeal = TravelDeal(
            "",
            edit_title.editText?.text.toString(),
            edit_description.editText?.text.toString(),
            edit_price.editText?.text.toString(),
            ""
        )
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("travel_deals")
        myRef.push().setValue(travelDeal)
    }

}
