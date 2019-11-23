import java.util.List;

public class SquareMap {
    List<Square> squares;

    public SquareMap(List<Square> squares){
        this.squares = squares;
    }

    public boolean isObjectContained(Object object){
        for (Square square: squares){
            if (square.isContained(object)){
                return true;
            }
        }
        return false;
    }
}
