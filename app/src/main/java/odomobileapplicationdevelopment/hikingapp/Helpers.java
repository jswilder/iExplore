package odomobileapplicationdevelopment.hikingapp;

/**
 * Created by j on 9/25/17.
 * helper functions for parsing and url creation
 */

public class Helpers {
    private static final String mURL = "https://trailapi-trailapi.p.mashape.com/";
    private static final String mLimit = "?limit=";
    private static final String mActivities = "&q[activities_activity_type_name_eq]=";
    private static final String mCity = "&q[city_cont]=";
    private static final String mCountry = "&q[country_cont]=";
    private static final String mState = "&q[state_cont]=";
    private static final String mRadius = "&radius=25";
    private static final String mAPI_Key = "&mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE";

    // Working URL
    // https://trailapi-trailapi.p.mashape.com/?limit=25
    // &q[activities_activity_type_name_eq]=mountain+biking
    // &q[city_cont]=Denver
    // &q[country_cont]=United+States
    // &q[state_cont]=Colorado
    // &radius=25
    // &mashape-key=41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE
    // Key 41R1FzuE3KmshQ2IQIBWeJsySdeCp1FtHHAjsn4g6sAhMBpClE

    public static String buildUrl(String city,String state, String country, String activity, int radius) {
        StringBuilder ret = new StringBuilder(mURL);
        // Limit of trails to search for
        ret.append(mLimit);

        if( !city.isEmpty() ){
            if( city.contains(" ")){
                city.replace(" ","+");
            }
            ret.append(mCity + city);
        }
        if( !state.isEmpty() ){
            if( state.contains(" ")){
                state.replace(" ","+");
            }
            ret.append(mState + state);
        }
        if( !country.isEmpty() ){
            if( country.contains(" ")){
                country.replace(" ","+");
            }
            ret.append(mCountry + country );
        }
        if( !activity.isEmpty() ){
            ret.append( mActivities + activity);
        }
        if( radius <= 4 ){
            ret.append(mRadius+5);
        } else {
            ret.append(mRadius+radius);
        }

        // Always append key!
        ret.append(mAPI_Key);

        return ret.toString();
    }
}