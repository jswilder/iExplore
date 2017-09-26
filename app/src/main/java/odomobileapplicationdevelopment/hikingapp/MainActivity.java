package odomobileapplicationdevelopment.hikingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    public void goCamping(View view){
        Toast.makeText(this,"LETS GO CAMPING!",Toast.LENGTH_SHORT).show();
    }

    public void goHiking(View view){
        Toast.makeText(this,"LETS GO HIKING!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,TrailDetailActivity.class);
        intent.putExtra("HIKING","We are going hiking");
        startActivity(intent);
    }

    public void goSpecific(View view){
        Toast.makeText(this,"LETS GO SWIMMING!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SearchDetails.class);
        startActivity(intent);
    }

    public void goCanoeing(View view){
        Toast.makeText(this,"LETS GO CANOEING!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,SearchDetails.class);
        startActivity(intent);
    }

    public void goClimbing(View view){
        Toast.makeText(this,"LETS GO CLIMBING!",Toast.LENGTH_SHORT).show();
    }

    public void goCycling(View view){
        Toast.makeText(this,"LETS GO CYCLING!",Toast.LENGTH_SHORT).show();
    }

    public void goCaving(View view){
        Toast.makeText(this,"LETS GO CAVING!",Toast.LENGTH_SHORT).show();
    }

    public void goUSA(View view){
        Toast.makeText(this,"LETS GO HIKE THE USA!",Toast.LENGTH_SHORT).show();
    }

    public void goCanada(View view){
        Toast.makeText(this,"LETS GO TO CANADA!",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
