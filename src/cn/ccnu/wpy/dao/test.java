package cn.ccnu.wpy.dao;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        String html=null;
        try {
            FileInputStream in=new FileInputStream("/home/messi-lp/IDEA/untitled1/src/cn/ccnu/wpy/dao/score.html");
            byte[]bytes=new byte[1024];
            int i=0;
            StringBuilder sb=new StringBuilder();
            while ((i=in.read(bytes))!=-1){
                sb.append(new String(bytes));
            }
            html=sb.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("<td valign=\"middle\">【 平时 】</td>.+?<td valign=\"middle\">(\\d+)%&nbsp;</td>.+?<td valign=\"middle\">(\\d+)&nbsp;</td>", Pattern.DOTALL);
        Matcher m = p.matcher(html);
        if (m.find()){
            System.out.println(m.group(1)+" "+m.group(2));
        }

    }
}
