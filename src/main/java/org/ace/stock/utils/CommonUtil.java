package org.ace.stock.utils;

public class CommonUtil {

	public static float obj2float(Object obj, float defVal) {
		return obj==null ? defVal : str2float(obj.toString(), defVal);
	}
	
	public static int str2int(String str, int defVal) {
		int result = defVal;
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {
		}
		return result;
	}
	
	public static float str2float(String str, float defVal) {
		float result = defVal;
		try {
			result = Float.parseFloat(str);
		} catch (Exception e) {
		}
		return result;
	}
	
	/**
	 * 最两位小数
	 * @param value
	 * @return
	 */
	public static float round2(float value) {
		return Math.round(value*100)/100f;
	} 
	
	public static double round2(double value) {
		return Math.round(value*100.0);
	} 
	
	/**
	 * 获取盈亏
	 * @return
	 */
	public static float getEarning(float currentPrice, float myPrice, int count){
		return CommonUtil.round2((currentPrice - myPrice) * count);
	}
	
	public static void main(String[] args) {
		System.out.println(0.77f);
	}
}
