package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 1/2/2016.
 */
public class Download_TEST extends ApplicationTestCase<Application> {
    CountDownLatch signal;
    String testStr;
    public Download_TEST()
        {
            super(Application.class);
        }

    public void test() {
        try {
            signal = new CountDownLatch(1);
          MainActivityFragmentt test=new MainActivityFragmentt();
          test.execute("test");
            signal.await(10, TimeUnit.SECONDS);
           testStr = test.getJoke();

            Log.i("bruce",testStr);
           assertNotNull("joke is null", testStr);
         //   assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }
}
