package com.bogdanovsky.fragmentcontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bogdanovsky.fragmentcontacts.UserFragment.Companion.TAG_USER_FRAGMENT

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOfViews = listOf<ViewGroup>(
            view.findViewById(R.id.item_layout_1),
            view.findViewById(R.id.item_layout_2),
            view.findViewById(R.id.item_layout_3),
            view.findViewById(R.id.item_layout_4),
        )
        for (i in users.indices) {
            val item = listOfViews[i]
            item.findViewById<TextView>(R.id.name).text = users[i].name
            item.findViewById<TextView>(R.id.surname).text = users[i].surname
            item.findViewById<TextView>(R.id.phone).text = users[i].phone
            item.setOnClickListener {
                (requireActivity() as MainActivity).navigateTo(TAG_USER_FRAGMENT, i)
            }
        }
    }

    companion object {
        const val TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT"
        val users = listOf<User>(
            User("Dianne", "Hackborn", "7 (999) 555-44-33"),
            User("Lyla", "Fujiwara", "7 (333) 234-43-43"),
            User("Megan", "Fox", "7 (323) 234-23-12"),
            User("Polina", "Sibogotulina", "7 (123) 123-45-67"),
        )

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}

interface FragmentNavigator {
    fun navigateTo(target: String, userIndex: Int)
}