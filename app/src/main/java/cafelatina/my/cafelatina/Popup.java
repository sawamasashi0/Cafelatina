package cafelatina.my.cafelatina;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Popup extends Activity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);
        Button popup = findViewById(R.id.sendButton);
        intent = getIntent();
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] Product_name = intent.getStringArrayExtra("Product_name");
                ArrayList<Integer> Number_of_command = intent.getIntegerArrayListExtra("Number_of_command");
                String Message = " ";
                /*
                for(int i = 0;i<Product_name.length;i++) {
                    Message += Product_name[i] + " " + Number_of_command.get(i) + "個, ";
                }
*/
                sendSMS("+33769452984",Message);

                Context context = getApplicationContext();
                CharSequence text = "Your command : " + Message + "was sent to kitchen";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Intent i = new Intent(Popup.this, EndActivity.class);

                startActivity(i);
            }
            });
        Button popup2 = findViewById(R.id.cancel);
        popup2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                Intent i2 = new Intent(Popup.this, CommandActivity.class);
                startActivity(i2);
             }
        });

    }
    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}

/*
public class Popup extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("注文を確定しますか？")
                .setPositiveButton("はい", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(getActivity(), "Pressed OK", Toast.LENGTH_SHORT).show();

                        Intent intent = getIntent();
                        String[] Product_name=intent.getStringArrayExtra("Product_name");
                        ArrayList<Integer> Number_of_command = intent.getIntegerArrayListExtra("Number_of_command");
                        String Message = " ";
                        for (int i = 0; i < Product_name.length; i++) {
                            Message += Product_name[i] + " " + Number_of_command.get(i) + "個, ";
                        }

                        sendSMS("+33769452984", Message);
                        Context context = getApplicationContext();
                        CharSequence text = "Your command : " + Message + "was sent to kitchen";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Intent i = new Intent(Popup.this,EndActivity.class);
                        startActivity(i);

                    }
                })
                .setNegativeButton("いいえ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        Toast.makeText(getActivity(), "Pressed No", Toast.LENGTH_SHORT).show();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
*/


