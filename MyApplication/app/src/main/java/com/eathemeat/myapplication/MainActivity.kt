package com.eathemeat.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.*
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.eathemeat.data.TestContext
import com.eathemeat.myapplication.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        for (item in TestContext.sIntance.navItems) {
            navView.menu.add(item.bottomItem.id).setIcon(item.bottomItem.icon).setTitle(item.bottomItem.title)
        }


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val provider: NavigatorProvider = navController.getNavigatorProvider()
        val fragmentNavigator =
            FragmentNavigator(this, getSupportFragmentManager(), R.id.nav_host_fragment_activity_main)
        provider.addNavigator(fragmentNavigator)
        val navGraph = NavGraph(NavGraphNavigator(provider))
        for (item in TestContext.sIntance.navItems) {
            val destination: FragmentNavigator.Destination = fragmentNavigator.createDestination()
            destination.id = item.fragmentItem.id
            destination.className = item.fragmentItem.className
            destination.addDeepLink(item.fragmentItem.pageUrl)
            navGraph.addDestination(destination)
        }
        navGraph.startDestination = TestContext.sIntance.navItems[0].fragmentItem.id
        navController.graph = navGraph
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_home, R.id.navigation_dashboard))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}