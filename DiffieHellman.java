import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class DiffieHellman {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter N:");
        BigInteger n=sc.nextBigInteger();
        ArrayList<BigInteger> a=new ArrayList<>();
        BigInteger kk=BigInteger.ONE;
        int c=0;
//        System.out.println(new BigInteger(2+"").compareTo(qt));
        for(BigInteger i=new BigInteger(1+"");i.compareTo(n)<0;i=i.add(kk)){
            BigInteger n1=n;
//            System.out.println("hahda"+i);System.out.println("hahda");
            BigInteger n2=i,n3=i;
            while(!n1.equals(n2)){
                if(n1.compareTo(n2)>0){
                    n1=n1.subtract(n2);
                }
                else if(n1.compareTo(n2)<0){
                    n2=n2.subtract(n1);
                }
            }
            if(n1.equals(BigInteger.ONE)){
            a.add(i);
            c++;
            System.out.println(i);
            }
        }
         ArrayList<BigInteger> check=new ArrayList<>();
        BigInteger alpha = BigInteger.ONE;
        int flag=0;
        for(BigInteger j:a){
            check.clear();
            BigInteger i2;
            BigInteger one=BigInteger.ONE;
            for(i2=one;i2.compareTo(new BigInteger(c+"").add(one))<0;i2=i2.add(one)){
                BigInteger val=BigInteger.ONE;
                 val=(j.modPow(i2,n));
                if(check.contains(val)){
                    flag=1;
                    break;
                }
                check.add(val);
            }
            if(flag==0){
                alpha=j;
                break;
            }
            flag=0;
        }
        System.out.println(alpha);
        int XA = n.intValue()-((int)Math.round((Math.random())*(n.intValue())));
        int XB= n.intValue()-((int)Math.round((Math.random())*(n.intValue())));
        BigInteger YA=alpha.modPow(new BigInteger(XA+""), n);
        BigInteger YB=alpha.modPow(new BigInteger(XB+""), n);
        BigInteger KA=YB.modPow(new BigInteger(XA+""), n);
        BigInteger KB=YA.modPow(new BigInteger(XB+""), n);
        System.out.println(KA+" "+KB);
        if(KA.equals(KB)){
            System.out.println("Verify");
        }
        else{
            System.out.println("Not Verified");
        }
    }

}

