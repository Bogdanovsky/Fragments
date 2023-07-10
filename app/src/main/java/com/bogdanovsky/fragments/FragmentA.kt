package com.bogdanovsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bogdanovsky.fragments.FragmentB.Companion.FRAGMENT_B_TAG

class FragmentA : Fragment(R.layout.fragment_a) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

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