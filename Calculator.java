class Calculator{
  public static void main(String args[]){
    int number1 = 0;  /* 最初の数字 */
    int number2 = 0;  /* 次の数字 */
    String operator;    /* 演算子 */
    int Answer;     /* 結果を格納 */

    //エラー処理
    if (args.length != 3){
      errDisp("引数は3個入力して下さい");
    }

    try{
      number1 = Integer.parseInt(args[0]);
      number2 = Integer.parseInt(args[2]);
    }catch(NumberFormatException e){
      errDisp("数値でない値が入力されています");
    }

    operator = args[1];

    //加減乗除の記号を追加
    String operatorStr[] = {"*", "/", "+", "-"};
    boolean errFlag = true;

    for (int i = 0 ; i < 4 ; i++){
      if (operator.equals(operatorStr[i])){
        errFlag = false;
      }
    }

    if (errFlag == true){
      errDisp("演算子は * / + - の4つです");
    }

    if (operator.equals("*")){
      Answer = number1 * number2;
    }else if (operator.equals("+")){
      Answer = number1 + number2;
    }else if (operator.equals("-")){
      Answer = number1 - number2;
    }else{
      if (number2 == 0){
        errDisp("0 で割ろうとしました");
      }

      Answer = number1 / number2;
    }

    System.out.println("入力された式は " + number1 + " " + operator + " " + number2 + " です");
    System.out.println("計算結果は " + Answer + " です");
  }

  private static void errDisp(String errStr){
    System.out.println("Usage : java Calculator 数値 演算子 数値");
    System.out.println(errStr);
    System.exit(0);  /* プログラムを終了する */
  }
}
