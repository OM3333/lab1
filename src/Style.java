import java.util.Locale;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final double strokeWidth;

    public Style(String fillColor, String strokeColor, double strokeWidth) {

        if(fillColor == null){
            fillColor = "transparent";
        }
        if(strokeColor == null){
            strokeColor = "transparent";
        }


        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.strokeWidth = strokeWidth;

    }

    public String toSvg(){
        return String.format(Locale.ENGLISH,"fill: %s;stroke: %s;stroke-width: %.2f",fillColor,strokeColor,strokeWidth);
    }
}
