package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;

import com.example.droidcafe.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActivityMainBinding mActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(mActivityBinding.getRoot());

        setSupportActionBar(mActivityBinding.toolbar);

        mActivityBinding.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());

        ImageView donut = findViewById(R.id.donut);
        donut.setOnClickListener(view -> showFoodOrder(getString(R.string.donut_order_message)));

        ImageView iceCream = findViewById(R.id.ice_cream);
        iceCream.setOnClickListener(view -> showFoodOrder(getString(R.string.ice_cream_order_message)));

        ImageView froyo = findViewById(R.id.froyo);
        froyo.setOnClickListener(view -> showFoodOrder(getString(R.string.froyo_order_message)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showFoodOrder(String message) {
        displayToast(message);
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}