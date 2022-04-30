import static java.lang.Math.*;

public class Vector3D {

    private double x;
    private double y;
    private double z;

    //конструктор без параметров
    public Vector3D(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    //конструктор по координатам
    public Vector3D ( double x, double y, double z ) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //конструктор по двум точкам
    public Vector3D ( Point3D a, Point3D b ){
        x = b.getX() - a.getX();
        y = b.getY() - a.getY();
        z = b.getZ() - a.getZ();
    }

    //вывод координат вектора на экран
    public String printXYZ () {
        String strX = Double.toString(x);
        String strY = Double.toString(y);
        String strZ = Double.toString(z);
        return "[" + strX + ", " + strY + ", " +  strZ + "]";
    }

    //длина вектора
    public double vectorLength () {
        return sqrt( x*x + y*y + z*z );
    }

    // getters
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }

    //setters
    public void setX( double x ) {
        this.x = x;
    }
    public void setY( double y ) {
        this.y = y;
    }
    public void setZ( double z ) {
        this.z = z;
    }

    public void VecLength(String v_name)
    {
        double v_length;
        v_length = Math.sqrt(x*x + y*y + z*z);
        System.out.println("Длина " + v_name + ": " + v_length);
        System.out.println();
    }

    @Override
    public boolean equals (Object obj) {
        if(obj == null) {
            return false;
        }
        if(!(obj instanceof Vector3D)) {
            return false;
        }

        double eps=1E-9;
        return Math.abs(this.vectorLength()-((Vector3D) obj).vectorLength())<eps;
    }

    //равенство с заданным вектором
    public boolean checkEqual ( Vector3D a ){
        double eps = 1E-6;
        return Math.abs(this.vectorLength() - a.vectorLength()) < eps;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }
}
