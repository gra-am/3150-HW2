package org.openjfx;

import java.io.*;

public class FileConverter {

    public void txtToBin(String fileName) throws IOException {
        File file = new File(fileName + ".bin");
        byte[] fileData = new byte[file.length()];
        FileInputStream in = new FileInputStream(file);
        in.read(fileData);
        in.close();
    }

    public void binToTxt(String file) throws IOException {

    }

    private String toBits(){

    }

}
