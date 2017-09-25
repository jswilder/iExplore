package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrailDetailActivity extends AppCompatActivity {

    @BindView(R.id.trails_list_View) ListView listView;

    private static final String ADVENTURE_LIST_TAG = "Trail_List";

    private static RequestQueue volley;

    private static final String CompleteURL = "https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";

    ArrayAdapter<Trail> mAdapter;

    private ArrayList<Trail> trails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_detail);

        ButterKnife.bind(this);

        mAdapter = new TrailAdapter(this, R.layout.trail_list_item, trails);

        listView.setAdapter(mAdapter);

        // Todo add on click to go to park url

            // Confirm I'm passing data throught the intent - Sanity check
        Bundle bundle = getIntent().getExtras();
        Log.e(ADVENTURE_LIST_TAG,bundle.getString("HIKING"));

            // Volley stuff
        volley = Volley.newRequestQueue(this);

        Response.Listener listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mAdapter.addAll( Helpers.parseJSON(response) );
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error retrieving data :(",Toast.LENGTH_SHORT).show();
            }
        };

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,CompleteURL,null,listener,errorListener);

        volley.add(jsonObjectRequest);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}