package com.neway.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用方法
 * @author jiong.sun
 *
 */
public class StrUtil {
	/**
	 * 处理中文乱码
	 * @param str
	 * @return
	 */
	public static String convertChinessMessyCode(String str){
		String outStr="";
		try{
			outStr = new String(str.getBytes("iso-8859-1"), "utf-8");
		}catch(Exception e){
			e.printStackTrace();
		}
		return outStr;
	}
	
	
	/**
	 * 获取yyyyMMddhhmmss 格式日期字符串
	 * @param date
	 * @return
	 */
	public static String getDateToStr(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddhhmmss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	
	/**
	 * 将日期转换成yyyy.MM.dd格式
	 * @param date
	 * @return
	 */
	public static String getDateFormat(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy.MM.dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 获取 yyyy-MM-dd格式日期
	 * @param date
	 * @return
	 */
	public static String getDateFormatDate(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 获取HH:mm:ss格式 时间   24小时制
	 * @param date
	 * @return
	 */
	public static String getDateFormatTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式
	 * @param date
	 * @return
	 */
	public static String getDateFormatCurrentTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * 将输入double型数字转换成保留两位小数的字符串
	 * @param d  输入值
	 * @return
	 */
	public static String formatDouble(double d){
		DecimalFormat df=new DecimalFormat("#0.000"); 
		String f = df.format(d);
		return f;
	}
	
	/**
	 * 将输入double型数字转换成不保留小数的字符串
	 * 若输入为0，则返回空字符串
	 * @param d  输入值
	 * @return
	 */
	public static String formatDoubleToInt(double d){
		String f="";
		if(d!=0){
			DecimalFormat df=new DecimalFormat("#0"); 
			f = df.format(d);
		}
		return f;
	}
	
	/**
	 * 对于值为null 返回空，不为null则不变
	 * @param o
	 * @return
	 */
	public static String  nullToStr(Object  o){
		if(o==null || o.toString().equals("null")){
			return "";
		}else{
			return o.toString();
		}
	}
	
	/**
	 * 对于值为null 返回空，不为null则不变
	 * @param o
	 * @return
	 */
	public static String  nullToStr(Object  o,String rtn){
		if(o==null || o.toString().equals("null")){
			return rtn;
		}else{
			return o.toString();
		}
	}
	
	/**
	 * 判断值是否是0.0，若是，则返回空
	 * 否则，去除小数点
	 * @param o
	 * @return
	 */
	public static String  zeroTonull(Object  o){
		if(o.toString().equals("0.0")){
			return "";
		}else{
			return formatDoubleToInt(Double.parseDouble(o.toString()));
		}
	}
	
	/**
	 * 摄氏温度度转华氏温度
	 * @param tempC 摄氏温度字符串
	 * @return
	 */
	public  static String convertCToF(String tempC){
		//华氏温度 = 摄氏温度*9/5+32
		int tempF = Integer.parseInt(tempC.trim())*9/5+32;
		return String.valueOf(tempF);
	}
}
