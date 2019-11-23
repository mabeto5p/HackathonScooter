import java.util.List;

public class SquareMap {
    List<Square> squares;

    public SquareMap(List<Square> squares){
        this.squares = squares;
    }

    public boolean isObjectContained(Object object, Coordinate coordinate){
        for (Square square: squares){
            if (square.isContained(object, coordinate)){
                return true;
            }
        }
        return false;
    }
}
