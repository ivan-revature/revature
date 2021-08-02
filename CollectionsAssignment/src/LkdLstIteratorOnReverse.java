import java.util.LinkedList;
import java.util.Iterator;

public class LkdLstIteratorOnReverse {
	LinkedList<String> linkedList = new LinkedList<>();
	
	public LkdLstIteratorOnReverse() {
		this.linkedList.add("Edward");
		this.linkedList.add("Mike");
		this.linkedList.add("George");
		this.linkedList.add("Markus");
	}
	
	public Iterator<String> lkdLstIteratorOnReverse() {
		return this.linkedList.descendingIterator();
	}
}
