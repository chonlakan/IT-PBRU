package pbru.yaemsak.chonlakan.itpbru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UploadAccount extends AppCompatActivity {

    //Explicit
    private TextView inOutTextView , nameTextView;
    private Spinner spinner;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_account);

        //Bind Widget
        inOutTextView = (TextView) findViewById(R.id.textView6);
        nameTextView = (TextView) findViewById(R.id.textView7);
        spinner = (Spinner) findViewById(R.id.spinner);
        editText = (EditText) findViewById(R.id.editText7);

        
    }//main method

    public void clickUpload(View view) {



    }//clickUpload

    public void clickCancel(View view) {
        finish();
    }//clickCancel

}//main class
