package example.com.afinal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextName;
    private EditText editTextNam;
    private EditText editEmployeeid;
    private EditText editTextPassword;
    private EditText editDesignation;
    private EditText editMobileNo;
    private Button buttonRegister;
    private static final String REGISTER_URL = "http://ioclapp.16mb.com/registeration.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextName = (EditText) findViewById(R.id.empname);
        editTextNam = (EditText) findViewById(R.id.empnam);
        editEmployeeid = (EditText) findViewById(R.id.empid);
        editTextPassword = (EditText) findViewById(R.id.passwordid);
        editDesignation = (EditText) findViewById(R.id.designation);
        editMobileNo=(EditText)findViewById(R.id.mobileno);
        buttonRegister = (Button) findViewById(R.id.signup);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        if(v == buttonRegister){
            registerUser();
        }
    }

    private void registerUser() {
        String name = editTextName.getText().toString().toLowerCase();
        String sname = editTextNam.getText().toString().toLowerCase();
        String employeid = editEmployeeid.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim().toLowerCase();
        String desig = editDesignation.getText().toString().trim().toLowerCase();
        String mobi = editMobileNo.getText().toString().trim().toLowerCase();
        name=(name+" ").concat(sname);
        register(name,employeid,password,desig,mobi);
    }

    private void register(String name, String employeid, String password, String desig,String mobi) {

        String urlSuffix = "?name="+name+"&employeid="+employeid+"&password="+password+"&designation="+desig+"&mobi="+mobi;
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Register.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }
    public void login(View v)
    {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Register.this, Login.class);
        startActivity(intent);
    }

}
