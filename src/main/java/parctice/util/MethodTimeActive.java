package parctice.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang3.time.StopWatch;

public class MethodTimeActive implements MethodInvocation {

	@Override
	public Object[] getArguments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccessibleObject getStaticPart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getThis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object proceed() throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Method getMethod() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
     * 自定义map集合，key：方法名，value：[0：运行次数，1：总时间]
     */
    public static Map<String,Long[]> methodTest = new HashMap<String, Long[]>();

	
	/**
     * 拦截要执行的方法
     */
	public Object invoke(MethodInvocation invocation) throws Throwable{
		// 创建一个计时器
        StopWatch watch = new StopWatch();
        // 计时器开始
        watch.start(); 
        // 执行方法
        Object object = invocation.proceed();
        // 计时器停止
        watch.stop();
        // 方法名称
        String methodName = invocation.getMethod().getName();
        // 获取计时器计时时间
        Long time = watch.getTime();
        if(methodTest.containsKey(methodName)) {
            Long[] x = methodTest.get(methodName);
            x[0]++;
            x[1] += time;
        }else{
            methodTest.put(methodName, new Long[] {1L,time});
        }
        return object;

	}

}
