package com.bogdanovsky.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bogdanovsky.fragments.FragmentA.Companion.FRAGMENT_A_TAG
import com.bogdanovsky.fragments.FragmentC.Companion.FRAGMENT_C_TAG

class FragmentB : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is MainActivity) throw java.lang.RuntimeException("Wrong context for FragmentB")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            findViewById<Button>(R.id.to_fragment_c_button).setOnClickListener {
                val bundle = Bundle()
                bundle.putString(STRING_TO_TRANSFER_KEY, STRING_TO_TRANSFER)
                (requireActivity() as MainActivity).onNextButtonClicked(FRAGMENT_C_TAG, bundle)
            }
            findViewById<Button>(R.id.fragment_b_back_button).setOnClickListener {
                (requireActivity() as MainActivity).onNavigateBackToClicked(FRAGMENT_A_TAG)
            }
        }
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        @JvmStatic
        fun newInstance() =
            FragmentB()
    }
}