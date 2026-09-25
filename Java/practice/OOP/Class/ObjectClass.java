package Class;

class User { // every class in java default inherits "Object" class
    private String name;
    private String mail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    // Default object class's method overrides
    // @Override
    // public String toString() {
    // return ("Name: " + this.name + ", Mail: " + this.mail);
    // }

    public boolean equals(User that) {
        return (this.name == that.name && this.mail == that.mail);
        // can also skip .this ,
        // return (this.name == that.name && this.mail == that.mail);
    }



}

public class ObjectClass {
    public static void main(String[] args) {
        User suman = new User("Suman", "sumanezhumalai@gmail.com");

        System.out.println(suman); // same - by defaut calls toString() from super class "Object"
        System.out.println(suman.toString()); // same (but can be overriden like above)

        User newUser = new User("Suman", "sumanezhumalai@gmail.com");

        System.out.println(suman == newUser);
        System.out.println(suman.equals(newUser));
        /*
         * In Java, every time you use the new keyword to create an object, a unique
         * block of memory is allocated in the heap with its own distinct memory
         * address. This happens even if the data inside the duplicate object is
         * completely identical to the original.
         * 
         * Heap Memory
         * ┌────────────────────────┐
         * │ [Address: 0x001] │ ◄── Object A (e.g., Person name="Alex")
         * ├────────────────────────┤
         * │ [Address: 0x002] │ ◄── Object B (e.g., Person name="Alex")
         * └────────────────────────┘
         * 
         * so we define a custom equals to override object's funtion
         */

        System.out.println(suman.hashCode());
    }

}
