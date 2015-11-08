package com.microblink.blinkid.result;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.microblink.blinkid.RegistrationForm;
import com.microblink.blinkid.demo.R;

//import com.microblink.blinkid.demo.R;

public class FormActivity extends Activity{
    RegistrationForm form;
    private EditText fname;
    private EditText mname;
    private EditText lname, idnum, address, address2, city, state, zip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

//        ActivityFormBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_form);
//        FormBinding binding = DataBindingUtile
        Spinner spinner = (Spinner) findViewById(R.id.political_parties);
        ArrayAdapter<CharSequence>  adapter = ArrayAdapter.createFromResource(this,
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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_form, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}