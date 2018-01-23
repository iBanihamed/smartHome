package ismael.banihamed.my.a353.csun.edu.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //Button to  finish inputting settings and go back to main menu
        Button finishButton = (Button) findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText zipCode = (EditText) findViewById(R.id.zipCode);
                EditText household = (EditText) findViewById(R.id.householdEditText);
                EditText januaryBill = (EditText) findViewById(R.id.januaryEditText);
                EditText marchBill = (EditText) findViewById(R.id.marchEditText);
                EditText mayBill = (EditText) findViewById(R.id.mayEditText);
                EditText julyBill = (EditText) findViewById(R.id.julyEditText);
                EditText septemberBill = (EditText) findViewById(R.id.septemberEditText);
                EditText novemberBill = (EditText) findViewById(R.id.novemberEditText);

                int zip = Integer.parseInt(zipCode.getText().toString());
                int jan_int_Bill = Integer.parseInt(zipCode.getText().toString());
                int mar_int_Bill = Integer.parseInt(zipCode.getText().toString());
                int may_int_Bill = Integer.parseInt(zipCode.getText().toString());
                int july_int_Bill = Integer.parseInt(zipCode.getText().toString());
                int sep_int_Bill = Integer.parseInt(zipCode.getText().toString());
                int nov_int_Bill = Integer.parseInt(zipCode.getText().toString());

                String houseHold = household.getText().toString();

                Intent listIntent = new Intent(getApplicationContext(), getStartedActivity.class);
                startActivity(listIntent);
            }
        });
    }

}
