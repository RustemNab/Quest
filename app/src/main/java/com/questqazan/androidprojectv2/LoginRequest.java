package com.questqazan.androidprojectv2;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {
        private static final String LOGIN_REQUST_URL = "https://aydar-test.000webhostapp.com/Login.php";
        //private static final String LOGIN_REQUST_URL = "https://questqazan.000webhostapp.com/Login.php";

        private Map<String, String> params;

        public LoginRequest(String login, String password, Response.Listener<String> listener) {
                super(Request.Method.POST, LOGIN_REQUST_URL, listener, null);
                params = new HashMap<>();
                params.put("login", login);
                params.put("password", password);
        }

        public Map<String, String> getParams() {
                return params;
        }
}
