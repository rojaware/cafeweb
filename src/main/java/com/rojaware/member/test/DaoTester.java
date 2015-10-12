package com.rojaware.member.test;

import java.lang.reflect.Field;

public class DaoTester {

	public DaoTester() {
		super();
	}
	public static void display(Object abc)
	{
		display(abc, false);

	}
	public static void display(Object abc, boolean hasValue)
	{
		for (Field field : abc.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			Object value = null;
			try {
				value = field.get(abc);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (hasValue)
			{
				if (value != null)
				{	
					System.out.printf(" %s: %s%n", name, value);
				}
			}else
			{
				System.out.printf(" %s: %s%n", name, value);
			}
		}

	}
}