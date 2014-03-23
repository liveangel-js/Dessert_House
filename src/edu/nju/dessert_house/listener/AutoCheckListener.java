package edu.nju.dessert_house.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AutoCheckListener
 *
 */
@WebListener
public class AutoCheckListener implements ServletContextListener {
	private Timer t;
	private AutoCheckTask task;
	
    /**
     * Default constructor. 
     */
    public AutoCheckListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	t=new Timer();
    	task=new AutoCheckTask();
    	t.schedule(task, 0,1000*60*60*24);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	t.cancel();
    }
	
}
