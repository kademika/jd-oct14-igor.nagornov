package lesson6.Video13Polymorf.Shapes;

public class ShapeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape[] shapes = new Shape[]{new Circle(), new Rectangle(), new Triangle(), new Square()};
		new ShapesTemplate(shapes);
		
	}

}
