import mytools.FileOperation.filePath;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.*;

public class jsonTest {
    public static void main(String[] args) throws FileNotFoundException {
        String proPath = System.getProperty("user.dir");
        String path = proPath+"/jsonFiles/test.json";
        path = path.replace("\\","/");

        File file = new File(path);
        FileReader fileReader= new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        StringBuilder sb=new StringBuilder();

        JSONObject jsonObject=new JSONObject(path);
        Object s = jsonObject.get("temp1");
        try {
            String str;
            while((str=reader.readLine())!=null) {
                sb.append(str).append(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(s.toString());
    }
}
