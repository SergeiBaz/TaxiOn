package presentation.fragments.mainScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.taxion.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class DriverMainScreenFragment : Fragment(R.layout.fragment_driver_main_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(
            R.id.mainBottomNavigationDriverView
        )
        val navController = (
                childFragmentManager
                    .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
                ).navController
        bottomNavigationView.setupWithNavController(navController)
    }
}