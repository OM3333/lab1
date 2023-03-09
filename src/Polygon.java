import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class Polygon {
    private Point[] pointArray;
    private Style style;

    public Polygon(int vertices, Style style){
        pointArray = new Point[vertices];
        this.style = style;
    }

    public void setPoint(int index, Point point){
        pointArray[index] = point;
    }
    public void setPointArray(Point[] pointArray){
        this.pointArray = pointArray;
    }

    public void randomizePointArray(int seed){
        for(int i = 0;i<pointArray.length;++i){
            pointArray[i] = new Point((i*i+seed)%340,(i+i*seed)%340);
        }
    }

    public String toSvg(){
        String polygonPoints = "";
        for (Point point: pointArray) {
            polygonPoints = polygonPoints.concat(String.format(Locale.ENGLISH, "%.2f,%.2f ",point.x,point.y));
        }
        String pointPart = String.format(Locale.ENGLISH, "points=\"%s\"",polygonPoints);

        String stylePart = String.format("style=\"%s\"",style.toSvg());

        String polygonSvg = String.format(Locale.ENGLISH,"<polygon %s %s/>",pointPart,stylePart);
        return polygonSvg;
    }

}
