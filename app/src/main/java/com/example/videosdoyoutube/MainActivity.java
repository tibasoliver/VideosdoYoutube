package com.example.videosdoyoutube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

public class MainActivity extends YouTubeBaseActivity {
    //AIzaSyAy7NjdjbnNeOg-8OhmpYnHASi0xTshOSI
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener ytListener;
    ImageView imagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.meuPlayerVideo);
        imagem = findViewById(R.id.imageView);

        ytListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("_RRefXawjnM");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        youTubePlayerView.initialize(YoutubeConfig.getApiKey(),ytListener);
        String caminhoImagem = "https://img.youtube.com/vi/"+"_RRefXawjnM"+"/hqdefault.jpg";
        Picasso.with(getApplicationContext()).load(caminhoImagem).into(imagem);
    }
}
