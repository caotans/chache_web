package com.ct.common;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @Author:ct
 * @Date:2018-3-28,16:23
 * @Description:
 */
public class JsonExchange {
    /**
     * 将 List 对象编码为 JSON格式
     *
     * @param objList 待封装的对象集合
     * @return String:封装后JSONArray String格式
     * @version 1.0
     * @date 2015-10-11
     * @Author zhou.wenkai
     */
    private static<T> String listToJson(List<T> objList) {
        final StringBuilder sb = new StringBuilder();
        for (T t : objList) {
            if(t instanceof String) {
                sb.append(stringToJson((String) t));
                sb.append(",");
            } else if(t instanceof Boolean ||
                    t instanceof Integer ||
                    t instanceof Float ||
                    t instanceof Double) {
                sb.append(t);
                sb.append(",");
            } else {
                sb.append(objectToJson(t));
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 将 String 对象编码为 JSON格式，只需处理好特殊字符
     *
     * @param str String 对象
     * @return String:JSON格式
     * @version 1.0
     * @date 2015-10-11
     * @Author zhou.wenkai
     */
    private static String stringToJson(final String str) {
        if(str == null || str.length() == 0) {
            return "\"\"";
        }
        final StringBuilder sb = new StringBuilder(str.length() + 2 << 4);
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            final char c = str.charAt(i);

            sb.append(c == '\"' ? "\\\"" : c == '\\' ? "\\\\"
                    : c == '/' ? "\\/" : c == '\b' ? "\\b" : c == '\f' ? "\\f"
                    : c == '\n' ? "\\n" : c == '\r' ? "\\r"
                    : c == '\t' ? "\\t" : c);
        }
        sb.append('\"');
        return sb.toString();
    }
    /**
     * 将 对象编码为 JSON格式
     *
     * @param t 待封装的对象
     * @return String: 封装后JSONObject String格式
     * @version 1.0
     */
    public static <T> String toJson(T t) {
        if (t == null) {
            return "{}";
        }
        return objectToJson(t);
    }
    /**
     * 将 对象编码为 JSON格式
     *
     * @param t 待封装的对象
     * @return String: 封装后JSONObject String格式
     * @version 1.0
     * @date 2015-10-11
     * @Author zhou.wenkai
     */
    private static <T> String objectToJson(T t) {


        Field[] fields = t.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder(fields.length << 4);
        sb.append("{");

        for (Field field : fields) {
            field.setAccessible(true);
            Class<?> type = field.getType();
            String name = field.getName();

            // 'this$Number' 是内部类的外部类引用(指针)字段
            if(name.contains("this$")) continue;

            String typeName = type.getName();
            if(typeName.equals("java.lang.String")) {
                try {
                    sb.append("\""+name+"\":");
                    sb.append(JsonExchange.stringToJson((String)field.get(t)));
                    sb.append(",");
                } catch (Exception e) {

                        e.printStackTrace();
                }
            } else if(typeName.equals("boolean") ||
                    typeName.equals("java.lang.Boolean") ||
                    typeName.equals("int") ||
                    typeName.equals("java.lang.Integer") ||
                    typeName.equals("float") ||
                    typeName.equals("java.lang.Float") ||
                    typeName.equals("double") ||
                    typeName.equals("java.lang.Double") ||
                    typeName.equals("long") ||
                    typeName.equals("java.lang.Long")) {
                try {
                    sb.append("\""+name+"\":");
                    sb.append(field.get(t));
                    sb.append(",");
                } catch (Exception e) {

                        e.printStackTrace();
                }
            } else if(typeName.equals("java.util.List") ||
                    typeName.equals("java.util.ArrayList")){
                try {
                    List<?> objList = (List<?>) field.get(t);
                    if(null != objList && objList.size() > 0) {
                        sb.append("\""+name+"\":");
                        sb.append("[");
                        String toJson =JsonExchange. listToJson((List<?>) field.get(t));
                        sb.append(toJson);
                        sb.setCharAt(sb.length()-1, ']');
                        sb.append(",");
                    }
                } catch (Exception e) {

                        e.printStackTrace();
                }
            } else {
                try {
                    sb.append("\""+name+"\":");
                    sb.append("{");
                    sb.append(objectToJson(field.get(t)));
                    sb.setCharAt(sb.length()-1, '}');
                    sb.append(",");
                } catch (Exception e) {

                        e.printStackTrace();
                }
            }

        }
        if(sb.length() == 1) {
            sb.append("}");
        }
        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }
}
