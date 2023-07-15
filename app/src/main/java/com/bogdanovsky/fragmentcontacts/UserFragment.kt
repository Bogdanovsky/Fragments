package com.bogdanovsky.fragmentcontacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bogdanovsky.fragmentcontacts.Database.users
import com.bogdanovsky.fragmentcontacts.ListFragment.Companion.LIST_FRAGMENT_TAG

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

        val user = users[userIndex]
        with(view) {
            findViewById<TextView>(R.id.id_text_view).text = "User index: $userIndex"
            val nameEditText = findViewById<EditText>(R.id.name_edit_view).apply {
                setText(user.name)
            }
            val surnameEditText = findViewById<EditText>(R.id.surname_edit_view).apply {
                setText(user.surname)
            }
            val phoneEditText = findViewById<EditText>(R.id.phone_edit_view).apply {
                setText(user.phone)
            }
            findViewById<Button>(R.id.save_button).setOnClickListener {
                user.apply {
                    name = nameEditText.text.toString()
                    surname = surnameEditText.text.toString()
                    phone = phoneEditText.text.toString()
                }
                (requireActivity() as MainActivity).navigateTo(LIST_FRAGMENT_TAG, userIndex)
            }
        }
    }

    companion object {
        const val USER_FRAGMENT_TAG = "TAG_USER_FRAGMENT"
        const val USER_INDEX_KEY = "USER_INDEX_KEY"

        @JvmStatic
        fun newInstance(userIndex: Int) = UserFragment().apply {
            arguments = Bundle().apply {
                putInt(USER_INDEX_KEY, userIndex)
            }
        }
    }
}