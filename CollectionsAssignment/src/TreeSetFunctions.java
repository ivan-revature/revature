import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetFunctions {
	TreeSet<String> treeSet = new TreeSet<String>();
	TreeSet<String> treeSet2 = new TreeSet<String>();
	
	public TreeSetFunctions(TreeSet<String> tSet) {
		this.treeSet = tSet;
	}
	
	public void treeSetIterator() {
		Iterator iterator = this.treeSet.iterator();
		int i=0;
		while(iterator.hasNext()) {
			System.out.print("Item: " + i++ + " ");
			System.out.println(iterator.next());
		}
	}
	
	public void copyTreeSet() {
		Object obj = this.treeSet.clone();
		this.treeSet2 = (TreeSet<String>)obj;
		Iterator<String> iterator = this.treeSet2.iterator();
		int i = 0;
		System.out.println("\nTreeSet2: ");
		while(iterator.hasNext()) {
			System.out.print("Item: " + i++ + " ");
			System.out.println(iterator.next());
		}
	}
	
	public void treeSetReverseOrder() {
		Iterator<String> iterator = this.treeSet.descendingIterator();
		int i = this.treeSet.size();
		System.out.println("\nTreeSet (descending): ");
		while(iterator.hasNext()) {
			System.out.print("Item: " + --i + " ");
			System.out.println(iterator.next());
		}
	}
	
	public void treeSetFirstAndLastItems() {
		System.out.println("\nFirst: " + this.treeSet.pollFirst());
		System.out.println("Last: " + this.treeSet.pollLast());
	}
}
