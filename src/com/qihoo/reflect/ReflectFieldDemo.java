package com.qihoo.reflect;

import java.lang.reflect.Field;

public class ReflectFieldDemo {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.qihoo.reflect.Food");
			System.out.println("User类的全路径类名" + c.getName());
			System.out.println("User类的类名" + c.getSimpleName());
			Food food = new Food();
			//获取类中所有的属性
			Field[] fields = c.getDeclaredFields();
			for (Field f : fields) {
				//获取变量的修饰符
				System.out.println(f.getModifiers());
				//获取变量的类型
				System.out.println(f.getType().getSimpleName());
				//获取变量名
				System.out.println(f.getName());
				//获取成员变量的值
				String fName = f.getName();
				//获取成员变量的值
				f.setAccessible(true);
				System.out.println(fName + "的值为：" + f.get(food));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
