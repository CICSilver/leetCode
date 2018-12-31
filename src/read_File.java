import java.io.*;
import java.util.Scanner;
public class read_File {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("输入你要输入的敏感词汇个数");
        int number = input.nextInt();
        int[] array = new int[number];
        for (int r = 0; r < number; r++)
            array[r] = 0;
        sensitive_Vocabulary test = new sensitive_Vocabulary();
        test.write(number);
        test.readObject(number);
        try {
            StringBuffer sb = new StringBuffer();
            FileReader reader = new FileReader("D://test.txt");
            BufferedReader br = new BufferedReader(reader);
            String str = null;
            String str_fir;
            while ((str = br.readLine()) != null) {
                sb.append(str);
                for (int k = 0; k < number; k++) {
                    str_fir = " " + test.ch[k] + " ";
                    array[k] += countStr(str, str_fir);
                }
            }
            br.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for (int j = 0; j < number; j++) {
            System.out.println("敏感词" + " " + test.ch[j] + " "+array[j] + "个");
        }
    }

    public static int countStr(String str1, String str2) {
        int counter = 0;
        if (!str1.equals(str2)) {
            return 0;
        }
        else {
            counter++;
        }
        return counter;
    }
}
