package odomobileapplicationdevelopment.hikingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goCamping(View view){
        Toast.makeText(this,"LETS GO CAMPING!",Toast.LENGTH_SHORT).show();
    }

    public void goHiking(View view){
        Toast.makeText(this,"LETS GO HIKING!",Toast.LENGTH_SHORT).show();
    }

    public void goSwimming(View view){
        Toast.makeText(this,"LETS GO SWIMMING!",Toast.LENGTH_SHORT).show();
    }
}
