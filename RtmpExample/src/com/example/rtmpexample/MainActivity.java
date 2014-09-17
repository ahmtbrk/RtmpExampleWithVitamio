package com.example.rtmpexample;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity{
	
	VideoView videoView;
	String streamURL = "rtmp://mn-l.mncdn.com/showtv/showtv2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(!LibsChecker.checkVitamioLibs(this))
			return;
		videoView = (VideoView)findViewById(R.id.videoView);
		videoView.setVideoPath(streamURL);
		videoView.requestFocus();
		MediaController controller = new MediaController(this);
		videoView.setMediaController(controller);
		videoView.setOnPreparedListener(new OnPreparedListener() {
			
			@Override
			public void onPrepared(MediaPlayer arg0) {
				videoView.start();
				
			}
		});
		
	}
	
}
