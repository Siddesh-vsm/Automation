
public class StringCompress {

	
	public static void main(String[] args) {
		String s1 = "abbbcaaaaw";
		int count = 0;
		String s2 = "";

		for (int i = 0; i < s1.length() - 1; i++) {

			if (s1.charAt(i) == s1.charAt(i + 1)) {
				count++;
			} else {

				if (count == 0) {
					s2 = s2 + s1.charAt(i);
				} else {
					s2 = s2 + s1.charAt(i) + (count + 1);
					count = 0;
				}
			}
			if (i == s1.length() - 2) {

				if (count == 0) {
					s2 = s2 + s1.charAt(i + 1);
				} else {
					s2 = s2 + s1.charAt(i + 1) + (count + 1);
					count = 0;
				}
			}
		}
		System.out.println(s2);
	}
}
