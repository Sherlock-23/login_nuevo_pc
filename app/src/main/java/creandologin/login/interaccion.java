package creandologin.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.TextView;


public class interaccion extends AppCompatActivity {

    /**
     * Created by Gonzalo on 14-11-2016.
     */

    private RadioGroup radio;
    private TextView mostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaccion_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Aprendamos de ellos");
        toolbar.setTitleTextColor(Color.WHITE);

          radio = (RadioGroup)findViewById(R.id.radiogroup);
          mostrar = (TextView)findViewById(R.id.textView21);



        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (checkedId){

                    case R.id.radioButton3:
                        mostrar.setText(R.string.visualizar_jugar);
                        break;

                    case R.id.radioButton4:
                        mostrar.setText("Acariciar");
                        break;

                    case R.id.radioButton5:
                        mostrar.setText("Conversar");
                        break;
                }

            }


        });




    }



}
