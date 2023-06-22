package presentation.activity

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.domain.useCases.CreateAuctionUseCase
import com.example.taxion.R
import com.example.taxion.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import di.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import presentation.fragments.UserChoiceFragment
import presentation.viewModels.CreateAuctionViewModel
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*(applicationContext as App).appComponent.inject(this)*/
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}