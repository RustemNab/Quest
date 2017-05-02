package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riga on 02.05.2017.
 */

public class AddInQuestioningRequest extends StringRequest {
    private static final String AddInQuestioning_REQUST_URL = "https://aydar-test.000webhostapp.com/AddInQuestioningRequest.php";
    private Map<String,String> params;

    public AddInQuestioningRequest(String login, Response.Listener<String> listener){
        super(Request.Method.POST, AddInQuestioning_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("login", login);
    }

    public Map<String, String> getParams(){
        return params;
    }
}
