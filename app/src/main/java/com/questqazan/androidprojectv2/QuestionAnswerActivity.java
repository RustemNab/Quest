package com.questqazan.androidprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class QuestionAnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_answer);

        TextView questionText = (TextView) findViewById(R.id.textView13);
        Button otv = (Button) findViewById(R.id.button);
        final EditText answerQ = (EditText) findViewById(R.id.AnswerQ);

        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");
        String question = intent.getStringExtra("Text_question");
        final String id = intent.getStringExtra("id");
        final int price = intent.getIntExtra("Price", -1);
        final int[] point = new int[1];
        final int[] all_point = new int[1];
        final String answer = intent.getStringExtra("Answer");

        Toast y = Toast.makeText(getApplication(), price + "", Toast.LENGTH_LONG);
        y.show();
        Toast yy = Toast.makeText(getApplication(), id, Toast.LENGTH_LONG);
        yy.show();

        ////
        questionText.setText(question);

        otv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answerUser = String.valueOf(answerQ.getText());

                if(answer.equals(answerUser))
                {
                    //Получение данных по логину
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try{
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");

                                if(success)
                                {
                                    point[0] = jsonResponse.getInt("point");
                                    point[0] += price;
                                    all_point[0] = jsonResponse.getInt("all_point");
                                    all_point[0] += price;

                                    //Изменение баллов и отправка их на сервер
                                    Response.Listener<String> responseListener1 = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try{
                                                JSONObject jsonResponse = new JSONObject(response);
                                                boolean success = jsonResponse.getBoolean("success");

                                                if(success)
                                                {
                                                    Toast toast = Toast.makeText(getApplication(), "Answer is loaded", Toast.LENGTH_LONG);
                                                    toast.show();
                                                }
                                            }
                                            catch (JSONException e){
                                                Toast y = Toast.makeText(getApplication(), "NonePoints", Toast.LENGTH_LONG);
                                                y.show();
                                            }
                                        }
                                    };

                                    ChangePoints changePointsRequest = new ChangePoints(login, point[0], all_point[0], responseListener1);
                                    RequestQueue queue1 = Volley.newRequestQueue(QuestionAnswerActivity.this);
                                    queue1.add(changePointsRequest);
                                }
                            }
                            catch (JSONException e) {
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                            }
                        }
                    };

                    AllInfoRequest allInfoRequest = new AllInfoRequest(login, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(QuestionAnswerActivity.this);
                    queue.add(allInfoRequest);
                }
                //Изменение в Questioning
                if(id.equals("1"))
                {
                    Toast y = Toast.makeText(getApplication(), "Was1", Toast.LENGTH_LONG);
                    y.show();
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try{
                                Toast y = Toast.makeText(getApplication(), "Change1", Toast.LENGTH_LONG);
                                y.show();
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            }
                            catch (JSONException e) {
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                            }
                        }
                    };

                    ChangeQuestioning1 changeQuestioning1 = new ChangeQuestioning1(login, responseListener);
                    RequestQueue queue11 = Volley.newRequestQueue(QuestionAnswerActivity.this);
                    queue11.add(changeQuestioning1);
                }
                if(id.equals("2"))
                {
                    Toast y = Toast.makeText(getApplication(), "Was2", Toast.LENGTH_LONG);
                    y.show();
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try{
                                Toast y = Toast.makeText(getApplication(), "Change2", Toast.LENGTH_LONG);
                                y.show();
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            }
                            catch (JSONException e) {
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                            }
                        }
                    };

                    ChangeQuestioning2 changeQuestioning2 = new ChangeQuestioning2(login, responseListener);
                    RequestQueue queue22 = Volley.newRequestQueue(QuestionAnswerActivity.this);
                    queue22.add(changeQuestioning2);
                }
                if(id.equals("3"))
                {
                    Toast y = Toast.makeText(getApplication(), "Was3", Toast.LENGTH_LONG);
                    y.show();
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try{
                                Toast y = Toast.makeText(getApplication(), "Change3", Toast.LENGTH_LONG);
                                y.show();
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            }
                            catch (JSONException e) {
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                            }
                        }
                    };

                    ChangeQuestioning3 changeQuestioning3 = new ChangeQuestioning3(login, responseListener);
                    RequestQueue queue33 = Volley.newRequestQueue(QuestionAnswerActivity.this);
                    queue33.add(changeQuestioning3);
                }
                if(id.equals("4"))
                {
                    Toast y = Toast.makeText(getApplication(), "Was4", Toast.LENGTH_LONG);
                    y.show();
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try{
                                Toast y = Toast.makeText(getApplication(), "Change4", Toast.LENGTH_LONG);
                                y.show();
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            }
                            catch (JSONException e) {
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                            }
                        }
                    };

                    ChangeQuestioning4 changeQuestioning4 = new ChangeQuestioning4(login, responseListener);
                    RequestQueue queue44 = Volley.newRequestQueue(QuestionAnswerActivity.this);
                    queue44.add(changeQuestioning4);
                }
                if(id.equals("5"))
                {
                    Toast y = Toast.makeText(getApplication(), "Was5", Toast.LENGTH_LONG);
                    y.show();
                    Response.Listener<String> responseListener = new Response.Listener<String>(){
                        @Override
                        public void onResponse(String response) {
                            try{
                                Toast y = Toast.makeText(getApplication(), "Change5", Toast.LENGTH_LONG);
                                y.show();
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                            }
                            catch (JSONException e) {
                                Toast y = Toast.makeText(getApplication(), "None", Toast.LENGTH_LONG);
                                y.show();
                            }
                        }
                    };

                    ChangeQuestioning5 changeQuestioning5 = new ChangeQuestioning5(login, responseListener);
                    RequestQueue queue55 = Volley.newRequestQueue(QuestionAnswerActivity.this);
                    queue55.add(changeQuestioning5);
                }

                //Переход на поле вопросов
                Intent intent1 = new Intent(QuestionAnswerActivity.this, QuestionsActivity.class);
                intent1.putExtra("login",login);
                QuestionAnswerActivity.this.startActivity(intent1);
            }
        });
    }

}

