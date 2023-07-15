package com.bogdanovsky.fragmentcontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bogdanovsky.fragmentcontacts.Database.users
import com.bogdanovsky.fragmentcontacts.UserFragment.Companion.USER_FRAGMENT_TAG

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfViews = mutableListOf<ViewGroup>()
        with (view) {
            listOfViews.apply {
                add(findViewById(R.id.item_layout_1))
                add(findViewById(R.id.item_layout_2))
                add(findViewById(R.id.item_layout_3))
                add(findViewById(R.id.item_layout_4))
            }
        }

        users.forEachIndexed { index, user ->
            with(listOfViews[index]) {
                findViewById<TextView>(R.id.name).text = user.name
                findViewById<TextView>(R.id.surname).text = user.surname
                findViewById<TextView>(R.id.phone).text = user.phone
                setOnClickListener {
                    (requireActivity() as MainActivity).navigateTo(USER_FRAGMENT_TAG, index)
                }
            }
        }
    }

    companion object {
        const val LIST_FRAGMENT_TAG = "TAG_LIST_FRAGMENT"

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}

