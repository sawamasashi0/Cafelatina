package cafelatina.my.cafelatina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EntryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
    }
    public void startOrder(View view){
        Intent intent = new Intent(this, OrderActivity.class);
        EditText tableName = (EditText) findViewById(R.id.tableName);
        EditText serverName = (EditText) findViewById(R.id.serverName);
        String message1 = tableName.getText().toString();
        String message2 = serverName.getText().toString();
        intent.putExtra("TABLENAME", message1);
        intent.putExtra("SERVERNAME", message2);
        startActivity(intent);
    }
}
