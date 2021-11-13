package com.example.text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn: Button = findViewById((R.id.button))
        btn.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("請選擇功能")
                .setMessage("請根據下方按鈕選擇要顯示的物件")
                .setNeutralButton("取消") { Dialog, which ->
                    Toast.makeText(this, "dialog關閉", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("自定義Toast") { Dialog, which ->
                    showToast()
                }
                .setPositiveButton("顯示list") { Dialog, which ->
                    showlistDialog()
                }
                .show()

        }

    }

    private fun showlistDialog() {
        var list = arrayOf("message1", "message2", "message3", "message4", "message5")
        AlertDialog.Builder(this)
            .setTitle("請使用LIST呈現")
            .setItems(list) { Dialog, which ->
                Toast.makeText(
                    this,
                    "你選的是" + list, Toast.LENGTH_SHORT
                ).show()
            }
    }


    private fun showToast() {
        val toast = Toast(this)
        toast.view = layoutInflater.inflate(R.layout.custom_toast, null)
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.TOP, 0, 0)

        toast.show()
    }

}