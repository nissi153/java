package java_ex100;

public class ex100_95 {
	public static void main(String[] args) {
		//????? 26?
		int[] counts = new int[26];
		//counts[0] <- a??
		//counts[1] <- b??
		// ??? ?? ????
		//oh! my god!
		String str = "oh! my god!";
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c >= 'a' && c <= 'z' )
			{
				int index = c - 97;//a -> 0
				System.out.println("i"+index);
				counts[index]++;
			}
		}
		for(int i=0; i<counts.length; i++) {
			System.out.println((char)('a'+i)+
					":"+ counts[i]);
		}
		
		
	}

}
