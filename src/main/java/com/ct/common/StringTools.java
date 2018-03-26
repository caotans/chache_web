package com.ct.common;

public class StringTools {

    public  static  String StringIsNull(Object obj){
        String result=null;
        if(obj instanceof String){
                if(obj==null){
                    result= "";
                }else{
                    result=obj.toString();

                }
        }
        return result;
    }
}
