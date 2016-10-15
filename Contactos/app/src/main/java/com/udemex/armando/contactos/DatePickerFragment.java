package com.udemex.armando.contactos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

/**
 * Created by Armando on 09/10/2016.
 */
public  class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    int dia;
    int mes;
    int año;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
         Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        dia=day;
        mes=month;
        año=year;
        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        dia=day;
        mes=month;
        año=year;
    }
}