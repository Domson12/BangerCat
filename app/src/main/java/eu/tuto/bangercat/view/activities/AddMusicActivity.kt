package eu.tuto.bangercat.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import eu.tuto.bangercat.R
import eu.tuto.bangercat.databinding.ActivityAddMusicBinding


class AddMusicActivity : AppCompatActivity() {
    private val getImage =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            if (uri != null) {
                findViewById<ImageView>(R.id.musicImage).setImageURI(uri)
                Log.e("AddMusicActivity", "added image")
            } else {
                Log.e("AddMusicActivity", " image URI not present")
            }
        }
    private val getMusic =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            if (uri != null) {
                findViewById<TextView>(R.id.musicUrlHolder).text = uri.toString()
                Log.e("AddMusicActivity", "added music")
            } else {
                Log.e("AddMusicActivity", "music URI not Present")
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityAddMusicBinding = ActivityAddMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            buttonAddImage.setOnClickListener {
                getImage.launch(arrayOf("image/*"))
            }
            buttonAddMusic.setOnClickListener {
                getMusic.launch(arrayOf("audio/*"))
            }
        }
    }
}

