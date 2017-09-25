package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class TrailDetailActivity extends AppCompatActivity {

    private static final String ADVENTURE_LIST_TAG = "Trail_List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_detail);

            // Confirm I'm passing data throught the intent - Sanity check
        Bundle bundle = getIntent().getExtras();
        Log.e(ADVENTURE_LIST_TAG,bundle.getString("HIKING"));
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
