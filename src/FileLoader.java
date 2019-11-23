import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    String fileContent;
    List<String> fileLines;



    public FileLoader(){
        readAndParseFile();
        fileLines = readFile();
    }

    public List<String> readFile(){
        File file = new File("C:\\Users\\mabet\\Documents\\Hackathon\\storFirkant.ubx");
        List<String> fileLines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String st;
            while((st = bufferedReader.readLine()) != null){
                if(st.contains("GNGGA")){
                    fileLines.add(st);
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileLines;
    }

    public List<Coordinate> getCoordinatesLoadedCoordinates (){
        List<Coordinate> coordinates = new ArrayList<>();
        for(String st : fileLines){
            coordinates.add(parseToCoordinatePoint(st));
        }
        return coordinates;
    }

    public List<Coordinate> readAndParseFile() {
        File file = new File("C:\\Users\\mabet\\Documents\\Hackathon\\storFirkant.ubx");

        List<Coordinate> coordinateList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String st;
            while((st = bufferedReader.readLine()) != null){
                if(st.contains("GNGGA")){
                    coordinateList.add(parseToCoordinatePoint(st));
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return coordinateList;
        }

    private Coordinate parseToCoordinatePoint (String st) {
        System.out.println(st);
        //System.out.println(st.length());
        if(st.length()!=79){
            return null;
        }
        //System.out.println(st.substring(19,27));
        Double latitude = Double.parseDouble(st.substring(17, 19))+Double.parseDouble(st.substring(19,27))/60.000;
        //System.out.println(st.substring(30,33));
        //System.out.println(st.substring(33,42));
        Double longitude = Double.parseDouble(st.substring(30,33))+Double.parseDouble(st.substring(33,41))/60.00;
        //System.out.println(latitude);
        //System.out.println(longitude);
        return new Coordinate(latitude, longitude);
    }

}

