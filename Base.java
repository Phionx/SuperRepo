/*
Just for the lols
*/

public class Base {
    private int _decNum;
    private String _baseNum;
    private final static String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String [] digits = {"0", "1", "2", "3","4","5","6","7","8","9","A","B","C","D","E","F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    public Base(){
        _decNum = 0;
        _baseNum = "0";
    }

    public static String decToBase(int n, int base){
        String ans = "";
		int temp = 0;
		while(n>0){
			temp = n%base;
			n = n/base;
			ans = digits[temp] + ans; 
		}
		return ans;
    }
    
    public static String decToBaseR(int n, int base){
        if(n==0) return "";
		return decToBaseR(n/base, base) + digits[n%base];
    }
    
    public static int baseToDec(String str, int base){
        int ans = 0;
		int len = str.length();
		while (len > 0){
			ans = base*ans + DIGITS.indexOf(str.substring(0,1));
			str = str.substring(1);
			len--;
		}
		return ans;
    }
    
    public static int baseToDecR(String str, int base){
        if(str.length() == 0) return 0;
		return base*baseToDecR(str.substring(0,str.length()-1), base) + (DIGITS.indexOf(str.substring(str.length()-1)));
    }
    
    
    public static String baseConvert(String s, int base1, int base2){
        int temp = baseToDec(s, base1);
        return decToBase(temp, base2);
    }
    
    public static String baseConvertR(String s, int base1, int base2){
        int temp = baseToDecR(s, base1);
        return decToBaseR(temp, base2);
    }
    
    public static void main(String [] args){
        System.out.println(Base.baseConvert("101", 2, 10));
        System.out.println(Base.baseConvertR("101", 2, 10));
    }
}