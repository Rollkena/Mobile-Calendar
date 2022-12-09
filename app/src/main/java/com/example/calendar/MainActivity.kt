package com.example.calendar

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dt = Date()
        var calendar: Calendar = Calendar.getInstance()
        var count: Int = 1

        fun setCalendar() {
            try {
                count = 1
                var c = Calendar.getInstance()
                c[Calendar.DAY_OF_MONTH] = 1
                var firstDay: Int = c.get(Calendar.DAY_OF_WEEK);
                c.add(Calendar.DATE, (firstDay - 7))
                var previousMonthDay: Int = c.get(Calendar.DAY_OF_MONTH) - 1

                for (i in 1..firstDay - 2) {
                    var new_Day = TextView(this)
                    new_Day.textSize = 20f
                    new_Day.gravity = Gravity.CENTER
                    new_Day.text = "$previousMonthDay"
                    previousMonthDay += 1
                    new_Day.width = 195
                    new_Day.height = 100
                    lay_1.addView(new_Day)
                }
                //первая неделя
                for (i in firstDay - 1..7) {
                    var new_Day = TextView(this)
                    new_Day.textSize = 20f
                    new_Day.gravity = Gravity.CENTER
                    new_Day.text = "$count"
                    count += 1
                    new_Day.width = 195
                    new_Day.height = 100
                    lay_1.addView(new_Day)
                    }
                } catch (e: Exception) {
                    Log.d("Error.", "Сообщение: ${e.message}, $count")
                }
            }




            btn_back.setOnClickListener { setCalendar() }
            btn_forward.setOnClickListener { setCalendar() }
            buttonToday.setOnClickListener {

                Log.e("What", "idk")
                try{
                    setCalendar()
                }
                catch (e:Exception){
                    Log.d("Error.","Сообщение: ${e.message}")
                }
            }
        }
    }
