package space.karaskiv.hasherz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

// TODO

    public void btnSHA(View v) {
        EditText etInput = findViewById(R.id.etInput);
        TextView tvOutput = findViewById(R.id.tvOutput);

        RadioGroup rg = findViewById(R.id.rg);
        int check = rg.getCheckedRadioButtonId();
        RadioButton rb = findViewById(check);


        byte[] inputData = etInput.getText().toString().getBytes();
        byte[] outputData = new byte[0];

        try {
            outputData = sha.encryptSHA(inputData, rb.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger(outputData);
        tvOutput.setText(shaData.toString(16));
    }
}