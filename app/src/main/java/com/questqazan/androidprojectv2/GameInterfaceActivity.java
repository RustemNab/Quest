package com.questqazan.androidprojectv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Space;
import android.view.View;

public class GameInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_interface);

        final Space questions = (Space) findViewById(R.id.go_questions);
        final Space tasks = (Space) findViewById(R.id.go_tasks);


        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameInterfaceActivity.this, QuestionsActivity.class);
                GameInterfaceActivity.this.startActivity(intent);
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


