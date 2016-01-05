package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.user.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by user on 1/2/2016.
 */
public class MainActivityFragmentt  extends AsyncTask<String, Void, String> {
    //  private static MyApi myApiService = null;
    // private OnJokeReceivedListener listener;
    private static MyApi myApiService = null;
    private String joke=null;

    public String getJoke(){
        return  joke;


    }

    @Override
    protected String doInBackground(String... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://test8-1088.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        //  listener = params[0];

        try {
            return myApiService.sayHi("hello").execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        joke=result;
      //  Intent intent = new Intent(getActivity(), MainLibraryActivity.class);
      //  intent.putExtra(MainLibraryActivity.key, joke);
       // startActivity(intent);
        Log.i("gevos",joke);
    }
}







