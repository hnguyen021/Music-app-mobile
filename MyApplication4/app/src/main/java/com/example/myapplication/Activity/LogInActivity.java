package com.example.myapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Model.User;
import com.example.myapplication.R;
import com.example.myapplication.Service.APIservice;
import com.example.myapplication.Service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {
    EditText edtUser,edtpass;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //Intent intent = getIntent();
        //intent.get
        Init();
        GetDataUser();
    }

    private void Init() {
        edtUser = findViewById(R.id.editTextUser);
        edtpass = findViewById(R.id.editTextPass);
        btnLogin = findViewById(R.id.buttonlogin);
    }

    private void GetDataUser() {
        DataService dataService = APIservice.getService();
        Call<List<User>> callback = dataService.GetDataUser();
        callback.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                final ArrayList<User> arrayList = (ArrayList<User>) response.body();
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for(int i =0;i<arrayList.size();i++) {
                            if (edtUser.getText().toString().equals(arrayList.get(i).getTenUser()) && edtpass.getText().toString().equals(arrayList.get(i).getPassWord())) {
                                Intent intent2 = new Intent(LogInActivity.this,MainActivity.class);
                                intent2.putExtra("Name",edtUser.getText().toString());
                                startActivity(intent2);

                            }
                            else{
                                Toast.makeText(LogInActivity.this,"dang nhap that bai",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });
    }
}
