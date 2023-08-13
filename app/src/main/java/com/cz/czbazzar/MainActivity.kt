package com.cz.czbazzar

import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cz.czbazzar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        /* load(home())

          binding.bottomnav.setOnItemSelectedListener{
              val selecetedFragment= when(it.itemId){

                  R.id.cart->{
                      cart()
                  }
                  R.id.profile->{
                      profile()
                  }
                  else-> {
                      home()
                  }
              }
              load(selecetedFragment)
              true


          }*/




        val navHostFragment=supportFragmentManager.findFragmentById(R.id.framelayout) as NavHostFragment
        val navController = navHostFragment.navController
        val popupMenu=PopupMenu(this,null)
        popupMenu.inflate(R.menu.menu)

        binding.bottomnav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(object :NavController.OnDestinationChangedListener{
            override fun onDestinationChanged(
                controller: NavController,
                destination: NavDestination,
                arguments: Bundle?
            ) {
                title=when(destination.id){

                   R.id.profile->"My Profile"
                   R.id.cart->"My Cart"

                    else->"Home"
                }
            }

        })
        setContentView(binding.root)
    }
   /* private fun load(fragment:Fragment){

       supportFragmentManager.beginTransaction().replace(R.id.framelayout, fragment).commit()


    }*/



}