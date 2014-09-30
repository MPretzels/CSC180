import java.util.ArrayList;
import java.util.List;


public class CollectionUtils {
	
	public static int cardinality(java.lang.Object obj, java.util.Collection coll) {
		
		int count = 0;
		for (Object o : coll) {
			if (o == obj) {
				count++;
			}
		}
		
		return count;
		
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(1);
		numbers.add(3);
		
		
		System.out.println("There are " + cardinality(1, numbers) + " 1's in the collection");
	}
}