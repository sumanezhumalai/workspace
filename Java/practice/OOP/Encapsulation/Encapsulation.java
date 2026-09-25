package Encapsulation;

class Account {

  private String name;
  private int balance;

  void setBalance(int amt) {
    if (amt > 0) {
      balance = amt;
      System.out.println("Amount has set");
    } else {
      System.out.println("Invalid amount");
    }
  }

  int getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

class Encapsulation {

  public static void main(String[] args) {

    Account A = new Account();

    // A.balance=100; we'll get error: balance has private access in Account
    A.setBalance(10000);
    System.out.println(A.getBalance());
  }
}
