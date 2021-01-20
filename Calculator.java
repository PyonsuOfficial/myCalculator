import java.util.Scanner;

public class Calculator {
  private static final Scanner SCANNER = new Scanner(System.in);

  public static void main (String[] args){
    int val1 = 0; // 最初の数字
    int val2 = 0; // 次の数字
    String ope; // 演算子 
    int result = 0; // 結果を収納
    
    System.out.println("これから計算をはじめます");
    System.out.println("すべて半角入力でお願いします");
    System.out.print("1つ目の整数を入力してください => ");
    String firstNum = SCANNER.next();
  
    System.out.print("演算子を入力してください(+,-,*,/) => ");
    ope = SCANNER.next();
      
    System.out.print("2つ目の整数を入力してください => ");
    String secondNum = SCANNER.next();
    
    if (isNumber(firstNum, secondNum)) { // 入力された数字のチェック 文字列から整数に変換
      val1 = Integer.parseInt(firstNum);
      val2 = Integer.parseInt(secondNum);
    } else {
      errDisp("数値でない値が入力されています");
    }

    if (!isOpeope(ope)) { // 入力された演算子のチェック
      errDisp("演算子は +, -, *, / の4つです");
    }

    result = cal(val1, val2, ope); // 計算

    System.out.println("入力された式は " + val1 + " " + ope + " " + val2 + " です");
    System.out.println("計算結果は " + result + " です");

  }

  public static boolean isNumber(String str1, String str2) {
    try{
      Integer.parseInt(str1);
      Integer.parseInt(str2);
        return true;
    } catch (NumberFormatException e) {
      return false;
    }
  } 

  public static boolean isOpeope(String str) {
    String[] opeStr = {"+", "-", "*", "/"};
    for (int i = 0; i < 4; i++) {
      if (str.equals(opeStr[i])) {
        return true;
      }
    }
    return false;
  }
    
    public static int cal(int val1, int val2, String ope) {
      int result = 0;
      if (ope.equals("+")) {
        result = val1 + val2;
      } else if (ope.equals("-")) {
        result = val1 - val2;
      } else if (ope.equals("*")) {
        result = val1 * val2;
      } else {
        if (val2 == 0) {
          errDisp("0で割ろうとしました");
        } else {
          result = val1 / val2 ;
        }
      }
      return result;
    }

  private static void errDisp(String errStr){
    System.out.println(errStr);
    System.out.println("プログラムを終了します");
    System.exit(0);  /* プログラムを終了する */
  }
}