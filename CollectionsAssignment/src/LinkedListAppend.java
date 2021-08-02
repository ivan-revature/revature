import java.util.LinkedList;

public class LinkedListAppend {
	LinkedList<String> linkedList = new LinkedList<>();
	
	public LinkedListAppend() {
		this.linkedList.add("Samuel");
		this.linkedList.add("Seymour");
		this.linkedList.add("Seth");
	}
	
	public LinkedList<String> lnkLstAppendAtLastPos(String item) {
		this.linkedList.addLast(item);
		return this.linkedList;
	}
}
