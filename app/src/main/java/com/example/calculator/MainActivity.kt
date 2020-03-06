package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b_0.setOnClickListener { setTextFields("0") }
        b_1.setOnClickListener { setTextFields("1") }
        b_2.setOnClickListener { setTextFields("2") }
        b_3.setOnClickListener { setTextFields("3") }
        b_4.setOnClickListener { setTextFields("4") }
        b_5.setOnClickListener { setTextFields("5") }
        b_6.setOnClickListener { setTextFields("6") }
        b_7.setOnClickListener { setTextFields("7") }
        b_8.setOnClickListener { setTextFields("8") }
        b_9.setOnClickListener { setTextFields("9") }
        b_dot.setOnClickListener { setTextFields(".") }
        b_plus.setOnClickListener { setTextFields("+") }
        b_minus.setOnClickListener { setTextFields("-") }
        b_mul.setOnClickListener { setTextFields("*") }
        b_divide.setOnClickListener { setTextFields("/") }
        b_AC.setOnClickListener {
            math_operation.text=""
            tv_result.text=""
        }
        b_del.setOnClickListener {
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length - 1)

            tv_result.text=""
        }

        b_equals.setOnClickListener {
            try{

                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if(result == longRes.toDouble())
                    tv_result.text = longRes.toString()
                else
                    tv_result.text = result.toString()

            } catch (e:Exception) {
                Log.d("Error!", "Message: ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if(tv_result.text != "") {
            math_operation.text = tv_result.text
            tv_result.text = ""
        }

        math_operation.append(str)
    }
}