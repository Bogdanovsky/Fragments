package com.bogdanovsky.fragments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.bogdanovsky.fragments.FragmentA.Companion.FRAGMENT_A_TAG
import com.bogdanovsky.fragments.FragmentB.Companion.FRAGMENT_B_TAG
import com.bogdanovsky.fragments.FragmentC.Companion.FRAGMENT_C_TAG
import com.bogdanovsky.fragments.FragmentD.Companion.FRAGMENT_D_TAG

const val STRING_TO_TRANSFER_KEY = "STRING_TO_TRANSFER_KEY"

class MainActivity : AppCompatActivity(), NavigateButtonClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager) {
            commit {
                replace(R.id.fragment_container_view, FragmentA.newInstance())
                addToBackStack(FRAGMENT_A_TAG)
            }
        }
    }

    companion object {
        @JvmStatic
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun onNextButtonClicked(targetName: String, bundle: Bundle?) {
        val target = when (targetName) {
            FRAGMENT_B_TAG -> FragmentB.newInstance()
            FRAGMENT_C_TAG -> bundle?.getString(STRING_TO_TRANSFER_KEY, "")
                ?.let { FragmentC.newInstance(it) }
            FRAGMENT_D_TAG -> FragmentD.newInstance()
            else -> {
                throw java.lang.RuntimeException("No such fragment tag")
            }
        }
        target?.let {
            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, it)
                addToBackStack(targetName)
            }
        }
    }

    override fun onNavigateBackToClicked(targetName: String) {
        val sfm = supportFragmentManager
        while (sfm.getBackStackEntryAt(sfm.backStackEntryCount - 1).name != targetName) {
            sfm.popBackStackImmediate()
        }
    }
}