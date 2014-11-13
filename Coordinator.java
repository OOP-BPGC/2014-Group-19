package nirmanApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

public class Coordinator extends Student
{
	private String password;
	private String userName;
	
	public boolean login(String user,String pass)	
	{
		return false;
	}
	
	public boolean logout()
	{
		return true;
	}
	
	public boolean promoteEvent(Event e)
	{
		/*
		 * if event doesnt exist return false or already promoted maybe
		 * else:
		 */
		return true;
	}
	
	public String search(String s)
	{
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		int resultCount=0;

		File dir = new File("D:/3-1/cs_f212_oops/workspace/Lab9/Directory");	//path of directory
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {

				try {
					br = new BufferedReader(new FileReader(child));	
					String line;
					try {
						while ((line = br.readLine()) != null)
						{

							String lineLower = line.toLowerCase();	//to ignore case in search
							//processing the line
							if(lineLower.matches(".*"+s.toLowerCase()+".*"))
							{
								resultCount++;
								sb.append("Search Result No."+resultCount+"     :	");//may remove this
								sb.append(line);
								sb.append("\n");	//nextLine
							}	
						}
					} catch (IOException e) {e.printStackTrace();}
				} catch (FileNotFoundException e) {e.printStackTrace();}
				finally
				{
					try {br.close();
					} catch (IOException e) {e.printStackTrace();}
				}


			}
		}
		else{System.out.println("No such directory found");}


		return sb.toString();
	}

	
	
	public boolean subscribeToFeed(Feed f)
	{
		//false if already subscribed
		return true;
	}
	
	public boolean postFeed(String msg)
	{
		return true;
	}
	
	public void openEvent(Event e1)
	{
		
	}
	
	public void closeEvent(Event e2)
	{
		
	}

	public boolean scheduleEvent(String name, Date startd,Date endD, String venue)
	{
		//set date and venue to the Event with given name
		//if name doesn't exist create new Event with this name
		return true;
	}
	
	
	public boolean scheduleMeeting(Date d,Time t,Time endT,String venue)
	{//create new Meeting ?????
		//false when ????/
		return true;
	}
	
}

