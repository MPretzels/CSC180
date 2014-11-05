
public class Padding {
	
	private int charNum = 31;
	private char emptyChar = '\u1000';
	private char testValue = 0x03;
	private char nonPrintChar = Character.valueOf((char) charNum);
	
	public String pad(Object obj, int len) {

		StringBuilder sb = new StringBuilder();
		String input = obj.toString();
		if (len < input.length()) {
			return input.substring(0, len);
		} else if (len > input.length()) {
			
			while (len > input.length()) {
				sb.append(nonPrintChar);
				len--;
			}
			return input.concat(sb.toString());
		}
		return input;
	}
	
	public Object unpad(String str) {
		str.replace(testValue, emptyChar);
		return str;
	}
	
	public <T> T unpad(String str, Class<T> clazz) {
		str.replace((char) 0x03, emptyChar);
		return (T) clazz;
	}
}
