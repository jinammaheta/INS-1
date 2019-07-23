
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
public class RSA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int p,q,m,e=0,N,TN;

        p=sc.nextInt();
        q=sc.nextInt();
//        for(int i=2;i<p/2;i++){
//            
//        }
        m=sc.nextInt();
        N=p*q;
        TN=(p-1)*(q-1);
        for(int i=2;i<=TN;i++){
            int check=gcd(i,TN);
            if(check==1){
                e=i;
                break;
            }
        }
        System.out.println(e);
        int d;
        for(int i=1;;i++){
            d=(1+(i*TN))%e;
//            System.out.println(d+" "+i);
            if(d==0&&d<TN){
                d=(1+(i*TN))/e;
                break;
            }
        }
        System.out.println(d);
        System.out.println("Encryption");
//        int c=(int) Math.pow(m, e)%N;
        double c=1;
        for(int i=1;i<=e;i++){
            c=(c*m)%N;
        }
        System.out.println(c);
        System.out.println("Decryption");
        double de=1;
        for(int i=1;i<=d;i++){
            de=(de*c)%N;
        }
        System.out.println(de);
    }
    public static int gcd(int n1,int n2) {
        if(n2%n1==0){
            return n1;
        }
        else{
            return 1;
        }
    }
}
