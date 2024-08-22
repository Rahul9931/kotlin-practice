package com.example.kotlin_practice2

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kotlin_practice2.databinding.ActivityNavigationPracticeBinding

class NavigationPracticeActivity : AppCompatActivity() {
    private val binding:ActivityNavigationPracticeBinding by lazy {
        ActivityNavigationPracticeBinding.inflate(layoutInflater)
    }
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController:NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setSupportActionBar(binding.toolbar2)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        // for removing upper back button
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.home_fragment2,R.id.settingFragment,R.id.notificationFragment),
            // for hamburger icon
            binding.dbView
        )
        // Attach action bar to navigation component
        setupActionBarWithNavController(navController,appBarConfiguration)

        // Attach toolbar to navigation component
        /*binding.toolbar2.setupWithNavController(navController)*/

        // Attach bottom navigation
        binding.bottomNavigationView.setupWithNavController(navController)

        // Attach Drawer Navigation
        binding.navigationDrawer.setupWithNavController(navController)

    }
    // Handling upper navigation back button
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}