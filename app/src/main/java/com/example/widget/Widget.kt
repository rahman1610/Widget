package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

        // membuat variable baru binding
    private lateinit var binding : ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inisialisasi binding
            binding = ActivityWidgetBinding.inflate(layoutInflater)

        // memanggil layout dengan menggunakan binding. root
        setContentView(binding.root)

        //Button Toast
        binding.btnToast.setOnClickListener{
            Toast.makeText(this, "ini adlah Toast", Toast.LENGTH_SHORT).show()
        }

        //ButtonSnackbar
        binding.btnSnackbar.setOnClickListener{
            Snackbar.make(it," ini adalah snackbar",Snackbar.LENGTH_SHORT).show()
        }
        //ButtonAlert
        binding.btnAlert.setOnClickListener{
           AlertDialog.Builder(this).apply {
               setTitle("Message")
               setMessage("Ini adalah Alert")

               setPositiveButton("OK") { dialog, _ ->
                   Toast.makeText(applicationContext, "Anda Klik OK", Toast.LENGTH_SHORT).show()
                   dialog.dismiss()
               }
               setPositiveButton("Back") { dialog, _ ->
                   Toast.makeText(applicationContext, "Anda Klik BACK", Toast.LENGTH_SHORT).show()
                   dialog.dismiss()
               }
           }.show()
        }

        //Button Custom Dialog
        binding.btnCustomDialog.setOnClickListener{
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.cutom_dialog)

                val btnCancle = this.findViewById<Button>(R.id.btnCancle)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancle.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda Klik Cancle", Toast.LENGTH_SHORT)
                        .show()
                    this.dismiss()
                }
                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda klik Contonue", Toast.LENGTH_SHORT)
                        .show()
                    this.dismiss()
                }
            }.show()

        }


    }
}