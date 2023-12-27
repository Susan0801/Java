1)The attached file (attendance.txt) is a list of email addresses you collected for a conference your company hosted.  Create a program that will parse each email address by its name and company.  (Note: email parser object is attached).   The company should be sorted in the first column and the person’s name associated with the company should be sorted in the second column; separated with tab character.  (first sort is by company; secondary sort is by firstname.lastname).  Sample output is listed below:  
amzn	bob.freed
amzn	caitlin.thomas
amzn	edward.flak
amzn	jill.bennet
amzn	mike.reade
fb		chris.booker
fb		fred.smith
fb		jane.bland
fb		megan.hill
goog	gary.teafer
goog	john.kohl
goog	larry.page
goog	phil.heal
goog	zara.war
msft	alan.gret
msft	darlene.neddle
msft	don.shaffer
msft	ken.smith
msft	sue.flemming
orcl		heidi.opal
orcl		john.voy
orcl		larry.lee
orcl		mark.lite
2)Create a histogram on the number of attendees per company for the conference.  (can be in same program as #1)

3)Check if bill.gates attended the conference.  Output that Bill Gates attended conference.  (can be in same program as #1)

4)[Optional] Create an output text file for the output above so that it can be imported in Excel for further analysis.  One method of code to write text to an output file:  (can be in same program as #1)

	String text = "my text";
        	BufferedWriter output = null;
        	try {
            	    File file = new File("example.txt");
            	    output = new BufferedWriter(new FileWriter(file));
            	    output.write(text);
        	} catch ( IOException e ) {
            	    e.printStackTrace();
        	} finally {
                         if ( output != null ) {
                                  output.close();  // need to close file to write to a file
          	}
        }
