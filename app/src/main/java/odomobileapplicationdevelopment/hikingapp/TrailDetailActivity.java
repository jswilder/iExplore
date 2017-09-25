package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    private static final String ADVENTURE_LIST_TAG = "Trail_List";

    private static RequestQueue volley;

/*
    private static final String CompleteURL = "https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";
*/
    private static final String CompleteURL = "https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[country_cont]=United+States&radius=25&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";

    TrailAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trail_detail);

        ButterKnife.bind(this);

        mAdapter = new TrailAdapter(this, R.layout.trail_list_item, new ArrayList<Trail>());

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
                parseJSON(response);
                //mAdapter.addAll( Helpers.parseJSON(response) );
                //Toast.makeText(getApplicationContext(),Helpers.parseJSON(response).toString(),Toast.LENGTH_SHORT).show();
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error retrieving data :(",Toast.LENGTH_SHORT).show();
            }
        };

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,CompleteURL,null,listener,errorListener);
        jsonObjectRequest.setTag(KILL_TAG);

        volley.add(jsonObjectRequest);
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
        ArrayList<Trail> list = new ArrayList<>();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        mAdapter.clear();

        try {
            JSONArray array = root.getJSONArray("places");
            for( int i = 0; i<array.length(); i++ ){
                String data = array.getJSONObject(i).toString();
                Trail trail = gson.fromJson(data,Trail.class);
                mAdapter.add(trail);
                Log.e("PARSER: ",trail.toString());
                Log.e("COUNT", String.valueOf(mAdapter.getCount()));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}