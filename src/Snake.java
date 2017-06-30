import java.awt.*;
import java.util.LinkedList;

class Snake {
    private int score;
    private Field field;
    private int dx, dy;
    private boolean crash;
    private LinkedList<Point> list = new LinkedList<>();

    Snake(Field field) {
        this.field = field;
        new Feet(field);
        score = 0;
        for (int i = 0; i < 4; i++) {
            field.setCell(30, 10 + i, 3);
            list.add(new Point(30, 10 + i));

        }
        dx = -1;
        dy = 0;
    }

    void right() {
        if (dx == 0) {
            dx = 1;
            dy = 0;
        }
    }

    void left() {
        if (dx == 0) {
            dx = -1;
            dy = 0;
        }
    }

    void up() {
        if (dy == 0) {
            dx = 0;
            dy = -1;
        }
    }

    void down() {
        if (dy == 0) {
            dx = 0;
            dy = 1;
        }
    }

    boolean isCrash() {
        return crash;
    }

    void move() {
        field.setCell(list.getLast().x,list.getLast().y,0);
        list.removeLast();
        Point currentHead = list.getFirst();
        Point point = new Point(currentHead.x + dx, currentHead.y + dy);
        switch (field.getCell(point.x,point.y)){
            case 0:
                break;
            case 2:
                score++;
                Point extraPoint = new Point(currentHead.x + dx, currentHead.y + dy);
                list.addFirst(extraPoint);
                field.setCell(extraPoint.x,extraPoint.y,3);
                new Feet(field);
                break;
            case 1:
            case 3:
                crash = true;
                return;
        }
        list.addFirst(point);
        field.setCell(point.x,point.y,3);
    }
    int getScore(){
        return score;
    }
}

