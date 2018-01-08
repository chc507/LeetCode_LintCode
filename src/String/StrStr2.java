package String;

public class StrStr2 {
    public int BASE = 10;
    public StrStr2(){}
    public int implementstrStr2(String source, String target){
        if(target == null || source == null) return -1;
        if(target.length() > source.length()) return -1;
        if(target.length() == 0) return 0;

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
                    sl = sr; // align sl with sr
                }
            }
        }
        return -1;
    }
    public int strSTR2wRk(String source, String target){

        if(source == null || target == null) {
            return -1;
        }

        int m = target.length();

        if( m == 0) {
            return 0;
        }

        // 31 ^ m
        int power = 1;
        for (int i = 0 ; i < m ; i++) {
            power = (power * 31) % BASE;
        }

        //hash code
        int targetCode = 0;
        for (int i = 0; i < m; i++){
            targetCode = (targetCode * 31 + target.charAt(i)) % BASE;
        }

        int hashCode = 0;
        for (int i = 0; i < source.length(); i++){
            //abc + d
            hashCode = (hashCode * 31 + source.charAt(i)) % BASE;
            if (i < m - 1){
                continue;
            }

            // /abcd -a
            if(i >= m){
                hashCode = (hashCode*31 - (source.charAt(i - m) * power)) % BASE;
                if(hashCode < 0){
                    hashCode += BASE; //roll back
                }
            }


            //double check with the String
            if(hashCode == targetCode){
                if(source.substring(i - m + 1, i + 1).equals(target)){
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}
