package edu.purdue.cs.cs180.safewalk;
import java.util.Iterator;


public class Calculations {
	
	public static double distance(Location start, Location end) {
		double x1 = start.getXY()[0];
		double y1 = start.getXY()[1];
		double x2 = end.getXY()[0];
		double y2 = end.getXY()[1];
		
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	public static Location closestWithRequests(Model model, Location location) {
		Location closest = null;
		Iterator<Location> it = model.getLocations().iterator();
		while (it.hasNext()) {
			Location l = it.next();
			if (!l.getRequests().isEmpty() && l != location) {
				if (closest == null) {
					closest = l;
				} else {
					if (distance(location, l) < distance(location, closest)) {
						closest = l;
					}
				}
			}
		}
		return closest;
	}
	
	public static Request highestValueAtLocation(Location location) {
		Request req = null;
		Iterator<Request> it = location.getRequests().iterator();
		while (it.hasNext()) {
			Request r = it.next();
			if (req == null) {
				req = r;
			} else {
				if (r.getValue() > req.getValue()) {
					req = r;
				}
			}
		}
		
		return req;
	}
}
