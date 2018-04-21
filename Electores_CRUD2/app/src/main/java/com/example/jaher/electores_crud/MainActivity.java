package com.example.jaher.electores_crud;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jaher.electores_crud.Config;
import com.example.jaher.electores_crud.R;
import com.example.jaher.electores_crud.RequestHandler;
import com.example.jaher.electores_crud.ViewAllElector;

import java.util.HashMap;

public class MainActivity  extends AppCompatActivity implements View.OnClickListener {

    //Defining views
    private EditText txtNombre;
    private EditText txtEdad;
    private EditText txtCurp;
    private EditText txtFechaVotacion;

    private Button btnAgregar;
    private Button btnVisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction();


        //Initializing views
        txtNombre = (EditText) findViewById(R.id.txt_nombre);
        txtEdad = (EditText) findViewById(R.id.txt_edad);
        txtCurp = (EditText) findViewById(R.id.txt_curp);
        txtFechaVotacion = (EditText) findViewById(R.id.txt_fecha_votacion);

        btnAgregar = (Button) findViewById(R.id.btn_agregar);
        btnVisualizar = (Button) findViewById(R.id.btn_visualizar);

        //Setting listeners to button
        btnAgregar.setOnClickListener(this);
        btnVisualizar.setOnClickListener(this);
    }


    //Adding an elector
    private void addElector(){

        final String nombre = txtNombre.getText().toString().trim();
        final String edad = txtEdad.getText().toString().trim();
        final String curp = txtCurp.getText().toString().trim();
            final String fecha_votacion = txtFechaVotacion.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(com.example.jaher.electores_crud.MainActivity.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(com.example.jaher.electores_crud.MainActivity.this,s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,nombre);
                params.put(Config.KEY_EMP_EDAD,edad);
                params.put(Config.KEY_EMP_CURP,curp);
                params.put(Config.KEY_EMP_FECHA_VOTACION,fecha_votacion);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                //Toast.makeText(MainActivity.this,params.toString(),Toast.LENGTH_LONG).show();
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == btnAgregar){
            addElector();
        }

        if(v == btnVisualizar){
            startActivity(new Intent(this,ViewAllElector.class));
        }
    }
}
