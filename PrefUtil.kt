package site.dougsdigitalpublishing.heskostimer.utl
import android.content.Context
import android.preference.PreferenceManager
import site.dougsdigitalpublishing.heskostimer.TimerActivity
import java.sql.Time

/**
 * Created by doug on 3/1/18.
 */
class PrefUtil {
    companion object {
        fun getTimerLength(context : Context): Int{
            //placeholder
            return 1
        }

        private const val PREVIOUS_TIMER_LENGTH_SECONDS_ID = "site.dougsdigitalpublishing.heskostimer.previous_timer_length"

        fun getPreviousTimerLengthSeconds(context: Context): Long{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID,0)
        }

        fun getPreviousTimerLengthSeconds(seconds: Long, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(PREVIOUS_TIMER_LENGTH_SECONDS_ID, seconds)
            editor.apply()
        }

        private const val TIMER_STATE_ID = "site.dougsdigitalpublishing.heskostimer.timer_state"

        fun  getTimerState(context: Context): TimerActivity.TimerState{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            val ordinal = preferences.getInt(TIMER_STATE_ID,0)
            return TimerActivity.TimerState.values()[ordinal]
             }

        fun getTimerState(state: TimerActivity.TimerState, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            val ordinal = state.ordinal
            editor.putInt(TIMER_STATE_ID, ordinal)
            editor.apply()
        }

        private const val SECONDS_REMAINING_ID = "site.dougsdigitalpublishing.heskostimer.seconds_remaining"

        fun getSecondsRemaining(context: Context): Long{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(SECONDS_REMAINING_ID,0)
        }

        fun setSecondsRemaining(seconds: Long, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(SECONDS_REMAINING_ID, seconds)
            editor.apply()
        }

        private const val Alarm_Set_Time_ID = "site.dougsdigitalpublishing.heskostimer.background_time"

        fun getAlarmSetTime(context: Context): Long{
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getLong(Alarm_Set_Time_ID, 0)
        }

        fun setAlarmSetTime (time: Long, context: Context){
            val editor = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putLong(Alarm_Set_Time_ID, time)
            editor.apply()
        }

        fun setPreviousTimerLengthSeconds(timerLengthSeconds: Long, timerActivity: TimerActivity) {}
        fun setSecondsRemaining(secondsRemaining: Long, timerActivity: TimerActivity) {}
        fun setTimerState(timerState: TimerActivity.TimerState, timerActivity: TimerActivity) {}
        fun setSecondsRemaing(timerLengthSeconds: Long, timerActivity: TimerActivity) {}

    }
}