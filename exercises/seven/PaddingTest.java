import org.junit.Test;


public class PaddingTest {

	Padding p = new Padding();
	
	@Test
	public void padTestLowerLength() {
		int num = 1234;
		System.out.println(p.pad(num, 2));
	}
	
	@Test
	public void padTestHigherLength() {
		int num = 1234;
		System.out.println(p.pad(num, 8));
	}
	
	@Test
	public void unpadTest() {
		System.out.println(p.unpad("1234~~~~~~~~~~~~"));
	}

}
