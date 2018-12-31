import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
public class sensitive_Vocabulary {

    Scanner input=new Scanner(System.in);
    public String[] ch;

    public void write(int number)throws Exception{
        System.out.println("输入查询敏感字");
        ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("sensitive.txt"));
        for(int i=0;i<number;i++) {
            String str = input.nextLine();
            output.writeUTF(str);
        }
        output.close();
    }



    public void readObject(int number)throws Exception{
        ObjectInputStream input=new ObjectInputStream(new FileInputStream("sensitive.txt"));
        ch =new String[number];
        for(int j=0;j<number;j++) {
            ch[j] = input.readUTF();
            //print("敏感词汇为："+ch[j]);
        }
        input.close();
    }

}