package creandologin.login;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.security.keystore.UserNotAuthenticatedException;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.Min;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mobsandgeeks.saripaar.annotation.ValidateUsing;

import java.util.List;

/**
 * Created by Gonzalo on 17/10/2015.
 */
public class ImplicitActivity extends Activity implements Validator.ValidationListener {


    Button guardar;
    Validator validator;

    @NotEmpty(message = "Escriba su Nombre")
    EditText tnombre;
    @NotEmpty(message = "Escriba su Apellido")
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

    @NotEmpty(message = "El usuario debe contener 15 caracteres (A-Z, a-z y 0-9)")
    EditText  tusuario;



    LoginDataBaseAdapter loginDataBaseAdapter;








    private Toolbar toolbar;




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


            @Override
            public void onClick(View v) {


                String userName=tusuario.getText().toString();
                String password=tcontraseña.getText().toString();
                String confirmPassword=tconfirmar.getText().toString();


                // check if any of the fields are vaccant
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(userName, password);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }

                validator.validate();



            }
        });
    }



    @Override
    public void onValidationSucceeded(){

        Toast.makeText(this, "Datos ingresados correctamente", Toast.LENGTH_SHORT).show();

    }

    @Override

    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {

            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText){

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