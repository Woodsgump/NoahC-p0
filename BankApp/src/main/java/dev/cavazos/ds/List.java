package dev.cavazos.ds;

public interface List<T> {
	/**
	 * Adds an element to the end of the list.
	 * 
	 * @param t the object to be added into the list
	 */
	public void add(T t);
	
	/**
	 * Adds an element to a specific index in the list, 
	 * moving all following elements back.
	 * 
	 * @param t the object to be added into the list
	 * @param index the index where the object will be placed
	 */
	public void add(T t, int index);
	
	/**
	 * Adds an array or comma-separated list of values 
	 * to the end of the list.
	 * 
	 * @param t the objects to be added into the list
	 */
	public void addAll(@SuppressWarnings("unchecked") T... t);
	
	/**
	 * Retrieves an element from a specified index.
	 * 
	 * @param index the index of the desired element
	 * @return the element at the specified index
	 */
	public T get(int index);
	
	/**
	 * Returns the index of the first instance of the 
	 * specified object in the list. The .equals method 
	 * is used to determine whether the object is the 
	 * one that is being searched for.
	 * 
	 * @param t the object being searched for
	 * @return the index of the specific object in the list
	 */
	public int indexOf(T t);
	
	/**
	 * Returns whether a specified object exists in the list. 
	 * The .equals method is used for this.
	 * 
	 * @param t the object being searched for
	 * @return true if the object is in the list, false otherwise
	 */
	public boolean contains(T t);
	
	/**
	 * Removes the first instance of the specified object in the list 
	 * and returns the object. The .equals method is used to find 
	 * the object.
	 * 
	 * @param t the object to be removed from the list
	 * @return the object that was removed
	 */
	public T remove(T t);
	
	/**
	 * Removes the object at the specified index from the list and 
	 * returns the object.
	 * 
	 * @param index the index of the object to be removed
	 * @return the object that was removed
	 */
	public T remove(int index);
	
	/**
	 * Returns the number of elements currently in the list.
	 * 
	 * @return the number of elements in the list
	 */
	public int size();

}