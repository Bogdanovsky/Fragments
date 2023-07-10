package com.bogdanovsky.fragments

import android.os.Bundle

interface NavigateButtonClickListener {

    fun onNextButtonClicked(
        targetName: String,
        bundle: Bundle? = null
    )

    fun onNavigateBackToClicked(
        targetName: String,
    )
}