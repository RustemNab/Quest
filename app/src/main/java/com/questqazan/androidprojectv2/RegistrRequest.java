package com.questqazan.androidprojectv2;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegistrRequest extends StringRequest {
    private static final String REGISTR_REQUST_URL = "https://androidprojectv2.000webhostapp.com/Registr.php";
    private Map<String,String> params;

    public RegistrRequest(String name, String login, String password, int age, Response.Listener<String> listener){
        super(Method.POST, REGISTR_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("login", login);
        params.put("password", password);
        params.put("age", age + "");
    }

    public Map<String, String> getParams(){
        return params;
    }
}
