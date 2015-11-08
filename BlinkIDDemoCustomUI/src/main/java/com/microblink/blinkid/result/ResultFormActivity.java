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
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.microblink.activity.ScanActivity;
import com.microblink.blinkid.RegistrationForm;
import com.microblink.blinkid.demo.R;
import com.microblink.blinkid.result.FormActivity;
import com.microblink.blinkid.result.ResultFragment;
import com.microblink.recognizers.BaseRecognitionResult;

/**
 * Created by igor on 12/2/14.
 */
public class ResultFormActivity extends FragmentActivity {
    RegistrationForm form;
    private EditText fname;
    private EditText mname;
    private EditText lname, idnum, address, address2, city, state, zip;

    FragmentPagerAdapter adapterViewPager;

    @SuppressLint("InlinedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_form);

//        ActivityFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_form);
//        FormBinding binding = DataBindingUtile
        Spinner spinner = (Spinner) findViewById(R.id.political_parties);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.political_parties, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        form = RegistrationForm.getRegistrationForm();
        this.fname = (EditText) findViewById(R.id.fname);
        this.mname = (EditText) findViewById(R.id.mname);
        this.lname = (EditText) findViewById(R.id.lname);
        this.idnum = (EditText) findViewById(R.id.idnum);
        this.address = (EditText) findViewById(R.id.address);
        this.address2 = (EditText) findViewById(R.id.address2);
        this.city = (EditText) findViewById(R.id.city);
        this.state = (EditText) findViewById(R.id.state);
        this.zip = (EditText) findViewById(R.id.zip);
        this.fname.setText(form.getFirst_name());
        this.mname.setText(form.getMiddle_name());
        this.lname.setText(form.getLast_name());
        this.idnum.setText(form.getId_number());
        this.address.setText(form.getHome_address());
        this.address2.setText(form.getHome_unit());
        this.city.setText(form.getHome_city());
        this.state.setText(form.getHome_city());
        this.zip.setText(form.getHome_zip_code());
    }

    public void buttonClickHandler(View view) {
        final int id = view.getId();
        if (id == R.id.btnYesPay) {

            Intent intent = new Intent(this, FormActivity.class);
            startActivity(intent);
        } else if (id == R.id.btnNoBack) {
            finish();
        }
    }


}
