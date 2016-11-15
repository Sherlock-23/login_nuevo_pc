package creandologin.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class integracion extends AppCompatActivity {

    /**
     * Created by Gonzalo on 12-11-2016.
     */
    Button collarI;
    Button inter;
    Button ayuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integracion);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Integración y cariño");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setBackgroundColor(Color.parseColor("#FF02680B"));


        //Pulsar boton collar

        collarI = (Button)findViewById(R.id.button8);
        collarI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent(integracion.this, collar.class);
                startActivity(c);
            }
        });

        //Pulsar boton aprendamos de ellos

        inter = (Button)findViewById(R.id.button7);
        inter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent d = new Intent(integracion.this, interaccion.class);
                startActivity(d);
            }
        });

        //pulsamos boton ayuda y consejos
        ayuda = (Button)findViewById(R.id.button9);
        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent e = new Intent(integracion.this, ayuda_integracion.class);
                startActivity(e);
            }
        });




    }
}
