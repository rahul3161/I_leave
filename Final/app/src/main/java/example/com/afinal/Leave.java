package example.com.afinal;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class Leave extends Activity {

    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private Button button;
    private String text1,text2,empid;
    private String[] Reason = {"Sick Leave","Tour","Casual Leave","Training","Meeting","Earned Leave"};
    private String[] Type = {"Forenoon","Afternoon","Full Day"};
    private int year, month, day, d1, d2, m1, m2, y1, y2, flag;
    private Spinner dropdown1,dropdown2;
    private TextView textView;
    private static final String STORE_URL = "http://ioclapp.16mb.com/store.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        dateView=(TextView) findViewById(R.id.textView);
        showDate(year,month+1,day);
        dropdown1 = (Spinner)findViewById(R.id.spinner1);
        dropdown2 = (Spinner)findViewById(R.id.spinner2);
        //textView = (TextView) findViewById(R.id.textVie);
        Intent i = getIntent();
        empid = i.getStringExtra("we");
        //textView.setText(empid);
        Toast.makeText(Leave.this, empid, Toast.LENGTH_LONG).show();

        ArrayAdapter<CharSequence> Adapter1 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,Reason);
        Adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown1.setAdapter(Adapter1);

        ArrayAdapter<CharSequence> Adapter2 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,Type);
        Adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown2.setAdapter(Adapter2);

        //done.setOnClickListener(this);
    }

    @SuppressWarnings("deprecation")
    public void setDateFrom(View view) {
        dateView=(TextView) findViewById(R.id.textView1);
        button=(Button) findViewById(R.id.button1);
        switch (view.getId())
        {
            case R.id.button1: flag=1;
                break;
            case R.id.button2: flag=2;
                break;
        }
        showDialog(999);
    }
    @SuppressWarnings("deprecation")
    public void setDateTo(View view) {
        dateView=(TextView) findViewById(R.id.textView2);
        button=(Button) findViewById(R.id.button2);
        switch (view.getId())
        {
            case R.id.button1: flag=1;
                break;
            case R.id.button2: flag=2;
                break;
        }
        showDialog(999);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2+1, arg3);
        }
    };
    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
        switch(flag){
            case 1: y1=year; m1=month; d1=day;
                break;
            case 2: y2=year; m2=month; d2=day;
                break;
            default:
                // Toast.makeText(this,"Enter Inputs", Toast.LENGTH_SHORT).show();
        }

    }

    public void done(View v)
    {
        if(d1==0){
            Toast.makeText(getApplicationContext(),"Select DateTo",Toast.LENGTH_SHORT).show();
        }
        else if(d2==0){
            d2=d1; m2=m1; y2=y1;
        }
        else if(d1>d2 && m1==m2 && y1==y2){
            Toast.makeText(getApplicationContext(),"DateTo cannot be Larger Than DateFrom",Toast.LENGTH_SHORT).show();
        }
        else if(m1>m2 && y1==y2){
            Toast.makeText(getApplicationContext(),"Starting Month cannot be Larger than ending Month",Toast.LENGTH_SHORT).show();
        }
        else if(y1>y2){
            Toast.makeText(getApplicationContext(),"Starting Year cannot be Larger than ending Year",Toast.LENGTH_SHORT).show();
        }
        else
        {
            text1 = dropdown1.getSelectedItem().toString();
            text2 = dropdown2.getSelectedItem().toString();
            String sy = Integer.toString(y1);
            String sm = Integer.toString(m1);
            String sd = Integer.toString(d1);
            String ey = Integer.toString(y2);
            String em = Integer.toString(m2);
            String ed = Integer.toString(d2);
            Toast.makeText(this,sd, Toast.LENGTH_SHORT).show();
            //  String empid=textView.getText().toString().trim().toLowerCase();
            if((text1=="Earned Leave"||text1=="Sick Leave")&&(text2=="Forenoon"||text2=="Afternoon")) {
                AlertDialog alertDialo = new AlertDialog.Builder(
                        Leave.this).create();
                alertDialo.setTitle("Alert");
                alertDialo.setMessage("This Leaves Can Only Be Full Day");

                alertDialo.setCanceledOnTouchOutside(true);
                alertDialo.show();
            }
            else
                register(empid,sy,sm,sd,ey,em,ed,text1,text2);
            //  register(sy,sm,sd,ey,em,ed,text1,text2,empid);
            //database storage...
        }
    }

    private void register(String empid,String sy,String sm,String sd,String ey,String em,String ed,String text1,String text2) {

        String urlSuffix ="?empid="+empid+"&sy="+sy+"&sm="+sm+"&sd="+sd+"&ey="+ey+"&em="+em+"&ed="+ed+"&text1="+text1+"&text2="+text2;
        Toast.makeText(getApplicationContext(), empid, Toast.LENGTH_LONG).show();
        class StoreUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            AlertDialog Builder;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Leave.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                AlertDialog alertDialog = new AlertDialog.Builder(
                        Leave.this).create();
                alertDialog.setMessage(s);

                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();
            /*    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setMessage(s);
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();*/
                //   Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();


            }
            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(STORE_URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();
                    Log.i("hhh",result);
                    return result;

                } catch (Exception e) {
                    return null;
                }
            }
        }
        StoreUser ru = new StoreUser();
        ru.execute(urlSuffix);
    }
}

