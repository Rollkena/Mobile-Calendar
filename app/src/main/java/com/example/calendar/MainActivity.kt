package com.example.calendar

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.LinearLayout
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
        var requiredMonth = 0
        var today: Int

        //для выделения текущей даты
        fun todayView(count: Int): TextView {
            var new_Day = TextView(this)
            new_Day.textSize = 20f
            new_Day.gravity = Gravity.CENTER
            new_Day.text = "$count"
            new_Day.setTextColor(Color.BLACK)
            new_Day.width = 195
            new_Day.height = 100
            new_Day.setBackgroundColor(Color.rgb(150, 209, 183))
            return new_Day
        }
        //заполнение чисел календаря
        fun setCalendar(newMonth: Int) {
            try {
                count = 1
                var firstDay: Int
                var c = Calendar.getInstance()
                today = c.get(Calendar.DATE) + 1
                c.add(Calendar.MONTH, newMonth)
                textMonth.text = "${c.get(Calendar.MONTH) + 1}.${c.get(Calendar.YEAR)}"
                c[Calendar.DAY_OF_MONTH] = 1
                if (c.get(Calendar.DAY_OF_WEEK) == 1){
                    firstDay = 7
                }
                else{
                    firstDay = c.get(Calendar.DAY_OF_WEEK) - 1;
                }
                c.add(Calendar.DATE, ((7 - firstDay) - 6))
                var previousMonthDay: Int = c.get(Calendar.DAY_OF_MONTH)
                c = Calendar.getInstance()
                c.add(Calendar.MONTH, newMonth)
                c[Calendar.DAY_OF_MONTH] = 1
                c.add(Calendar.MONTH, 1)
                c.add(Calendar.DATE, -1)
                var lastDay: Int = c.get(Calendar.DAY_OF_MONTH)
                var lastDayWeek: Int
                if (c.get(Calendar.DAY_OF_WEEK) == 1){
                    lastDayWeek = 7
                }
                else{
                    lastDayWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
                }
                //прошлый месяц
                for (i in 1..firstDay - 1) {
                    var new_Day = TextView(this)
                    new_Day.textSize = 20f
                    new_Day.gravity = Gravity.CENTER
                    new_Day.text = "$previousMonthDay"
                    new_Day.setTextColor(Color.GRAY)
                    previousMonthDay += 1
                    new_Day.width = 195
                    new_Day.height = 100
                    lay_1.addView(new_Day)
                }
                //первая неделя
                for (i in firstDay..7) {
                    if (count == today && requiredMonth == 0) {
                        var new_Day = todayView(count)
                        count += 1
                        lay_1.addView(new_Day)
                    }
                    else{
                        var new_Day = TextView(this)
                        new_Day.textSize = 20f
                        new_Day.gravity = Gravity.CENTER
                        new_Day.text = "$count"
                        new_Day.setTextColor(Color.BLACK)
                        count += 1
                        new_Day.width = 195
                        new_Day.height = 100
                        lay_1.addView(new_Day)
                    }
                }
                //вторая неделя
                for (i in 1 ..7) {
                    if (count == today&& requiredMonth == 0) {
                        var new_Day = todayView(count)
                        count += 1
                        lay_2.addView(new_Day)
                    }
                    else{
                        var new_Day = TextView(this)
                        new_Day.textSize = 20f
                        new_Day.gravity = Gravity.CENTER
                        new_Day.text = "$count"
                        new_Day.setTextColor(Color.BLACK)
                        count += 1
                        new_Day.width = 195
                        new_Day.height = 100
                        lay_2.addView(new_Day)
                    }
                }
                //третья неделя
                for (i in 1 ..7) {
                    if (count == today&& requiredMonth == 0) {
                    var new_Day = todayView(count)
                    count += 1
                    lay_3.addView(new_Day)
                    }
                else{
                    var new_Day = TextView(this)
                    new_Day.textSize = 20f
                    new_Day.gravity = Gravity.CENTER
                    new_Day.text = "$count"
                    new_Day.setTextColor(Color.BLACK)
                    count += 1
                    new_Day.width = 195
                    new_Day.height = 100
                    lay_3.addView(new_Day)
                    }
                }
                //четвертая неделя
                for (i in 1 ..7) {
                    if (count == today&& requiredMonth == 0) {
                        var new_Day = todayView(count)
                        count += 1
                        lay_4.addView(new_Day)
                    }
                    else{
                        var new_Day = TextView(this)
                        new_Day.textSize = 20f
                        new_Day.gravity = Gravity.CENTER
                        new_Day.text = "$count"
                        new_Day.setTextColor(Color.BLACK)
                        count += 1
                        new_Day.width = 195
                        new_Day.height = 100
                        lay_4.addView(new_Day)
                    }
                }
                if ((lastDay == 30 && firstDay == 7) || (lastDay == 31 && firstDay > 5)){
                    //пятая неделя
                    for (i in 1 ..7) {
                        if (count == today&& requiredMonth == 0) {
                            var new_Day = todayView(count)
                            count += 1
                            lay_5.addView(new_Day)
                        }
                        else{
                            var new_Day = TextView(this)
                            new_Day.textSize = 20f
                            new_Day.gravity = Gravity.CENTER
                            new_Day.text = "$count"
                            new_Day.setTextColor(Color.BLACK)
                            count += 1
                            new_Day.width = 195
                            new_Day.height = 100
                            lay_5.addView(new_Day)
                        }
                    }
                    //шестая неделя
                    for (i in 1 ..lastDayWeek % 7) {
                        if (count == today&& requiredMonth == 0) {
                            var new_Day = todayView(count)
                            count += 1
                            lay_6.addView(new_Day)
                        }
                        else{
                            var new_Day = TextView(this)
                            new_Day.textSize = 20f
                            new_Day.gravity = Gravity.CENTER
                            new_Day.text = "$count"
                            new_Day.setTextColor(Color.BLACK)
                            count += 1
                            new_Day.width = 195
                            new_Day.height = 100
                            lay_6.addView(new_Day)
                        }
                    }
                    //след. месяц
                    count = 1
                    for (i in (lastDayWeek % 7) + 1 ..35) {
                        var new_Day = TextView(this)
                        new_Day.textSize = 20f
                        new_Day.gravity = Gravity.CENTER
                        new_Day.text = "$count"
                        new_Day.setTextColor(Color.GRAY)
                        count += 1
                        new_Day.width = 195
                        new_Day.height = 100
                        lay_6.addView(new_Day)
                    }
                }
                else{
                    //пятая неделя
                    if(lastDayWeek == 7){
                        for (i in 1 .. 7) {
                            if (count == today&& requiredMonth == 0) {
                                var new_Day = todayView(count)
                                count += 1
                                lay_5.addView(new_Day)
                            }
                            else{
                                var new_Day = TextView(this)
                                new_Day.textSize = 20f
                                new_Day.gravity = Gravity.CENTER
                                new_Day.text = "$count"
                                new_Day.setTextColor(Color.BLACK)
                                count += 1
                                new_Day.width = 195
                                new_Day.height = 100
                                lay_5.addView(new_Day)
                            }
                        }
                    }
                    else{
                        for (i in 1 ..lastDayWeek % 7) {
                            if (count == today && requiredMonth == 0) {
                                var new_Day = todayView(count)
                                count += 1
                                lay_5.addView(new_Day)
                            }
                            else{
                                var new_Day = TextView(this)
                                new_Day.textSize = 20f
                                new_Day.gravity = Gravity.CENTER
                                new_Day.text = "$count"
                                new_Day.setTextColor(Color.BLACK)
                                count += 1
                                new_Day.width = 195
                                new_Day.height = 100
                                lay_5.addView(new_Day)
                            }
                        }
                    }
                    //след. месяц
                    count = 1
                    for (i in (lastDayWeek % 7) + 1 ..35) {
                        var new_Day = TextView(this)
                        new_Day.textSize = 20f
                        new_Day.gravity = Gravity.CENTER
                        new_Day.text = "$count"
                        new_Day.setTextColor(Color.GRAY)
                        count += 1
                        new_Day.width = 195
                        new_Day.height = 100
                        lay_5.addView(new_Day)
                    }
                }
                } catch (e: Exception) {
                    Log.d("Error.", "Сообщение: ${e.message}, $count")
                }
            }
        fun deleteViews(){
            lay_1.removeAllViews()
            lay_2.removeAllViews()
            lay_3.removeAllViews()
            lay_4.removeAllViews()
            lay_5.removeAllViews()
            lay_6.removeAllViews()
        }
        //создание при запуске
        setCalendar(0)
        btn_back.setOnClickListener {
                deleteViews()
                requiredMonth -= 1
                setCalendar(requiredMonth)
            }
        btn_forward.setOnClickListener {
                deleteViews()
                requiredMonth += 1
                setCalendar(requiredMonth)
            }
        buttonToday.setOnClickListener {
                requiredMonth = 0
                deleteViews()
                setCalendar(0)
            }
        }
    }
