package com.bogdanovsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.bogdanovsky.fragments.FragmentA.Companion.FRAGMENT_A_TAG
import com.bogdanovsky.fragments.FragmentD.Companion.FRAGMENT_D_TAG


class FragmentC : Fragment() {
    private var stringFromB: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stringFromB = it.getString(STRING_TO_TRANSFER_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.fragment_c_extra_textview).text = stringFromB

        view.findViewById<Button>(R.id.to_fragment_d_button).setOnClickListener {
            (requireActivity() as MainActivity).onNextButtonClicked(FRAGMENT_D_TAG)
        }

        view.findViewById<Button>(R.id.fragment_c_go_back_to_fragment_a_button).setOnClickListener {
            (requireActivity() as MainActivity).onNavigateBackToClicked(FRAGMENT_A_TAG)
        }
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        @JvmStatic
        fun newInstance(text: String) =
            FragmentC().apply {
                arguments = Bundle().apply {
                    putString(STRING_TO_TRANSFER_KEY, text)
                }
            }
    }
}