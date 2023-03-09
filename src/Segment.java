import java.util.List;
import java.util.Locale;

public class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }

    public static Segment[] perpendicular(Segment s, Point p){
        double xP = s.end.x-s.start.x;
        double yP = s.end.y-s.start.y;
        Point startP = new Point(-yP+p.x,xP+p.y);
        Point startP2 = new Point(yP+p.x,-xP+p.y);
        Segment result1 = new Segment(startP,p);
        Segment result2 = new Segment(startP2,p);
        Segment results[] = {result1,result2};
        return results;

    }

    public String toSvg(){
        return String.format(Locale.ENGLISH, "<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\" style=\"stroke:rgb(%d,%d,%d);stroke-width:2\"/>",start.x, start.y, end.x, end.y,start.x*10%255,end.y%255,(start.x+end.x)%255);
    }

    public double length()
    {
        return Math.sqrt(Math.pow((start.x-end.x),2)+Math.pow((start.y-end.y),2));
    }
}
