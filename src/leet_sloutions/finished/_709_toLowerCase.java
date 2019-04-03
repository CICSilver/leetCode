package leet_sloutions.finished;

public class _709_toLowerCase {
    /**
     * 大写字符转换为小写
     */
    public String toLowerCase(String str) {
        if(str==null) {
            return str;
        }
        for(int i=0;i< str.length();i++) {
            int temp=(int)(str.charAt(i));
            if(temp<65||temp>122) {
                continue;
            }else if(temp<97&&temp>91) {
                continue;
            }
            if(temp<91) {
                str=str.replace(str.charAt(i),(char)(str.charAt(i)+32));
            }
        }
        return str;
    }
}
