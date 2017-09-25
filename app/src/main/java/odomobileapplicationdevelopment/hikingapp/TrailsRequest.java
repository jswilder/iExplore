package odomobileapplicationdevelopment.hikingapp;

import android.support.annotation.NonNull;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by j on 9/25/17.
 */

public class TrailsRequest extends Request {

    // Working URL
    // https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25
    // &mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE
    // Key 41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE

    private static String mURL = "https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25";

        //  "X-Mashape-Key"
    private final String API_KEY = "&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";

    private final String CompleteURL = "https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";

    public TrailsRequest(int method, String mURL, Response.ErrorListener listener) {
        super(method, mURL, listener);
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(Object response) {

    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }

    // Working URL
    // https://trailapi-trailapi.p.mashape.com/?limit=25&q[activities_activity_type_name_eq]=mountain+biking&q[city_cont]=Denver&q[country_cont]=United+States&q[state_cont]=Colorado&radius=25
    // &mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE
    // Key 41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE

    public String getUrl() {
        return  String.valueOf(mURL + API_KEY);
    }

}
