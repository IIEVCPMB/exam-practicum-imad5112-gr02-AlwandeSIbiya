package com.example.campsitecommander

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ->
            setContentView(R.layout.main_layout)

            //Link UI components to variables
            val inputItem = findViewById<EditText>(R.id.additemstxt)
            val btngear = findViewById<Button>(R.id.btngear)
            val txtResult= findViewById<TextView>(R.id.txtResult)

            btngear.setOnClickListener {
                val item = inputItem.text.toString().trim().lowercase()
                if(item.isEmpty()) {
                    Toast.makeText(this,"Add gear you like", Toast.LENGTH_SHORT). show()
                    return@setOnClickListener
                }


            }





        }
    }
}