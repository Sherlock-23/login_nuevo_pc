package creandologin.login;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class Inicio extends AppCompatActivity {


    /**
     * Created by Gonzalo on 20/10/2015.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Inicio Sesión");
        toolbar.setTitleTextColor(Color.WHITE);


    }


}
