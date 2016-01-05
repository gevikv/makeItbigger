package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.user.myapplication.backend.myApi.MyApi;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

import northamerica.phnix.mylibrary.MainLibraryActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static MyApi myApiService = null;
    private String joke=null;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);


        Button button = (Button) root.findViewById(R.id.myJoke_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new EndpointsAsyncTask().execute("hello");
            }
        });


        return root;
    }

    public class EndpointsAsyncTask extends AsyncTask<String, Void, String> {
      //  private static MyApi myApiService = null;
       // private OnJokeReceivedListener listener;

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
            Intent intent = new Intent(getActivity(), MainLibraryActivity.class);
            intent.putExtra(MainLibraryActivity.key, joke);
            startActivity(intent);
            Log.i("gevos",joke);
        }
    }





}
