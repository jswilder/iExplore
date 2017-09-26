package odomobileapplicationdevelopment.hikingapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by j on 9/18/17.
 */

public class TrailAdapter extends ArrayAdapter {

    private Context mContext;
    private ArrayList<Trail> mTrails;

    public TrailAdapter(Context context, int resource, ArrayList<Trail> arrayList){
        super(context,resource,arrayList);
        mContext = context;
        mTrails = arrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Trail trail = mTrails.get(position);

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View view = null;

        view = layoutInflater.inflate(R.layout.trail_list_item, null);

        TextView name = (TextView) view.findViewById(R.id.park_name_text);
        TextView description = (TextView) view.findViewById(R.id.park_details_text);

        ImageView image = image = (ImageView) view.findViewById(R.id.park_thumbnail);

        String imgURI = "";
        if( imgURI.isEmpty() ){
            image.setImageResource(R.drawable.ic_forest); // If there isn't a link, dont try to retrieve thumbnail img
        } else {

            /*Picasso.with(getContext()).load(imgURI).fit().centerCrop().placeholder(R.drawable.burger)
                    .error(R.drawable.burger).into(image);*/
        }

        String n = trail.getName();
        String c = trail.getCity();
        String s = trail.getState();

        if( n != null){
            name.setText(n);
        } else {
            name.setText("Beautiful Park");
        }

        if( c != null && s != null ){
            description.setText(c + ", " + s);
        } else{
            description.setText("City, State");
        }
        return view;
    }
}