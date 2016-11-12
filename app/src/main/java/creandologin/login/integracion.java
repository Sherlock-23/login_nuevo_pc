package creandologin.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class integracion extends AppCompatActivity {

    /**
     * Created by Gonzalo on 12-11-2016.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integracion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Integración y cariño");
        toolbar.setTitleTextColor(Color.WHITE);




    }
}
