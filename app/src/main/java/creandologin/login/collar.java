package creandologin.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.TextView;


public class collar extends AppCompatActivity {

    /**
     * Created by Gonzalo on 13-11-2016.
     */

    RadioGroup radiocollar;
    private TextView mostrarcollar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collar);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Collar de identificación");
        toolbar.setTitleTextColor(Color.WHITE);


        radiocollar = (RadioGroup)findViewById(R.id.radiogroupcollar);
        mostrarcollar = (TextView)findViewById(R.id.textView22);


        radiocollar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){

                    case R.id.radioButton:
                        mostrarcollar.setText(R.string.visualizar_jugar);
                        break;

                    case R.id.radioButton2:

                        Intent ayuda = new Intent(collar.this, ayuda_integracion.class);
                        startActivity(ayuda);


                        break;

                }

            }


        });






    }


}
