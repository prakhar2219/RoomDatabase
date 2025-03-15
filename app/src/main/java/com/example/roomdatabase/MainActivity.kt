package com.example.roomdatabase

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
// singleton pattern means ek project ke andaar database kaa sirf ek hi instance hoga
//        database = Room.databaseBuilder(applicationContext,
//            ContactDatabase::class.java,
//            "contactDB").build()

        database = ContactDatabase.getDatabase(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0, "John", "99999", Date()))
        }
//        jaise jaise data me update hoga ye call ho jayegaa

    }
    fun getContact(view: View){
        database.contactDao().getContact().observe(this){
            Log.d("prakhar",it.toString())
        }
    }
}