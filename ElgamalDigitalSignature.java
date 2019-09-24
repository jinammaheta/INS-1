/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /**********************************************************************************************
 Sample Input
---------------------------------------------------------------------------------------------
Step 1:Public/ Private Keys Generation 
Enter q
16
Enter XA,such that 1 < XA < q-1
14
Step 2:Digital Signature
Message with hash value m , such that m is an integer in the range0 <= m <= q -1. :
12
Enter K value random  Choose a random integer K such that 1 <= K <= q - 1 
4
[1, 0, 15] [0, 1, 4] 
Step 3: Verification
[1, 0, 15] [0, 1, 4] 
4 4
1 1
Verification Completed, Signature is Valid
***********************************************************************************************/

/**
 *
 * @author JayGoga
 */
import java.math.BigInteger;
import java.util.*;
public class ElgamalDigitalSignature {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Step 1:Public/ Private Keys Generation ");
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter q");
        BigInteger qt=new BigInteger(sc.next());
//        int q=qt.intValue();
        int c=0;
        String justc="";
        ArrayList<BigInteger> a=new ArrayList<>();
        BigInteger kk=BigInteger.ONE;
//        System.out.println(new BigInteger(2+"").compareTo(qt));
        for(BigInteger i=new BigInteger(2+"");i.compareTo(qt)<0;i=i.add(kk)){
            BigInteger n1=qt;
//            System.out.println("hahda"+i);System.out.println("hahda");
            BigInteger n2=i,n3=i;
            while(!n1.equals(n2)){
//                System.out.println("hhk");
                if(n1.compareTo(n2)>0){
                    n1=n1.subtract(n2);
//                    System.out.println("n1 g"+n1);
                }
                else if(n1.compareTo(n2)<0){
                    n2=n2.subtract(n1);
//                    System.out.println("n2 g"+n2);
                }
            }
//            int g=(n*n3)/n1;
//            System.out.println("hahda");
            if(n1.equals(BigInteger.ONE)){
            a.add(i);
//            System.out.println(i);
            c++;
            }
        }
//        System.out.println(c);
        ArrayList<BigInteger> check=new ArrayList<>();
        BigInteger alpha = BigInteger.ONE;
        int flag=0;
        for(BigInteger j:a){
            check.clear();
//            System.out.println("LIST:"+check);
//            System.out.println(j);
            
//            BigInteger lj=new BigInteger(j+"");
//            BigInteger li=BigInteger.ONE;
            BigInteger i2;
            BigInteger one=BigInteger.ONE;
            for(i2=one;i2.compareTo(new BigInteger(c+"").add(one))<0;i2=i2.add(one)){
//                BigInteger li=new BigInteger(i2+"");
//                /=i+"";
//                int val=1;
//                for(int k=1;k<=i;k++){
//                        val=(val*j)%n;
//                    }
                BigInteger val=BigInteger.ONE;
                 val=(j.modPow(i2,qt));
//                val=(lj.pow(i)).mod(new BigInteger(q+""));
//                System.out.println(i2+" "+val);
                if(check.contains(val)){
//                    System.out.println("Same");
                    flag=1;
                    break;
                }
                check.add(val);
            }
            if(flag==0){
                alpha=j;
//                justc=justc+alpha+" ";
//                System.out.println(alpha);
                break;
            }
            flag=0;
        }
//        System.out.println("asa"+justc);
//        System.out.println("");
//        System.out.println("alpha: "+alpha);
//        alpha=new BigInteger(10+"");
        System.out.println("Enter XA,such that 1 < XA < q-1");
        BigInteger XA=new BigInteger(sc.next());
        BigInteger YA=BigInteger.ONE;
        YA=alpha.modPow(XA, qt);
//        System.out.println("YA"+YA);
        System.out.println("Step 2:Digital Signature");
        System.out.println("Message with hash value m , such that m is an integer in the range0 <= m <= q -1. :");
        BigInteger m=new BigInteger(sc.next());
        System.out.println("Enter K value random  Choose a random integer K such that 1 <= K <= q - 1 ");
        BigInteger k=sc.nextBigInteger();
        BigInteger valid=kinverse(qt.subtract(BigInteger.ONE),k,1);
        while(!valid.equals(BigInteger.ONE)){
        System.out.println("Enter K value random  Choose a random integer K such that 1 <= K <= q - 1 ");
            System.out.println("Note: gcd(K, q - 1) = 1");
            k=sc.nextBigInteger();
            valid=kinverse(qt.subtract(BigInteger.ONE),k,1);
        }
//        BigInteger k=new BigInteger(random.nextInt(qt.intValue())+"");
//        BigInteger k=new BigInteger(rand+"");
//        System.out.println(k);
        BigInteger SA=BigInteger.ONE;
        BigInteger SB=BigInteger.ONE;
        
