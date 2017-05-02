package com.questqazan.androidprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;

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
}


