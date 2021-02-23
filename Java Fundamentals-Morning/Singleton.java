public class Singleton {

    private static Singleton single_instance=null; 
    public String s; 
    private Singleton() 
    { 
        s = "Singleton class"; 
    } 
    public static Singleton Singleton() 
    { 
        // To ensure only one instance is created 
        if (single_instance == null) 
        { 
            single_instance = new Singleton(); 
        } 
        return single_instance; 
    } 

}
