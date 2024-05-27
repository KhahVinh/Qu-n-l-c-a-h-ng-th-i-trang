
package IO;

import Models.MatHang;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class MatHangIO {
    private static final String FILE_NAME_MATHANG = "MatHang.txt";
   
    public static ArrayList<MatHang> readFromFile() {
        ArrayList<MatHang> list = new ArrayList<MatHang>();
        try {
            FileReader fr = new FileReader(FILE_NAME_MATHANG);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                list.add(new MatHang(txt[0], txt[1]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (list == null) {
            list = new ArrayList<MatHang>();
        }
        return list;
    }
    
    public static void writeToFile(ArrayList<MatHang> list) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_MATHANG);
            BufferedWriter bw = new BufferedWriter(fw);
            for (MatHang i : list) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void writeToFile(ArrayList<MatHang> list, boolean nextLine) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME_MATHANG, nextLine);
            BufferedWriter bw = new BufferedWriter(fw);
            for (MatHang i : list) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
