package presentation.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.taxion.R
import com.example.taxion.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.fragments.UserChoiceFragment

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.Main).launch {
            binding.progressBar.max = 1000
            ObjectAnimator.ofInt(binding.progressBar, "progress", 1000)
                .setDuration(3000).start()
            delay(3000)
            binding.apply {
                imageView.visibility = View.GONE
                progressBar.visibility = View.GONE
            }
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.place_holder,
                    UserChoiceFragment.newInstance())
                .commit()
        }
    }
}