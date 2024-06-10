package com.st10450053.myweatherapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Date

class PAGE2 : AppCompatActivity() {
    private lateinit var date: EditText
    private lateinit var morning_screentime: EditText
    private lateinit var afternoon_screentime: EditText
    private lateinit var notes: EditText
    private lateinit var ADDbutton: Button
    private lateinit var CLEARbutton: Button
    private lateinit var NEXTbutton2: Button

    private val dateList = ArrayList<String>()
    private val morningList = ArrayList<Int>()
    private val afternoonList = ArrayList<Int>()
    private val notesList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailedviewscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

    val dateEditText = findViewById<EditText>(R.id.DATEeditText3)
    val minEditText = findViewById<EditText>(R.id.MineditText)
    val maxEditText = findViewById<EditText>(R.id.MaxeditText2)

fun <T> findViewById(maxeditText2: Int): T {


    val activityNotesEditText = findViewById<EditText>(R.id.NOTESeditText4)
    val addButton = findViewById<Button>(R.id.ADDbutton)
    val clearButton = findViewById<Button>(R.id.CLEARbutton)
    val viewDetailsButton = findViewById<Button>(R.id.NEXTbutton2)

    addButton.setOnClickListener {
        val day = dateEditText.text.toString()
        val min = minEditText.text.toString().toIntOrNull()
        val max = maxEditText.text.toString().toIntOrNull()
        val activityNotes = activityNotesEditText.text.toString()

        if (day.isNotEmpty() && min != null && max != null && activityNotes.isNotEmpty()) {
            day.add(day)
            min.add(min)
            max.add(max)
            activityNotes.add(activityNotes)
            Toast.makeText(/* context = */ this, /* text = */ "Data Added", /* duration = */ Toast.LENGTH_SHORT).show()
            clearFields(dateEditText, minEditText, maxEditText, activityNotesEditText)

        } else {
            Toast.makeText(/* context = */ this, /* text = */
                "Please fill in all fields", /* duration = */
                Toast.LENGTH_SHORT).show()
        }
    }
//The code that is commented out below will clear all data saved in the arraylists!
    clearButton.setOnClickListener {
        //day.clear()
        // min.clear()
        //max.clear()
        // activityNotes.clear()
        // Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
        clearFields(dateEditText, minEditText, maxEditText, activityNotesEditText)

    }

    viewDetailsButton.setOnClickListener {
        val intent = Intent(this, DETAILEDVIEWSCREEN::class.java)
        val day = null
        intent.putStringArrayListExtra("days", day)
        val min = null
        intent.putIntegerArrayListExtra("min", min)
        val max = null
        intent.putIntegerArrayListExtra("max", max)
        val activityNotes = null
        intent.putStringArrayListExtra("activityNotes", activityNotes)
        startActivity(intent)
    }
}

private fun clearFields(vararg fields: EditText) {
    for (field in fields) {
        field.text.clear()
    }
}


private fun Int.add(min: Int) {

}

private fun String.add(day: String) {

}





