package pbru.yaemsak.chonlakan.itpbru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    //Explicit
    private EditText nameEditText,
                     surnameEditText,
                     userEditText,
                     passwordEditText;

    private String nameString,
                   surnameString,
                   userString,
                   passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind Widget
        nameEditText = (EditText) findViewById(R.id.editText);
        surnameEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(R.id.editText3);
        passwordEditText = (EditText) findViewById(R.id.editText4);




    }//Main Method

    public void clickSignUpSign(View view) {

        nameString = nameEditText.getText().toString().trim();
        surnameString = surnameEditText.getText().toString().trim();
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        //check Space
        if (checkSpace()) {
            //True



        } else {
            //False




        }


    }//click SignUp

    private boolean checkSpace() {

        boolean result = true;

        result = surnameString.equals("")||
                 surnameString.equals("") ||
                 nameString.equals("") ||
                 passwordString.equals("");

        return result;
    }//checkSpace


}//Main Class