package com.bogdanovsky.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.bogdanovsky.fragments.FragmentB.Companion.FRAGMENT_B_TAG

class FragmentD : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_d, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.back_to_fragment_b_button).setOnClickListener {
            (requireActivity() as MainActivity).onNavigateBackToClicked(FRAGMENT_B_TAG)
        }
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        @JvmStatic
        fun newInstance() = FragmentD()
    }
}