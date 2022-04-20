package android.bignerdranch.criminalintent;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimePickerFragment extends DialogFragment {
    public static final String EXTRA_HOUR = "android.bignerdranch.criminalintent.hour";
    public static final String EXTRA_MIN = "android.bignerdranch.criminalintent.min";

    private static final String ARG_HOUR = "hour";
    private static final String ARG_MINUTE = "minute";

    private TimePicker mTimePicker;

    public TimePickerFragment() {
            // Required empty public constructor
    }

    private void sendResult(int resultCode, int hour, int min) {
        if(getTargetFragment() == null)
            return;

        Intent intent = new Intent();
        intent.putExtra(EXTRA_HOUR, hour);
        intent.putExtra(EXTRA_MIN, min);

        getTargetFragment().onActivityResult(
                getTargetRequestCode(), resultCode, intent);
    }

    public static TimePickerFragment newInstance(int hour, int min) {
        Bundle args = new Bundle();
        args.putInt(ARG_HOUR, hour);
        args.putInt(ARG_MINUTE, min);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        int hour = getArguments().getInt(ARG_HOUR, 0);
        int min = getArguments().getInt(ARG_MINUTE, 0);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.fragment_time_picker, null);

        mTimePicker = (TimePicker) v.findViewById(R.id.timePicker1);

        mTimePicker.setCurrentHour(hour);
        mTimePicker.setCurrentMinute(min);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int hour = mTimePicker.getCurrentHour();
                                int min = mTimePicker.getCurrentMinute();

                                sendResult(Activity.RESULT_OK, hour, min);
                            }
                        })
                .create();
    }

}
