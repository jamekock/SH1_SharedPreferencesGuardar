package com.sh1.sharedpreferencesguardar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.content.Context.*;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    TextView txtNombre;
    TextView txtApellido;
    TextView txtEmail;
    TextView txtTelefono;
    TextView txtLocation;
    String[] string;
    TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtLocation = findViewById(R.id.txtLocation);
        string = new String[]{"nombre", "apellido", "email", "telefono", "location"};
        textViews = new TextView[]{txtNombre, txtApellido, txtEmail, txtTelefono, txtLocation};
        for (String item : string) {
            preferences = getSharedPreferences(item, MODE_PRIVATE);
        }
        editor = preferences.edit();

        for (TextView t: textViews) {
            for (String name : string) {
                t.setText(preferences.getString(name,"").toString());
            }
        }
    }
    public void save(View view){
        for (TextView t: textViews) {
            for (String name: string) {
                editor.putString(name,t.getText().toString());
            }
        }
        editor.commit();
    }
}