import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIteratorStartAt {
	LinkedList<String> linkedList = new LinkedList<>();
	
	public LinkedListIteratorStartAt() {
		this.linkedList.add("Edward");
		this.linkedList.add("Mike");
		this.linkedList.add("John");
		this.linkedList.add("George");
	}
	
	public ListIterator linkedListIteratorStartAt(int index) {
		ListIterator literator = this.linkedList.listIterator(index);
		return literator;
	}
}
