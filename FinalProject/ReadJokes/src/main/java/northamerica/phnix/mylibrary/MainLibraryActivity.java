package northamerica.phnix.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainLibraryActivity extends AppCompatActivity {
    public static String key="myKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}
