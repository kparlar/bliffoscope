package com.kparlar.bliffoscope.model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public abstract class AbstractItem {

    private char[][] matrix;
    private int width;
    private int height;
    private InputStream inputStream;

    public AbstractItem(InputStream inputStream) throws IOException {
        this.inputStream = inputStream;
        this.readData();
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void readData() throws IOException {
        List<String> rows = this.readFile(this.inputStream);
        this.constructMatrix(rows);
    }
    protected List<String> readFile(InputStream fileinputstream) throws IOException {
        InputStream is = fileinputstream;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String line = null;
        List<String> rows = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            rows.add(line);
        }

        br.close();

        return rows;
    }
    protected void constructMatrix(List<String> rows) {
        int row = rows.size();
        int column = rows.get(0).length();
        matrix = new char[row][column];

        for (int i = 0; i < row; i++) {
            String r = rows.get(i);
            for (int j = 0; j < column; j++) {
                matrix[i][j] = r.charAt(j);
            }
        }

    }
}
