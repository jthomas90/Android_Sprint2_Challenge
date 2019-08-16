package com.lambdaschool.sprint2_challenge
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GrocerlistRepo.createGroceryList()

        grocery_list_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ShoppingListAdapter(GrocerlistRepo.grocerylist)
        }


        //triggering notification and intent taking orderList and taking it to Messaging app
        share_button.setOnClickListener {
           val shareIntent: Intent = Intent().apply {
               action = Intent.ACTION_SEND
               putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
               type = "text/plain"
           }
            startActivity(shareIntent)



        }




    }

    fun notificationSaver(orderList: String) {
        val channelID = "${this.packageName}.simplechannel"
        val notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

        }
    }







}
