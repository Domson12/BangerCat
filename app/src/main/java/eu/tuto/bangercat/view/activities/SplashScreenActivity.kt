package eu.tuto.bangercat.view.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import eu.tuto.bangercat.R
import eu.tuto.bangercat.databinding.ActivitySplashScreenBinding


private lateinit var binding: ActivitySplashScreenBinding


@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
            binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim)
        binding.appName.animation = splashAnimation

        splashAnimation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
               Handler(Looper.getMainLooper()).postDelayed({
                 startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
               }, 1000)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }

        })

    }
}