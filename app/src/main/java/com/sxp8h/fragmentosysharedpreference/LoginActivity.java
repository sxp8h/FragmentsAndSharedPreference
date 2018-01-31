package com.sxp8h.fragmentosysharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUser;
    private EditText edtPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        checkSharedPreferences();
        // SharedPreference START

        // Visual elements
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        // OnClickListener
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save date on SharedPreference before change screen
                saveSharedPreferences(edtUser.getText().toString(), edtPass.getText().toString());
                nextScreen();
            }
        });
        // SharedPreference END
    }

    private void nextScreen(){
        Intent intent = new Intent(getBaseContext(), DisplayMusicActivity.class);
        startActivity(intent);
    }

    private void checkSharedPreferences(){
        SharedPreferences saveOnXML = getSharedPreferences("DATA_LOGIN", Context.MODE_PRIVATE);
        String user = saveOnXML.getString("USER",null);
        if(user != null){
            nextScreen();
        }
    }
    private void saveSharedPreferences(String user, String pass){
        SharedPreferences saveOnXML = getSharedPreferences("DATA_LOGIN", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saveOnXML.edit();
        editor.putString("USER", user);
        editor.putString("PASS", pass);
        editor.commit();
    }
}
