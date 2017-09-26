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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @BindView(R.id.button_USA) ImageButton USA;
    @BindView(R.id.button_CAN) ImageButton CAN;

    @BindView(R.id.spinner_State_Province) Spinner states;
    @BindView(R.id.spinner_Activity) Spinner activity;

    private String STATE = "";
    private String COUNTRY = "United States";
    private String CITY = "";
    private String ACTIVITY = "";

    private boolean USA_Selected = true;
    ArrayAdapter<CharSequence> state_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

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
            // Put state/country/activity into intent extras
        Toast.makeText(this,"LETS GO EXPLORING!",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,TrailDetailActivity.class);
        intent.putExtra("EXPLORING","We are going exploring");
        startActivity(intent);
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
