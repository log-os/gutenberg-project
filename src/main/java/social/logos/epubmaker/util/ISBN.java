package social.logos.epubmaker.util;

public class ISBN {

    	private static final long LIMIT = 10000000000L;
    	private static long last = 0;

    	public static long getID() {
    	  // 10 digits.
    	  long id = System.currentTimeMillis() % LIMIT;
    	  if ( id <= last ) {
    	    id = (last + 1) % LIMIT;
    	  }
    	  return last = id;
    	}
    	
    	public static void main(String a[]){
    		System.out.println(getID());
    	}
    	
    	public static String getID(int id){
    		String numberAsString = String.format ("%011d", id );
    		System.out.println(numberAsString);
    		return "LO"+numberAsString;
    	}
}