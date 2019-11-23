import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileLoader fileLoader = new FileLoader();
        Square square =  new Square(fileLoader.getSquareCoordinatesLoadedCoordinates());
        List<Square> squares = new ArrayList<>();
        squares.add(square);
        SquareMap squareMap = new SquareMap(squares);
        fileLoader.addObserver(new GUI(squareMap));
        fileLoader.continuousReading();
    }
}
