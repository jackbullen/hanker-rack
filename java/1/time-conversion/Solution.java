// import java.util.HashMap;

public class Solution {
    // public static HashMap<Integer, String> AMmap = new HashMap<>();
    
    // static {
    //     AMmap.put(1, "01");
    //     AMmap.put(2, "02");
    //     AMmap.put(3, "03");
    //     AMmap.put(4, "04");
    //     AMmap.put(5, "05");
    //     AMmap.put(6, "06");
    //     AMmap.put(7, "07");
    //     AMmap.put(8, "08");
    //     AMmap.put(9, "09");
    //     AMmap.put(10, "10");
    //     AMmap.put(11, "11");
    //     AMmap.put(12, "00");
    // }

    /**
     * Converts a 12 hour time string with meridian into 24 hour format.
     *  
     * @param time a string holding the time (hh:mm:ssAM or hh:mm:ssPM)
     * @return a string holding the 24 hour format (hh:mm:ss)
    */
    public static String timeConversion(String time) {
        String meridian = time.substring(time.length()-2);
        int hour = Integer.parseInt(time.substring(0, 2));

        String newTime = "";
        if (meridian.equals("PM") && hour != 12) {
            hour = (hour + 12) % 24;
        } else if (meridian.equals("AM") && hour == 12) {
            hour = 0;
        } 
    
        newTime += String.format("%02d", hour) + time.substring(2, time.length() - 2);
        return newTime;
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("11:00:00AM"));
        System.out.println(timeConversion("11:00:00PM"));
        System.out.println(timeConversion("01:00:00PM"));
        System.out.println(timeConversion("11:59:59PM"));
    }
}