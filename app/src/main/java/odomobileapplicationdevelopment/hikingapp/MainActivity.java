package odomobileapplicationdevelopment.hikingapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private String STATE = "";
    private String COUNTRY = "United States";
    private String CITY = "";
    private String ACTIVITY = "";

    private ImageButton USA;
    private ImageButton CAN;

    private boolean USA_Selected = true;

    private Spinner states;
    private Spinner activity;

    ArrayAdapter<CharSequence> state_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USA = (ImageButton) findViewById(R.id.button_USA);
        CAN = (ImageButton) findViewById(R.id.button_CAN);

        USA.setColorFilter(Color.parseColor("#002868"));

        states = (Spinner) findViewById(R.id.spinner_State_Province);
        activity = (Spinner) findViewById(R.id.spinner_Activity);

        state_adapter = ArrayAdapter.createFromResource(this,R.array.state_names,R.layout.support_simple_spinner_dropdown_item);
        state_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> activity_adapter = ArrayAdapter.createFromResource(this,R.array.activities,R.layout.support_simple_spinner_dropdown_item);
        activity_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        states.setAdapter(state_adapter);
        activity.setAdapter(activity_adapter);
    }

    public void goExploring(View view){
        Toast.makeText(this,"LETS GO EXPLORING!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,TrailDetailActivity.class);
        intent.putExtra("EXPLORING","We are going exploring");
        startActivity(intent);
    }

    public void goUSA(View view){
        Toast.makeText(this,"LETS GO HIKE THE USA!",Toast.LENGTH_SHORT).show();
    }

    public void goCanada(View view){
        Toast.makeText(this,"LETS GO TO CANADA!",Toast.LENGTH_SHORT).show();
    }

    public void switchToUSA(View view){
     //   Toast.makeText(this,"Switch Country - USA",Toast.LENGTH_SHORT).show();
        if( !USA_Selected){
            // Highlight USA
            USA.setColorFilter(Color.parseColor("#002868"));
            CAN.setColorFilter(Color.BLACK);
        }

        USA_Selected = true;
        state_adapter = ArrayAdapter.createFromResource(this,R.array.state_names,R.layout.support_simple_spinner_dropdown_item);
        states.setAdapter(state_adapter);
    }

    public void switchToCANADA(View view){
       // Toast.makeText(this,"Switch Country - CANADA",Toast.LENGTH_SHORT).show();
        if(USA_Selected){
            // Highlight Canada
            CAN.setColorFilter(Color.RED);
            USA.setColorFilter(Color.BLACK);
        }
        USA_Selected = false;
        state_adapter = ArrayAdapter.createFromResource(this,R.array.canada_provinces,R.layout.support_simple_spinner_dropdown_item);
        states.setAdapter(state_adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
