package ds;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<T> implements List<T> {
	private T[] array;
	private int nextIndex;
	
	public ArrayList() {
		this.array = (T[]) new Object[4];
	}
	
	public ArrayList(T... values) {
		this.array = values;
	}
	
	@Override
	public void add(T obj) {
		adjustSizeIfNeeded();
		
		//add the new object
		this.array[nextIndex] = obj;
		nextIndex++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(array);
		result = prime * result + nextIndex;
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
		if (!Arrays.deepEquals(array, other.array))
			return false;
		if (nextIndex != other.nextIndex)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("");
		for(int i = 0; i<this.nextIndex; i++) {
			result.append(this.array[i] + "\n";)
		}
		return result.toString();
	}
	
}
