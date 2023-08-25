package ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taxion.R
import com.example.taxion.databinding.FragmentUserChoiceBinding

class UserChoiceFragment : Fragment() {
    lateinit var binding: FragmentUserChoiceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserChoiceBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.apply {
            ButtonPassenger.setOnClickListener {
                controller.navigate(R.id.splashScreenFragment)
            }
            ButtonDriver.setOnClickListener {
                controller.navigate(R.id.lobbyFragment)
            }
        }
    }
}