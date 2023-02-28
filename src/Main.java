
public class Main {



    public static void main(String[] args) {
        Segment s = new Segment(new Point(100,100),new Point(200,200));
        System.out.println(s.toSvg()+"\n");
        System.out.println(Segment.perpendicular(s,new Point(100,200)).get(0).toSvg());
        System.out.println(Segment.perpendicular(s,new Point(100,200)).get(1).toSvg());
    }
}