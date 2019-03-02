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
     * �Զ���map���ϣ�key����������value��[0�����д�����1����ʱ��]
     */
    public static Map<String,Long[]> methodTest = new HashMap<String, Long[]>();

	
	/**
     * ����Ҫִ�еķ���
     */
	public Object invoke(MethodInvocation invocation) throws Throwable{
		// ����һ����ʱ��
        StopWatch watch = new StopWatch();
        // ��ʱ����ʼ
        watch.start(); 
        // ִ�з���
        Object object = invocation.proceed();
        // ��ʱ��ֹͣ
        watch.stop();
        // ��������
        String methodName = invocation.getMethod().getName();
        // ��ȡ��ʱ����ʱʱ��
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
