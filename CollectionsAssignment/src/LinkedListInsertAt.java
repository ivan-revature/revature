import java.util.LinkedList;

public class LinkedListInsertAt {
	LinkedList<String> linkedList = new LinkedList<>();
	
	public LinkedListInsertAt() {
		this.linkedList.add("Edward");
		this.linkedList.add("Mike");
		this.linkedList.add("George");
		this.linkedList.add("Markus");
	}
	
	public LinkedList<String> lkdLstInsertAt(String item, int index) {
		this.linkedList.add(index, item);
		return this.linkedList;
	}
}
