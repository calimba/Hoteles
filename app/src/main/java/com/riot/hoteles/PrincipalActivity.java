package com.riot.hoteles;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toolbar;

public class PrincipalActivity extends AppCompatActivity {
    static  public PrincipalActivity Main;
    private TextView mTextMessage;
    private FloatingActionButton fab;
    private LinearLayout contenedor;
    private RelativeLayout rl_txt_hotel,rl_txt_vuelos,rl_txt_ofertas,rl_txt_autos,rl_txt_actividades,rl_txt_cruceros;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        contenedor = findViewById(R.id.linear_contenedor);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fab = findViewById(R.id.fab);

        //Context context = this;
        //collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
        Main = this;

        NestedScrollView nsv = findViewById(R.id.scrollprincipal);
        contenedor.removeAllViews();


        RelativeLayout elItem;

        LayoutInflater elInflador = Main.getLayoutInflater();

        elItem = (RelativeLayout) elInflador.inflate(R.layout.cards_principal, null);
        rl_txt_cruceros = elItem.findViewById(R.id.rl_txt_cruceros);
        rl_txt_actividades = elItem.findViewById(R.id.rl_txt_actividades);
        rl_txt_autos = elItem.findViewById(R.id.rl_txt_autos);
        rl_txt_ofertas = elItem.findViewById(R.id.rl_txt_ofertas);
        rl_txt_vuelos = elItem.findViewById(R.id.rl_txt_vuelos);
        rl_txt_hotel = elItem.findViewById(R.id.rl_txt_hotel);
        contenedor.addView(elItem);

        rl_txt_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta("Proximamente","Hoteles Proximamente");
            }
        });

        rl_txt_vuelos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta("Proximamente","Vuelos Proximamente");

            }
        });

        rl_txt_ofertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta("Proximamente","Ofertas Proximamente");

            }
        });

        rl_txt_autos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta("Proximamente","Autos Proximamente");

            }
        });

        rl_txt_actividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta("Proximamente","Actividades Proximamente");

            }
        });

        rl_txt_cruceros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alerta("Proximamente","Cruceros Proximamente");

            }
        });





        nsv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY) {
                    fab.show();
                } else {
                    fab.hide();
                }

                if (scrollY == 0) {
                    Log.d("arriba", "TOP SCROLL");
                }

                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    fab.hide();
                }
            }
        });

    }


    public void alerta(final String ptitulo, final String pmensaje)
    {
        runOnUiThread(new Runnable() {
            public void run() {
                AlertDialog.Builder constructor = new AlertDialog.Builder(Main);
                constructor.setMessage(pmensaje);
                constructor.setCancelable(false);
                constructor.setPositiveButton("Ok",  new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id)
                    {
                        dialog.cancel();
                    }
                });
                constructor.setTitle(ptitulo);
                AlertDialog alerta = constructor.create();
                alerta.show();
            }
        });
    }



}
