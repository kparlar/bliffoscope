package com.kparlar.bliffoscope.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TargetItem extends AbstractItem {

    public TargetItem(InputStream inputStream) throws IOException {
        super(inputStream);
    }
    @Override
    public void readData() throws IOException {
        List<String> rows = readFile(this.getInputStream());

        // Removing last row as it is Blank line
        rows.remove(rows.size() - 1);

        // Removing first row as it is Blank line
        rows.remove(0);

        for (int i = 0; i < rows.size(); i++) {
            StringBuilder sb = new StringBuilder(rows.get(i));
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
            // Removing surrounding white space in first and last column
            rows.set(i, sb.toString());
        }

        constructMatrix(rows);

    }
}
