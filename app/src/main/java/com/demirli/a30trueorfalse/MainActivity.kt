package com.demirli.a30trueorfalse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var string1 = ""
    private var string2 = ""
    private var operator = ""

    private var result: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_result_btn.setOnClickListener {

            string1 = string1_et.text.toString()
            string2 = string2_et.text.toString()
            operator = operator_et.text.toString()

            when(operator){
                "==" -> {result = string1 == string2}
                "!=" -> {result = string1 != string2}
            }

            if(string1.matches("[0-9]+".toRegex()) && string2.matches("[0-9]+".toRegex())){

                when(operator){
                    ">" -> {result = string1 > string2}
                    ">=" -> {result = string1 >= string2}
                    "<" -> {result = string1 < string2}
                    "<=" -> {result = string1 <= string2}
                }

            }else if(operator != "==" && operator != "!="){
                Toast.makeText(this,"Values are not numeric.", Toast.LENGTH_SHORT).show()
                result_tv.text = ""
            }

            result_tv.text = result.toString()
        }
    }
}
