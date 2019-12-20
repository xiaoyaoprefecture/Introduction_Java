package com.xiaoyao.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.xiaoyao.bean.User;

/**
 * 转json格式的字符串
 * @author ly
 *
 */
public class ToJsonUtils {
	public static StringBuilder getString(List<? extends Object>list) {
		StringBuilder ss=new StringBuilder();
		for(int i=0;i<list.size();i++) {
			if(i==list.size()-1) {
				ss.append(ObjectToString(list.get(i)));
			}else {
				ss.append(ObjectToString(list.get(i))+",");
			}			
		}
		return 	ss;
	}
	//将一个对象转化为Json数据格式
	public static StringBuilder ObjectToString(Object o) {
		StringBuilder ss=new StringBuilder();
		Field[] fields = o.getClass().getDeclaredFields();
		ss.append("{");
		for(int i=0;i<fields.length;i++) {
			if(i==fields.length-1) {
				ss.append("\""+fields[i].getName()+"\""+":"+"\""+getFieldValueByName(fields[i].getName(),o)+"\"");
			}else {
				ss.append("\""+fields[i].getName()+"\""+":"+"\""+getFieldValueByName(fields[i].getName(),o)+"\",");		
			}		
		}
		ss.append("}");
		return ss;
	}
	//根据属性名获取属性值
	private static Object getFieldValueByName(String FieldName,Object o) {
		try {
			String firstLetter =FieldName.substring(0,1).toUpperCase();
			String getter="get"+firstLetter+FieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value=method.invoke(o, new Object[] {});
			return value;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//定义一个方法返回Json字符串
		public static String getJson(String status, List<? extends Object>list) {
			StringBuilder  json=new StringBuilder("{");
			json.append("\"status\":\""+status+"\",");
			json.append("\"data\":[");	
			json.append(ToJsonUtils.getString(list));
			json.append("]}");
			return json.toString();
		}
}
