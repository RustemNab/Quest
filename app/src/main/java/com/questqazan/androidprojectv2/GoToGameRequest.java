package com.questqazan.androidprojectv2;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class GoToGameRequest extends StringRequest {
    private static final String GoToGame_REQUST_URL = "https://aydar-test.000webhostapp.com/GoToGame.php";
    private Map<String,String> params;

    public GoToGameRequest(String login, Response.Listener<String> listener){
        super(Request.Method.POST, GoToGame_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
