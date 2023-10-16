package edu.mp.mrunalpatil_colorpicker

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var RedSwitch: Switch
    lateinit var BlueSwitch: Switch
    lateinit var GreenSwitch: Switch
    lateinit var Red_Seek: SeekBar
    lateinit var Blue_Seek: SeekBar
    lateinit var Green_Seek: SeekBar
    lateinit var RedText: EditText
    lateinit var BlueText: EditText
    lateinit var GreenText: EditText
    lateinit var cview: View
    lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var red_color = 0
        var blue_color = 0
        var green_color = 0

        RedSwitch = findViewById(R.id.RedSwitch)
        BlueSwitch = findViewById(R.id.BlueSwitch)
        GreenSwitch = findViewById(R.id.GreenSwitch)
        Red_Seek = findViewById(R.id.Red_seek)
        Blue_Seek = findViewById(R.id.Blue_seek)
        Green_Seek = findViewById(R.id.Green_seek)
        RedText = findViewById(R.id.Red_View)
        BlueText = findViewById(R.id.Blue_View)
        GreenText = findViewById(R.id.Green_View)
        resetButton = findViewById(R.id.resetButton)
        cview = findViewById(R.id.ColView)
        //cview.setBackgroundColor(Color.BLACK)

        var Red = 0
        var Blue = 0
        var Green = 0

        Red_Seek.isEnabled = false
        Blue_Seek.isEnabled = false
        Green_Seek.isEnabled = false
        RedText.isEnabled = false
        BlueText.isEnabled = false
        GreenText.isEnabled = false

        Red_Seek.progress = 0
        RedText.setText("0.0")
        Blue_Seek.progress = 0
        BlueText.setText("0.0")
        Green_Seek.progress = 0
        GreenText.setText("0.0")


        RedSwitch.setOnCheckedChangeListener { _, isChecked ->
            Red_Seek.isEnabled = isChecked
            RedText.isEnabled = isChecked
            if (isChecked) {
                Red_Seek.isEnabled = true
                RedText.setText("0.0")
            }
            else {
                Red_Seek.isEnabled = false
                RedText.setText("0.0")
            }
            update(cview, Red, Green, Blue)
        }

        Red_Seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}

            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (Red_Seek != null) {
                    Red = Red_Seek.progress
                    update(cview, Red, Green, Blue)
                }
                val output = DecimalFormat("#0.00").format(progress/255.0)
                RedText.setText(output)
                /*RedTextView.setText("%.2f".format(p1 / 100.0))
                update(cview, Red, Green, Blue)*/
            }

            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
        })
//************************

        RedText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.toDoubleOrNull()?.let {
                    val progress = (it * 255).toInt()
                    Red_Seek.progress = progress
                }
            }
        })


/*
        RedTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
/*
                s?.toString()?.toDoubleOrNull()?.let {
                    val output = (it * 255).toInt()
                    Red_Seek.progress = output
                }
                */
                val output = s.toString().toFloatOrNull()
                if (output != null && output >= 0 && output <= 1) {
                    Red_Seek.progress = (output * 100).toInt()
                    update(cview, Red, Green, Blue)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        })
*/
        BlueSwitch.setOnCheckedChangeListener { _, isChecked ->
            Blue_Seek.isEnabled = isChecked
            BlueText.isEnabled = isChecked
            if (isChecked) {
                Blue_Seek.isEnabled = true
                BlueText.setText("0.0")
            }
            else {
                Blue_Seek.isEnabled = false
               BlueText.setText("0.0")
            }
            update(cview, Red, Green, Blue)
        }


        Blue_Seek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}

            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                if (Blue_Seek != null) {
                    Blue = Blue_Seek.progress
                    update(cview, Red, Green, Blue)
                }
                val output = DecimalFormat("#0.00").format(progress/255.0)
                BlueText.setText(output)
            }

            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
        })

        BlueText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.toDoubleOrNull()?.let {
                    val progress = (it * 255).toInt()
                    Blue_Seek.progress = progress
                }
            }
        })
/*
        BlueTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(colrange: Editable?) {
                val output = colrange.toString().toFloatOrNull()
                if (output != null && output >= 0 && output <= 1) {
                    Blue_Seek.progress = (output * 100).toInt()
                    update(cview, Red, Green, Blue)
                }
            }

            override fun beforeTextChanged(colrange: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(colrange: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }
        })
*/
        GreenSwitch.setOnCheckedChangeListener { _, isChecked ->
            Green_Seek.isEnabled = isChecked
            GreenText.isEnabled = isChecked
            if (isChecked) {
                Green_Seek.isEnabled = true
                GreenText.setText("0.0")
            }
            else {
                Green_Seek.isEnabled = false
                GreenText.setText("0.0")
            }
            update(cview, Red, Green, Blue)
        }

        Green_Seek.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onStartTrackingTouch(SeekBar: SeekBar?) {}

            override fun onProgressChanged(SeekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (Green_Seek != null) {
                    Green = Green_Seek.progress
                    update(cview, Red, Green, Blue)
                }
                val output = DecimalFormat("#0.00").format(progress/255.0)
                GreenText.setText(output)

            }

            override fun onStopTrackingTouch(SeekBar: SeekBar?) {}
        })


        GreenText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                s?.toString()?.toDoubleOrNull()?.let {
                    val progress = (it * 255).toInt()
                    Green_Seek.progress = progress
                }
            }
        })
/*
        GreenTextView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(colrange: Editable?) {
                val output = colrange.toString().toFloatOrNull()
                if (output != null && output >= 0 && output <= 1) {
                    Green_Seek.progress = (output * 100).toInt()
                    update(cview, Red, Green, Blue)
                }
            }

            override fun beforeTextChanged(colrange: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(colrange: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("Not yet implemented")
            }
        })
*/


        resetButton.setOnClickListener {
            Red_Seek.progress = 0
            Blue_Seek.progress = 0
            Green_Seek.progress = 0

            Red_Seek.isEnabled = false
            Blue_Seek.isEnabled = false
            Green_Seek.isEnabled = false

            RedSwitch.isChecked = false
            BlueSwitch.isChecked = false
            GreenSwitch.isChecked = false

            RedText.setText("0.0")
            BlueText.setText("0.0")
            GreenText.setText("0.0")

            update(cview, Red, Green, Blue)
        }


    }


    private fun update(colorView: View, Red: Int, Green: Int, Blue: Int) {
        var updateColor = Color.rgb(Red,Green, Blue)

        if (Red == 0 && Green == 0 && Blue == 0) {
            colorView.setBackgroundColor(Color.WHITE)
        }
        else {
            colorView.setBackgroundColor(updateColor)
        }
    }

}