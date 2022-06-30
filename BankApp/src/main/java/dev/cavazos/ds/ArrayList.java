package dev.cavazos.ds;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {
	private T[] array;
	private int nextIndex;
	
	public ArrayList() {
		this.array = (T[]) new Object[3]; // How many accounts can you make from a bank? Regular account, checkings, savings
	}
	
	public ArrayList(T... values) {
		this.array = values;
	}
	
	@Override
	public void add(T t) {
		adjustSizeIfNeeded();
		
		// add the new object
		this.array[nextIndex] = t;
		nextIndex++;
	}

	@Override
	public void add(T t, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(T... t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void adjustSizeIfNeeded() {
		boolean tooSmall = (this.nextIndex >= this.array.length);
		boolean tooBig = (this.nextIndex < this.array.length/4);

		if (tooSmall || tooBig) {
			// hang on to the old array
			T[] temp = this.array;
			int newLength = this.array.length;
			
			if (tooSmall) {
				// the new length will be 1.5 * the size of the old one
				newLength = (int) Math.floor(this.nextIndex * 1.5);
			} else if (tooBig) {
				// the new length will be 1/2 the size of the old one
				newLength = (int) Math.floor(this.array.length/2);
			}
			
			// create the new array
			this.array = (T[]) new Object[newLength];
			// copy everything over from the old array
			for (int i = 0; i < this.nextIndex; i++) {
				this.array[i] = temp[i];
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(array);
		result = prime * result + Objects.hash(nextIndex);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArrayList other = (ArrayList) obj;
		return Arrays.deepEquals(array, other.array) && nextIndex == other.nextIndex;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("");
		for (int i = 0; i<this.nextIndex; i++) {
			result.append(this.array[i] + "\n");
		}
		return result.toString();
	}
}