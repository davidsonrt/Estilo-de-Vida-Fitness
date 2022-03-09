package com.example.style_de_vida_fitness;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class dont extends AppCompatActivity {


    MediaPlayer player;


    Button playBtn;

    SeekBar positionBar;
    int totalTime;

    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dont);

        playBtn = (Button) findViewById(R.id.idplay);


        elapsedTimeLabel = (TextView) findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = (TextView) findViewById(R.id.remainingTimeLabel);
        //player = MediaPlayer.create(this, R.raw.song);//Berlin at Night - Dan Henig
        player = MediaPlayer.create(this, R.raw.music);//Don't Wanna Be - Kwon
        //player = MediaPlayer.create(this, R.raw.song1);//Four More Weeks - Vans in Japan

        player.setLooping(true);

        player.seekTo(0);


        totalTime = player.getDuration();






        positionBar = (SeekBar) findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);

        positionBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            player.seekTo(progress);

                            positionBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );



        // Thread (Update positionBar & timeLabel)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (player != null) {
                    try {
                        Message msg = new Message();
                        msg.what = player.getCurrentPosition();

                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }

        }).start();

    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currentPosition = msg.what;
            // Update positionBar.
            positionBar.setProgress(currentPosition);

            // Update Labels.
            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLabel(totalTime - currentPosition);
            remainingTimeLabel.setText("- " + remainingTime);
        }
    };



    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void PlayBtnClick(View view) {
        if (!player.isPlaying()) {
            player.start();
            playBtn.setBackgroundResource(R.drawable.ic_action_pause);
        } else {
            player.pause();
            playBtn.setBackgroundResource(R.drawable.ic_action_play);
        }
    }






    @Override
    public void onBackPressed(){

        player.pause(); dont.this.finish();
    }






         /*  public void play(View v){
            if(player == null){
                player = MediaPlayer.create(this,R.raw.song);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stopPLayer();
                }
            });
            }
            player.start();
            } */

}
