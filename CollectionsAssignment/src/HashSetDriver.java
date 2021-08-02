import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hsNames = new HashSet<String>();
		
		hsNames.add("Edward");
		hsNames.add("Mike");
		hsNames.add("George");
		hsNames.add("Markus");
		
		HashSetFunctions hashSetFn = new HashSetFunctions(hsNames);
		hashSetFn.hashSetAddItemAtEnd(hsNames,"Anonymous");
		
		hashSetFn.hashSetIterate();
		System.out.println("Count: " + hashSetFn.hashSetItemCount());
		hashSetFn.hashSetClearAll();
		System.out.println("Count: " + hashSetFn.hashSetItemCount());
	}

}
