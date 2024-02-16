package com.tvr.androidtemplate.features.home

import android.os.Bundle
import android.view.ContextMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tvr.androidtemplate.R
import com.tvr.androidtemplate.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
/**
 * Created By Tanvir Hasan
 * Email: tanvirhasan553@gmail.com
 */
@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController: NavController
    private val viewModel: HomeViewModel by viewModels()
    lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setupBottomNavigation()
        //setSupportActionBar(binding.toolbar)

        navController = findNavController(R.id.nav_host_fragment_content_main)
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //binding.bottomNavigationView.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_post, R.id.nav_albums, R.id.nav_photo,R.id.nav_todo
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomNavigationView.setupWithNavController(navController)

    }

    /**
     * populating bottom navigation here
     */
   /* private fun setupBottomNavigation() {
       binding.bottomNavigationView.setOnItemSelectedListener {
           when(it.itemId){
               R.id.action_post-> setFragment(R.id.PostFragment,this.getString(R.string.post))
               R.id.action_albums-> setFragment(R.id.PhotoFragment,this.getString(R.string.album))
               R.id.action_photos-> setFragment(R.id.PhotoFragment,this.getString(R.string.photo))
              else -> setFragment(R.id.PostFragment,this.getString(R.string.todo))
           }
       }
    }*/

    private fun setFragment(id: Int,title:String): Boolean{
        //binding.toolbar.title = title
        navController.navigate(id)
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}