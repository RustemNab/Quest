package com.questqazan.androidprojectv2;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ClearTokenRequest extends StringRequest {
    private static final String ClearToken_REQUST_URL = "https://aydar-test.000webhostapp.com/ClearToken.php";
    //private static final String ClearToken_REQUST_URL = "https://questqazan.000webhostapp.com/ClearToken.php";

    private Map<String,String> params;

    public ClearTokenRequest(String login, Response.Listener<String> listener){
        super(Request.Method.POST, ClearToken_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
