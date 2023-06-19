package presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taxion.R

class ApplicationDirectionSelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(
            R.layout.fragment_application_direction_selection,
            container,
            false
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = ApplicationDirectionSelectionFragment()
    }
}