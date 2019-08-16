package com.lambdaschool.sprint2_challenge
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
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
            saverNotification()
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, () )//this will hold my orderlist
                type = "text/plain"
            }
            startActivity(shareIntent)


        }


    }

    fun saverNotification(orderList: String) {
        val channelId = "${this.packageName}.grocerychannel"
        val notificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Grocery Notification Channel"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val description = "Channel to send shopping notification"

            val channel = NotificationChannel(channelId, name, importance)
            channel.description = description

            notificationManager.createNotificationChannel(channel)
        }


        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setPriority(NotificationManager.IMPORTANCE_HIGH)
            .setSmallIcon(android.R.drawable.ic_dialog_alert)
            .setContentTitle("Confimation")
            .setContentText("Order Has Been Placed")
            .setAutoCancel(true)
        notificationManager.notify(10, notificationBuilder.build())



    }

}
