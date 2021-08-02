import java.util.LinkedList;
import java.util.Iterator;

public class Driver2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListAppend lkdLst = new LinkedListAppend();
		LinkedList<String> ll = lkdLst.lnkLstAppendAtLastPos("Anonymous");
		Iterator iterator = ll.iterator();
		
		System.out.println("Iterator sample: ");
		while( iterator.hasNext() ) {
			System.out.println(iterator.next());
		}
	}

}
