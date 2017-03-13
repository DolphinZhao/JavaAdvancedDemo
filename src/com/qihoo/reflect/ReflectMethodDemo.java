package com.qihoo.reflect;

import java.lang.reflect.Method;

public class ReflectMethodDemo {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.qihoo.reflect.Food");
			Method[] methods = c.getDeclaredMethods();
			for (Method m : methods) {
				//��ȡ�������η�
				System.out.println(m.getModifiers());
				//��ȡ��������
				System.out.println(m.getReturnType().getName());
				//��ȡ������
				System.out.println(m.getName() + " ");
				//��ȡ�����Ĳ���
				Class[] params = m.getParameterTypes();
				for (int i = 0; i < params.length; i++) {
					Class pc = params[i];
					System.out.println(pc.getSimpleName() + ",");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
