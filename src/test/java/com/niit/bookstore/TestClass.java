package com.niit.bookstore;

import java.util.UUID;

public class TestClass {
	public static void main(String[] args) {
		
		System.out.println(UUID.randomUUID().toString().substring(24).toUpperCase());
	}
}
