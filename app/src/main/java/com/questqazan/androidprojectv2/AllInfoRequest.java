package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riga on 09.04.2017.
 */

public class AllInfoRequest extends StringRequest {
    private static final String AllInfo_REQUST_URL = "https://aydar-test.000webhostapp.com/AllInfo.php";
    private Map<String,String> params;

    public AllInfoRequest(String login, Response.Listener<String> listener){
        super(Request.Method.POST, AllInfo_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams(){
        return params;
    }
}