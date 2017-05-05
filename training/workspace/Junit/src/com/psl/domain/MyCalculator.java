package com.psl.domain;

import java.util.List;

import com.psl.exception.InvalidInputException;

public class MyCalculator {

	public int add(int x, int y) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x + y;
	}

	public void incr(List<Integer> lst, int val) {
		lst.add(val);
	}

	int divide(int x, int y) throws InvalidInputException {
		if (y == 0)
			throw new InvalidInputException();
		else
			return x / y;

	}
}
