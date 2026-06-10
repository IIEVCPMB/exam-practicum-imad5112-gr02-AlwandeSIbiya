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


            //--Parallel Arrays --
            val itemNames = mutableListOf("Tent","Marshmallows","Flashlght")
            val itemCategories = mutableListOf("Shelter","Food", "Safety")
            val itemQuantities = mutableListOf(1,2,3)
            val itemComments = mutableListOf(
                "4-person waterproof",
                  "S'mores",
                    "Battries (AAA)"
            )







        }
    }
}