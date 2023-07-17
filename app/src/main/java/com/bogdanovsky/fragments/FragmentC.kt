package com.bogdanovsky.fragments

import android.content.Context
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
    private var stringFromB: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is MainActivity) throw java.lang.RuntimeException("Wrong context for FragmentC")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            stringFromB = it.getString(STRING_TO_TRANSFER_KEY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_c, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            findViewById<TextView>(R.id.fragment_c_extra_textview).text = stringFromB
            findViewById<Button>(R.id.to_fragment_d_button).setOnClickListener {
                (requireActivity() as MainActivity).onNextButtonClicked(FRAGMENT_D_TAG)
            }
            findViewById<Button>(R.id.fragment_c_go_back_to_fragment_a_button).setOnClickListener {
                (requireActivity() as MainActivity).onNavigateBackToClicked(FRAGMENT_A_TAG)
            }
        }
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        @JvmStatic
        fun newInstance(bundle: Bundle) =
            FragmentC().apply {
                arguments = bundle
            }
    }
}