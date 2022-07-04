package dev.cavazos.ds;

import java.util.Arrays;
import java.util.Objects;

/**
 * Establishing an ArrayList of data structures for the data banking application (if possible).
 * 
 * @author Noah Cavazos
 *
 */
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
	public void add(T obj, int index) {
		adjustSizeIfNeeded();
		
		for (int i = this.nextIndex-1; i>=index; i--) {
			this.array[i+1] = this.array[i];
		}
		
		this.array[index] = obj;
		nextIndex++;	
	}

	@Override
	public void addAll(T... objs) {
		for (T obj : objs) {
			this.add(obj);
		}
	}

	@Override
	public T get(int index) {
		if (index>=0 && index < this.nextIndex) {
			return this.array[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(T obj) {
		for (int i = 0; i < this.nextIndex; i++) {
			if (obj==null) {
				if (this.array[i]==null) return i;
			} else if (obj.equals(this.array[i])) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(T obj) {
		for (T element : this.array) {
			if (obj==null) {
				if (element==null) return true;
			} else if (obj.equals(element)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T remove(T obj) {
		int index = this.indexOf(obj);
		if (index != -1) {
			return this.remove(index);
		}
		return null;
	}

	@Override
	public T remove(int index) {
		if (index>=0 && index < this.array.length) {
			T obj = this.array[index];
			// shift everything over
			for (int i=index; i<this.array.length-1; i++) {
				this.array[i] = this.array[i+1];
			}
			// shift the last item over
			this.array[this.array.length-1]=null;
			this.nextIndex--;
			return obj;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {
		return this.nextIndex;
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