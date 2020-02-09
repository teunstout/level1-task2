package com.example.level1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    val isTrue = "T"
    val isFalse = "F"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener{checkConjunction()}
    }

    fun checkConjunction () {
        var correctAwnsers = 0
        if (checkRowConjunction(conjunctionTable.row1.aRow1.text.toString() ,  conjunctionTable.row1.bRown1.text.toString())
            .equals(checkAwnserRowConjunction(conjunctionTable.row1.abRow1.text.toString()))) correctAwnsers++

        if (checkRowConjunction(conjunctionTable.row2.aRow2.text.toString() ,  conjunctionTable.row2.bRow2.text.toString())
                .equals(checkAwnserRowConjunction(conjunctionTable.row2.abRow2.text.toString()))) correctAwnsers++

        if (checkRowConjunction(conjunctionTable.row3.aRow3.text.toString() ,  conjunctionTable.row3.bRow3.text.toString())
                .equals(checkAwnserRowConjunction(conjunctionTable.row3.abRow3.text.toString()))) correctAwnsers++

        if (checkRowConjunction(conjunctionTable.row4.aRow4.text.toString() ,  conjunctionTable.row4.bRow4.text.toString())
                .equals(checkAwnserRowConjunction(conjunctionTable.row4.abRow4.text.toString()))) correctAwnsers++

        toastMessage(correctAwnsers)
    }


    /**
     * Checks the columns with letters and what gives a boolean based on that
     * example : T^T = true; F^F = false; T^F = false
     */
    fun checkRowConjunction(columnLeft: String, columnRight: String): Boolean {
        if (columnLeft == columnRight && columnLeft == isTrue) return true
        return false
    }

    /**
     * Checks if the awnser is true or false
     */
    fun checkAwnserRowConjunction(awnser: String): Boolean {
        if (awnser.toLowerCase() == isTrue.toLowerCase()) return true
        if (awnser.toLowerCase() == isFalse.toLowerCase()) return false
    }

    fun toastMessage(correctAwnsers: Int){
        Toast.makeText(this, getString(R.string.correctAwnsers, correctAwnsers), Toast.LENGTH_SHORT).show()
    }
}
