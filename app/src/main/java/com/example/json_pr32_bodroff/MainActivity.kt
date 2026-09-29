package com.example.json_pr32_bodroff

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.button)
        val text1 = findViewById<EditText>(R.id.editText)
        val text2 = findViewById<EditText>(R.id.editText2)
        val text3 = findViewById<EditText>(R.id.editText3)
        val vivod = findViewById<TextView>(R.id.vivod)


        button.setOnClickListener() {

            val text1string = text1.text.toString()
            val text2string = text2.text.toString()
            val text3string = text3.text.toString()

            if (text1string != "" && text2string != "" && text3string != ""){

               val price = text2string.toDoubleOrNull()

                if (price != null) {

                   val product = Product(
                        text1string,
                        price,
                        text3string.split(" ")
                    )

                    val gson = Gson()

                    val json = gson.toJson(product)

                    vivod.text = json

                    val product2 = gson.fromJson(json, Product::class.java)

                     Log.d("json", product2.name)

                }
                else {

                    AlertDialog.Builder(this)
                        .setMessage("Значение цены должно быть числовым!!!")
                        .setPositiveButton("ок", null).show()



                }




            }
            else {

                Toast.makeText(this, "Заполните поля!!!", Toast.LENGTH_SHORT).show()

            }



        }



//        val Product = Product(
//
//           "ПРОДУКТ",
//            1500.0,
//            listOf("тег1", "тег2", "тег3")
//
//        )
//
//        val gson = Gson()
//
//        val json = gson.toJson(Product)
//
//        Log.d("json_test",json)
//
//        val product2 = gson.fromJson(json, Product::class.java)
//
//       Log.d("testsf", product2.name)



    }
}