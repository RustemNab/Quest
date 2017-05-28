package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class ProvToken  extends StringRequest {
    private static final String ProvToken_REQUST_URL = "https://aydar-test.000webhostapp.com/ProverkaToken.php";
    //private static final String ProvToken_REQUST_URL = "https://questqazan.000webhostapp.com/ProverkaToken.php";

    private Map<String,String> params;

    public ProvToken(String login, String token, Response.Listener<String> listener){
        super(Request.Method.POST, ProvToken_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
        params.put("token", token);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
