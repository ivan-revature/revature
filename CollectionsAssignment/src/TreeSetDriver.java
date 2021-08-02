import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;


public class TreeSetDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		
		list.add("Navy blue");
		list.add("Passion red");
		list.add("Blood orage");
		list.add("Pitch black");
		list.add("Blue green");
		list.add("Stark brown");
		list.add("Light yellow");
		list.add("Ivory white");
		list.add("Silvery gray");
	
		Collection<String> coll = list;
		
		TreeSet<String> tSet = new TreeSet<String>(coll);
		System.out.println(tSet);
		TreeSetFunctions tSetFn = new TreeSetFunctions(tSet);
		tSetFn.treeSetIterator();
		tSetFn.copyTreeSet();
		tSetFn.treeSetReverseOrder();
		tSetFn.treeSetFirstAndLastItems();
		
	}

}
