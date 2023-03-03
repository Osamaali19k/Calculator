package com.example.newcalculator


class SimpleExpression {
    var Operand1 : Int = 0
    var Operand2 : Int = 0
    var Operator = ""
    var result: Int = 0


    fun calculate() {
            if (Operator == "+")
            {
                result = Operand1 + Operand2
            } else if (Operator == "-") {
                result = Operand1 - Operand2
            }
            else if (Operator == "/")
            {
                result = Operand1 / Operand2
            }
        else
            {
                result = 0
        }
        clear()

    }
    fun clear()
    {
        Operand1 = 0
        Operand2 = 0
    }

    fun value() : Int {
        calculate()
        return result
    }

}

