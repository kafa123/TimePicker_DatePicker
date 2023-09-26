package com.example.countryroad

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import com.example.countryroad.databinding.ActivityPesanBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

private lateinit var binding: ActivityPesanBinding
class PesanActivity : AppCompatActivity() {


private lateinit var datePickers: EditText
private lateinit var timePicker: EditText
private lateinit var tiket:Array<String>
lateinit var jenisTiket:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPesanBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val Country = intent.getStringExtra("COUNTRY_NAME")
        datePickers=findViewById(R.id.datePicker)
        timePicker=findViewById(R.id.timePicker)
        tiket=resources.getStringArray(R.array.tiket)


        with(binding){
            val myCalendar = Calendar.getInstance()

            val datePicker= DatePickerDialog.OnDateSetListener{
                view,year,month,dayOfMonth->
                myCalendar.set(Calendar.YEAR,year)
                myCalendar.set(Calendar.MONTH,month)
                myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
                updateLable(myCalendar)
            }
            val timePickerDialog = TimePickerDialog(this@PesanActivity, TimePickerDialog.OnTimeSetListener { _: TimePicker, hourOfDay: Int, minute: Int ->
                myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                myCalendar.set(Calendar.MINUTE, minute)
                updateTimeLabel(myCalendar)
            }, myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE), false)

            btnDatePicker.setOnClickListener {
                val datePickerDialog=DatePickerDialog(this@PesanActivity,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH))
                datePickerDialog.show()
            }
            btnTimePicker.setOnClickListener {
                timePickerDialog.show()
            }
            btnPesan.setOnClickListener {
                val selectedTiket=jenisTiket.selectedItem.toString()

                Toast.makeText(this@PesanActivity,"Pemesanan Telah Berhasil Dilakukan",Toast.LENGTH_SHORT).show()
                Toast.makeText(this@PesanActivity, "anda memesan tiket pesan menuju "+Country, Toast.LENGTH_SHORT).show()
                Toast.makeText(this@PesanActivity,"pada tanggal "+ datePickers.text.toString(),Toast.LENGTH_SHORT).show()
                Toast.makeText(this@PesanActivity,"pukul: "+timePicker.text.toString(),Toast.LENGTH_SHORT).show()
                Toast.makeText(this@PesanActivity,"menggunakan "+selectedTiket,Toast.LENGTH_SHORT).show()
            }
            val tiketClass = ArrayAdapter(/* context = */ this@PesanActivity,/* resource = */
                android.R.layout.simple_spinner_dropdown_item,tiket)
            tiketClass.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            jenisTiket.adapter= tiketClass
        }
        }
    private fun updateLable(myCalendar: Calendar){
        val myFormat = "dd-MM-yyyy"
        val sdf= SimpleDateFormat(myFormat, Locale.UK)
        datePickers.setText(sdf.format(myCalendar.time))
    }
    private fun updateTimeLabel(myCalendar: Calendar){
        val myFormat = "HH:mm"
        val sdf= SimpleDateFormat(myFormat, Locale.UK)
        timePicker.setText(sdf.format(myCalendar.time))
    }
}