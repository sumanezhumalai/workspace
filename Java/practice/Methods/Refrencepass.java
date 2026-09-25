class Suman {
  String name;
  int age;
  boolean student;

  void detailModify(Suman y) {

    y.name = "Ezhumalai";
    y.age = 52;
    y.student = false;
  }

  void Display() {
    System.out.println(name + " " + age + " " + " student : " + student);
  }
}

class Refrencepass {
  public static void main(String[] args) {
    Suman a = new Suman();
    a.name = "Suman";
    a.age = 20;
    a.student = true;
    a.Display();
    a.detailModify(a);
    a.Display();
  }
}
