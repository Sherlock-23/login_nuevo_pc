package creandologin.login;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class probando extends AppCompatActivity {

    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Iniciar Sesión");
        toolbar.setTitleTextColor(Color.WHITE);


        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        final EditText usuario=(EditText) findViewById(R.id.iniciosesion1);
        final EditText contraseña=(EditText) findViewById(R.id.iniciosesion2);
        Button sesion = (Button) findViewById(R.id.iniciosesion3);

        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = usuario.getText().toString();
                String password = contraseña.getText().toString();


                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                if (password.equals(storedPassword)) {


                    Toast.makeText(probando.this, "Has iniciado sesión exitosamente", Toast.LENGTH_LONG).show();
                    Intent a = new Intent(probando.this, Principal.class);
                    startActivity(a);
                } else {
                    Toast.makeText(probando.this, "Usuario o contraseña incorrectas", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}