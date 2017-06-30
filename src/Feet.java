import java.util.Random;

class Feet {
    Feet(Field field){
        int rx;
        int ry;
        do {
            rx = new Random().nextInt(38);
            ry = new Random().nextInt(38);
        }while (field.getCell(rx, ry)!= 0);
        field.setCell(rx, ry,2);
    }
}

