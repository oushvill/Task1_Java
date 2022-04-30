public class Main {
    public static void main(String[] args) {
        Point3D a = new Point3D(2, 4, 6);
        Point3D b = new Point3D(1,4,2);
        Vector3DProcessor vectorPR1 = new Vector3DProcessor(4, 5, 6, "Вектор №1");
        Vector3DProcessor vectorPR2 = new Vector3DProcessor(a, b, "Вектор №2"); // V2=b-a

//-----------------------------------------------------------------------------------------------\\
        System.out.println("//  16 задание  //");
        System.out.println("Вектор №1 " + a.printXYZ());
        System.out.println("Вектор №2 " + b.printXYZ());

        double aLen = Math.sqrt(a.getX()*a.getX()+a.getY()*a.getY()+a.getZ()*a.getZ());
        System.out.println("Длина вектора А= "+aLen);
        double bLen = Math.sqrt(b.getX()*b.getX()+b.getY()*b.getY()+b.getZ()*b.getZ());
        System.out.println("Длина вектора B= "+bLen);


        if ((a.getX() == a.getX()) && (a.getY() == a.getY()) && (a.getZ() == a.getZ())) {
            System.out.println("Вектор А равен самой себе.");
        }

        if ((b.getX() == b.getX()) && (b.getY() == b.getY()) && (b.getZ() == b.getZ())) {
            System.out.println("Вектор B равен самой себе.");
        }

        if ((a.getX() == b.getX()) && (a.getY() == b.getY()) && (a.getZ() == b.getZ())) {
            System.out.println("Вектор А равен вектору B.");
        } else {
            System.out.println("Вектор А не равен вектору В.");
        }

//-----------------------------------------------------------------------------------------------\\

        System.out.println("\n\n//  17 задание  //");
        vectorPR1.print();
        vectorPR2.print();

        vectorPR1.sum(vectorPR2).print();
        vectorPR1.raz(vectorPR2).print();
        vectorPR1.prz(vectorPR2).print();
        double sc = vectorPR1.scl(vectorPR2);
        System.out.println("Скалярное произведние = " + sc);
        boolean cl = vectorPR1.cll(vectorPR2);
        System.out.println("Коллониарность: " + cl);
//-----------------------------------------------------------------------------------------------\\

        System.out.println("\n\n//  18 задание  //");
        Vector3DArray vArr = new Vector3DArray(5);

        Vector3D vector0 = new Vector3D(0, 0, 0);
        Vector3D vector1 = new Vector3D(2, 5, -1);
        Vector3D vector2 = new Vector3D(-12, 4, 1);
        Vector3D vector3 = new Vector3D(1, 1, 1);
        Vector3D vector4 = new Vector3D(-1, -1, 1);


        vArr.replaceVector(vector0, 0);
        vArr.replaceVector(vector1, 1);
        vArr.replaceVector(vector2, 2);
        vArr.replaceVector(vector3, 3);
        vArr.replaceVector(vector4, 4);


        System.out.println("Длина массива = "+vArr.getLength());
        System.out.println("Наибольшая длина векторов в массиве = "+vArr.maxLength());

        //Vector3D vM=vector1;
        Vector3D vM=new Vector3D(45, 6, 3);

        int i = vArr.searchVect(vM);
        System.out.println("Результат поиска вектора M"+vM.printXYZ()+" в массиве = "+i);

        Vector3D sumAll = vArr.summarize();
        System.out.println("Сумма всех векторов в массиве = " + sumAll.printXYZ());


        double[] z = {2, 2, 100, 2};
        try {
            Vector3D lineCombVector = new Vector3D();
            lineCombVector = vArr.linearComb(z);
            System.out.println("Результат вычисление линейной комбинации = " + lineCombVector.printXYZ());
        } catch (Exception e) {
            System.out.println("Результат не существует, т.к. длины массивов разные. ");
        }

        Point3D P = new Point3D(1,1,1);
        Point3D[] pArr = vArr.shiftPoint(P);
        System.out.println("\nСдвиг массива по точке P"+ P.printXYZ());
        for ( int i1 = 0; i1 < pArr.length; i1++ ){
            System.out.println("P["+i1+"] = (" + pArr[i1].getX()+", "+pArr[i1].getY()+", "+pArr[i1].getZ()+")");
        }
        System.out.println();

    }
}
