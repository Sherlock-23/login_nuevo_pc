package creandologin.login;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class admusuario extends AppCompatActivity {


    /**
     * Created by Gonzalo on 03/11/2015.
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admusuario);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Administración usuario");
        toolbar.setTitleTextColor(Color.WHITE);

        ;


    }
}
