import java.util.Locale;

public class Ellipse extends Shape{

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void setRadiusX(double radiusX) {
        this.radiusX = radiusX;
    }

    public void setRadiusY(double radiusY) {
        this.radiusY = radiusY;
    }

    public Point getCentre() {
        return centre;
    }

    public double getRadiusX() {
        return radiusX;
    }

    public double getRadiusY() {
        return radiusY;
    }

    private Point centre;

    private double radiusX;
    private double radiusY;

    public Ellipse(Style style){
        super(style);
    }

    public String toSvg(){
        return String.format(Locale.ENGLISH,"<ellipse cx=\"%.2f\" cy=\"%.2f\" rx=\"%.2f\" ry=\"%.2f\" style=\"%s\" />",centre.x,centre.y,radiusX,radiusY,style.toSvg());
    }
}
