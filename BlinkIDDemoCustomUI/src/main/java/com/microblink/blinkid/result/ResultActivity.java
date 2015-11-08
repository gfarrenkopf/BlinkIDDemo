package com.microblink.blinkid.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.microblink.activity.ScanActivity;
import com.microblink.blinkid.RegistrationForm;
import com.microblink.blinkid.demo.R;
import com.microblink.recognizers.BaseRecognitionResult;

/**
 * Created by igor on 12/2/14.
 */
public class ResultActivity extends FragmentActivity {

    FragmentPagerAdapter adapterViewPager;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.result_menu);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new ResultFragmentAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
    }

    public void buttonClickHandler(View view) {
        final int id = view.getId();
        if (id == R.id.btnYesPay) {

            Intent intent = new Intent(this, FormActivity.class);
            Log.i(RegistrationForm.class.getSimpleName(), Integer.toString((adapterViewPager).getCount()));
            RegistrationForm.setData(((ResultFragmentAdapter) adapterViewPager).results, adapterViewPager.getCount());
            startActivity(intent);
        } else if (id == R.id.btnNoBack) {
            finish();
        }
    }

    class ResultFragmentAdapter extends FragmentPagerAdapter {

        Parcelable[] results = getIntent().getExtras().getParcelableArray(
                ScanActivity.EXTRAS_RECOGNITION_RESULT_LIST
        );

        public ResultFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ResultFragment.newInstance(results[position]);
        }

        @Override
        public int getCount() {
            return results.length;
        }



        @Override
        public CharSequence getPageTitle(int position) {
            BaseRecognitionResult result = (BaseRecognitionResult) results[position];
            return result.getTitle();
        }
    }
}
