package com.bestservicecarlm.fragment;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by lchan on 22/06/2016.
 */
public class DatePickedFragment  extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {
    private NoticeDialogListener mListener;
    public static DatePickedFragment newInstance(Long dateLimit, int year, int month, int day) {
        DatePickedFragment fragment = new DatePickedFragment();
        Bundle args = new Bundle();
        args.putInt("year", year);
        args.putInt("month", month);
        args.putInt("day", day);
        args.putLong("dateLimit", dateLimit);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Utilice la fecha actual como la fecha predeterminada en el selector
        int year = getArguments().getInt("year");
        int month = getArguments().getInt("month");
        int day = getArguments().getInt("day");
        Long dateLimit = getArguments().getLong("dateLimit");
        DatePickerDialog dpd =  new DatePickerDialog(getActivity(), this, year, month, day);
        if(dateLimit!=null)
            dpd.getDatePicker().setMinDate(dateLimit);
        return dpd;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        mListener.onDateSet(view, year, month, day);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " no seas pato no pusiste el NoticeDialogListener al activity");
        }
    }

    public interface NoticeDialogListener {
        public void onDateSet(DatePicker view, int year, int month, int day);
    }
}
