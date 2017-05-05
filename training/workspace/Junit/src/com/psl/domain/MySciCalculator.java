package com.psl.domain;

import com.psl.exception.InfiniteValueException;

public class MySciCalculator {
		public int getPower(int i, int j){
			return (int) Math.pow(i, j);
		}
		
		public double squareRoot(int i){
			return Math.sqrt(i);
		}
		
		public int absValue(double i){
			return (int) Math.abs(i);
			
		}
		
		public double getLogValue(int i) throws InfiniteValueException{
			int a=(int) Math.log(i);
			if(a==Integer.MAX_VALUE||a==Integer.MIN_VALUE)
				
					throw new InfiniteValueException();
				
				
			return Math.log(i);
		}
}
