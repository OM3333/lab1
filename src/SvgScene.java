import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SvgScene {
    ArrayList<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void save(String fileName){
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            String polygonSvgs = "";
            for(Shape shape : shapes){
                polygonSvgs = polygonSvgs.concat(shape.toSvg());
            }
            String toWrite = String.format(" <!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<body>\n" +
                    "\n" +
                    "<svg width=\"1000\" height=\"1000\">\n" +
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
