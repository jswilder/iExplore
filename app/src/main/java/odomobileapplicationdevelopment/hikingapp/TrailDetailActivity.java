package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class TrailDetailActivity extends AppCompatActivity {

    // @BindView(R.id.respone_text) TextView text;

    private static final String ADVENTURE_LIST_TAG = "Trail_List";

    private static RequestQueue volley;
    private static String mURL = "https://trailapi-trailapi.p.mashape.com/";

    private final String CompleteURL = "https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_detail);

            // Confirm I'm passing data throught the intent - Sanity check
        Bundle bundle = getIntent().getExtras();
        Log.e(ADVENTURE_LIST_TAG,bundle.getString("HIKING"));

            // Volley stuff
        volley = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET, CompleteURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                TextView text = (TextView) findViewById(R.id.respone_text);
                text.setText("Response is " + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                TextView text = (TextView) findViewById(R.id.respone_text);
                text.setText(error.toString());
            }
        });

        volley.add(request);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}
