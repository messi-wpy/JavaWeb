package cn.ccnu.wpy.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConvertUtil {


    public static String getDataString(Date date){
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd");
        String str=sdf.format(date);
        return str;
    }
}
