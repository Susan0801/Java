import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AttendanceParser {

  public static void main(String[] args) throws Exception {

     File f = new File("attendance.txt");
     Scanner scan = new Scanner(f);
     
     Map<String,List<String>> mp = new TreeMap<String,List<String>>();

     // read in data input into Collection
     while (scan.hasNextLine()) {
        String emailAddr = scan.nextLine();
        Email email = new Email(emailAddr);
        String co = email.parseCompanyName();
        String name = email.parseEmailName();
        // System.out.println("  name=" + name + "  company=" + co);

        // insert data into a Map Collection
        if (mp.containsKey(co)) {
         // company name exist
         List<String> nameList;
         nameList = mp.get(co);
         nameList.add(name);
         Collections.sort(nameList);
         mp.put(co,nameList);
        } else {
         // does not exist in Map
         List<String> nameList = new ArrayList<String>();
         nameList.add(name);
         mp.put(co,nameList);
        }


     }
 // end while loop  for data entry to Collection

    System.out.println("number of companies: " + mp.size());

     for (Map.Entry<String,List<String>> entry: mp.entrySet()) {
         String key = entry.getKey();
         List<String> value = entry.getValue();
         for (String strName: value) {
            // String s = key + "\t" + strName + "\r\n";
            String s = key + "\t" + strName + "";
            System.out.println(s);
         }
}
//2. Create a histogram on the number of attendees per company for the conference

System.out.println("\nHistogram of Attendees per Company:");
for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
    String key = entry.getKey();
    List<String> value = entry.getValue();
    int attCount = value.size();

    // Printing histogram bars
    System.out.printf("%s: ", key);
    for (int i = 0; i < attCount; i++) {
        System.out.print("*");
    }
    System.out.println();
}

//3. Check if bill.gates attended the conference.  Output that Bill Gates attended conference.

boolean billGatesAttended = false;
for (Map.Entry<String, List<String>> entry : mp.entrySet()) {
    List<String> value = entry.getValue();
    if (value.contains("bill.gates")) {
        billGatesAttended = true;
        break; 
    }
}
if (billGatesAttended) {
    System.out.println("Bill Gates attended the conference!");
} else {
    System.out.println("Bill Gates did not attend the conference.");
}





   // Initialize file parameters
 BufferedWriter output = null;
   try {
      
      File file = new File("attendanceParseValues.txt");
      output = new BufferedWriter(new FileWriter(file));
     
      for (Map.Entry<String,List<String>> entry: mp.entrySet()) {
         String key = entry.getKey();
         List<String> value = entry.getValue();
         for (String strName: value) {
            String s = key + "\t" + strName + "\r\n";
            output.write(s);
         }

	  /*
         for (String strName: value)
            System.out.println(key + "\t" + strName);
	  */   	   
      }
    } catch ( IOException e ) {
       e.printStackTrace();
    } finally {
       if ( output != null ) 
          output.close();  // need to close file to write to a file
    }    

  }

}