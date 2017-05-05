package com.exceptions;

public class NotEnoughItems extends Exception{
			public NotEnoughItems(String msg) {
				System.out.println(msg);
			}
}
