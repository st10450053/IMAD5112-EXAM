package com.st10450053.myweatherapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DETAILEDVIEWSCREEN : AppCompatActivity() {
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

val day: Any
        get()  = intent.getStringArrayListExtra("day") ?: arrayListOf()
val min
    get() = intent.getIntegerArrayListExtra("min") ?: arrayListOf()
val max
    get() = intent.getIntegerArrayListExtra("max") ?: arrayListOf()
val activityNotes
    get() = intent.getStringArrayListExtra("activityNotes") ?: arrayListOf()

val DETAILSTextView = findViewById<TextView>(R.id.DETAILStextView3)
val AVERAGETextView = findViewById<TextView>(R.id.AVERAGEtextView4)
val BACKTOMAINMENU = findViewById<Button>(R.id.BTMSbutton)
val BACKTOSPLASHSCREEN = findViewById<Button>(R.id.BTSSbutton2)

var totalScreenTime = 0
var displayText = ""

 for (i in day.indices) {
    val dailyScreenTime = min[i] + max[i]
    totalScreenTime += dailyScreenTime
    displayText += "Day: ${day[i]}, Min: ${min[i]} min, Max: ${max[i]} min, Notes: ${activityNotes[i]}\n\n"
}
val averageScreenTime = if (day.isNotEmpty()) totalScreenTime / day.size else 0

DETAILStextView3.text = displayText
AVERAGEtextView4.text = "Average temperature for the week: $averageScreenTime minutes/day"

BACKTOMAINMENUbutton.setOnClickListener {
    val intent = Intent(this, MainActivity::class.java)
    PAGE2(intent)
