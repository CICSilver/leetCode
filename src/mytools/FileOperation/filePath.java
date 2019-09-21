package mytools.FileOperation;

import java.util.Objects;

public class filePath {
    public String path;
    public filePath(String fileName) {
        path= getClass().getClassLoader().getResource(fileName).toString();
        path = path.replace("\\","/");
        if(path.contains(":")) {
            path = path.replace("file:/","");
        }
    }
}
