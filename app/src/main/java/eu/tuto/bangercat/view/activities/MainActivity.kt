package eu.tuto.bangercat.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import eu.tuto.bangercat.R
import eu.tuto.bangercat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.addButton.setOnClickListener {
            addButtonActivity()
        }

    }

    private fun addButtonActivity() {
        val intent = Intent(this, AddMusicActivity::class.java)
        startActivity(intent)
    }

}