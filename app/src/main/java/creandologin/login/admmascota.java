package creandologin.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class admmascota extends AppCompatActivity {

    /**
     * Created by Gonzalo on 12-11-2016.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admmascota);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Administración mascota");
        toolbar.setTitleTextColor(Color.WHITE);




    }
}