        System.out.println("Step 3: Verification");
        BigInteger kinvere=BigInteger.ONE;
        SA=alpha.modPow(k, qt);
//        System.out.println(new BigInteger("12").pow(-1);
//        kinvere=k.modPow(new BigInteger("0").subtract(new BigInteger("1")), (qt.subtract(new BigInteger("1"))));
//        kinvere=new BigInteger("1").divide(k);
//        kinvere=k.modInverse(qt.subtract(BigInteger.ONE));
//        k=new BigInteger(5+"");
        kinvere=kinverse(qt.subtract(BigInteger.ONE),k,0);
        System.out.println(k+" "+kinvere);
        
//        System.out.println(kinvere);
        SB=kinvere.multiply(m.subtract(XA.multiply(SA))).mod(qt.subtract(new BigInteger("1")));
//        System.out.println(SB);
        BigInteger VA=BigInteger.ONE;
        BigInteger VB=BigInteger.ONE;
        VA=alpha.modPow(m, qt);
        VB=(YA.modPow(SA, qt).multiply(SA.modPow(SB, qt))).mod(qt);
        System.out.println(VA+" "+VB);
        if(VA.equals(VB)){
            System.out.println("Verification Completed, Signature is Valid");
        }
        else{
            System.out.println("Verification Completed, Signature is Valid");
        }
    }
    public static BigInteger kinverse(BigInteger m,BigInteger b,int id){
         ArrayList<BigInteger> A=new ArrayList<>();
        A.add(BigInteger.ONE);
        A.add(BigInteger.ZERO);
        A.add(m);
        ArrayList<BigInteger> B=new ArrayList<>();
        B.add(BigInteger.ZERO);
        B.add(BigInteger.ONE);
        B.add(b);
        int flag=0;
        int ni=0;
        System.out.println(A+" "+B+" ");
        while(flag!=1){
        if(B.get(2).equals(BigInteger.ZERO)){
            flag=1;
            ni=1;
            break;
        }
        if(B.get(2).equals(BigInteger.ONE)){
            flag=1;
            break;
        }
        BigInteger Q;
        Q=A.get(2).divide(B.get(2));
        ArrayList<BigInteger> T=new ArrayList<>();
        T.add(BigInteger.ZERO);
        T.add(BigInteger.ZERO);
        T.add(BigInteger.ZERO);
//            System.out.println(A+" "+B+" "+T);
        for(BigInteger i=BigInteger.ZERO;i.compareTo(new BigInteger(T.size()+""))<0;i=i.add(BigInteger.ONE)){
            T.set(i.intValue(), A.get(i.intValue()).subtract(Q.multiply(B.get(i.intValue()))));
        }
//        T.add(A.get(0).subtract(Q.multiply(B.get(0))));
//        T.add(A.get(1).subtract(Q.multiply(B.get(1))));
//        T.add(A.get(2).subtract(Q.multiply(B.get(2))));
        for(BigInteger i=BigInteger.ZERO;i.compareTo(new BigInteger(A.size()+""))<0;i=i.add(BigInteger.ONE)){
            A.set(i.intValue(), B.get(i.intValue()));
        }
//        A.addAll(B);
        for(BigInteger i=BigInteger.ZERO;i.compareTo(new BigInteger(B.size()+""))<0;i=i.add(BigInteger.ONE)){
            B.set(i.intValue(), T.get(i.intValue()));
        }
//        B.addAll(T);
//        B.replaceAll(T);
//        System.out.println(A+" "+B+" "+T);
        }
        if(id==0){
        return B.get(1);
        }
        else if(id==1&&ni==1){
            return A.get(2);
        }
        else{
          return B.get(2);
          }
    }
        
    
}
