package exam;

import java.util.*;

public class coupons {
	public static void main(String []args){
		Scanner sc= new Scanner(System.in);
		System.out.println("enter no of coupons to be added");
		int n=Integer.parseInt(sc.nextLine().trim());;
		HashMap<String,String> ht=new HashMap<String,String>();
		//for adding coupons
		for(int i=0;i<n;i++){
			System.out.println("enter coupons name and its details");
			String t=sc.nextLine();
			String coup[]=t.split("-");
			ht.put(coup[0],coup[1]);
		}
		System.out.println("\nto get the list of coupons\n");
		//for the list of coupons
		for(String key: ht.keySet()){
			System.out.println(key);
		}
		//to get details of a coupon
		System.out.println("\nto get the details of a coupon\n");
		for(String key: ht.keySet()){
			System.out.println(ht.get(key));
		}
	}
}
