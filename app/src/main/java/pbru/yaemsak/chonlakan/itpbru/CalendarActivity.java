package pbru.yaemsak.chonlakan.itpbru;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {
    //Explicit
    private CalendarView calendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //Bind Widget
        calendarView = (CalendarView) findViewById(R.id.calendarView);

        //Active When Click Calendar
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
                confirmDialog(day, month, year);


            }
        });//setDateChange



    }//Main Method

    private void confirmDialog(int day, int month, int year) {

        String strDate = Integer.toString(day) +
                "/" + Integer.toString(month + 1) +
                "/" + Integer.toString(year);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);//no close cancel
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle(strDate);
        builder.setMessage("Note Account");


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setPositiveButton("Receivable", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(CalendarActivity.this, UploadAccount.class);
                intent.putExtra("Login", getIntent().getStringArrayExtra("Login"));
                intent.putExtra("InOut", 0);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Payable", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(CalendarActivity.this, UploadAccount.class);
                intent.putExtra("Login", getIntent().getStringArrayExtra("Login"));
                intent.putExtra("InOut", 1);
                startActivity(intent);

                dialog.dismiss();
            }
        });
        builder.show();

    }//confirmDialog

}//Main Class
