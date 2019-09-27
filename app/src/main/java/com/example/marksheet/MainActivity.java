package com.example.marksheet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marksheet.Marksheet.StudentMarksheet;
import com.example.marksheet.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText txtname, txtmarks1, txtmarks2, txtmarks3;
    private Button btncalculate;
    private TextView tvresult;

    private int marks1, marks2, marks3, result11;

    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtname = (EditText) findViewById(R.id.txtname);

        txtmarks1 = (EditText) findViewById(R.id.txtmarks11);
        txtmarks2 = (EditText) findViewById(R.id.txtmarks22);
        txtmarks3 = (EditText) findViewById(R.id.txtmarks33);

        btncalculate = (Button) findViewById(R.id.btncalculate11);

        tvresult = (TextView) findViewById(R.id.tvresult);

        btncalculate.setOnClickListener(this);

//        btncalculate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String name;
//                name = txtname.getText().toString();
//                marks1 = Integer.parseInt(txtmarks1.getText().toString());
//                marks2 = Integer.parseInt(txtmarks2.getText().toString());
//                marks3 = Integer.parseInt(txtmarks3.getText().toString());
//                result11=marks1+marks2+marks3;
//                tvresult.append("Student Name: -" + name + " "+"Percentage is " + result11);
//            }
//        });


    }

    @Override
    public void onClick(View view) {

        if(TextUtils.isEmpty(txtname.getText().toString())){
            txtname.setError("Enter Your Full Name");
            return;
        }


        if(TextUtils.isEmpty(txtmarks1.getText().toString())){
            txtmarks1.setError("Enter DDW Marks ");
            return;
        }

        if(TextUtils.isEmpty(txtmarks2.getText().toString())){
            txtmarks2.setError("Enter DDD Marks");
            return;
        }
        if(TextUtils.isEmpty(txtmarks3.getText().toString())){
            txtmarks3.setError("Enter PIT Marks");
            return;
        }


        marks1=Integer.parseInt(txtmarks1.getText().toString());
        marks2=Integer.parseInt(txtmarks2.getText().toString());
        marks3=Integer.parseInt(txtmarks3.getText().toString());

        switch (view.getId()){

            case R.id.btncalculate11 :
                if(btncalculate.isClickable()){
                    StudentMarksheet student=new StudentMarksheet(marks1, marks2, marks3);
                    result11=student.Resultmarksheet();
//                    tvresult.setText(Integer.toString(result11));

                    String name;
                    name=txtname.getText().toString();
                    tvresult.append("Student Name: -" + name + " "+"Percentage is: - " + result11 + "%" +"\n");

                    txtname.getText().clear();
                    txtmarks1.getText().clear();
                    txtmarks2.getText().clear();
                    txtmarks3 .getText().clear();

                }

                else {
                    Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show();

                }
                break;
        }

    }
}

