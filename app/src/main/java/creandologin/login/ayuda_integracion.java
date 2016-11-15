package creandologin.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class ayuda_integracion extends AppCompatActivity {

    /**
     * Created by Gonzalo on 15-11-2016.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda_integracion_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Ayuda y consejos");
        toolbar.setTitleTextColor(Color.WHITE);


    }

}
