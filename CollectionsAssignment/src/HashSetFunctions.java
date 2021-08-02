// 1. Write a Java program to:
// append the specified element to the end of a hash set. 
// iterate through all elements in a hash list.
// get the number of elements in a hash set.
// empty an hash set.
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetFunctions {
	HashSet<String> hashSet = new HashSet<String>();
	LinkedHashSet<String> lHashSet = new LinkedHashSet<String>();
    
    public HashSetFunctions(HashSet<String> set) {
    	// Take hash set and set instance HashSet set
    	// equal to it
    	this.hashSet = set;
    }
    
    public void hashSetAddItemAtEnd(HashSet<String> hset, String item) {
    	LinkedHashSet<String> lhSet = new LinkedHashSet<String>();
    	Iterator<String> iterator = hset.iterator();
    	while(iterator.hasNext()) 
    		this.lHashSet.add(iterator.next());
    	lHashSet.add(item);
    	this.hashSet = lHashSet;
    }
    
    public void hashSetIterate() {
    	Iterator<String> iterator = lHashSet.iterator();
    	while(iterator.hasNext()) {
    		System.out.println(iterator.next());
    	}
    }
    
    public int hashSetItemCount() {
    	return this.hashSet.size();
    }
    
    public void hashSetClearAll() {
    	lHashSet.clear();
    	this.hashSet = lHashSet;
    }
}
