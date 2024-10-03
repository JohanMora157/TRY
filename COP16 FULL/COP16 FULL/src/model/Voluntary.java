package model;

public class Voluntary {

	private String id;
	private String name;
	public Route[] routes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Voluntary(String id, String name) {
		this.id = id;
		this.name = name;
		this.routes = new Route[1];

	}

	public String toString() {

		return "atriubutos" + "-" + id + "-" + name;
	}

	public Route[] getRoutes() {
		return routes;
	}

	public boolean AddRoutes(Route newRoute) {

		for (int i = 0; i < routes.length; i++) {
			if (routes[i] == null) {
				routes[i] = newRoute;
				return true;
			}
		}
		return false;
	}

	/*
	 * public Route shoewRoute(Route newRoute) {
	 * 
	 * /*for (int i = 0; i < routes.length; i++) {
	 * if (routes[i] == null) {
	 * routes[i] = newRoute;
	 * return true;
	 * }
	 * }
	 * return false;}
	 * return routes[0];
	 */

}