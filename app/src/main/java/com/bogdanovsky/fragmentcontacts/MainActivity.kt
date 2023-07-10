package com.bogdanovsky.fragmentcontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.bogdanovsky.fragmentcontacts.ListFragment.Companion.TAG_LIST_FRAGMENT
import com.bogdanovsky.fragmentcontacts.UserFragment.Companion.TAG_USER_FRAGMENT

class MainActivity : AppCompatActivity(), FragmentNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(supportFragmentManager) {
            commit {
                replace(R.id.fragment_container_view, ListFragment.newInstance())
//                addToBackStack(TAG_LIST_FRAGMENT)
            }
        }
    }

    override fun navigateTo(target: String, userIndex: Int) {
        supportFragmentManager.commit {
            val targetFragment = when (target) {
                TAG_LIST_FRAGMENT -> ListFragment.newInstance()
                TAG_USER_FRAGMENT -> UserFragment.newInstance(userIndex)
                else -> throw java.lang.RuntimeException("No such tag")
            }
            replace(R.id.fragment_container_view, targetFragment)
        }
    }
}