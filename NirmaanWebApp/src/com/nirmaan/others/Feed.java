package com.nirmaan.others;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

<<<<<<< HEAD
import com.nirmaan.database.Database;
=======
/**
 * @author Group-19
 *Class to manage Feeds
 */

public class Feed {
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f

public class Feed {
	private String feed_head;
	private String feed_body;
	private ArrayList<String> subscribers;
	
	public Feed(String feed_head,String feed_body, Database db)	{
		this.feed_head = feed_head;
		this.feed_body = feed_body;
		
		db.runUpdate("INSERT ", "INTO feed(feed_name) values('", this.getFeed_head() + "\n" + this.getFeed_body() + "')" , "", "");
	}

	public String getFeed_head() {
		return feed_head;
	}

	public void setFeed_head(String feed_head) {
		this.feed_head = feed_head;
	}

	public String getFeed_body() {
		return feed_body;
	}

<<<<<<< HEAD
	public void addSubscriber(String sub) {
		this.subscribers.add(sub);
=======
	
	public void addSubscriber() {
>>>>>>> be67708a7b2b21984355b57c5653a612235d720f
	}
	
	public void printFeeds(Database db) {
		ResultSet tempRs;
		tempRs = db.runQuery("select * from feed", "", "", "", "");
		try {
			while (tempRs.next()) {
				int id = tempRs.getInt("feed_id");
				String name = tempRs.getString("feed_name");

				System.out.println(id + " " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
