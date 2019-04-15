package mapClasses;

import java.util.ArrayList;
import java.util.Comparator;

import treeClasses.LinkedBST;
import interfaces.Entry;
import interfaces.Map;
import positionalStructures.Position;

public class BSTMap<K, V> implements Map<K, V> {
	// the binary search tree supporting this implementation of the map
	private LinkedBST<K, V> tree;   	

	/**
	 * Creates an instance of BSTMap. 
	 * @param cmp the comparator of keys that is received and which shall
	 * be used to compare keys of entries. 
	 */
	public BSTMap(Comparator<K> cmp) { 
		tree = new LinkedBST<>(cmp); 
	}

	@Override
	/**
	 * the size of the map is the size of the tree. 
	 */
	public int size() {
		return tree.size();
	}

	@Override
	/** 
	 * the map is empty iff the tree is empry
	 */
	public boolean isEmpty() {
		return tree.isEmpty();
	}

	@Override
	/**
	 * Get operation of the map. 
	 */
	public V get(K key) {
		// for for the entry having given key in the tree, if any
		Entry<K, V> result = tree.get(key); 

		// if not found, return null
		if (result == null) return null; 

		// if found, the value of the element that matches the search.
		return result.getValue();
	}


	@Override
	/**
	 * put of the map...
	 */
	public V put(K key, V value) {

		// ADD CODE HERE AS PART OF EXERCISE 1.
		if(tree.isEmpty()) {
			tree.add(key, value);
			return null;
		}
		else if(tree.getAll(key).isEmpty()) {
			tree.add(key, value);
			return null;
		}
		ModifiableEntry<K, V> result = (ModifiableEntry<K, V>) tree.get(key); 

		V val = result.getValue();
		

		return val;
	}

	@Override
	/**
	 * remove of the map
	 */
	public V remove(K key) {

		if(tree.get(key).equals(null)) {
			return null;
		}

		Entry<K,V> etr = tree.remove(key);



		return etr.getValue();     // SUBSTITUE THIS STATEMENT WITH YOUR CODE NEEDED FOR THIS OPERATION
		// AS PART OF EXERCISE 1.
	}

	@Override
	public Iterable<K> keySet() {
		ArrayList<K> keys = new ArrayList<>();
		// ADD CODE HERE AS PART OF EXERCISE 2. 
		// USE THE FACT THE THE LINKED BINARY TREE IS ITERABLE of its elements!
		return keys; 
	}

	@Override
	public Iterable<V> values() {
		// ADD CODE HERE AS PART OF EXERCISE 2. 
		// USE THE FACT THE THE LINKED BINARY TREE IS ITERABLE of its elements!
		return null;   // NEED TO CHANGE THIS STATEMENT TOO
	}

	@Override
	public Iterable<Entry<K, V>> entrySet() {
		// ADD CODE HERE AS PART OF EXERCISE 2.
		// USE THE FACT THE THE LINKED BINARY TREE IS ITERABLE of its elements!
		return null;  // NEED TO CHANGE THIS STATEMENT TOO
	}

	public void displayMAPTree() {   // This operation has been added just for testing
		this.tree.display();
	}

}
