package com.bestservicecarlm.fragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by lchan on 22/06/2016.
 */
public class TimePickertFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener  {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Utilizar el time actual como los valores por defecto para el selector
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        // Crear una nueva instancia de diálogo Selector de fechas y devolverlo
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
