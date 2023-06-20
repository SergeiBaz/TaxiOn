package presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxion.R
import com.example.taxion.databinding.FragmentUserChoiceBinding

class UserChoiceFragment : Fragment() {

    lateinit var binding: FragmentUserChoiceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentUserChoiceBinding
            .inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = UserChoiceFragment()
    }
}