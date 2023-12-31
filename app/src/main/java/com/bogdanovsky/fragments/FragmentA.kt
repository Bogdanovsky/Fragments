package com.bogdanovsky.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.bogdanovsky.fragments.FragmentB.Companion.FRAGMENT_B_TAG

class FragmentA : Fragment(R.layout.fragment_a) {
    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is MainActivity) throw java.lang.RuntimeException("Wrong context for FragmentA")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_a, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.to_fragment_b_button).setOnClickListener {
            (requireActivity() as MainActivity).onNextButtonClicked(FRAGMENT_B_TAG)
        }
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}