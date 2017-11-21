package com.example.patrickdz96.aqp_tour;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import android.os.Handler;
import java.util.logging.LogRecord;

public class LugarTuristico extends AppCompatActivity {



    ImageView img;
    int i = 0;
    int[] ImageList;
    MediaPlayer mediaPlayer;

    //seekbar

    SeekBar seekBar;
    Handler handler;
    Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar_turistico);
        img= (ImageView) findViewById(R.id.imagen_turistica);
        ImageList = new int[]{R.drawable.ciudad_blanca, R.drawable.diablo,R.drawable.catedral1,R.drawable.catedral2};
        //ArrayList<Integer> myImageList = new ArrayList<>();
        //myImageList.add(R.drawable.thingOne);
        // later...
        //myImageView.setImageResource(myImageList.get(i));

        handler = new Handler();

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create(LugarTuristico.this,R.raw.dialogo_arequipa);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //mediaPlayer.start();


/*
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener(){
            @Override
            public void onPrepared(MediaPlayer mediaPlayer){
                seekBar.setMax(mediaPlayer.getDuration());
                playCycle();
                mediaPlayer.start();
            }
        });
*/
        seekBar.setMax(mediaPlayer.getDuration());
        playCycle();
        mediaPlayer.start();



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean input) {
                if(input){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void playCycle(){
        seekBar.setProgress(mediaPlayer.getCurrentPosition());

        if(mediaPlayer.isPlaying()){
            runnable = new Runnable() {
                @Override
                public void run() {
                    playCycle();
                }
            };
            handler.postDelayed(runnable,1000);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
        playCycle();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
        handler.removeCallbacks(runnable);
    }







    public void atras(View view) {
        //Toast.makeText(this, "ATRAS", Toast.LENGTH_LONG).show();
        i--;
        if(i<0){i=0;}
        img.setImageResource(ImageList[i]);}


    public void adelante(View view) {
        //Toast.makeText(this, "ADELANTE", Toast.LENGTH_LONG).show();
        i++;
        if(i>3){i=3;}
        img.setImageResource(ImageList[i]);}


    public void play_dialogo(View view){

        if(mediaPlayer.isPlaying())
        {
            //stop or pause your media player mediaPlayer.stop(); or mediaPlayer.pause();
            mediaPlayer.pause();
        }
        else
        {
            mediaPlayer.start();
            playCycle();
        }
    }





}
