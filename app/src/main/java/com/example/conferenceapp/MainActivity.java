package com.example.conferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .setWelcomePageEnabled(false)
                    .setAudioOnly(true)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void onButtonClick(View v)
    {
        EditText editText = findViewById(R.id.conferenceName);
        String txt = editText.getText().toString();

        if(txt.length()>0)
        {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder().setRoom(txt)
                    .build();
            JitsiMeetActivity.launch(this, options);
        }
    }

}