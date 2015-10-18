package edu.purdue.cs.cs180.safewalk;
/**
 * Start up for SafeWalk Monitor program.
 * 
 * @author dhelia
 * @author jtk
 */

import javax.swing.SwingUtilities;

public class SafeWalkClient implements Runnable {
    String host;
    int port;
    String key;
    String nick;

    /**
     * The main method, starts the SafeWalkMonitor
     * 
     * @param args
     */
    public static void main(String[] args) {
	Log.setupLogging("Monitor", true);
	
	String host;
	int port;
	String key;
    String nick;
	
	if (args.length == 0) {
	    host = "pc.cs.purdue.edu";
	    port = 1337;
	    key = "k471559";
	    nick = "Sahil";
	} else {
	    host = args[0];
	    port = Integer.parseInt(args[1]);
	    key = args[2];
	    nick = args[3];
	}

	// Pass args to new SafeWalkMonitor instance running on Event Dispatch Thread...
	SwingUtilities.invokeLater(new SafeWalkClient(host, port, key, nick));
    }

    public SafeWalkClient(String host, int port, String keyUser, String nickUser) {
	this.host = host;
	this.port = port;
	this.key = keyUser;
	this.nick = nickUser;
    }

    /**
     * Run on the EDT, creating model, view, and controller.
     */
    public void run() {
	Model model = new Model();
	//View view = new View(model);
	
	new Controller(model, host, port, key, nick);
    }
}