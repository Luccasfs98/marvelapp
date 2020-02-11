package br.com.marvel.common.view

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import com.marvel.common.R


class WithoutNetworkDialog(activity: AppCompatActivity) {

    private val dialog = Dialog(activity)
    private var isShow = false

    fun show() {
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_without_network)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isShow = true
        dialog.show()
    }

    fun dismiss() {
        isShow = false
        dialog.dismiss()
    }

    fun isShowing() = isShow
}
