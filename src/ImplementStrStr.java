public class ImplementStrStr {
    public ImplementStrStr(){}
    public int strStr(String source, String target){
        if(target.length() > source.length()) return -1;
        if(target.length() == 0 || source.length() == 0) return 0;

        //use double pointer to solve the problem
        int j = 0; //source pointer
        char firstLetter = target.charAt(0);
        int targetLength = target.length();
        for(j = 0; j < source.length(); j++){
            if (source.charAt(j) == firstLetter){
                if(j + targetLength <= source.length()) {
                    if (source.substring(j, j + targetLength).matches(target)) {
                        return j;
                    }
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }
}
