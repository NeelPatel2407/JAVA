abstract class Shape{
    public abstract double area();
}

class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length=length;
        this.width=width;
    }

    public double area(){
        return length * width;
    }
}

class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(double base, double height){
        this.base=base;
        this.height=height;
    }

    public double area(){
        return 0.5 * base * height;
    }
}

public class P5_partA_1{
    public static void main(String [] args){
        Shape[] shapes = {
            
            new Circle(10),
            new Rectangle(15, 25),
            new Triangle(36, 60)
        };

        double total=0;
        double largest=0;

        for(Shape shape : shapes){
            double area=shape.area();
            total+=area;

        if(area>largest){
            largest=area;
        }

        System.out.printf("Area is: %.2f\n", total);
        }
        System.out.printf("Area is: %.2f\n" , total);
        System.out.printf("Largest area is: %.2f\n" , largest);
    }
}