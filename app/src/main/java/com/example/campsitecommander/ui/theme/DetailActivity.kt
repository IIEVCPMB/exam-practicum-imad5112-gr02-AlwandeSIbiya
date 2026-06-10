package com.example.campsitecommander.ui.theme

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private val Any.activity_detail: Any
private val Any.btnBackToBase: Int
private val Any.tvDetailCategory: Int
private val Any.tvDetailComment: Int
private val Any.tvDetailQty: Int
private val Any.tvDetailName: Int

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val contentView = setContentView(R.layout.activity_detail)


        // Receive data sent from MainActivity
        val name = intent.getStringExtra("ITEM_NAME") ?: "Unknown"
        val category = intent.getStringExtra("ITEM_CATEGORY") ?: "Unknown"
        val quantity = intent.getIntExtra("ITEM_QUANTITY", 0)
        val comment = intent.getStringExtra("ITEM_COMMENT") ?: "No comments"

        // Display the data
        findViewById<TextView>(R.id.tvDetailName).text = name
        findViewById<TextView>(/* id = */ R.id.tvDetailCategory).text = category
        findViewById<TextView>(R.id.tvDetailQty).text = quantity.toString()
        findViewById<TextView>(R.id.tvDetailComment).text = comment

        // Back to Base button
        findViewById<Button>(R.id.btnBackToBase).setOnClickListener {
            finish()
        }
    }
}
