package leet_sloutions.finished;

public class _771_numJewelsInStones {
    /**
     *  你想知道你拥有的石头中有多少是宝石。
     * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
     * @param J 石头中宝石的类型
     * @param S 代表你拥有的石头，个字符代表了一种你拥有的石头的类型
     * @return 宝石个数
     */
    public int numJewelsInStones(String J, String S) {
        int lenJ=J.length();
        int lenS=S.length();
        int count=0;
        for(int i=0;i<lenS;i++) {
            for(int j=0;j<lenJ;j++) {
                if(S.charAt(i)==J.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
}
