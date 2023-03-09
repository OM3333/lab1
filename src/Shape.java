public abstract class Shape {

    protected Style style;

    public abstract String toSvg();

    public Shape(Style style){
        this.style = style;
    }
}
