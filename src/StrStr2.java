public class StrStr2 {
    public StrStr2(){}
    public int implementstrStr2(String source, String target){
        if(target.length() > source.length()) return -1;
        if(source.length() == 0 || target.length() == 0) return -1;

        int sl = 0; //left pointer used in source;
        int sr; //right pointed used in source;
        int tp = 0; //pointer used in target;
        for(sr = 0; sr < source.length();){
            if(source.charAt(sl) != target.charAt(0)){ // if sl is not equal to the first letter, move along with sr
                sl++;
                sr++;
            }else{ //if sl is equal, star checking
                if(tp == target.length() - 1 && source.charAt(sr) == target.charAt(tp))return sl;  //if tp move the end, the result is found
                if(source.charAt(sr) == target.charAt(tp)){ //if sr and tp are pointing the same char, move two points together
                    sr++;
                    tp++;
                }else{
                    tp = 0; //reset the tp
                    sr ++; //move sr forward
                    sl = sr; // align sl with sr
                }
            }
        }
        return -1;
    }
}
