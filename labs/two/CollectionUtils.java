import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;


public class CollectionUtils<T> {
	
	public static int cardinality(java.lang.Object obj, java.util.Collection coll) {
		
		int count = 0;
		for (Object o : coll) {
			if (o == obj) {
				count++;
			}
		}
		
		return count;
		
	}
	
	public static <T> Collection<T> filter(Collection<T> coll, Predicate<T> p) {
		List<T> newColl = new ArrayList<T>();
		for (T t : coll) {
			if(p.evaluate(t)) {
				newColl.add(t);
			}
		}
		return newColl;
	}
	
	
}