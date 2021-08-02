import java.util.LinkedList;

public class Driver5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListInsertAt lkdLst = new LinkedListInsertAt();
		int insertAt = 1;
		LinkedList<String> ll = lkdLst.lkdLstInsertAt("Anonymous", insertAt);
		
		System.out.println("LinkedList after add at " + insertAt + ": ");
		
		for(String name:ll) {
			System.out.println("Name: " + name);
		}
	}

}
