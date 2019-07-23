
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author s16it06
 */
public class RailFence {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        int n=sc.nextInt();
        String s="";
        int c=0,l=n-1;
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<p.length();j=j+2*(n-1)){
                System.out.println(j);
                s+=p.charAt(j);
                if(i!=0&&i!=(n-1)&&c==0){
                    k=j+2*(l-1);
                    System.out.println(k);
                    s+=p.charAt(j+2*(l-1));
                    c++;
                    l--;
                }
                else if(c!=0&&k+2*(n-1)<p.length()){
                    System.out.println(k+2*(n-1));
                    s+=p.charAt(k+2*(n-1));
                    k=k+2*(n-1);
                }
//                    if(l==0){
//                        c++;
//                        System.out.println(c);
//                        l++;
//                    }
//                    System.out.println(Math.pow(2,c)+j);
//                    s+=p.charAt((int) (Math.pow(2,c)+j));
//                }
            }
            c=0;
//            l=0;
        }
        System.out.println(s);
    }
}
