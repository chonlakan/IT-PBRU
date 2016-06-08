package pbru.yaemsak.chonlakan.itpbru;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //Explicit
    private MyManage myManage;
    private static final String urlJson = "http://swiftcodingthai.com/pbru2/get_user_master.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(this);

        //Test Add new User
        //myManage.addNewUser("11", "name", "surn", "user", "pass");

        deleteAllSQLite();
        mySynJSON();

    }//Main Method

    private void mySynJSON() {
        ConnectedUserTABLE connectedUserTABLE = new ConnectedUserTABLE(this);
        connectedUserTABLE.execute();

    }

        //Create Inner Class
    private class ConnectedUserTABLE extends AsyncTask<Void, Void, String> {

        private Context context;

        private ProgressDialog progressDialog;//

        public ConnectedUserTABLE(Context context) {
            this.context = context;
        }//Constructor

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(context, "Synchronize Server",
                                        "Please Wait... Process Synchronize");

        }//onpre

        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJson).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();

            } catch (Exception e) {
                Log.d("7June", "error DoIn ==>" + e.toString());
                return null;
            }
        }//doInBackGround

        @Override   //ดึงข้อมูล
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                try {
                    progressDialog.dismiss();
                    Log.d("7June", "JSON ==> " + s);

                    JSONArray jsonArray = new JSONArray(s);

                    String[] idStrings = new String[jsonArray.length()];
                    String[] nameStrings = new String[jsonArray.length()];
                    String[] surnameStrings = new String[jsonArray.length()];
                    String[] userStrings = new String[jsonArray.length()];
                    String[] passwordStrings = new String[jsonArray.length()];

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        idStrings[i] = jsonObject.getString("id");
                        nameStrings[i] = jsonObject.getString(MyManage.column_name);
                        surnameStrings[i] = jsonObject.getString(MyManage.column_surname);
                        userStrings[i] = jsonObject.getString(MyManage.column_user);
                        passwordStrings[i] = jsonObject.getString(MyManage.column_password);

                        myManage.addNewUser(idStrings[i], nameStrings[i],
                                surnameStrings[i], userStrings[i], passwordStrings[i]);



                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }



        }//onPost

    }//Connected Class


    private void deleteAllSQLite() {
        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper
                .database_name, MODE_PRIVATE, null);
        sqLiteDatabase.delete(MyManage.user_table, null, null);

    }//Delete All Data SQLite

    public void clickSignUpMain(View view) {

        startActivity(new Intent(MainActivity.this,SignUpActivity.class));

    }


}//Main Class