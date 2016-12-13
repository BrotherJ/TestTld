package com.neway.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ͨ�÷���
 * @author jiong.sun
 *
 */
public class StrUtil {
	/**
	 * ������������
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
	 * ��ȡyyyyMMddhhmmss ��ʽ�����ַ���
	 * @param date
	 * @return
	 */
	public static String getDateToStr(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddhhmmss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	
	/**
	 * ������ת����yyyy.MM.dd��ʽ
	 * @param date
	 * @return
	 */
	public static String getDateFormat(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy.MM.dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��ȡ yyyy-MM-dd��ʽ����
	 * @param date
	 * @return
	 */
	public static String getDateFormatDate(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��ȡHH:mm:ss��ʽ ʱ��   24Сʱ��
	 * @param date
	 * @return
	 */
	public static String getDateFormatTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ��ȡyyyy-MM-dd HH:mm:ss��ʽ
	 * @param date
	 * @return
	 */
	public static String getDateFormatCurrentTime(Date date){
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=sdf.format(date);
		return dateTime;
	}
	
	/**
	 * ������double������ת���ɱ�����λС�����ַ���
	 * @param d  ����ֵ
	 * @return
	 */
	public static String formatDouble(double d){
		DecimalFormat df=new DecimalFormat("#0.000"); 
		String f = df.format(d);
		return f;
	}
	
	/**
	 * ������double������ת���ɲ�����С�����ַ���
	 * ������Ϊ0���򷵻ؿ��ַ���
	 * @param d  ����ֵ
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
	 * ����ֵΪnull ���ؿգ���Ϊnull�򲻱�
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
	 * ����ֵΪnull ���ؿգ���Ϊnull�򲻱�
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
	 * �ж�ֵ�Ƿ���0.0�����ǣ��򷵻ؿ�
	 * ����ȥ��С����
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
	 * �����¶ȶ�ת�����¶�
	 * @param tempC �����¶��ַ���
	 * @return
	 */
	public  static String convertCToF(String tempC){
		//�����¶� = �����¶�*9/5+32
		int tempF = Integer.parseInt(tempC.trim())*9/5+32;
		return String.valueOf(tempF);
	}
}
