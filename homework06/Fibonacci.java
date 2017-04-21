public class Fibonacci{
  public static GinormousInt fibonacci(int number) {
    GinormousInt fib1  = new GinormousInt("0");
    GinormousInt fib2  = new GinormousInt("1");
    GinormousInt fib3  = null;


    if (number == 0|| number == 1) {
      return GinormousInt.ONE;
    }
    for (int i = 1; i < number; i ++) {
      fib1 = fib2.addInt(fib3);
      fib2 = fib3;
      fib3 = fib1;
    }
    return fib1;
  }

  public static void main( String args[] ) {
    Fibonacci fibonacci = new Fibonacci();
    System.out.println(fibonacci(Integer.parseInt(args[0])));
  }
}
