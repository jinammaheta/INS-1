//# d={"a":"d","b":"e","c":"f"}
//# s="Abc abc"
//# s1=s.lower()
//# s2=""
//# l=[];
//# for i in s1:
//#     if(i!=" "):
//#         s2+=d.get(i)
//#     else:
//#         s2+=" "
//# prints(s2)
//
//def wc(s):
//    l2=['E','T','A','O','I','N','S','R','H','D','L','U','C','M','F','Y','W','G','P','B','V','K','X','Q','J','Z']
//    s=s.lower();
//    count={}
//    rev={}
//    l1=[]
//    for i in s:
//        if(ord(i)>96 and ord(i)<123):
//            count[i]=s.count(i)
//    print(count)    
//    for i,k in sorted(count.items(),key= lambda a:a[1],reverse=True):
//        rev[i]=k
//        l1.append(i)
//    print(l1)    
//    for i,k in zip(l1,l2):
//        s=s.replace(i,k)
//    print(s)
//#s="it was disclosed yesterday that several inform but direct contacts have been made with political representative of the viet cong in moscow"
//s="UZ QSO VUOHXMOPV ZPEVSGZWS ZOPF PESXUDB METSXATZ VUE PHZHMD ZHMDZSHZ OWSF PAPP DTSV PQUZ WYMXUZUHS XEPYEPOPDZSZUFP OM BZW PFUP ZHMD JU DTMOHMQ"
//wc(s)