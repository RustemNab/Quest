package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ChangeQuestioning4 extends StringRequest {
    //private static final String Change_REQUST_URL = "https://aydar-test.000webhostapp.com/ChangeQuestioning4.php";
    private static final String Change_REQUST_URL = "https://questqazan.000webhostapp.com/ChangeQuestioning4.php";

    private Map<String,String> params;

    public ChangeQuestioning4(String login, Response.Listener<String> listener){
        super(Request.Method.POST, Change_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
