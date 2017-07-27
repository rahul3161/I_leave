package example.com.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class About extends Activity {

    private TextView tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.8));

        tt=(TextView)findViewById(R.id.at);
        String htmlText = "<p> I-Leave App :</p> <p> It helps to keep track of the leaves taken by the employees of a department in a month. </p>" +
                "<p> Casual Leave:CL  Training:TR  Meeting:M </p> <p> Earned Leave:EL  Sick Leave:SL  Tour:TO </p> <p> </p> <p> Developers : </p> <p> Rahul Roy & Tuheli Bhattacharya </p> <p> </p> <p> Project Guide :</p>" +
                "<p> Arindam Bag </p>";
        tt.setText(Html.fromHtml(htmlText));
    }
}
