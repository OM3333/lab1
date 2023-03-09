
public class Main {



    public static void main(String[] args) {
        int seed = 221233215;
        //interesting seeds
        //221233213 gives a spike
        SvgScene svgScene = new SvgScene();
        for(int i = 0;i<10;++i){
            Polygon toAdd = new Polygon(10,new Style("red","green",3));
            toAdd.randomizePointArray(i*seed);
            svgScene.addShape(toAdd);
        }
        Ellipse ellipse = new Ellipse(new Style("blue","gold",1));
        ellipse.setCentre(new Point(50,50));
        ellipse.setRadiusX(10);
        ellipse.setRadiusY(40);
        svgScene.addShape(ellipse);
        svgScene.save("abc123.html");

    }
}