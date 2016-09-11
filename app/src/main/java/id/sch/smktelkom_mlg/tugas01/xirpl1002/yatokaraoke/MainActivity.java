package id.sch.smktelkom_mlg.tugas01.xirpl1002.yatokaraoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    TextView y,d,p,a,t,tvHasil1,tvHasil2,tvHasil3,tvHasil4,tvHasil5;
    EditText etName;
    RadioGroup rgStatus;
    CheckBox cbW,cbF,cbA;
    Spinner spTrack,spSong;
    Button bOk;
    int nAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.editTextName);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        spTrack = (Spinner) findViewById(R.id.spinnerTrack);
        spSong = (Spinner) findViewById(R.id.spinnerSong);
        cbW = (CheckBox) findViewById(R.id.checkBoxW);
        cbA = (CheckBox) findViewById(R.id.checkBoxA);
        cbF = (CheckBox) findViewById(R.id.checkBoxF);
        bOk = (Button) findViewById(R.id.buttonOK);

        cbW.setOnCheckedChangeListener(this);
        cbW.setOnCheckedChangeListener(this);
        cbW.setOnCheckedChangeListener(this);


        tvHasil1 = (TextView) findViewById(R.id.textViewHasil1);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        tvHasil5 = (TextView) findViewById(R.id.textViewHasil5);



        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v){
                doClick();
            }
        });

    }

    private void doClick() {
        String name = etName.getText().toString();
        String hasil2 = "Add On :" ;
        String hasil3 = null;
        int startlen = hasil2.length();

        if (name.isEmpty())
        {
            etName.setError("You Haven't Fill Your Name");
        }
        else{
            etName.setError(null);
        }

        tvHasil1.setText("Name          :" + name);
        if (rgStatus.getCheckedRadioButtonId()!=-1)
        {
            RadioButton rb =(RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil3 = rb.getText().toString();
        }
        if (hasil3 == null){
            tvHasil3.setText("You Haven't Choose Your Packet!");
        }
        else {
            tvHasil3.setText("Your Packet : " + hasil3);
        }

        if (cbW.isChecked()) hasil2+=cbW.getText()+",";
        if (cbF.isChecked()) hasil2+=cbF.getText()+",";
        if (cbA.isChecked()) hasil2+=cbA.getText()+".";

        if (hasil2.length()==startlen) hasil2+=" No Add On";
        tvHasil4.setText(hasil2);
        tvHasil2.setText("Track List Choose :" + "Artist, " + spTrack.getSelectedItem().toString() + "Title, "
                + spSong.getSelectedItem().toString());
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nAdd+=1;
        else nAdd-=1;

        tvHasil5.setText("Add On ("+nAdd+" choosen)");
    }
}
