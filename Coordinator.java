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
		File[] files = new File[4];
		files[0] = new File("userData.txt");
		files[1] = new File("meetingData.txt");
		files[2] = new File("eventData.txt");		
		files[3] = new File("activityData.txt");	//NullPointerException if do not specify anything to each
		int resultCount=0;
		
		
		for(int i=0;i<4;i++)
		
		{	
			
		try {
			br = new BufferedReader(new FileReader(files[i]));	
			String line;
			try {
				while ((line = br.readLine()) != null)
				{
					//to ignore case in search
					String lineLower = line.toLowerCase();
					
//					if(line.matches(".*"+s+".*"))
//					{
//						System.out.println("also Works");
//					}
					//processing the line
					if(lineLower.contains(s.toLowerCase()))
					{
						resultCount++;
						sb.append("Search Result No."+resultCount+"     :	");
						sb.append(line);
						sb.append("\n");	//nextLine
					}	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
			
		}
		
		
		
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

