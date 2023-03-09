import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SvgScene {
    ArrayList<Polygon> polygons = new ArrayList<>();

    public void addPolygon(Polygon polygon){
        polygons.add(polygon);
    }

    public void save(String fileName){
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            String polygonSvgs = "";
            for(Polygon polygon : polygons){
                polygonSvgs = polygonSvgs.concat(polygon.toSvg());
            }
            String toWrite = String.format(" <!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<svg width=\"100\" height=\"100\">\n" +
                    "%s" +
                    "</svg>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html> ",polygonSvgs);
            System.out.println(toWrite);
            fileWriter.write(toWrite);
            fileWriter.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }
}
