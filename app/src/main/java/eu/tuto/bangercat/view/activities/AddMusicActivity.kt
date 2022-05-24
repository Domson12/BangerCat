package eu.tuto.bangercat.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import eu.tuto.bangercat.R
import eu.tuto.bangercat.database.Data
import eu.tuto.bangercat.databinding.ActivityAddMusicBinding
import eu.tuto.bangercat.viewmodel.MusicViewModel


class AddMusicActivity : AppCompatActivity() {
    private lateinit var musicViewModel: MusicViewModel
    private val getImage =
        registerForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
            contentResolver.takePersistableUriPermission(uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
            if (uri != null) {
                findViewById<ImageView>(R.id.musicImage).setImageURI(uri)
                findViewById<TextView>(R.id.imageUrlHolder).text = uri.toString()
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
        musicViewModel = MusicViewModel(application)
        setContentView(binding.root)

        binding.apply {
            buttonAddImage.setOnClickListener {
                getImage.launch(arrayOf("image/*"))
            }
            buttonAddMusic.setOnClickListener {
                getMusic.launch(arrayOf("audio/*"))
            }
            addAllButton.setOnClickListener {
                if (
                    editTextAuthor.text.isEmpty() ||
                    editTextTitle.text.isEmpty() ||
                    musicUrlHolder.text.isEmpty()
                ) {
                    Toast.makeText(
                        applicationContext,
                        "add required data. author, title, mp3 music",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val addAuthorToDatabase = editTextAuthor.text.toString()
                    val addTitleToDatabase = editTextTitle.text.toString()
                    val addMusicToDatabase = musicUrlHolder.text.toString()
                    val addImageToDatabase = imageUrlHolder.text.toString()

                    val addToDatabase = Data(
                        0,
                        addAuthorToDatabase,
                        addTitleToDatabase,
                        addMusicToDatabase,
                        addImageToDatabase
                    )
                    musicViewModel.addMusic(addToDatabase)
                    Toast.makeText(applicationContext, "Successfully added!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}

