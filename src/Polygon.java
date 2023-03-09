import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Locale;

public class Polygon extends Shape {
    private Point[] pointArray;

    public Polygon(int vertices, Style style){
        super(style);
        pointArray = new Point[vertices];
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

    public static Polygon square(Segment segment, Style style){
        Polygon result = new Polygon(4,style);
        Point middlePoint = new Point((segment.start.x+segment.end.x)/2,(segment.start.y+segment.end.y)/2);
        Segment perpendicularSegmentA = Segment.perpendicular(segment,middlePoint)[0];
        Segment perpendicularSegmentB = Segment.perpendicular(segment,middlePoint)[1];
        result.setPoint(0,segment.start);
        result.setPoint(1,perpendicularSegmentB.start);
        result.setPoint(2,segment.end);
        result.setPoint(3,perpendicularSegmentA.start);
        return result;
    }

}
