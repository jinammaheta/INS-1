
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
public class HillCipher {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String p=sc.nextLine();
        int a[][]=new int[4][4];
        int b[]=new int[3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                a[i][j]=sc.nextInt();
            }
        }
        String s="";
        int c=0,l=0;
        while(c<p.length()){
        for(int i=c;l<3;i++){
            a[l][3]=((int)p.charAt(i))-97;
            System.out.println(a[l][3]);
            l++;
        }
        l=0;
//        for(int i=0;i<3;i++){
//            b[i]=0;
//            for(int j=0;j<3;j++){
//                if(i%2==0&&j%2==0){
//                    b[i]+=a[i][j]*a[j][3];
//                }
//                else if(i%2==0&&j%2!=0){
//                    b[i]-=a[i][j]*a[j][3];
//                }
//                else if(i%2!=0&&j%2==0){
//                    b[i]-=a[i][j]*a[j][3];
//                }
//                else{
//                    b[i]+=a[i][j]*a[j][3];
//                }
//            }
//            System.out.println(b[i]);
//        }
        for(int i=0;i<3;i++){
            b[i]=0;
            for(int j=0;j<3;j++){
                b[i]+=a[i][j]*a[j][3];
            }
            b[i]=b[i]%26;
            char ch=(char)(b[i]+65);
            s+=ch;
        }
        c=c+3;
        }
        System.out.println(s);
    }
   
}
