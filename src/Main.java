import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Leet Code");
        //strStr();
        //subSets();
        subSetswDups();
    }

    public static void strStr(){
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println("result: " + implementStrStr.strStr("ab", "ab"));
        System.out.println("result: " + implementStrStr.strStr("ab", "abcd"));
        System.out.println("result: " + implementStrStr.strStr("ad", ""));
        System.out.println("result: " + implementStrStr.strStr("adbasdasdadadaas", "dd"));
        System.out.println("result: " + implementStrStr.strStr("abcd", "ab"));
        System.out.println("result: " + implementStrStr.strStr("abcdefghijk", "ghi"));
        System.out.println("result: " + implementStrStr.strStr("abcdefghijk", "ijk"));
        System.out.println("result: " + implementStrStr.strStr("", ""));
        System.out.println("result: " + implementStrStr.strStr("", "a"));
    }
    public static void subSets(){
        Subset subset1 = new Subset();
        List<List<Integer>> result = subset1.getSubsets(new int[]{0,1,2,3});
        List<List<Integer>> resultRes = subset1.getSubsetsRecursive(new int[]{0,1,2});
    }
    public static void subSetswDups(){
        SubsetwDup subsetwDup = new SubsetwDup();
        List<List<Integer>> result = subsetwDup.getSubsetsRecursive(new int[]{0,1,2,2});
        System.out.println(result);

    }
}
