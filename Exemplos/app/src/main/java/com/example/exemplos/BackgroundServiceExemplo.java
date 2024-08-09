package com.example.exemplos;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class BackgroundServiceExemplo {
    package com.example.musicapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

    public class MusicBackgroundService extends Service {
        private MediaPlayer mediaPlayer;

        public IBinder onBind(Intent intent){
            return null;
        }

        public int onStartCommand(Intent intent, int flags, int startId){
            mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();

            return START_STICKY;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();

            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }

    package com.example.musicapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

    public class AirplaneModeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
                boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);

                String msg = isAirplaneModeOn ? "Airplane Mode is ON" : "Airplane mode is OFF";

                Toast.makeText(context, ""+msg, Toast.LENGTH_LONG);
            }
        }
    }

}
