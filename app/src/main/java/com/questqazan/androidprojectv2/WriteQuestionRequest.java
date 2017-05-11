package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class WriteQuestionRequest extends StringRequest {
    //private static final String Question_REQUST_URL = "https://aydar-test.000webhostapp.com/WriteQuestion.php";
    private static final String Question_REQUST_URL = "https://questqazan.000webhostapp.com/WriteQuestion.php";

    private Map<String,String> params;

    public WriteQuestionRequest(String id, Response.Listener<String> listener){
        super(Request.Method.POST, Question_REQUST_URL, listener, null);
        params = new HashMap<>();
        params.put("id", id);
    }

    public Map<String, String> getParams(){
        return params;
    }
}