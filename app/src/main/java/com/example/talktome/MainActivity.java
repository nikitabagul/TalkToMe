package com.example.talktome;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout = findViewById(R.id.layotu_parent);


        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground(); //animation using drawable  resourses
        animationDrawable.setEnterFadeDuration(3000);//entry duration
        animationDrawable.setExitFadeDuration(1000);//end duration
        animationDrawable.start();//start of animation


    }


    public void  play_btn(View view) {
        final Button sound = (Button) view;

        MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,getResources().getIdentifier((String) sound.getTag(),"raw",getPackageName()));
        mediaPlayer.start();//playing the sound

        if (mediaPlayer.isPlaying()) {
            sound.setBackgroundColor(Color.RED);//while the sound is playing change the color of the button to red
        }
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                sound.setBackgroundColor(Color.GREEN);//sound completion change the color of button to the green
                sound.setTextColor(Color.WHITE);
            }
        });

    }
}

