package com.example.myapplication.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Update;

import com.example.myapplication.Database.Object.User;
import com.example.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.tvNameOfUsername)
    TextView Username;

    @BindView(R.id.Tv_Email)
    TextView Email;

    @BindView(R.id.Tv_Address)
    TextView address;

    @BindView(R.id.Tv_Phone)
    TextView phone;

    @BindView(R.id.Tv_ShowUs)
    TextView fullName;

    @BindView(R.id.btn_savechange)
    Button bt_svChange;

    @BindView(R.id.btn_Changepassword)
    Button btn_changePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String usename = bundle.getString("username");
        User user1 = LoginActivity.myAppDatabase.myDAO().getUserByUsName(usename);

        if (bundle != null) {

            Username.setText("Hello " + user1.getUserName());
            Email.setText(user1.getEmail());
            phone.setText(user1.getPhoneNum());
            address.setText(user1.getUserAddress());
            fullName.setText(user1.getFullName());
        }
        else
        {
            Username.setText("Something wrong");
        }
        bt_svChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, UpdateProfile.class);
                i.putExtras(bundle);
                startActivity(i);
             }
        });

        btn_changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, ChangePassWord.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        ButterKnife.bind(this).unbind();
        super.onDestroy();
    }
}
