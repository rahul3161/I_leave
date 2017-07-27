package example.com.afinal;

/**
 * Created by dell on 25-Aug-16.
 */
public class Configu {

    //URL to our login.php file
    public static final String LOGIN_URL = "http://ioclapp.16mb.com/login.php";

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMPOYEEID = "employeid";
    public static final String KEY_PASSWORD = "password";

    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "myloginapp";

    //This would be used to store the email of current logged in user
    public static final String EMPLOYEE_SHARED_PREF = "employeid";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";

}
