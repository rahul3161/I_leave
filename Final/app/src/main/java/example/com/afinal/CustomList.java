package example.com.afinal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by dell on 26-Aug-16.
 */
public class CustomList extends ArrayAdapter{
    private String[] N;
    private String[] ys1;
    private String[] ye1;
    private String[] ms1;
    private String[] me1;
    private String[] n1;
    private String[] s1;
    private String[] e1;
    private String[] r1;
    private int j,i,k,l;
    private String Bg,z1,z2,g;
    private Activity context;
    private String[] flag = new String[31];

    public void getData(String x1,String x2, String len,String n[] ,String[] s,String[] e,String[] r,String[] q1,String[] q2,String[] q3,String[] q4){
        z1=x1;
        z2=x2;
        l=Integer.parseInt(len);
        n1=new String[l];
        s1=new String[l];
        e1=new String[l];
        r1=new String[l];
        ys1=new String[l];
        ye1=new String[l];
        ms1=new String[l];
        me1=new String[l];
        for(int x=0;x<l;x++) {
            n1[x] = n[x];
            s1[x] = s[x];
            e1[x] = e[x];
            r1[x] = r[x];
            ys1[x] = q1[x];
            ye1[x] = q2[x];
            ms1[x] = q3[x];
            me1[x] = q4[x];
        }
    }
    public CustomList(Activity context, String[] N){
        super(context, R.layout.listview,N);
        this.context = context;
        this.N = N;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listview,null,true);

