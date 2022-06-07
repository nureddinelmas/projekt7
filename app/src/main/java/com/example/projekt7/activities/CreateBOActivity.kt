package com.example.projekt7.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.projekt7.Model.BusinessOwner
import com.example.projekt7.R
import com.example.projekt7.util.DataManager

class CreateBOActivity : AppCompatActivity() {
    lateinit var nameEditText: EditText
    lateinit var businessEditText: EditText
    lateinit var streetEditText: EditText
    lateinit var zipEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var mailEditText: EditText
    lateinit var keyEditText: EditText
    lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_boactivity)

        supportActionBar?.hide()

        val createUserButton = findViewById<Button>(R.id.buttonCreateUser)
        createUserButton.setOnClickListener() {
            nameEditText = findViewById(R.id.businessName)
            businessEditText = findViewById(R.id.adressBusiness)

            zipEditText = findViewById(R.id.phoneNumber)

            mailEditText = findViewById(R.id.editTextMail)
            passwordEditText = findViewById(R.id.editTextPassword)
            keyEditText = findViewById(R.id.editTextIdentityKey)

            var nameString = nameEditText.getText().toString()
            var streetString = streetEditText.getText().toString()
            var businessString = businessEditText.getText().toString()
            var passwordString = passwordEditText.getText().toString()
            var zipString = zipEditText.getText().toString()
            var phoneString = phoneEditText.getText().toString()
            var mailString = mailEditText.getText().toString()


            val newBusinessOwner = BusinessOwner(
                nameString, businessString, streetString, zipString, phoneString, mailString,
                passwordString
            )
            DataManager.businessOwnerList.add(newBusinessOwner)

            //Nedan är lite check i LogCat på att alla uppgifter sparats
            var printNewUser =
                DataManager.businessOwnerList[DataManager.businessOwnerList.lastIndex]


            DataManager.createBO(mailString,passwordString)
            val intent = Intent(this, LoginScreenActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Account created !", Toast.LENGTH_SHORT).show()
        }
    }
}