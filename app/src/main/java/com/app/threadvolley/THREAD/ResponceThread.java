package com.app.threadvolley.THREAD;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.app.threadvolley.API.API;
import com.app.threadvolley.UI.MainActivity;
import com.app.threadvolley.Model.Population;
import com.app.threadvolley.Model.Worldpopulation;
import com.app.threadvolley.Utils.C;
import com.app.threadvolley.Utils.NetworkUtils;
import com.app.threadvolley.volley.MySingleton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponceThread extends Thread {

    public Context context;
    List<Worldpopulation> models;
    MainActivity.getResponce getResponces;

    public ResponceThread(Context context, List<Worldpopulation> models, MainActivity.getResponce getResponces) {
        this.context = context;
        this.models = models;
        this.getResponces = getResponces;
    }

    @Override
    public void run() {
        try {
            GetEventList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void GetEventList() {


        if (NetworkUtils.isNetworkConnected(context)) {
            // setProgress();
            StringRequest strreq = new StringRequest(Request.Method.POST, API.RESPONCE,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // get response
                            try {
                                if (!C.isEmpty(response)) {
                                    //  dismisDialog();
                                    try {
                                        GsonBuilder builder = new GsonBuilder();
                                        Gson gson = builder.create();
                                        Population rishabh = gson.fromJson(response, Population.class);
                                        getResponces.onSelect(rishabh);
                                    } catch (Exception e) {
                                        e.printStackTrace();

                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError e) {
                    //    dismisDialog();
                    e.printStackTrace();
                }
            }) {
                @Override
                public Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    return params;
                }
            };
            MySingleton.getInstance(context).addToRequestQue(strreq);
        }
    }

}
