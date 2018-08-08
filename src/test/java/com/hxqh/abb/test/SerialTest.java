package com.hxqh.abb.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerialTest {

//    public static void main(String[] args){
//
//        Long[] lon=new Long[]{54484L,442462L,1246L,215L,23L,1L};
//        for (int i = 0; i < lon.length; i++) {
//            System.out.println(setponum(lon[i]));
//        }
//    }
//    private static String setponum(Long id) {
//        StringBuffer stringBuffer = new StringBuffer().append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
//        Long poid = new Long(id);
//        int i = poid.toString().length();
//        String s = String.valueOf(poid);
//        switch (i) {
//            case 1:
//                stringBuffer.append("00").append(s);
//                break;
//            case 2:
//                stringBuffer.append("0").append(s);
//                break;
//            default:
//                String str = s.substring(i - 3, i);
//                stringBuffer.append(str);
//                break;
//        }
//
//       return  stringBuffer.toString();
//    }
}
