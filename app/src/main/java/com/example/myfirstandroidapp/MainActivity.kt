package com.example.myfirstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var tvResult: TextView
    private lateinit var btnAdd: Button
    private lateinit var rdoSum: RadioButton
    private lateinit var rdoSubtract: RadioButton

    val a = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // binding
        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)
        tvResult = findViewById(R.id.tvResult)
        btnAdd = findViewById(R.id.btnAdd)
        rdoSubtract = findViewById(R.id.rdoSubtract)
        rdoSum = findViewById(R.id.rdoSum)

        btnAdd.setOnClickListener {

            //Validate
            if(TextUtils.isEmpty(etFirst.text)){
                etFirst.error = "Enter first number"
                etFirst.requestFocus()
                return@setOnClickListener
            } else if(TextUtils.isEmpty(etSecond.text)){
                etSecond.error = "Enter second number"
                etSecond.requestFocus()
                return@setOnClickListener
            }

            val first = etFirst.text.toString().toInt()
            val second = etSecond.text.toString().toInt()

            if (rdoSum.isChecked)
                addNumber(first,second)
            else
                subtractNo(first,second)
        }
    }
    private fun subtractNo(first:Int, second:Int) {
        val result = first - second
        tvResult.text = result.toString()
        Toast.makeText(this@MainActivity, "Sum is $result", Toast.LENGTH_SHORT).show()
    }
    private fun addNumber(first:Int, second:Int) {
        val result = first + second
        tvResult.text = result.toString()
        Toast.makeText(this@MainActivity, "Sum is $result", Toast.LENGTH_SHORT).show()
    }
//    private fun validateEdittext() : Boolean{
//        var isEmpty = false
//        if(TextUtils.isEmpty(etFirst.text)){
//            etFirst.error = "Enter first number"
//            etFirst.requestFocus()
//            isEmpty = true
//        }
//    }
}
