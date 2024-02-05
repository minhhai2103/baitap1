package com.example.myapplication.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.Test.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edituser;
    private EditText editpass;
    private Button btn;

    private List<User> nListUser;

    private User nUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edituser = findViewById(R.id.user);
        editpass = findViewById(R.id.pass);
        btn = findViewById(R.id.login);
        nListUser = new ArrayList<>();

        getListUser();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ClickLogin();
            }
        });
    }

    private void ClickLogin() {
        String strUser = edituser.getText().toString().trim();
        String strPass = editpass.getText().toString().trim();

        if (nListUser == null || nListUser.isEmpty()){
            return;
        }

        boolean isHasUser = false;
        for(User user:nListUser){
            if (strUser.equals(user.getId()) && strPass.equals(user.getPassword()){
                isHasUser = true;
                nUser = user;
                break;
            }
        }
        if (isHasUser){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user",nUser);
            intent.putExtras(bundle);
            startActivity(intent);

        }else {
            Toast.makeText(LoginActivity.this, "user va pass ...", Toast.LENGTH_SHORT).show();
        }
    }

    private void getListUser(){
        ApiService.apiService.getLiatUsers("customer")
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        nListUser = response.body();
                        Log.e("list User", nListUser.size() + "");
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}