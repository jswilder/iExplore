package odomobileapplicationdevelopment.hikingapp;

import android.content.Intent;
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
        Intent intent = new Intent(this,TrailDetailActivity.class);
        intent.putExtra("HIKING","We are going hiking");
        startActivity(intent);
    }

    public void goSwimming(View view){
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
}
