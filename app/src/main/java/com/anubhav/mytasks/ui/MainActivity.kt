package com.anubhav.mytasks.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.anubhav.mytasks.R
import com.anubhav.mytasks.databinding.ActivityMainBinding
import com.anubhav.mytasks.models.TaskItem
import com.anubhav.mytasks.ui.recyclerviewadapter.RecyclerViewAdapter

class MainActivity : AppCompatActivity() {

    //create a binding instance of activity main binding
    private lateinit var binding: ActivityMainBinding

    //create a global empty list to store the data to be displayed in recycler view
    private val taskList: MutableList<TaskItem> = mutableListOf()
    private val recyclerViewAdapter = RecyclerViewAdapter(taskList)

    //when the activity xml is created
    // instructions to execute when the xml is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate and bind all the views we have added in our xml file -"activity_main"
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //attach the toolbar we have added in our xml
        setSupportActionBar(binding.toolbar)
        //set title for your toolbar
        supportActionBar?.title = "Task App"
        //inflate the menu we have designed
        (this as MenuHost).addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                //inflate the menu layout you want to display in the toolbar
                menuInflater.inflate(R.menu.toolbar_account_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    // the menu id's you want to check
                    R.id.sortMenu -> {
                        // write the instructions you want to execute when this menu is pressed
                        return true
                    }

                    R.id.deleteMenu -> {
                        // write the instructions you want to execute when this menu is pressed
                        return true
                    }
                }
                return false
            }
        }, this) //this -> is to say or indicate who is the owner of this toolbar
        // here this is referring to the Main Activity class
        // since main activity is the owner or the place where our toolbar menu are present

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = recyclerViewAdapter

        binding.addButton.setOnClickListener {
            //here you can write the instructions that need to be executed when the button is clicked
            //here we are displaying a message (toast) to the user with a message.
            // (Run the app to understand and find out how a toast looks like)
            Toast.makeText(this, "Hello guys welcome to android kotlin event", Toast.LENGTH_LONG).show()
            val taskItem1 = TaskItem("Conduct kotlin mvvm", 1);
            taskList.add(taskItem1)
            Log.i("MY-TESTING","The contents in the list are $taskList")
            recyclerViewAdapter.notifyDataSetChanged()
        }


    }
}