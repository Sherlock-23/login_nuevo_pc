package creandologin.login;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;


public class Principal extends Activity {

    /**
     * Created by Gonzalo on 03/11/2015.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Felicidades");
        toolbar.setTitleTextColor(Color.WHITE);


    }
}
