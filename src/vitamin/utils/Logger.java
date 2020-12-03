package vitamin.utils;

public class Logger {
    
    public static void log(Object... args){
        System.out.print("\033[37;1m[LOG]\033[0m");
        System.out.print("\033[37m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }

    public static void error(Object... args){
        System.out.print("\033[31;1m[ERROR]\033[0m");
        System.out.print("\033[31m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }

    public static void info(Object... args){
        System.out.print("\033[32;1m[INFO]\033[0m");
        System.out.print("\033[32m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }

    public static void warn(Object... args){
        System.out.print("\033[33;1m[WARN]\033[0m");
        System.out.print("\033[33m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }
    public static void debug(Object... args){
        System.out.print("\033[34;1m[DEBUG]\033[0m");
        System.out.print("\033[34m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }

    public static void record(Object... args){
        System.out.print("\033[35;1m[RECORD]\033[0m");
        System.out.print("\033[35m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }

    public static void mark(Object... args){
        System.out.print("\033[36;1m[MARK]\033[0m");
        System.out.print("\033[36m ");
        for(Object arg : args) {
            System.out.print(arg); 
            System.out.print(" "); 
        }
        System.out.println("\033[0m");
    }
    
    public static void colour(String content){
        colour(content, "");
    }

    public static void colour(String content,String join){
        int length=content.length();
        int i=0;
        int color=1;
        while(i<length){
            char c=content.charAt(i);
            System.out.print("\033[3"+color+"m"+c+join+"\033[0m");
            color++;
            if(color>6) color=1;
            i++;
        }
        System.out.println();
    }
}
