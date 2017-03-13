package com.qihoo.reflect;

public class ReflectClass {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Food food1 = new Food();
		//1
		Class class1 = Food.class;
		//2
		Class class2 = food1.getClass();
		//3
		Class class3 = Class.forName("com.qihoo.reflect.Food");
		//Í¨¹ý
		Food food = (Food) class1.newInstance();
	}
	
}
