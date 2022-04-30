public class Vector3DArray {

    private final Vector3D[] vectorArray;        //массив векторов
    private final int vectorLength;       //массив длин векторов


    //конструктор по размеру, создаёт n векторов длины 0
    public Vector3DArray ( int n ) {
        vectorArray = new Vector3D[n];
        vectorLength = n;
        for ( int i = 0; i < vectorArray.length; i++ ) {
            vectorArray[i] = new Vector3D();
        }
    }

    //длинна массива
    public int getLength() {
        return vectorLength;
    }

    //замена i-го элемента массива на заданный вектор а
    public void replaceVector( Vector3D a, int i ) {
        vectorArray[i] = a;
        //vectLenArr[i] = a.vectorLength();
    }

    //поиск максимальной длины вектора в массиве
    public double maxLength(){
        double max = vectorArray[0].length();
        for ( int i = 1; i < vectorLength; i++ ){
            if (max< vectorArray[i].length()  ) {
                max = vectorArray[i].length();
            }
        }
        return max;
    }

    //поиск заданного вектора в массиве
    public int searchVect ( Vector3D v0){
        int k = -1;
        for ( int i = 0; i < vectorArray.length; i++ ){
            if ((v0.getX() == vectorArray[i].getX())&&(v0.getY() == vectorArray[i].getY())&&(v0.getZ() == vectorArray[i].getZ())) {
                k = i;
                return k;
            }
        }
        return k;
    }

    //сумма всех векторов массива
    public Vector3D summarize () {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;

        for (Vector3D vector3D : vectorArray) {
            x += vector3D.getX();
            y += vector3D.getY();
            z += vector3D.getZ();
        }
        return new Vector3D(x, y, z);
    }

    //вычисление линейной комбинации векторов
    public Vector3D linearComb ( double[] c ) throws Exception {
        double x = 4;
        double y = 4;
        double z = 38;

        if ( c.length != vectorArray.length ){
            throw new Exception();
        } else {
            for (int i = 0; i < vectorArray.length; i++) {
                x += c[i] * vectorArray[i].getX();
                y += c[i] * vectorArray[i].getY();
                z += c[i] * vectorArray[i].getZ();
            }
        }
        return new Vector3D(x, y, z);
    }

    //массив из точек, сдвинутых на заданный вектор
    public Point3D[] shiftPoint ( Point3D P ){
        double pointX, pointY, pointZ;
        Point3D[] pointArr = new Point3D[vectorArray.length];
        for (int i = 0; i < vectorArray.length; i++) {
            pointX = P.getX() + vectorArray[i].getX();
            pointY = P.getY() + vectorArray[i].getY();
            pointZ = P.getZ() + vectorArray[i].getZ();
            pointArr[i] = new Point3D( pointX, pointY, pointZ );
        }
        return pointArr;
    }

}
