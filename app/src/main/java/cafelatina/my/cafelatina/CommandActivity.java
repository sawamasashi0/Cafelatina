package cafelatina.my.cafelatina;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CommandActivity extends AppCompatActivity {
    ArrayList<String> l0;
    ArrayList<Integer> l1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_command);

        Intent intent = getIntent();

        String message1 = intent.getStringExtra("product1_number");
        String message2 = intent.getStringExtra("product2_number");

        String message3 = intent.getStringExtra("product1_name");
        String message4 = intent.getStringExtra("product2_name");

        String nbProducts = intent.getStringExtra("number of products");

        //合計を計算する。
        int a = Integer.parseInt(message1);
        int b = Integer.parseInt(message2);
        int sum = a * 200 + b * 300;
        TextView textView7 = findViewById(R.id.textView7);
        textView7.setText(String.valueOf(sum));
        //注文する商品を画面に表示する。
        int nb = Integer.parseInt(nbProducts);
        //商品名と注文した個数の2つのList, l0,l1を作る。
        l0 = new ArrayList<String>();
        l0.add(message3);
        l0.add(message4);
        l1 = new ArrayList<Integer>();
        l1.add(a);
        l1.add(b);

        ViewGroup vg = (ViewGroup) findViewById(R.id.TableLayout1);
        String k0;
        int k1;
        for (int i = 0; i < l0.size(); i++) {
            k0 = l0.get(i);
            k1 = l1.get(i);
            //商品数が0個以上注文された場合、画面にそれらの商品を表示する。
            if (k1 != 0) {
                // 行を追加
                getLayoutInflater().inflate(R.layout.table_row, vg);
                // 文字設定
                TableRow tr = (TableRow) vg.getChildAt(i);
                String str0 = String.valueOf(k0);
                String str1 = String.valueOf(k1);
                ((TextView) (tr.getChildAt(0))).setText(str0);
                ((TextView) (tr.getChildAt(1))).setText(str1);
            } else {
                l0.remove(i);
                l1.remove(i);
            }
        }

        Button popup = findViewById(R.id.button3);
        popup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(CommandActivity.this,Popup.class);
                intent2.putExtra("Product_name",l0);
                intent2.putExtra("Number_of_command",l1);
                startActivity(intent2);
            }
        });
    }

}
