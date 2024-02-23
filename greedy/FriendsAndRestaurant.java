
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static final Random random = new Random();

    public static void main(String[] args) throws IOException {
        FastReader in=new FastReader();
        int tests = in.nextInt();
        while (tests-- > 0) {
        long n=in.nextLong();
        List<Pair> ls=new ArrayList<>();
        List<Long> x=new ArrayList<>();
        List<Long> y=new ArrayList<>();
        for(int i=0;i<n;i++){
            long temp=in.nextLong();
            x.add(temp);
        }
            for(int i=0;i<n;i++){
                long temp=in.nextLong();
                y.add(temp);
            }
            for(int i=0;i<n;i++){
                long diff=y.get(i)-x.get(i);
                ls.add(new Pair((int) diff,i));
            }
            Collections.sort(ls, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.f<o2.f) return 1;
                    else if(o1.f==o2.f) return 0;
                    else return -1;
                };
            });
            long j=n-1;
            int cnt=0;
            for (int i = 0; i <n ; i++) {
                while(j>=0 && ls.get(i).f+ls.get((int) j).f<0)j--;
                if(j<=i) break;
                cnt++;j--;
            }
            System.out.println(cnt);
        }

    }

    static long sum(long[] arr){
        long ans=0;
        int i=0;
        while(true){
            if(i==arr.length) break;
            ans+=arr[i];
            i++;
        }
        return ans;
    }
    static class FastReader {
            BufferedReader br;
            StringTokenizer st;

            public FastReader() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next() {
                while (st == null || !st.hasMoreElements()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }

            long nextLong() {
                return Long.parseLong(next());
            }

            double nextDouble() {
                return Double.parseDouble(next());
            }

            String nextLine() {
                String str = "";
                try {
                    str = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            }
        }

    public static int upper_bound(ArrayList<Integer> ar,int k)
    {
        int s=0;
        int e=ar.size();
        while (s !=e)
        {
            int mid = s+e>>1;
            if (ar.get(mid) <=k)
            {
                s=mid+1;
            }
            else
            {
                e=mid;
            }
        }
        if(s==ar.size())
        {
            return -1;
        }
        return s;
    }
    public static int lower_bound(ArrayList<Integer> ar,int k)
    {
        int s=0;
        int e=ar.size();
        while (s !=e)
        {
            int mid = s+e>>1;
            if (ar.get(mid) <k)
            {
                s=mid+1;
            }
            else
            {
                e=mid;
            }
        }
        if(s==ar.size())
        {
            return -1;
        }
        return s;
    }
    static ArrayList<Long> sieve(long n){
        ArrayList<Long> list=new ArrayList<>();
        boolean[] primes=new boolean[(int)n+1];
        for (int i = 0; i <=n ; i++) {
            primes[i]=true;
        }
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(primes[i]){
                for (int j = i*i; j <=n ; j+=i) {
                    primes[j]=false;
                }
            }
        }
        for (int i = 2; i <=n ; i++) {
            if(primes[i]) list.add((long) i);
        }
        return list;
    }
    static public long gcd(long a,long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    static boolean isPrime(int n){
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
}

class Pair{
    int f;
    int s;
    Pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}
