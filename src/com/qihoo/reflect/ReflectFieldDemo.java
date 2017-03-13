package com.qihoo.reflect;

import java.lang.reflect.Field;

public class ReflectFieldDemo {

	public static void main(String[] args) {
		try {
			Class c = Class.forName("com.qihoo.reflect.Food");
			System.out.println("User���ȫ·������" + c.getName());
			System.out.println("User�������" + c.getSimpleName());
			Food food = new Food();
			//��ȡ�������е�����
			Field[] fields = c.getDeclaredFields();
			for (Field f : fields) {
				//��ȡ���������η�
				System.out.println(f.getModifiers());
				//��ȡ����������
				System.out.println(f.getType().getSimpleName());
				//��ȡ������
				System.out.println(f.getName());
				//��ȡ��Ա������ֵ
				String fName = f.getName();
				//��ȡ��Ա������ֵ
				f.setAccessible(true);
				System.out.println(fName + "��ֵΪ��" + f.get(food));
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