        Bg=N[position];
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.empNm);
        textViewName.setText(Bg);

        TextView d0 = (TextView)  listViewItem.findViewById(R.id.d0);
        TextView d29 = (TextView)listViewItem.findViewById(R.id.d29);
        TextView d30 = (TextView)listViewItem.findViewById(R.id.d30);
        TextView d31 = (TextView)listViewItem.findViewById(R.id.d31);
        switch (z1) {
            case "1":
                d0.setText("Jan" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
            case "2":
                d0.setText("Feb"+" "+z2);
                int year=Integer.parseInt(z2);
                if((year%4==0&&year%100!=0)||year%400==0)
                    d29.setText("29");
                break;
            case "3":
                d0.setText("Mar" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
            case "4":
                d0.setText("Apr" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                break;
            case "5":
                d0.setText("May" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
            case "6":
                d0.setText("June" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                break;
            case "7":
                d0.setText("July" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
            case "8":
                d0.setText("Aug" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
            case "9":
                d0.setText("Sep" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                break;
            case "10":
                d0.setText("Oct" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
            case "11":
                d0.setText("Nov" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                break;
            case "12":
                d0.setText("Dec" + " " + z2);
                d29.setText("29");
                d30.setText("30");
                d31.setText("31");
                break;
        }

        TextView t1 = (TextView)listViewItem.findViewById(R.id.m1);
        TextView t2 = (TextView) listViewItem.findViewById(R.id.m2);
        TextView t3 = (TextView) listViewItem.findViewById(R.id.m3);
        TextView t4 = (TextView) listViewItem.findViewById(R.id.m4);
        TextView t5 = (TextView) listViewItem.findViewById(R.id.m5);
        TextView t6 = (TextView) listViewItem.findViewById(R.id.m6);
        TextView t7 = (TextView) listViewItem.findViewById(R.id.m7);
        TextView t8 = (TextView) listViewItem.findViewById(R.id.m8);
        TextView t9 = (TextView) listViewItem.findViewById(R.id.m9);
        TextView t10 = (TextView) listViewItem.findViewById(R.id.m10);
        TextView t11 = (TextView) listViewItem.findViewById(R.id.m11);
        TextView t12 = (TextView) listViewItem.findViewById(R.id.m12);
        TextView t13 = (TextView) listViewItem.findViewById(R.id.m13);
        TextView t14 = (TextView) listViewItem.findViewById(R.id.m14);
        TextView t15 = (TextView) listViewItem.findViewById(R.id.m15);
        TextView t16 = (TextView) listViewItem.findViewById(R.id.m16);
        TextView t17 = (TextView) listViewItem.findViewById(R.id.m17);
        TextView t18 = (TextView) listViewItem.findViewById(R.id.m18);
        TextView t19 = (TextView) listViewItem.findViewById(R.id.m19);
        TextView t20 = (TextView) listViewItem.findViewById(R.id.m20);
        TextView t21 = (TextView) listViewItem.findViewById(R.id.m21);
        TextView t22 = (TextView) listViewItem.findViewById(R.id.m22);
        TextView t23 = (TextView) listViewItem.findViewById(R.id.m23);
        TextView t24 = (TextView) listViewItem.findViewById(R.id.m24);
        TextView t25 = (TextView) listViewItem.findViewById(R.id.m25);
        TextView t26 = (TextView) listViewItem.findViewById(R.id.m26);
        TextView t27 = (TextView) listViewItem.findViewById(R.id.m27);
        TextView t28 = (TextView) listViewItem.findViewById(R.id.m28);
        TextView t29 = (TextView) listViewItem.findViewById(R.id.m29);
        TextView t30 = (TextView) listViewItem.findViewById(R.id.m30);
        TextView t31 = (TextView) listViewItem.findViewById(R.id.m31);

        for(i=0;i<31;i++)
            flag[i]=" ";

        for(int a=0;a<l;a++){
            if(Bg.equals(n1[a]))
            {
                i = Integer.parseInt(s1[a]);
                k = Integer.parseInt(e1[a]);
                g = r1[a];
                switch (g) {
                    case "Sick":
                        g = "SL";
                        break;
                    case "Tour":
                        g = "TO";
                        break;
                    case "Casual":
                        g = "CL";
                        break;
                    case "Earned":
                        g = "EL";
                        break;
                    case "Training":
                        g = "TR";
                        break;
                    case "Meeting":
                        g = "M";
                        break;
                }
                if(!ys1[a].equals(ye1[a]))
                {
                    if(ys1[a].equals(z2))
                    {
                        for(j=i-1;j<31;j++)
                        {
                            flag[j]=g;
                        }
                    }
                    else
                    {
                        for(j=0;j<k;j++)
                        {
                            flag[j]=g;
                        }
                    }
                }
                else if(!ms1[a].equals(me1[a]))
                {
                    if(ms1[a].equals(z1))
                    {
                        for(j=i-1;j<31;j++)
                        {
                            flag[j]=g;
                        }
                    }
                    else
                    {
                        for(j=0;j<k;j++)
                        {
                            flag[j]=g;
                        }
                    }
                }
                else
                {
                    for (j = i - 1; j < k; j++)
                    {
                        flag[j] = g;
                    }
                }
            }
        }
        t1.setText(flag[0]);
        t2.setText(flag[1]);
        t3.setText(flag[2]);
        t4.setText(flag[3]);
        t5.setText(flag[4]);
        t6.setText(flag[5]);
        t7.setText(flag[6]);
        t8.setText(flag[7]);
        t9.setText(flag[8]);
        t10.setText(flag[9]);
        t11.setText(flag[10]);
        t12.setText(flag[11]);
        t13.setText(flag[12]);
        t14.setText(flag[13]);
        t15.setText(flag[14]);
        t16.setText(flag[15]);
        t17.setText(flag[16]);
        t18.setText(flag[17]);
        t19.setText(flag[18]);
        t20.setText(flag[19]);
        t21.setText(flag[20]);
        t22.setText(flag[21]);
        t23.setText(flag[22]);
        t24.setText(flag[23]);
        t25.setText(flag[24]);
        t26.setText(flag[25]);
        t27.setText(flag[26]);
        t28.setText(flag[27]);
        t29.setText(flag[28]);
        t30.setText(flag[29]);
        t31.setText(flag[30]);

        return listViewItem;
    }

}
