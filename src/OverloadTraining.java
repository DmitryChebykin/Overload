public class OverloadTraining {
    public static final int BYTE_BIT_AMOUNT = 8;

    public static void main(String[] args) {
        {
            int x = 2_000_123;
            printPrimitiveInfo(x);
            System.out.println("getTypeSize = " + getTypeSize(x));
        }

        {
            byte x = 16;
            printPrimitiveInfo(x);
            System.out.println("getTypeSize = " + getTypeSize(x));
        }

        {
            long x = Long.MAX_VALUE;
            printPrimitiveInfo(x);
            System.out.println("getTypeSize = " + getTypeSize(x));
        }

        {
            short x = 32000;
            printPrimitiveInfo(x);
            System.out.println("getTypeSize = " + getTypeSize(x));
        }

        {
            double x = 16.4;
            printPrimitiveInfo(x);
            System.out.println("getTypeSize = " + getTypeSize(x));
        }

        {
            float x = 16;
            printPrimitiveInfo(x);
            System.out.println("getTypeSize = " + getTypeSize(x));
        }
    }

    private static int getTypeSize(byte argument) {
        return 1;
    }

    private static int getTypeSize(int argument) {
        return 4;
    }

    private static int getTypeSize(short argument) {
        return 2;
    }

    private static int getTypeSize(long argument) {
        return 8;
    }

    private static int getTypeSize(float argument) {
        return 4;
    }

    private static int getTypeSize(double argument) {
        return 8;
    }

    private static <E extends Number> void printPrimitiveInfo(E x) {
        Object bitSize = null;

        try {
            bitSize = x.getClass().getField("SIZE").get(x);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        String type = x.getClass().getTypeName().toLowerCase().replace("java.lang.", "");

        System.out.println(type + " x = " + x + ", byte size = " + (int) bitSize / BYTE_BIT_AMOUNT);
    }
}