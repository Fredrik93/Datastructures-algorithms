import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class RPN {
  private Stack<String> evaluationStack = new Stack<String>();


  // Main input loop
  public void loop() {
    Scanner in = new Scanner(System.in);

    final String prompt = "> ";
    System.out.print(prompt);

    while (in.hasNext()) {
      try {
        String s = in.next();
        if (s.equals("quit") || s.equals("q")) {
          System.out.println("Quitting");
          break;
        }
        if (s.equals("/") || s.equals("+") || s.equals("-") || s.equals("*")) {
          if (evaluationStack.size() < 2) {
            throw new Exception("stack has one or no value in it");
          }

          evaluate(s);
        } else {
          if (!checkString(s))
            System.out.println("Got a string: " + s);
          else {
            evaluationStack.push(s);
            this.toString();
          }
        }

        System.out.print(prompt);
      } catch (Exception e){
        System.out.println(e.getMessage());
        System.out.print(prompt);
      }
    }
    this.toString();
    in.close();
  }

  // Evaluate the stack and push the result back in the same stack
  public void evaluate(String s) {
    System.out.println("Tokens: " + s);
    double temp1 = Double.parseDouble(evaluationStack.pop());
    double temp2 = Double.parseDouble(evaluationStack.pop());
    double temp3 = 0;
    boolean flag = false;
    try {
      if( s.equals("/")) {
        temp3 = temp2 / temp1;
        flag = true;
      }
      if( s.equals("+")) {
        temp3 = temp2 + temp1;
        flag = true;
      }
      if( s.equals("-")) {
        temp3 = temp2 - temp1;
        flag = true;
      }
      if ( s.equals(("*"))) {
        temp3 = temp2 * temp1;
        flag = true;
      }
      if (!flag)
        throw new Exception("temp 3 in evaluate is not initialised");
    } catch (Exception e){
      e.getMessage();
    } finally {
      System.out.println(temp3);
      if (flag) {
        String newV = String.valueOf(temp3);
        evaluationStack.push(newV);
      }
    }



    System.out.println(this.toString());
  }

  // To visualise the token stack
  public String toString() {
    System.out.println(Arrays.toString(evaluationStack.toArray()));
    StringBuilder res = new StringBuilder();
    return res.toString();
  }

  // For unit test purposes
  public void addToken(String token) {
    evaluationStack.add(token);
  }

  // For unit test purposes
  public Stack<String> getEvaluationStack() {
    Stack<String> copy = new Stack<String>();
    copy.addAll(evaluationStack);
    return copy;
  }

  public static boolean checkString(String in) {

    try {
      double i = Double.parseDouble(in);

    } catch (NumberFormatException | NullPointerException nfe) {
      return false;
    }

    return true;
  }

  public String printStack(){
    return evaluationStack.toString();
  }


  public static void main(String[] args) {
    RPN calc = new RPN();
    calc.loop();

  }
}