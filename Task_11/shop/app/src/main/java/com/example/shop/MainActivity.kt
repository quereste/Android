package com.example.shop

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shop.adapter.ItemAdapter
import com.example.shop.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val innerDataSet = DataSource().loadItems()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ItemAdapter(this, innerDataSet)
        recyclerView.setHasFixedSize(true)

        val notificationManager = ContextCompat.getSystemService(this, NotificationManager::class.java,
        ) as NotificationManager

        createChannel(notificationManager, getString(R.string.channel_id), "news")

        notificationManager.sendNotificationNewProduct("Dot is now available", this)
        notificationManager.sendNotificationDiscount("Discount up to the end of the week", this)
    }
}

private const val NOTIFICATION_NEWPRODUCT_ID = 123
private const val NOTIFICATION_DISCOUNT_ID = 243

private fun createChannel(notificationManager: NotificationManager, channelId: String, channelName: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val notificationChannel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_LOW
        ).apply { setShowBadge(true) }

        notificationManager.createNotificationChannel(notificationChannel)
    }
}

@RequiresApi(Build.VERSION_CODES.M)
fun NotificationManager.sendNotificationNewProduct(messageBody: String, applicationContext: Context) {
    val intent = Intent(applicationContext, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_NEWPRODUCT_ID,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.channel_id)
    )
        .setSmallIcon(R.drawable.square)
        .setContentTitle("New product")
        .setContentText(messageBody)
        .setContentIntent(pendingIntent)
        .setAutoCancel(false)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setBadgeIconType(NotificationCompat.BADGE_ICON_LARGE)

    notify(NOTIFICATION_NEWPRODUCT_ID, builder.build())


}

@RequiresApi(Build.VERSION_CODES.M)
fun NotificationManager.sendNotificationDiscount(messageBody: String, applicationContext: Context) {
    val intent = Intent(applicationContext, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_DISCOUNT_ID,
        intent,
        PendingIntent.FLAG_IMMUTABLE
    )

    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.channel_id)
    )
        .setSmallIcon(R.drawable.square)
        .setContentTitle("Discount!!!")
        .setContentText(messageBody)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_HIGH)

    notify(NOTIFICATION_DISCOUNT_ID, builder.build())
}
