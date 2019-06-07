package com.riot.hoteles;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyfishjy.library.RippleBackground;

public class SplashActivity extends Activity {

    private ImageView logo;
    private TextView texto;
    private RippleBackground content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        logo = findViewById(R.id.imageView);
        texto = findViewById(R.id.slide_tutorial_1_lbl_descripcion);
        content = findViewById(R.id.content);

        Animation mianim = AnimationUtils.loadAnimation(this,R.anim.mitransicion);
        texto.setAnimation(mianim);
        logo.setAnimation(mianim);

        content.startRippleAnimation();

        Thread timer = new Thread(){
            public void run (){
                try {
                    sleep(5000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent a = new Intent(SplashActivity.this,PrincipalActivity.class);
                    a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(a);
                }
            }
        };
        timer.start();



    }
}
