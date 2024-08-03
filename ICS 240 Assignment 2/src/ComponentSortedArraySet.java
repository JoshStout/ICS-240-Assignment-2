/**
 * The <CODE>ComponentSortedArraySet</CODE> Java class for Component data type collection.
 * It represents a sorted order of electronic component stored in an array. It is first sorted
 * by alphabetical order by type then by size. Duplicates are not stored. 
 */

import java.util.Iterator;

public class ComponentSortedArraySet implements Iterable<Component> {
	
	//Invariant of the ComponentSortedArraySet class:
	// 1. numComponent is an integer that represents the number of Components.
	// 2. data is the array containing the Component objects.
	
	private int numComponent; 
	private Component[] data;
	
	/**
	 * Constructor for [ComponentSortedArraySet] object.
	 * @param maxNum the maximum number of Component elements that can be stored in the collection.
	 * @exception IllegalArgumentException indicates the input value is negative. 
	 */
	public ComponentSortedArraySet(int maxNum) {
		if(maxNum < 0) {
			throw new IllegalArgumentException("max capacity is negative: " + maxNum);
		}
		numComponent = 0;
		data = new Component[maxNum];
	}
	
	/**
	 * method instantiate objects of Component type and inserted it in the collection.
	 * @param type the electronic component type.
	 * @param size the electrical property size.
	 * @precondition will not add if new Component is already in the collection.
	 * @postcondition will be placed in sorted order within the collection.
	 */
	public void add(String type, int size) {
		Component c = new Component(type, size);
		int pos = 0;
		
		//don't add if new Component is a duplicate
		for(int i = 0; i < numComponent; i++) {
			if(this.data[i].equals(c)) {
				return;
			}
		}
		
		//find the correct place for new Component
		while(this.data[pos] != null && this.data[pos].compareTo(c) < 0 && pos < this.numComponent) {
			pos++;
		}
		
		//make a hole for the new Component
		for(int i = numComponent; i > pos; i--) {
			this.data[i] = this.data[i-1];
		}
		
		//put new Component in the hold
		this.data[pos] = c;
		numComponent++;
	}
	
	/**
	 * find the amount of Component objects in the collection.
	 * @return an integer representing the size of the collection.
	 */
	public int size() {
		return numComponent;
	}
	
	/**
	 * toString Override method.
	 * @return a String representation of the collection
	 * 		in a tabular format.
	 */
	public String toString() {
		String output = "\n";
		output += "Type";
		output += "\t\t";
		output += "Size";
		output += "\n";
		output += "---------------------";
		output += "\n";
		for(int i = 0; i < numComponent; i++) {
			if(data[i] != null) {
				output += data[i].toString();
				output += "\n";
			}
		}
		output += "\n";
		return output;
	}
	
	/**
	 * method that returns the an integer that represents the
	 * array index where the input element is found.
	 * @param c Component object to search for within the collection.
	 * @return integer representing the index where the input element is found, returns -1 if not found.
	 */
	public int indexOf(Component c) {
		int pos = 0;
		while(this.data[pos] != null) {
			if(this.data[pos].equals(c)) {
				return pos;
			}
			pos++;
		}
		return -1;
	}
	
	/**
	 * modification method to remove the Component object from collection.
	 * @param c the Component element to be removed.
	 * @return returns true if object was removed, false if not found in collection.
	 * @postcondition all indexes after the removed element will be moved forward 
	 * 		to prevent any holes in the array.  
	 */
	public boolean remove(Component c) {
		int pos = 0;
		
		//find target
		while(pos < this.numComponent && !this.data[pos].equals(c)) {
			pos++;
		}
		
		if(pos == numComponent) {
			return false;
		}else {
			//if found, fill the hole
			for(int i = pos; i < numComponent -1; i++) {
				this.data[i] = this.data[i+1];
			}
			numComponent--;
			return true;
		}
	}
	
	/**
	 * returns the element at the index specified by the input value
	 * @param index the index at which to retrieve the element.
	 * @return the Component object at the input index.
	 */
	public Component grab(int index) {
		return this.data[index];
	}
	
	/**
	 * modification method to replace an object if found within the collection. The new 
	 * Component object will be added in sorted order, regardless of the location of the
	 * Component object being replaced.
	 * @param oldComponent the Component object to be replaced within the collection.
	 * @param newComponent the new Component object to be added to the collection.
	 * @return true if a replacement was made.
	 * @precondition the object to be replaced must be found within the collection or
	 * 		the new Component object will not be added.
	 * @postcondition the new Component object will be added in sorted order.
	 */
	public boolean replace(Component oldComponent, Component newComponent) {
		if(this.indexOf(oldComponent) != -1) {
			this.remove(oldComponent);
			this.add(newComponent.getType(), newComponent.getSize());
			return true;
		}
		return false;
	}
	
	/**
	 * method to compare if input set is equal
	 * @param cSet a ComponentSortedArraySet collection to be compared.
	 * @return true of both sets are equal.
	 */
	public boolean equals(ComponentSortedArraySet cSet) {
		if(this.numComponent != cSet.size()) {
			return false;
		}
		for(int i = 0; i < numComponent; i++) {
			if(!this.data[i].equals(cSet.data[i])) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * a static method to sum all the size values within the collection.
	 * @param cSet the ComponentSortedArraySet collection to sum its size values.
	 * @return the sum of all size values within the collection.
	 */
	public static int total(ComponentSortedArraySet cSet) {
		int result = 0;
		for(int i = 0; i < cSet.size(); i++) {
			result += cSet.data[i].getSize();
		}
		return result;
	}
	
	/**
	 * iterator method
	 */
	@Override
	public Iterator<Component> iterator() {
		return new ComponentSortedArraySetIterator();
	}
	
	public class ComponentSortedArraySetIterator implements Iterator<Component>{
		private int cursor = 0;
		

		@Override
		public boolean hasNext() {
			boolean output = false;
			if(cursor < numComponent) {
				output = true;
			}
			return output;
		}

		@Override
		public Component next() {
			Component output = data[cursor];
			cursor++;
			return output;
		}		
	}
}
