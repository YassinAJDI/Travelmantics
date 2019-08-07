package com.ajdi.yassin.travelmantics.ui.dealslist


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.ajdi.yassin.travelmantics.R


/**
 * A simple [Fragment] subclass.
 *
 */
class DealsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_deals_list, container, false)
        populateUI()
        return view
    }

    private fun populateUI() {
        val viewModel = ViewModelProviders.of(this).get(DealsListViewModel::class.java)
//        val liveData = viewModel.getDataSnapshotLiveData()
//        liveData.observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                // update the UI here with values in the snapshot
//                val deals = it.getValue(TravelDeal::class.java)
//            }
//        })
//        val database = FirebaseUtil.database
//        val dealsReference = FirebaseUtil.dealsReference
//        val dealsListener = object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // Get Post object and use the values to update the UI
//                val deals = dataSnapshot.getValue(TravelDeal::class.java)
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Getting deals failed, log a message
//                Log.w(javaClass.simpleName, "loadDeals:onCancelled", databaseError.toException())
//            }
//        }
//        val dealsChildEventListener = object : ChildEventListener {
//            override fun onCancelled(p0: DatabaseError) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
//                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//            }
//
//            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
//                val deal = dataSnapshot.getValue(TravelDeal::class.java)
//            }
//
//        }
//        dealsReference.addValueEventListener(dealsListener)
//        dealsReference.addChildEventListener(dealsChildEventListener)
    }

}
