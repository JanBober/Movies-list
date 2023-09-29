package com.movieslist.base.ktx

import android.app.Activity
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.movieslist.R

fun Activity.showSnackBar(
    messenge: String,
    isLong: Boolean = true,
    @ColorRes colorRes: Int = R.color.white
) =
    Snackbar.make(
        findViewById<ViewGroup>(android.R.id.content).getChildAt(0),
        messenge,
        if (isLong) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT
    ).also {
        (it.view as? Snackbar.SnackbarLayout)
            ?.rootView
            ?.setBackgroundColor(ContextCompat.getColor(it.context, colorRes))
    }
        .show()
