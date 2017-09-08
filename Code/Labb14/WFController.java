package laboration14;

import java.util.*;
import java.awt.BorderLayout;
import java.io.*;

import javax.swing.JFrame;

import f14.*;

public class WFController {
	private Graph<String> graph = new Graph<String>();
	private MapView map;
	private TreeMap<String, Road> roads;

	public WFController(String placeFile, String roadFile, String mapFile) {
		ArrayList<Place> places = WFController.readPlaces(placeFile);

		roads = WFController.readRoads(roadFile);
		ArrayList<Road> roadList = new ArrayList<Road>();
		Iterator<Road> values = roads.values().iterator();
		while (values.hasNext())
			roadList.add(values.next());

		map = new MapView(mapFile, 12.527, 56.346, 14.596, 55.324);
		showMap();

		map.showRoads(roadList);

//	    makeGraph(places, roads); // Uppgift 2
	}

	public static ArrayList<Place> readPlaces(String filename) {
		ArrayList<Place> places = new ArrayList<Place>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename), "UTF-8"));
			String[] parts;
			double longitude, latitude;
			String text = br.readLine();
			while (text != null) {
				parts = text.split(" ");
				longitude = Double.parseDouble(parts[2]);
				latitude = Double.parseDouble(parts[1]);
				places.add(new Place(parts[0], longitude, latitude));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return places;
	}

	public static TreeMap<String, Road> readRoads(String filename) {
		TreeMap<String, Road> res = new TreeMap<String, Road>();
		ArrayList<Position> path;
		String[] parts;
		String text;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename), "UTF-8"));
			text = br.readLine();
			while (text != null) {
				path = new ArrayList<Position>();
				parts = text.split(",");
				for (int i = 3; i < parts.length; i += 2) {
					path.add(new Position(Double.parseDouble(parts[i]), Double
							.parseDouble(parts[i + 1])));
				}
				int i=0;
				res.put(parts[0] + "-" + parts[1], new Road(parts[0],parts[1], Integer.parseInt(parts[2]), path));
				text = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		return res;
	}

	public void showMap() {
		JFrame frame = new JFrame("Karta");
		frame.setSize(686, 592);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(map, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	// Uppgift 2
	public void makeGraph(ArrayList<Place> places, TreeMap<String, Road> roads) {
		// Iterera genom arraylisten places
		// för varje Place-objekt så lägg till platsens namn som en nod
		// i grafen (instansvariabeln graph), ungefär:
		// graph.addVertex(namn)
		// Om du studerar klassen Place hittar du lämplig get-metod för namnet.

		// skapa en Iterator över values (Road-objekt) i roads
		// så länge det finns Road-objekt i Iteratorn
		// lägg till en båge i grafen med addEdge(T from, T to, int
		// cost)-metoden
		Iterator<Road> values = roads.values().iterator();
		Road road;
		for (Place place : places) {
			graph.addVertex(place.getName());
		}
		while (values.hasNext()) {
			road = values.next();
			graph.addEdge(road.getFrom(), road.getTo(), road.getCost());
		}
	}

	// Uppgift 3
	public void search1(String from, String to) {
	}

	// Uppgift 4
	public void shortestPath(String from, String to) {
	}

	// Uppgift 5
	public void randomSearch(String from, String to) {
	}


    private void showRoads(Graph<String> graph) {
    	ArrayList<Road> roadList = new ArrayList<Road>();
    	Iterator<Edge<String>> iter = graph.iterator();
    	Edge<String> edge;
    	while(iter.hasNext()) {
    		edge = iter.next();
    		roadList.add(roads.get(edge.getFrom()+"-"+edge.getTo()));
    	}
    	map.showRoads(roadList);
    }
    
	public static void main(String[] args) {
		WFController controller = new WFController("files/places.txt",
				"files/roads.txt", "files/skane.jpg");
		
//		controller.search1("Eslöv", "Kristianstad");
//		controller.search1("Kristianstad", "Eslöv");
//		controller.shortestPath("Kristianstad", "Eslöv");
//		controller.shortestPath("Höganäs", "Åhus");
//		controller.randomSearch("Åhus", "Ängelholm");
	}
}
