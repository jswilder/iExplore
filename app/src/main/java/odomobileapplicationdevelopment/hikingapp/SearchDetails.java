package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_details);

        Spinner countries = (Spinner) findViewById(R.id.spinner_Country);
        Spinner states = (Spinner) findViewById(R.id.spinner_State_Province);
        Spinner activity = (Spinner) findViewById(R.id.spinner_Activity);

        ArrayAdapter<CharSequence> country_adapter = ArrayAdapter.createFromResource(this,R.array.countries,R.layout.support_simple_spinner_dropdown_item);
        country_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> state_adapter = ArrayAdapter.createFromResource(this,R.array.states_provinces,R.layout.support_simple_spinner_dropdown_item);
        state_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> activity_adapter = ArrayAdapter.createFromResource(this,R.array.activities,R.layout.support_simple_spinner_dropdown_item);
        activity_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

/*        countries.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        states.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        activity.setOnItemClickListener((AdapterView.OnItemClickListener) this);*/

        countries.setAdapter(country_adapter);
        states.setAdapter(state_adapter);
        activity.setAdapter(activity_adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = (String) adapterView.getItemAtPosition(i);
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}