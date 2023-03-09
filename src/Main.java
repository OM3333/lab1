
public class Main {



    public static void main(String[] args) {
        int seed = 141110;
        //interesting seeds
        //221233213 gives a spike
        SvgScene svgScene = new SvgScene();
        for(int i = 0;i<10;++i){
            Polygon toAdd = new Polygon(10,new Style("red","green",3));
            toAdd.randomizePointArray(i*seed);
            svgScene.addPolygon(toAdd);
        }
        svgScene.save("abc123.html");

    }
}