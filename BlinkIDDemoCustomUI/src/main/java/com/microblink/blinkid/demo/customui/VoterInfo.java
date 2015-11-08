package com.microblink.blinkid.demo.customui;

import android.os.Parcelable;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.microblink.blinkid.result.ResultActivity;

/**
 * Created by phambd on 11/7/15.
 */
public class VoterInfo {
    private static String fName;
    private static String lName;
    private static String address;
    private static String city;
    private static String state;
    private static String zip;
    private static String birth;
    private static String tNumber;

    public static void setData(Parcelable[] data) {
        for (int i =0; i < data.length; i ++){
            Log.i(VoterInfo.class.getSimpleName(), data[i].toString());
        }
    }

//    public static void passData(RegistrationForm form) {

//    }


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getBirth() {
        return birth;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }
}
