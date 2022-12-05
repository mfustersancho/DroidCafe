package com.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.droidcafe.databinding.ActivityMainBinding;
import com.example.droidcafe.databinding.ActivityOrderBinding;

public class OrderActivity extends AppCompatActivity {

    private static final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();

    private ActivityOrderBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.sameday.setOnClickListener(view -> {
            onRadioButtonClicked(view);
        });

        mBinding.nextday.setOnClickListener(view -> {
            onRadioButtonClicked(view);
        });

        mBinding.pickup.setOnClickListener(view -> {
            onRadioButtonClicked(view);
        });

    }

    public void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if(checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                if(checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                if(checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.pick_up));
                break;
            default:
                Log.d(TAG_ACTIVITY, getString(R.string.nothig_clicked));
                break;
        }
    }
}