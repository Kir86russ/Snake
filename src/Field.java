import java.io.*;

class Field {

    static final int SIZE = 40;
    private File file;
    private int[][] field = new int[SIZE][SIZE];

    Field() {
        file = new File("resource/Field.txt");
        readField();
    }

    private void readField() {
        String read;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < field.length; i++) {
                read = in.readLine();
                for (int j = 0; j < field.length; j++) {
                    field[i][j] = (int) read.charAt(j) - 48;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int getCell(int x, int y){
        return field[y][x];
    }

    void setCell(int x, int y, int value){
        field[y][x] = value;
    }
}


