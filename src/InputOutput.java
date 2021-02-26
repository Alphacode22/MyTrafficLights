import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InputOutput {

    //temp variable
    int intersection =3;

    int[] intersectionGreen = {1, 2, 1};
    ArrayList<HashMap<String, Integer>> intersections = new ArrayList<HashMap<String, Integer>>();
    HashMap<String, Integer> street = new HashMap<String, Integer>();

    public void createOutput(String fileName) throws Exception{

        HashMap<String, Integer> intersection1 = new HashMap<String, Integer>();
        intersection1.put("rue-d-londres", 1);

        HashMap<String, Integer> intersection2 = new HashMap<String, Integer>();
        intersection2.put("rue-d-athens", 2);
        intersection2.put("rue-d-amsterdam", 1);

        HashMap<String, Integer> intersection3 = new HashMap<String, Integer>();
        intersection3.put("rue-d-moscou", 1);

        HashMap<String, Integer> intersectionX = new HashMap<String, Integer>();
        int numOfIntersectionPlaces = 1;

        for(int i=0; i< numOfIntersectionPlaces; i++){
            intersections.add(intersectionX);
        }

//        intersections.get(0).put("rue-d-londres", 1);
//
//        intersections.get(1).put("rue-d-athens", 2);
//        intersections.get(1).put("rue-d-amsterdam", 1);
//        //here
//        intersections.get(2).put("rue-d-moscou", 1);

        intersections.add(intersection1);
        intersections.add(intersection2);
        intersections.add(intersection3);



        if(fileName == null){
            throw new IOException("You are missing a file");
        }

        File file = new File(fileName);

        // Read in what file
        FileWriter myWriter = new FileWriter(file);

        myWriter.write(intersection + "\n");
        //Output file
        for(int i=0; i < intersectionGreen.length; i++){
            myWriter.write(i + "\n");
            myWriter.write(intersectionGreen[i] + "\n");
            for (Map.Entry<String, Integer> intersectionIndex: intersections.get(i).entrySet()) {
                myWriter.write(intersectionIndex.getKey() + " " + intersectionIndex.getValue() + "\n");
            }
        }

        myWriter.flush();
        myWriter.close();
    }


//    public static void main(String[] arg) throws Exception{
//        InputOutput in = new InputOutput();
//        in.createOutput("Output1.txt");
//    }
}
