package parctice.util;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.sun.crypto.provider.AESParameters;

public class TestTimeUtil {

	private static Logger log = Logger.getLogger(TestTimeUtil.class);
	
	public static void testPerformance(String pName, Class pClass, String pMethodName, int[] arr) {
		
		long wBegTim = System.currentTimeMillis();
		try {
			Method wMethod = pClass.getMethod(pMethodName, arr.getClass());
			wMethod.invoke(pClass.newInstance(), arr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long wEndTim = System.currentTimeMillis();
		if (isSort(arr) == false) {System.out.println("没有排序好");};
		long exec = wEndTim - wBegTim;
		log.debug(pName + "执行时间：" + exec + "ms");
		
		

	}
	
	private static boolean isSort(int[] array) {
		int length = array.length;
		
		for (int i = 1; i < length; i++) {
			if (array[i] < array[i-1]) 
				return false;
		}
		return true;
	}

}
