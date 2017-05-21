package com.questqazan.androidprojectv2;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TokenRequest extends StringRequest {
    //private static final String TOKEN_REQUST_URL = "https://aydar-test.000webhostapp.com/Token.php";
    private static final String TOKEN_REQUST_URL = "https://questqazan.000webhostapp.com/Token.php";

    private Map<String,String> params;

    public TokenRequest(String login, Response.Listener<String> listener){
        super(Request.Method.POST, TOKEN_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams(){
        return params;
    }
}

