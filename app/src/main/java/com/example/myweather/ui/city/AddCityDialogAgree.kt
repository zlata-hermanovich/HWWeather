package com.example.myweather.ui.city

import android.app.Dialog
import android.os.Bundle
import com.example.myweather.databinding.DialogBinding
import android.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.myweather.databinding.FragmentAddCityBinding

class AddCityDialogAgree :DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val view = DialogBinding.inflate(layoutInflater)

        return AlertDialog.Builder(context)
            .setView(view.root)
            .setCancelable(true)
            .setPositiveButton(
                "Yes"
            ) { _, _ ->AddCityFragment().addCity()
            }
            .setNegativeButton("Cancel") { _, _ ->
                dismiss()
            }
            .create()
    }
}