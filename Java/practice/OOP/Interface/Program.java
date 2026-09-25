package Interface;


class Program implements Workings {

  public void print() {
    System.out.println("Print function called from " + this.getClass());
  }

  public static void main(String arg[]) {
    Workings obj = () -> {
      System.out.println("Printable executed");
    };
    obj.print();
  }
}
