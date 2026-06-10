package com.example.campsitecommander

import android.annotation.SuppressLint
import android.app.ComponentCaller
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
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
import com.example.campsitecommander.ui.theme.AddGearActivity
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme

class MainActivity : ComponentActivity() {

    //--Parallel Arrays --
    val itemNames = mutableListOf("Tent","Marshmallows","Flashlght")
    val itemCategories = mutableListOf("Shelter","Food", "Safety")
    val itemQuantities = mutableListOf(1,2,3)
    val itemComments = mutableListOf(
        "4-person waterproof",
        "S'mores",
        "Battries (AAA)"
    )
    lateinit var tvTotalItems: TextView
    lateinit var lvGearList: ListView

    fun startActivityForResult(intent: Any, requestCode: Int) {
        TODO("Not yet implemented")
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            setContentView(R.layout.main_layout)

            tvTotalItems = findViewById(R.id.tvTotallItems)
            lvGearList = findViewById<ListView>(R.id.lvGearList)
            val btnGear = findViewById<Button>(R.id.btngear)

            refreshList()

            //--Navigate to Add Gear Screen --
            btnGear.setOnClickListener {
                val intent=Intent(this, AddGearActivity::class.java)
                startActivityForResult(Intent,1)
            }

            // --- Called when returning from AddGearActivity ---
            override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                super.onActivityResult(requestCode, resultCode, data)
                if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
                    itemNames.add(data.getStringExtra("NAME") ?: "")
                    itemCategories.add(data.getStringExtra("CATEGORY") ?: "")
                    itemQuantities.add(data.getIntExtra("QUANTITY", 1))
                    itemComments.add(data.getStringExtra("COMMENT") ?: "")
                    refreshList()
                }
            }

            //--Refresh List and total---
            fun refreshList {
                val calculate = ""
                tvTotalItems.text = "Total Items Packed: ${calculate TotalItems()}"

                val adapter = object : ArrayAdapter<String>(this, R.layout.activity_add_gear, itemNames) {
                    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                        val view = convertView ?: layoutInflater.inflate(R.layout.item_gear, parent, false)
                        view.findViewById<TextView>(R.id.tvItemName).text = itemNames[position]
                        view.findViewById<TextView>(R.id.tvItemCategory).text = itemCategories[position]
                        view.findViewById<TextView>(R.id.tvItemQty).text = "x${itemQuantities[position]}"
                        return view
                    }
                }
                lvGearList.adapter = adapter
            }

            //--Calculate using a loop ---
            fun calculate{} TotallItems(): int {
                var total = 0
            for (qty in itemQuantities){
                total+= qty
            }

            return total
            }












        }
    }

    private fun refreshList() {
        TODO("Not yet implemented")
    }
}