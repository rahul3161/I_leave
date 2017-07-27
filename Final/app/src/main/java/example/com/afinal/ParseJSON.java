package example.com.afinal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by dell on 26-Aug-16.
 */
public class ParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] sy;
    public static String[] sm;
    public static String[] sd;
    public static String[] ey;
    public static String[] em;
    public static String[] ed;
    public static String[] text1;
    public static int len;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_IDS = "empid";
    public static final String KEY_NAME = "name";
    public static final String KEY_sy = "sy";
    public static final String KEY_sm = "sm";
    public static final String KEY_sd = "sd";
    public static final String KEY_ey = "ey";
    public static final String KEY_em = "em";
    public static final String KEY_ed = "ed";
    public static final String KEY_TEXT1 = "text1";

    private JSONArray leaves = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            leaves = jsonObject.getJSONArray(JSON_ARRAY);
            len = leaves.length();
            ids = new String[leaves.length()];
            names = new String[leaves.length()];
            sy = new String[leaves.length()];
            sm = new String[leaves.length()];
            sd = new String[leaves.length()];
            ey = new String[leaves.length()];
            em = new String[leaves.length()];
            ed = new String[leaves.length()];
            text1 = new String[leaves.length()];

            for (int i=0;i<leaves.length();i++){
                JSONObject jo = leaves.getJSONObject(i);
                ids[i] = jo.getString(KEY_IDS);
                names[i] = jo.getString(KEY_NAME);
                sy[i] = jo.getString(KEY_sy);
                sm[i] = jo.getString(KEY_sm);
                sd[i] = jo.getString(KEY_sd);
                ey[i] = jo.getString(KEY_ey);
                em[i] = jo.getString(KEY_em);
                ed[i] = jo.getString(KEY_ed);
                text1[i] = jo.getString(KEY_TEXT1);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
