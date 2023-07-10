package com.bogdanovsky.fragmentcontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bogdanovsky.fragmentcontacts.ListFragment.Companion.TAG_LIST_FRAGMENT

class UserFragment : Fragment() {

    var userIndex: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userIndex = requireArguments().getInt(USER_INDEX_KEY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            view.findViewById<TextView>(R.id.id_text_view).text = "User index: $userIndex"
            val user = ListFragment.users[userIndex]
            val nameEditText = findViewById<EditText>(R.id.name_edit_view)
            nameEditText.setText(user.name)
            val surnameEditText = findViewById<EditText>(R.id.surname_edit_view)
            surnameEditText.setText(user.surname)
            val phoneEditText = findViewById<EditText>(R.id.phone_edit_view)
            phoneEditText.setText(user.phone)
            findViewById<Button>(R.id.save_button).setOnClickListener {
                user.name = nameEditText.text.toString()
                user.surname = surnameEditText.text.toString()
                user.phone = phoneEditText.text.toString()
                (requireActivity() as MainActivity).navigateTo(TAG_LIST_FRAGMENT, userIndex)
            }
        }
    }

    companion object {
        const val TAG_USER_FRAGMENT = "TAG_USER_FRAGMENT"
        const val USER_INDEX_KEY = "USER_INDEX_KEY"

        @JvmStatic
        fun newInstance(userIndex: Int) = UserFragment().apply {
            arguments = Bundle().apply {
                putInt(USER_INDEX_KEY, userIndex)
            }
        }
    }
}