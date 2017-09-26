package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TrailDetailActivity extends AppCompatActivity {

    @BindView(R.id.trails_list_View) ListView listView;

    private static final String KILL_TAG = "JsonRequestTag";

    private static RequestQueue volley;

    private String STATE = "";
    private String COUNTRY = "";
    private String CITY = "";
    private String ACTIVITY = "";

    TrailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_detail);

        ButterKnife.bind(this);

        mAdapter = new TrailAdapter(this, R.layout.trail_list_item, new ArrayList<Trail>());

        listView.setAdapter(mAdapter);

            // Retrieve Values
        Bundle bundle = getIntent().getExtras();
        COUNTRY = bundle.getString("COUNTRY");
        STATE = bundle.getString("STATE");
        CITY = bundle.getString("CITY");
        ACTIVITY = bundle.getString("ACTIVITY");

            // Volley stuff
        volley = Volley.newRequestQueue(this);

        Response.Listener listener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                parseJSON(response);
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error retrieving data :(",Toast.LENGTH_SHORT).show();
            }
        };

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,Helpers.buildUrl(CITY,STATE,COUNTRY,ACTIVITY,5)
                ,null,listener,errorListener);
        request.setTag(KILL_TAG);
        volley.add(request);
    }

    @Override
    protected void onStop() {
        super.onStop();
            // Kills the request if the activity is being destroyed
        if(volley != null){
            volley.cancelAll(KILL_TAG);
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    public void parseJSON(JSONObject root){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        mAdapter.clear();

        try {
            JSONArray array = root.getJSONArray("places");
            for( int i = 0; i<array.length(); i++ ){
                String data = array.getJSONObject(i).toString();
                Trail trail = gson.fromJson(data,Trail.class);
                mAdapter.add(trail);
                //Log.e("PARSER: ",trail.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}