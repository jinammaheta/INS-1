import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int n=sc.nextInt();
        ArrayList<ArrayList<String>> a=new ArrayList<ArrayList<String>>();
        ArrayList<Integer> st=new ArrayList<Integer>();
        int i=0,k=0,c=0,l=0;
        for(int j=0;j<s.length();){
            if(!st.contains(c)){
                st.add(c);
                a.add(new ArrayList<String>());
            }
            // System.out.println(c+" "+j);
            a.get(c).add(s.charAt(j)+"");
            j++;
            System.out.println(c);
            if(l==0)    
                c++;
            else
                c--;
            if(c==n){
                c+=-2;
                // System.out.println(c);
                l=1;
            }
            else if(c==0){
                c=0;
                l=0;
            }
        }
        System.out.println(a);
	}
}
