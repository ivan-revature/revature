//import java.util.LinkedList;
import java.util.Iterator;

public class Driver4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LkdLstIteratorOnReverse lkdlst = new LkdLstIteratorOnReverse();
		Iterator iterator = lkdlst.lkdLstIteratorOnReverse();
		
		System.out.println("LinkedList descending iterator sample: ");
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
