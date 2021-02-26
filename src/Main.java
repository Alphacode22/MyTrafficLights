import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap; // import the HashMap class
import java.util.*;

public class Main {

    public static int takesTime;
    public static int intersections;
    public static int streets;
    public static int cars;
    public static int score;
    public static boolean [] status;			// status of trafic light
    public static HashMap<String, Integer> roadsInsec;   // used to store road name with end intersection
    public static ArrayList<ArrayList<Node>> graph;     //the entire road system
    public static ArrayList<Car> carJourneys = new ArrayList <Car>(); //used to store car journey

    public static void main(String [] args) {
        try {
            File myObj = new File("a.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            String [] tokens = data.split(" ");
            takesTime = Integer.parseInt(tokens[0]);
            intersections = Integer.parseInt(tokens[1]);
            streets = Integer.parseInt(tokens[2]);
            cars = Integer.parseInt(tokens[3]);
            score = Integer.parseInt(tokens[4]);

            status = new boolean[streets];
            graph = new ArrayList();
            for (int i =0; i<intersections;i++) {
                ArrayList<Node> n = new ArrayList<Node>();
                graph.add(n);
            }
            //roads are indexes
            //graph(startIntersection).(Node -> endInter, timetakes)
            roadsInsec = new HashMap<String, Integer>();
            for(int i=0; i<streets;i++) {
                int start = myReader.nextInt();
                int end = myReader.nextInt();
                String sName =  myReader.next();
                int weight = myReader.nextInt();
                roadsInsec.put(sName, end); //hMap
                Node node = new Node(end, weight);
                graph.get(start).add(node);
            }

            for(int i =0; i<cars;i++) {
                int routes = myReader.nextInt();
                String[] paths = new String[routes];
                for(int j=0; j<routes;j++) {
                    paths[j] = myReader.next();
                }
                Car car = new Car(roadsInsec.get(paths[0]),roadsInsec.get(paths[paths.length-1]),paths);
                carJourneys.add(car);
            }

            myReader.close();

            //Doing the sorting here
            Organiser myOrganiser = new Organiser();
            myOrganiser.findTrafficLightToChange();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
