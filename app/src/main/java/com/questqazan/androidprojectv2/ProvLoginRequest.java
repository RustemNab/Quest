package com.questqazan.androidprojectv2;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ProvLoginRequest extends StringRequest{
    private static final String PROV_REQUST_URL = "https://aydar-test.000webhostapp.com/Prov.php";
    private Map<String,String> params;

    public ProvLoginRequest(String login, Response.Listener<String> listener){
        super(Method.POST, PROV_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
