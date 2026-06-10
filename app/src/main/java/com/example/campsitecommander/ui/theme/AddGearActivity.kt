package com.example.campsitecommander.ui.theme

import androidx.appcompat.app.AppCompatActivity

class AddGearActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_gear)

        // Connect views
        val etItemName = findViewById<EditText>(R.id.etItemName)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val etComment = findViewById<EditText>(R.id.etComment)
        val spinner = findViewById<Spinner>(R.id.spinnerCategory)
        val btnSave = findViewById<Button>(R.id.btnSaveGear)
        val btnBack = findViewById<Button>(R.id.btnBackToBase)

        // Fill the category dropdown
        val categories = listOf("Shelter", "Food", "Safety", "Cooking", "First Aid", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Save button with error handling
        btnSave.setOnClickListener {

            val name = etItemName.text.toString().trim()
            val qtyText = etQuantity.text.toString().trim()
            val comment = etComment.text.toString().trim()
            val category = spinner.selectedItem.toString()

            // ERROR 1: empty name
            if (name.isEmpty()) {
                etItemName.error = "Please enter an item name!"
                etItemName.requestFocus()
                return@setOnClickListener
            }

            // ERROR 2: empty quantity
            if (qtyText.isEmpty()) {
                etQuantity.error = "Please enter a quantity!"
                etQuantity.requestFocus()
                return@setOnClickListener
            }

            // ERROR 3: quantity not a valid number
            val qty = qtyText.toIntOrNull()
            if (qty == null || qty <= 0) {
                etQuantity.error = "Quantity must be a number greater than 0!"
                etQuantity.requestFocus()
                return@setOnClickListener
            }

            // All good - send data back to MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("NAME", name)
            resultIntent.putExtra("CATEGORY", category)
            resultIntent.putExtra("QUANTITY", qty)
            resultIntent.putExtra("COMMENT", comment)
            setResult(RESULT_OK, resultIntent)
            Toast.makeText(this, "$name added to your pack!", Toast.LENGTH_SHORT).show()
            finish()
        }
        {
}
        // Back button - go back without saving
        btnBack.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}
