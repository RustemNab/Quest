package com.questqazan.androidprojectv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GoToGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_game);

        final Button but = (Button)findViewById(R.id.ButtonGoPlay);
        but.setVisibility(View.INVISIBLE);
        final TextView InGame = (TextView)findViewById(R.id.InGameTV);
        InGame.setVisibility(View.INVISIBLE);

        final Intent intent = getIntent();
        final String login = intent.getStringExtra("login");
        int game = intent.getIntExtra("game", -1);


        //Получение данных о начале игры
        Response.Listener<String> responseListener1 = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        TextView info = (TextView)findViewById(R.id.TimeInfoTV);

                        int year = jsonResponse.getInt("year");
                        int mounth = jsonResponse.getInt("mounth");
                        int day = jsonResponse.getInt("day");
                        int hour_start = jsonResponse.getInt("hour_start");
                        int hour_finish = jsonResponse.getInt("hour_finish");


                        GregorianCalendar gcalendar = new GregorianCalendar();
                        int mounthNow = gcalendar.get(Calendar.MONTH);
                        int YearNow = gcalendar.get(Calendar.YEAR);
                        int dayNow = gcalendar.get(Calendar.DAY_OF_MONTH);
                        int hourNow = gcalendar.get(Calendar.HOUR_OF_DAY);

                        if(YearNow == year) {
                            if(mounthNow == mounth){
                                if(dayNow == day){
                                    if(hourNow < hour_start){
                                        info.setText(hour_start - hourNow + " hours");
                                    }
                                    if((hourNow >= hour_start)&&(hourNow < hour_finish)){
                                        info.setText("Игра началась! Финиш в " + hour_finish + ":00" );
                                    }
                                    if(hourNow > hour_finish)
                                        info.setText("Игра окончена");
                                }
                                else{
                                    info.setText(day - dayNow + " days");
                                }
                            }
                            else{
                                info.setText("Game start in next mounth in " + day);
                            }
                        }
                        else{
                            String str = null;
                            if (mounth==0) str="Jan";
                            if (mounth==1) str="Feb";
                            if (mounth==2) str="Mar";
                            if (mounth==3) str="Apr";
                            if (mounth==4) str="May";
                            if (mounth==5) str="Jun";
                            if (mounth==6) str="Jul";
                            if (mounth==7) str="Aug";
                            if (mounth==8) str="Sep";
                            if (mounth==9) str="Okt";
                            if (mounth==10) str="Nov";
                            if (mounth==11) str="Dec";

                            info.setText("Game start in next year in " + str + " , in " + day);
                        }
                    }
                    else {
                    }
                }
                catch (JSONException e) {
                }
            }
        };

        TimeToStart timeToStart = new TimeToStart("1", responseListener1);
        RequestQueue queue = Volley.newRequestQueue(GoToGameActivity.this);
        queue.add(timeToStart);


        //Получение данных по логину
        Response.Listener<String> responseListener = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success)
                    {
                        int game = jsonResponse.getInt("game");

                        if(game != 0)
                        {
                            InGame.setText("Вы зарегестрированы");
                            InGame.setVisibility(View.VISIBLE);
                        }
                        else
                            but.setVisibility(View.VISIBLE);
                    }
                }
                catch (JSONException e) {
                }
            }
        };

        AllInfoRequest allInfoRequest = new AllInfoRequest(login, responseListener);
        RequestQueue queue1 = Volley.newRequestQueue(GoToGameActivity.this);
        queue1.add(allInfoRequest);


        //Отправка регитрации на игру
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success)
                            {
                                InGame.setText("Вы зарегестрированы");
                                InGame.setVisibility(View.VISIBLE);
                                but.setVisibility(View.INVISIBLE);
                            }
                        }
                        catch (JSONException e) {
                        }
                    }
                };


                GoToGameRequest goToGameRequest = new GoToGameRequest(login, responseListener);
                RequestQueue queue = Volley.newRequestQueue(GoToGameActivity.this);
                queue.add(goToGameRequest);

                Intent intent1 = new Intent(GoToGameActivity.this, InterfaceActivity.class);
                intent1.putExtra("login", login);

                GoToGameActivity.this.startActivity(intent1);
            }
        });


    }
}
