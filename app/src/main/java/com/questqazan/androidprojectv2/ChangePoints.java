package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class ChangePoints extends StringRequest {
    private static final String ChangePoints_REQUST_URL = "https://aydar-test.000webhostapp.com/ChangePoints.php";
    private Map<String,String> params;

    public ChangePoints(String login, int point, int all_point, Response.Listener<String> listener){
        super(Request.Method.POST, ChangePoints_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
        params.put("point", point + "");
        params.put("all_point", all_point + "");
    }

    public Map<String, String> getParams(){
        return params;
    }
}