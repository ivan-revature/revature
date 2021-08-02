import java.util.LinkedList;
import java.util.ListIterator;

public class Driver3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListIteratorStartAt iteratorAtIndex = new LinkedListIteratorStartAt();
		
		int startAt = 1;
		ListIterator iteratorList = iteratorAtIndex.linkedListIteratorStartAt(startAt);
		
		System.out.println("ListIterator sample: (starting at pos " + startAt + ")");
		while(iteratorList.hasNext()) {
			System.out.println(iteratorList.next());
		}
	}

}
