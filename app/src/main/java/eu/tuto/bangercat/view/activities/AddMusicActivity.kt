package eu.tuto.bangercat.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import eu.tuto.bangercat.R
import eu.tuto.bangercat.databinding.ActivityAddMusicBinding



class AddMusicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_music)
    }
}