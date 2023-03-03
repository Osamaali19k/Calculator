package com.example.newcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var mNumerDisplay : TextView? = null
    var mExpression : SimpleExpression? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNumerDisplay = findViewById<View>(R.id.btnT) as TextView
        mExpression = SimpleExpression()
    }

    private fun saveOperand1()
    {
        try {
            val value = mNumerDisplay!!.text as String
            mExpression!!.Operand1 = value.toInt()
        } catch (e : NumberFormatException)
        {
            mExpression!!.Operand1 = 0
        }
    }

    private fun saveOperand2()
    {
        try {
            val value = mNumerDisplay!!.text as String
            mExpression!!.Operand2 = value.toInt()
        } catch (e : NumberFormatException)
        {
            mExpression!!.Operand2 = 0
        }
    }

    fun ac(view: View?)
    {
        mExpression!!.clear()
        mNumerDisplay!!.text = "0"
    }

    fun goOperand(view: View)
    {
     val value = mNumerDisplay!!.text as String
     val digit = view.contentDescription as String
     if ( value[0] == '0')
     {
         mNumerDisplay!!.text = digit
     }
      else
     {
         mNumerDisplay!!.text = (mNumerDisplay!!.text as String + digit[0])
     }
    }

    fun goOperator(view: View)
    {
        val operator = view.contentDescription as String
        saveOperand1()
        mNumerDisplay!!.text = "0"
        mExpression!!.Operator = operator
    }

    fun goCompute(view: View?)
    {
        saveOperand2()
        mNumerDisplay!!.text = mExpression!!.value().toString()
    }
}