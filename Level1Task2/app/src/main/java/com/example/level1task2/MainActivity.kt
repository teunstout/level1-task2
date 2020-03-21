package com.example.level1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private val isTrue = "T"
    private val isFalse = "F"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener { checkConjunction() }
    }

    /**
     * Check per row wat het antwoord moet zijn. Als het goed is antwoord ++
     * display antwoord aan het eind in een toast
     */
    fun checkConjunction() {
        var correctAwnsers = 0
        if (checkRowConjunction(
                conjunctionTable.row1.aRow1.text.toString(),
                conjunctionTable.row1.bRow1.text.toString(),
                conjunctionTable.row1.abRow1.text.toString()
            )
        ) correctAwnsers++
        if (checkRowConjunction(
                conjunctionTable.row2.aRow2.text.toString(),
                conjunctionTable.row2.bRow2.text.toString(),
                conjunctionTable.row2.abRow2.text.toString()
            )
        ) correctAwnsers++
        if (checkRowConjunction(
                conjunctionTable.row3.aRow3.text.toString(),
                conjunctionTable.row3.bRow3.text.toString(),
                conjunctionTable.row3.abRow3.text.toString()
            )
        ) correctAwnsers++
        if (checkRowConjunction(
                conjunctionTable.row4.aRow4.text.toString(),
                conjunctionTable.row4.bRow4.text.toString(),
                conjunctionTable.row4.abRow4.text.toString()
            )
        ) correctAwnsers++

        // toast
        Toast.makeText(this, getString(R.string.correctAwnsers, correctAwnsers), Toast.LENGTH_SHORT)
            .show()
    }


    /**
     * Checks if the awnser is right
     */
    fun checkRowConjunction(columnLeft: String, columnRight: String, awnser: String): Boolean {
        if (awnser.toLowerCase() == isTrue.toLowerCase()) {             // check if the awnser is True
            if (columnLeft == columnRight && columnLeft != isFalse) {   // if awnser is true check if column left == column right. Checkt dus op T^T
                return true                                             // if that is true than return true
            }
        } else if (awnser.toLowerCase() == isFalse.toLowerCase()) {     // else check if awnser == F.
            if (columnLeft == isFalse || columnRight == isFalse) {      // check if column is false
                return true
            }                                                           // return true if awnser == F
        }
        return false                                                    // if awnser also doesn't == f awnser is wrong
    }
}
