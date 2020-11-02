
public class SmallestDifference {

	public static void main(String[] args) {

		int arr1[] = { 1, 3, 15, 11, 2 };
		int arr2[] = { 23, 127, 235, 19 ,8};
		int l=0;
		int m=0;
		int max =Integer.MAX_VALUE;
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if(Math.abs(arr1[i]-arr2[j])< max){
					max=Math.abs(arr1[i]-arr2[j]);
					l=arr1[i];m=arr2[j];
				}
			}
		}
			System.out.println("smallest diff is "+max);
			System.out.println("values are " + l+" "+ m);

	}
}
