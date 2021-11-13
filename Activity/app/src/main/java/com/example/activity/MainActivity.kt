package com.example.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.Nullable

class MainActivity : AppCompatActivity() {
    private lateinit var btn : Button
    private lateinit var  tv_meal : TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_meal = findViewById(R.id.tv_meal)
        btn = findViewById(R.id.btn_choice)
        btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(this, MainActivity2::class.java)
                startActivityForResult(intent, 1)

            }

            private fun Intent(
                onClickListener: View.OnClickListener,
                java: Class<MainActivity2>
            ): Intent? {
                return intent
            }
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return;
        if (requestCode == 1) {
            if (resultCode == 101) {
               var b = data.getBundleExtra("")

               var str1 :String = data.getStringExtra("drink").toString()
                var str2 :String = data.getStringExtra("sugar").toString()
                var str3 :String = data.getStringExtra("ice").toString()
                tv_meal.setText(String.format("飲料: %s\n\n甜度: %s\n\n冰塊: %s\n\n",
                    str1,
                    str2,
                    str3));
            }
        }
    }

 

}