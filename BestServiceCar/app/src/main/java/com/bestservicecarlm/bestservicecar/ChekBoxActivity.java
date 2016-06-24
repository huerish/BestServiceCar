package com.bestservicecarlm.bestservicecar;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.bestservicecarlm.fragment.TimePickertFragment;

public class ChekBoxActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chek_box);
        inicializar();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ciudades, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void selectFavAnimal(View view) {
        boolean checked = ((CheckBox)view).isChecked();
        switch (view.getId()){
            case R.id.checkboxDog:
                showMessage(getResources().getString(R.string.Perros),checked);
                break;
            case R.id.checkboxCat:
                showMessage(getResources().getString(R.string.Gatos),checked);
                break;
            case R.id.checkboxFish:
                showMessage(getResources().getString(R.string.Peses),checked);
                break;
        }
    }
    private void showMessage(String animal, boolean like){
        String message;
        if(like)
            message = "Me gustan los "+animal;
        else message = "No me gustan los "+animal;
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickertFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }
    public void selectRadioButtonClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radio_si:
                showMessage(getResources().getString(R.string.si),checked);
                break;
            case R.id.radio_no:
                showMessage(getResources().getString(R.string.no),checked);
                break;
            case R.id.radio_aveces:
                showMessage(getResources().getString(R.string.aveces),checked);
                break;
        }
    }
    private void inicializar() {
        ToggleButton toggle = (ToggleButton)findViewById(R.id.togglebutton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });
        toggle.isChecked();

        Switch sw = (Switch)findViewById(R.id.switchs);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });
        sw.isChecked();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      String[] array =   getResources().getStringArray(R.array.ciudades);
        String selected = array[position];
        Toast.makeText(this, selected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
