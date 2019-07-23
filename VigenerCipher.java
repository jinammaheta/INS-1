
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
public class VigenerCipher {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String pl=sc.nextLine();
        pl=pl.toUpperCase();
        String key=sc.nextLine();
        key=key.toUpperCase();
        String s="";
        for(int i=0;i<pl.length();i++){
            int l1=(int)pl.charAt(i)-65;
            int l2=(int)key.charAt(i%key.length())-65;
//            System.out.println(l1+" "+l2);
            int sum=(l1+l2)%26;
//            System.out.print((sum+65)+" ");
            char ch=(char) (sum+65);
            s+=ch;
        }
        System.out.println(s);
    }
}
