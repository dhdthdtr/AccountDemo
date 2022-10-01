package com.example.accountdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Calendar AuthUI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() == null){

        } else {

        }
    }

    public void sign_in(View view){
        FirebaseAuth auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() == null){
            Toast.makeText(
                    getApplicationContext(),
                    "User already sign in signout first",
                    Toast.LENGTH_SHORT);
        } else {
            List<AuthUI.IdpConfig> providers= Arrays.asList(new AuthUI.IdpConfig.EmailBuilder().build());
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(),12345);
        }
    }
}