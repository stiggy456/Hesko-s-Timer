package site.dougsdigitalpublishing.heskostimer

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.support.v4.app.NotificationCompat
import java.nio.channels.Channel

/**
 * Created by doug on 3/26/18.
 */
class NotificationUtil {
    companion object {
        private const val CHANNEL_ID_TIMER ="menu_timer"
        private const val CHANNEL_NAME_TIMER = "Timmer App Timer"
        private const val TIMER_ID = 0

        fun showTimerExpired(context: Context){
            val startIntent = Intent(context, TimerNotificationActivationReciever::class.java)
            startIntent.action = AppConstant.ACTION_START
            val startPendingIntent = PendingIntent.getBroadcast(context, 0, startIntent, PendingIntent.FLAG_UPDATE_CURRENT)

            val nBuilder = getBasicNotificationBuilder(context, CHANNEL_ID_TIMER, true)
            nBuilder.setContentTitle("Timer Expired!")
                    .setContentText("Start Again?")
                    .setContentIntent()
        }

        private fun getBasicNotificationBuilder(context: Context, channelId: String, playSound: Boolean)
        : NotificationCompat.Builder{
            val notificationSound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val nBuilder = NotificationCompat.Builder(context, channelId)
                    .setSmallIcon(R.drawable.ic_timer)
                    .setAutoCancel(true)
                    .setDefaults(0)
            if (playSound) nBuilder.setSound(notificationSound)
            return nBuilder

        }

        private fun <T> getPendingIntentWithStack(context: Context, javaClass: Class<T>): PendingIntent{
            val resultIntent = Intent(context, javaClass)
            resultIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

            val stackBuilder = TaskStackBuilder.create(context)
            stackBuilder.addParentStack(javaClass)
            stackBuilder.addNextIntent(resultIntent)

            return stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }


    }
}