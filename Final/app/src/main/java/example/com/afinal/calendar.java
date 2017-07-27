package example.com.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class calendar extends AppCompatActivity {

    private static String sm;
    private static String sy,t;
    private static int l,o;
    private static String[] ys;
    private static String[] ye;
    private static String[] ms;
    private static String[] me;
    private static String[] r;
    private static String[] n;
    private static String[] e;
    private static String[] s;
    private static String[] N = {"Animesh Sanyal","Goutam Chakraborty","Subrata Das","Kalpana Verma Samajpati","Subhankar Chakraborty","Rudra Narayan Biswas","Arindam Bag","Anuj Kumar Vats","Swapan Gangopadhyay","Amita Basu"};
    private ListView listView;
    private static final String JSON_URL = "http://ioclapp.16mb.com/json.php?sm=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        listView = (ListView) findViewById(R.id.listView);
        Intent m = getIntent();
        sm=m.getStringExtra("z1");
        sy=m.getStringExtra("z2");
        sendRequest();
    }
    private void sendRequest() {

        String url=JSON_URL+sm+"&sy="+sy;

        StringRequest stringRequest = new StringRequest(Request.Method.GET ,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(calendar.this, error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        l =ParseJSON.len;
        ys=new String[l];
        ye=new String[l];
        ms=new String[l];
        me=new String[l];
        n=new String[l];
        s=new String[l];
        e=new String[l];
        r=new String[l];
        for(o=0;o<l;o++){
            ys[o] = ParseJSON.sy[o];
            ye[o] = ParseJSON.ey[o];
            ms[o] = ParseJSON.sm[o];
            me[o] = ParseJSON.em[o];
            n[o] = ParseJSON.names[o];
            s[o] = ParseJSON.sd[o];
            e[o] = ParseJSON.ed[o];
            r[o] = ParseJSON.text1[o];
        }
        t = Integer.toString(l);
        CustomList cl = new CustomList(this,N);
        cl.getData(sm,sy,t,n,s,e,r,ys,ye,ms,me);
        listView.setAdapter(cl);
    }

}
