package com.algorithm.sort;

public class heap {
   static int[] a={0,4,5,2,3,6,1};

   static void swap(int i,int j)
   {
       int t=a[i];
       a[i]=a[j];
       a[j]=t;
   }
    public static  void adjust(int id,int n)
    {
        if(id*2<=n&&a[id*2]>a[id])
        {
           swap(id*2,id);
           adjust(id*2,n);
        }
        if(id*2+1<=n&&a[id*2+1]>a[id])
        {
            swap(id*2+1,id);
            adjust(id*2+1,n);
        }
    }
   public static void build(int n)
   {

       for(int i=n/2;i>=1;i--) {
           adjust(i, n);
       }

   }
   public static   void run(int n)
   {
       build(n);

       for(int i=n;i>1;i--)
       {
           swap(1,i);
           adjust(1,i-1);
       }
   }
    public static void main(String[] args) {
        run(6);
        for(int i=1;i<=6;i++)
        {
            System.out.println(a[i]);
        }

    }
}
