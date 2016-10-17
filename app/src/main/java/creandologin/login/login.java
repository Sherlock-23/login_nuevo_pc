package creandologin.login;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import android.widget.EditText;
import android.app.Dialog;

public class login extends AppCompatActivity {

   Button crearcuenta, sesion;

    LoginDataBaseAdapter loginDataBaseAdapter;




    public static final int CODIGO_SOLICITUD_DEL_TEXTO = 1;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("BIENVENIDO");
        setSupportActionBar(toolbar);



        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();




        sesion = (Button)findViewById(R.id.inicios);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });






        crearcuenta = (Button) findViewById(R.id.crearcuenta);



        crearcuenta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent empezarOtraActividadIntent = new Intent(login.this, ImplicitActivity.class);
                startActivity(empezarOtraActividadIntent);
            }


        });







    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == CODIGO_SOLICITUD_DEL_TEXTO && resultCode == RESULT_OK){
            String nombreText = data.getStringExtra("mensaje1");
            String apellidoText = data.getStringExtra("mensaje2");
            String emailText = data.getStringExtra("mensaje3");
            String fechaText = data.getStringExtra("mensaje4");
            String usuarioText = data.getStringExtra("mensaje5");
            String contraseñaText = data.getStringExtra("mensaje6");

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }







    public void quieroentrar(View V)
    {
        final Dialog dialog = new Dialog(login.this);
        dialog.setContentView(R.layout.inicio_layout);
       dialog.setTitle("Inicio Sesión");




        // get the Refferences of views
        final  EditText usuario=(EditText)dialog.findViewById(R.id.iniciosesion1);
        final  EditText contraseña=(EditText)dialog.findViewById(R.id.iniciosesion2);

        Button sesion=(Button)dialog.findViewById(R.id.iniciosesion3);

        // Set On ClickListener
        sesion.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // get The User name and Password
                String userName = usuario.getText().toString();
                String password = contraseña.getText().toString();

                // fetch the Password form database for respective user name
                String storedPassword = loginDataBaseAdapter.getSinlgeEntry(userName);

                // check if the Stored password matches with  Password entered by user
                if (password.equals(storedPassword)) {


                    Toast.makeText(login.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                    Intent a = new Intent(login.this, Principal.class);
                    startActivity(a);
                    dialog.dismiss();


                } else {
                    Toast.makeText(login.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
                }


            }


        });



        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close The Database
        loginDataBaseAdapter.close();
    }




}

