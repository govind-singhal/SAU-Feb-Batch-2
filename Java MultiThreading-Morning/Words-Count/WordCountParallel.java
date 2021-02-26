import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WordCountParallel implements Runnable {
    private final String buffer;
    private final ConcurrentMap<String,Integer> counts;

    public WordCountParallel(String buffer, 
                             ConcurrentMap<String,Integer> counts) {
        this.counts = counts;
        this.buffer = buffer;
    }

    private final static String DELIMS = " :;,.{}()\t\n";
    private final static boolean printAll = false;

    private static int findDelim(String buf) {
        for (int i = buf.length() - 1; i>=0; i--) {
            for (int j = 0; j < DELIMS.length(); j++) {
                char d = DELIMS.charAt(j);
                if (d == buf.charAt(i)) return i;
            }
        }
        return 0;
    }

    private static String readFileAsString(BufferedReader reader, int size)
        throws java.io.IOException 
    {
        StringBuffer fileData = new StringBuffer(size);
        int numRead=0;

        while(size > 0) {
            int bufsz = 1024 > size ? size : 1024;
            char[] buf = new char[bufsz];
            numRead = reader.read(buf,0,bufsz);
            if (numRead == -1)
                break;
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
            size -= numRead;
        }
        return fileData.toString();
    }
    private void updateCount(String q) {
        Integer oldVal, newVal;
        Integer cnt = counts.get(q);
        if (cnt == null) {
            oldVal = counts.put(q, 1);
            if (oldVal == null) return;
        }
        do {
            oldVal = counts.get(q);
            newVal = (oldVal == null) ? 1 : (oldVal + 1);
        } while (!counts.replace(q, oldVal, newVal));
    } 

    public void run() {
        StringTokenizer st = new StringTokenizer(buffer,DELIMS);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            updateCount(token);
        }
    } 

    public static void main(String args[]) throws java.io.IOException {
    	
        long startTime = System.currentTimeMillis();
        
        int numThreads = 1;
        int chunksize = 1000;
        
        ExecutorService pool = Executors.newFixedThreadPool(numThreads);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        ConcurrentMap<String,Integer> m = 
            new ConcurrentHashMap<String,Integer>();
        String leftover = "";
        while (true) {
            String res = readFileAsString(reader,chunksize);
            if (res.equals("")) {
                if (!leftover.equals("")) 
                    new WordCountParallel(leftover,m).run();
                break;
            }
            int idx = findDelim(res);
            String taskstr = leftover + res.substring(0,idx);
            leftover = res.substring(idx,res.length());
            pool.submit(new WordCountParallel(taskstr,m));
        }
        pool.shutdown();
        try {
            pool.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            System.out.println("Pool interrupted!");
            System.exit(1);
        }
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        int total = 0;
        for (Map.Entry<String,Integer> entry : m.entrySet()) {
            int count = entry.getValue();
            if (printAll)
                System.out.format("%-30s %d\n",entry.getKey(),count);
            total += count;
        }
        System.out.println("Total words = "+total);
        System.out.println("Total time = "+elapsed+" ms");
    }
}
