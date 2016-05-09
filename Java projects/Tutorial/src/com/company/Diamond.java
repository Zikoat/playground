package com.company;

/**
 * Created by zik on 16.02.16.
 */
public class Diamond {

	public int size = 3;
	private int currentSize;
	private int direction = 1;

	public Diamond(int size) {
		this.size = size;
	}

	public void print(){
		currentSize = size;

		for(currentSize = 0; currentSize > -1; currentSize+=direction){

			for( int i = size; i > currentSize; i--) System.out.print(" ");

			System.out.print("O");

			for( int j = currentSize; j > 0; j--) System.out.print("OO");

			System.out.println();
			if(currentSize >= size ) direction = -1;
		}
	}

	public static void main( String args[] ){
		Diamond pyramid = new Diamond(5);
		pyramid.print();
	}
}