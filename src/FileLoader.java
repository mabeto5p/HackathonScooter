import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
    List<Observer> observers;

    List<String> fileLines;
    File fileLocation = null;

    public FileLoader(){
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            fileLocation = chooser.getSelectedFile();
        }
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    long previousFileLength = 0;

    public void continuousReading(){

        try {
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(fileLocation));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        while(true) {
            if (fileLocation.length() > previousFileLength) {
                readFile(previousFileLength);
                previousFileLength = fileLocation.length();
            }
        }
    }



    public void readFile(long fileLength){
        String line = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileLocation));
            in.skip(fileLength);
            while((line = in.readLine()) != null)
            {
                if(line.contains("GNGGA")){
                    Coordinate coordinate = parseToCoordinatePoint(line);
                    doStuffWithCoordinate();
                }
            }
            in.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void doStuffWithCoordinate () {
        for(Observer observer : observers){
            //observer.update();
        }
    }


    public List<String> readFile(){

        List<String> fileLines = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
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
            Coordinate parsedCoordinate = parseToCoordinatePoint(st);
            if(parsedCoordinate!= null) {
                coordinates.add(parseToCoordinatePoint(st));
            }
        }
        return coordinates;
    }

    private Coordinate parseToCoordinatePoint (String st) {
        if(st.length()!=79){
            return null;
        }
        Double latitude = Double.parseDouble(st.substring(17, 19))+Double.parseDouble(st.substring(19,27))/60.000;
        Double longitude = Double.parseDouble(st.substring(30,33))+Double.parseDouble(st.substring(33,41))/60.000;
        return new Coordinate(latitude, longitude);
    }
}

