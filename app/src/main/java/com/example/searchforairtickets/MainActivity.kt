package com.example.searchforairtickets

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {

    private lateinit var departureCitie: Spinner
    private lateinit var arrivalCity: Spinner
    private lateinit var departureDate: EditText
    private lateinit var arrivalDate: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        departureCitie = findViewById(R.id.spinnerDepartureCitie)
        arrivalCity = findViewById(R.id.spinnerArrivalCity)
        departureDate = findViewById(R.id.DepartureDate)
        arrivalDate = findViewById(R.id.ArrivalDate)
        val cityAdapter = ArrayAdapter.createFromResource(this, R.array.city_array, android.R.layout.simple_spinner_item)
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        departureCitie.adapter = cityAdapter
        arrivalCity.adapter = cityAdapter

        departureDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay.${selectedMonth + 1}.$selectedYear"
                    departureDate.setText(selectedDate)
                },
                year, month, day
            )

            datePickerDialog.show()
        }

        arrivalDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = "$selectedDay.${selectedMonth + 1}.$selectedYear"
                    arrivalDate.setText(selectedDate)
                },
                year, month, day
            )

            datePickerDialog.show()
        }
    }
}