package com.santidev.admobtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    //Banners
    String bannerId = "ca-app-pub-6746418246816572/2796521286"; //
    //Intersititials
    String insterstitialId = "ca-app-pub-6746418246816572/9237219824";
    //Native
    //Video Rewards
    String videoReward = "ca-app-pub-6746418246816572/7924138153";

    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //arrancamos el sdk de admob
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });

        adView = (AdView) findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder().build();
        adView.loadAd(request);

       /* AdView newAdView = new AdView(this);
        newAdView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(bannerId);*/

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
                //cuando el usuario hace click en la publicidad
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                //cuando se cierra la publicidad y el usuario decide volver a la app
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                //se llama cuando la publicidad no puede cargarse correctamente...
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
                //cuando se imprime la publicidad en la pantalla
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                //El codigo se ejecuta cuando se acaba de cargar la publicidad
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                //cuando la publicidad se abre y ocupa la pantalla
            }

        });
    }
}