package cn.ccnu.wpy.util;

import com.google.gson.Gson;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConvertUtil {
    public static Gson gson=new Gson();

    public static String getDataString(Date date){
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd");
        String str=sdf.format(date);
        return str;
    }
}
