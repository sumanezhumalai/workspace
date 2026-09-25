package Encapsulation;

class Account {

    private String name;
    private int balance;
    final float INTEREST_RATE = 2.5f;

    void setBalance(int amt) {
        balance = amt;
    }

    public void setINTEREST_RATE(float INTEREST_RATE) {
        // this.INTEREST_RATE = INTEREST_RATE; //throws error "The final field
        // Account.INTEREST_RATE cannot be assigned"
        // so no Encapsulation assignment/updation of a variable (CONSTANT)
    }

    public float getINTEREST_RATE() {
        return INTEREST_RATE;
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

class Final {

    public static void main(String[] args) {

        Account A = new Account();

        final String bankBeaurueName = "RBI";
        // bankBeaurueName = "SBI"; // throws error "The final local variable bankBeaurueName cannot be assigned. It
                                 // must be blank and not using a compound assignment"

        System.out.println("Order by : " + bankBeaurueName);
        // A.setBalance(10000);
        // System.out.println(A.getBalance());
    }
}
