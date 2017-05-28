package com.questqazan.androidprojectv2;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TimeToStart extends StringRequest {
    private static final String TimeToStart_REQUST_URL = "https://aydar-test.000webhostapp.com/TimeToStart.php";
    //private static final String TimeToStart_REQUST_URL = "https://questqazan.000webhostapp.com/TimeToStart.php";

    private Map<String,String> params;

    public TimeToStart(String id, Response.Listener<String> listener){
        super(Method.POST, TimeToStart_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", id);
    }

    public Map<String, String> getParams(){
        return params;
    }
}