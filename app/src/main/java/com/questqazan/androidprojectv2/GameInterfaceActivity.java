package com.questqazan.androidprojectv2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import android.widget.Space;

import android.widget.Toast;

public class GameInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_interface);

        final Space questions = (Space) findViewById(R.id.go_questions);
        final Space tasks = (Space) findViewById(R.id.go_tasks);
        ImageView question_im = (ImageView) findViewById(R.id.imageView8);

        //Взятие логина после логинизации
        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");



        //Переход к вопросам
        question_im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(GameInterfaceActivity.this, QuestionsActivity.class);
                intent1.putExtra("login", login);
                GameInterfaceActivity.this.startActivity(intent1);
            }
        });


        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameInterfaceActivity.this, TasksActivity.class);
                GameInterfaceActivity.this.startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                GameInterfaceActivity.this);
        quitDialog.setTitle("Вы уверены, что хотите выйти?");

        quitDialog.setPositiveButton("Да", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                finishAffinity();
            }
        });

        quitDialog.setNegativeButton("Нет", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

}


