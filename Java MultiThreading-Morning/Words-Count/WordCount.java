public class WordCount {  
      static int wordcount(String string)  
        {  
          int count=0;  
      
            char ch[]= new char[string.length()];     
            for(int i=0;i<string.length();i++)  
            {  
                ch[i]= string.charAt(i);  
                if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                    count++;  
            }  
            return count;  
        }  
      public static void main(String[] args) {  
          String string ="Java is a powerful general-purpose programming language. It is used to develop desktop and mobile applications, big data processing, embedded systems, and so on. According to Oracle, the company that owns Java, Java runs on 3 billion devices worldwide, which makes Java one of the most popular programming languages."; 
          long startTime = System.currentTimeMillis();
         System.out.println(wordcount(string) + " words.");
         long endTime = System.currentTimeMillis();
         long elapsed = endTime - startTime;
         System.out.println("Total time = "+elapsed+" ms");
    }  
} 
