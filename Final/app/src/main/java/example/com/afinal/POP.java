package example.com.afinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by dell on 26-Aug-16.
 */
public class POP extends Activity{
    private String[] month = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private Spinner dp1,dp2;
    private ArrayList<String> years = new ArrayList<String>();
    private static String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));

        dp1 = (Spinner)findViewById(R.id.sp1);
        dp2 = (Spinner) findViewById(R.id.sp2);

        for(int i=2000;i<=2050;i++)
        {
            years.add(Integer.toString(i));
        }

        ArrayAdapter<CharSequence> Ad1 = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,month);
        Ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dp1.setAdapter(Ad1);

        ArrayAdapter<String> Ad2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,years);
        Ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dp2.setAdapter(Ad2);
    }

    public void show1(View v){
        s1=dp1.getSelectedItem().toString();
        s2=dp2.getSelectedItem().toString();
        switch(s1){
            case "January":s1="1";
                break;
            case "February":s1="2";
                break;
            case "March":s1="3";
                break;
            case "April":s1="4";
                break;
            case "May":s1="5";
                break;
            case "June":s1="6";
                break;
            case "July":s1="7";
                break;
            case "August":s1="8";
                break;
            case "September":s1="9";
                break;
            case "October":s1="10";
                break;
            case "November":s1="11";
                break;
            case "December":s1="12";
                break;
        }
        Intent i = new Intent(POP.this, calendar.class);
        i.putExtra("z1",s1);
        i.putExtra("z2",s2);
        startActivity(i);
    }
}

