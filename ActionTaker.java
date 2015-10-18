package edu.purdue.cs.cs180.safewalk;


public class ActionTaker {
	public static void closestHighestValue(Model model, Location location, Connector connector) {
		if (!location.getRequests().isEmpty()) {
			Request req = Calculations.highestValueAtLocation(location);
			connector.writeLine("walk " + req.getName());
		} else {
			Location closest = Calculations.closestWithRequests(model, location);
			connector.writeLine("move " + closest.getName());
		}
	}
}
