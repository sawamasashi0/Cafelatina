package cafelatina.my.cafelatina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("TABLENAME");
        String message2 = intent.getStringExtra("SERVERNAME");
        // Capture the layout's TextView and set the string as its text
        TextView textView1 = findViewById(R.id.tableName1);
        TextView textView2 = findViewById(R.id.serverName1);
        textView1.setText(message1);
        textView2.setText(message2);
        final LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout1);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent intent = new Intent(OrderActivity.this, CommandActivity.class);
                EditText product1_number = (EditText) findViewById(R.id.product13);
                EditText product2_number = (EditText) findViewById(R.id.product23);
                String message1 = product1_number.getText().toString();
                String message2 = product2_number.getText().toString();
                int a = Integer.parseInt(message1);
                int b = Integer.parseInt(message2);
                if(a>100 || b>100){
                    layout.removeAllViews();
                    getLayoutInflater().inflate(R.layout.layout1, layout);
                }else {
                    intent.putExtra("product1_number", message1);
                    intent.putExtra("product2_number", message2);
                    int nbProduct = 2;

                    TextView product1_name = (TextView) findViewById(R.id.product11);
                    TextView product2_name = (TextView) findViewById(R.id.product21);
                    String message3 = product1_name.getText().toString();
                    String message4 = product2_name.getText().toString();
                    intent.putExtra("product1_name", message3);
                    intent.putExtra("product2_name", message4);

                    String message100 = String.valueOf(nbProduct);
                    intent.putExtra("number of products", message100);
                    startActivity(intent);
                }
        }
    });

    }
}
