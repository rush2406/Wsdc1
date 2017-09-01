package com.example.rusha.wsdc1;

import android.location.Address;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by rusha on 02-09-2017.
 */
class det{
    private String name;
    private String address;
    public void setName(String s)
    {
        name=s;
    }
    public void setAddress(String s)
    {
        address=s;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }

}
public class Utils {
    public static String toJson()
    {

        try{
            JSONArray array=new JSONArray();
            for(int i=0;i<3;i++) {
                det D=new det();
                D.setName("Hello");
                D.setAddress("Hi");
                JSONObject object = new JSONObject();
                object.put("name", D.getName());
                object.put("address", D.getAddress());
                array.put(object);
            }
            return array.toString();

        }catch (JSONException j)
        {
          Log.v(Utils.class.getSimpleName(),"Error");
        }
        return null;
    }
}
