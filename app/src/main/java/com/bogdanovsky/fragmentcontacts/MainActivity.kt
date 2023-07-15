package com.bogdanovsky.fragmentcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.bogdanovsky.fragmentcontacts.ListFragment.Companion.LIST_FRAGMENT_TAG
import com.bogdanovsky.fragmentcontacts.UserFragment.Companion.USER_FRAGMENT_TAG

class MainActivity : AppCompatActivity(), FragmentNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager) {
            commit {
                replace(R.id.fragment_container_view, ListFragment.newInstance())
            }
        }
    }

    override fun navigateTo(target: String, userIndex: Int) {
        supportFragmentManager.commit {
            when (target) {
                USER_FRAGMENT_TAG -> {
                    replace(R.id.fragment_container_view, UserFragment.newInstance(userIndex))
                    addToBackStack(USER_FRAGMENT_TAG)
                }
                LIST_FRAGMENT_TAG -> {
                    supportFragmentManager.popBackStack()
                }
            }
        }
    }
}