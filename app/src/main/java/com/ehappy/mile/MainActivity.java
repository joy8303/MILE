package com.ehappy.mile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private EditText edtMile;
    private TextView txtKm;
    private Button btnTran, toastButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtMile=(EditText)findViewById(R.id.edtMile);
        txtKm=(TextView)findViewById(R.id.txtKm);
        btnTran=(Button)findViewById(R.id.btnTran);
        toastButton = (Button) findViewById(R.id.btnTran);

        btnTran.setOnClickListener(btnTranListener);
        toastButton.setOnClickListener(btnTranListener);
    }
    //自訂義方法 觸發按鈕後啟動功能
    private Button.OnClickListener btnTranListener = new Button.OnClickListener() {
        public void onClick(View v) {

            double miles=Double.parseDouble(edtMile.getText().toString());
            double km=1.61*miles;
            txtKm.setText("時速=" + km+"公里");
            if (miles==0 || miles<0)
            Toast.makeText(v.getContext(), "顯示錯誤", Toast.LENGTH_LONG).show(); //LONG 改為 SHORT 則顯示的結果會慢慢出現...
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
