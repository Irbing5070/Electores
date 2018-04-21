package com.example.jaher.electores_crud;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SesionActivity extends AppCompatActivity implements View.OnClickListener{

        private EditText txtUser;
        private EditText txtPwd;
        private EditText txtRol;
        private Button btnLogin;
        private Button btnCancelar;
        private String user;
        private String rol;
        private boolean banOk; //Indica si el acceso es valido


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = (EditText) findViewById(R.id.txt_user);
        txtPwd = (EditText) findViewById(R.id.txt_pwd);
        txtRol = (EditText) findViewById(R.id.txt_rol);
        btnLogin = (Button) findViewById(R.id.btn_entrar);
        btnCancelar = (Button) findViewById(R.id.btn_cancelar);

        btnLogin.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_entrar) {
            user = txtUser.getText().toString();
            getUser();
            if(banOk){
                Toast.makeText(this,"Bienvenido!!",Toast.LENGTH_LONG).show();
                startActivity(new Intent(this,MainActivity.class));
            }else{
                Toast.makeText(this,"Usuario Incorrecto!!",Toast.LENGTH_LONG).show();
            }
        }
    }

        private void getUser(){
            class GetUser extends AsyncTask<Void,Void,String> {
                ProgressDialog loading;
                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(SesionActivity.this,"Fetching...","Wait...",false,false);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    showUser(s);
                }

                @Override
                protected String doInBackground(Void... params) {
                    RequestHandler rh = new RequestHandler();
                    String s = rh.sendGetRequestParam(Config.URL_LOGIN_USER,user);
                    return s;
                }
            }
            GetUser gu = new GetUser();
            gu.execute();
        }

    private void showUser(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String rol = c.getString(Config.TAG_ROL);

            txtRol.setText(rol);
            if(!rol.equals(null)){
                banOk = true;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
