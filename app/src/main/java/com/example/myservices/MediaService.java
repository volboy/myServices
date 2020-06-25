package com.example.myservices;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MediaService extends Service {

    MediaPlayer ambientMediaPlayer;


    //вызывается при закреплении клиента за сервисом с помощью метода bindService()
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //вызывается при создании сервиса
    @Override
    public void onCreate(){
        ambientMediaPlayer=MediaPlayer.create(this, R.raw.dog);
        ambientMediaPlayer.setLooping(true);
    }

    //вызывается при получении сервисом команды, отправленной с помощью метода startService()
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        ambientMediaPlayer.start();
        return START_STICKY; //если процесс сервиса будет неожиданно завершен системой, то сервис останется в остановленном состоянии
    }

    @Override
    public void onDestroy(){
        ambientMediaPlayer.stop();
    }
}
