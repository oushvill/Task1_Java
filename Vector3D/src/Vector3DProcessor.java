public class Vector3DProcessor {
    private double x;
    private double y;
    private double z;
    String name;

    public void print() {
        System.out.println(name + " = (" + x + ", " + y + ", " + z + ")");
    }


    public Vector3DProcessor(double v_x, double v_y, double v_z, String v_name) {
        this.x = v_x;
        this.y = v_y;
        this.z = v_z;
        this.name = v_name;
    }

    Vector3DProcessor(Object a, Object b, String v_name) {
        x = ((Point3D) b).getX() - ((Point3D) a).getX();
        y = ((Point3D) b).getY() - ((Point3D) a).getY();
        z = ((Point3D) b).getZ() - ((Point3D) a).getZ();
        name = v_name;
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}

    public Vector3DProcessor sum(Object v) {
        double x2, y2, z2;
        Vector3DProcessor vector = (Vector3DProcessor) v;
        x2 = getX() + vector.getX();
        y2 = getY() + vector.getY();
        z2 = getZ() + vector.getZ();
        Vector3DProcessor v_sum = new Vector3DProcessor(x2, y2, z2, "Вектор суммы: ");
        return v_sum;
    }

    public Vector3DProcessor raz(Object v) {
        double x3, y3, z3;
        Vector3DProcessor vector = (Vector3DProcessor) v;
        x3 = getX() - vector.getX();
        y3 = getY() - vector.getY();
        z3 = getZ() - vector.getZ();
        Vector3DProcessor v_raz = new Vector3DProcessor(x3, y3, z3, "Вектор разности: ");
        return v_raz;
    }

    public double scl(Object v) {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        double v_scl;
        v_scl = getX() * vector.getX() + getY() * vector.getY() + getZ() * vector.getZ();
        return v_scl;
    }


    public Vector3DProcessor prz(Object v) {
        double iPr, jPr, kPr;
        Vector3DProcessor vector = (Vector3DProcessor) v;
        iPr = getY() * vector.getZ() - getZ() * vector.getY();
        jPr = getZ() * vector.getX() - getX() * vector.getZ();
        kPr = getX() * vector.getY() - getY() * vector.getX();
        Vector3DProcessor v_pr = new Vector3DProcessor(iPr, jPr, kPr, "Вектор произведения: ");
        return v_pr;
    }


    public boolean cll(Object v) {
        Vector3DProcessor vector = (Vector3DProcessor) v;
        double xColl = getX() / vector.getX();
        double yColl = getY() / vector.getY();
        double zColl = getZ() / vector.getZ();

        if (xColl == yColl && xColl == zColl && yColl == zColl) {
            return true;
        } else {
            return false;
        }
    }
}

