package creandologin.login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class menu_principal extends AppCompatActivity {

    ImageView pulsardescanso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Menu principal");
        toolbar.setTitleTextColor(Color.WHITE);


        pulsardescanso = (ImageView)findViewById(R.id.imageView5);
        pulsardescanso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent descanso = new Intent(menu_principal.this, Principal.class);
                startActivity(descanso);
            }
        });
    }
}