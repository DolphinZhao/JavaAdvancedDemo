package com.qihoo.reflect;

import java.lang.reflect.Method;

public class ReflectMethodDemo {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.qihoo.reflect.Food");
			Method[] methods = c.getDeclaredMethods();
			for (Method m : methods) {
				//获取方法修饰符
				System.out.println(m.getModifiers());
				//获取方法类型
				System.out.println(m.getReturnType().getName());
				//获取方法名
				System.out.println(m.getName() + " ");
				//获取方法的参数
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
