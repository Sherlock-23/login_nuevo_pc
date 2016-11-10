package creandologin.login;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.Pattern;
import java.util.List;


public class ImplicitActivity extends Activity implements Validator.ValidationListener {
    /**
     * Created by Gonzalo on 17/10/2015.
     */


    Button guardar;
    Validator validator;



    @Pattern (regex = "[a-zA-Z]+",message = "Escriba su Nombre")
    EditText tnombre;

    @Pattern(regex = "[a-zA-Z]+", message = "Escriba su Apellido")
    EditText tapellido;

    @Email(message = "Email incorrecto")
    EditText  temail;

    @Min(value = 10, message = "Edad minima 10 años")
    @Max(value = 100, message = "Edad maxima 100 años")
    EditText  tedad;

    @Password(min = 10, scheme = Password.Scheme.ALPHA_NUMERIC, message = "La contraseña debe tener 10 caracteres(A-Z, a-z y 0-9)")
    EditText  tcontraseña;

    @ConfirmPassword (message = "Las contraseñas no coinciden")
    EditText  tconfirmar;

    @Pattern (regex = "([0-9]{0,}[a-zA-Z]+[0-9]{0,})+", message = "Escriba su usuario (A-Z, a-z y 0-9)")
    EditText  tusuario;



    LoginDataBaseAdapter loginDataBaseAdapter;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("REGISTRO");
        toolbar.setTitleTextColor(Color.WHITE);


        // create a instance of SQLite Database
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();



        tnombre = (EditText) findViewById(R.id.nombre);
        tapellido = (EditText) findViewById(R.id.apellido);
        temail = (EditText) findViewById(R.id.email);

        tedad =  (EditText) findViewById(R.id.edad);
        tusuario = (EditText) findViewById(R.id.usuario);
        tcontraseña = (EditText) findViewById(R.id.contraseña);
        tconfirmar = (EditText) findViewById(R.id.confirmar);
        guardar = (Button) findViewById(R.id.guardar);

        validator = new Validator(this);
        validator.setValidationListener(this);





        guardar.setOnClickListener(new View.OnClickListener() {



            public void onClick(View v) {

                validator.validate();

                String userName = tusuario.getText().toString();
                String password = tcontraseña.getText().toString();
                String confirmPassword = tconfirmar.getText().toString();


                // check if any of the fields are vaccant
                if (userName.equals("") || password.equals("") || confirmPassword.equals("")) {
                    //Toast.makeText(getApplicationContext(), "Al usuario le faltan expresiones regulares", Toast.LENGTH_LONG).show();
                    return;
                }

                // check if both password matches
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    //return;
                } else {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    // Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                    Intent a = new Intent (ImplicitActivity.this, probando.class);
                    startActivity(a);
                }

                //validator.validate();


            }


        });



    }









    public void onValidationSucceeded() {

        Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();

    }


    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {

            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText) {

                ((EditText) view).setError(message);
            }
            else
            {


                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }

        }







    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }



}