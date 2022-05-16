package eu.tuto.bangercat.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import eu.tuto.bangercat.R
import eu.tuto.bangercat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.addButton.setOnClickListener {
            addButtonActivity()
            Log.e("works", "da clicked")
        }

    }

    private fun addButtonActivity() {
        val intent = Intent(this, AddMusicActivity::class.java)
        startActivity(intent)
        Log.e("works", "da clicked")
    }

}