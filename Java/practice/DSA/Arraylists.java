import java.util.ArrayList;
import java.util.List;

class Arraylists {
  public static void name() {
    List<String> a = new ArrayList<String>();
    a.add("Suman");

    for (int i = 0; i < a.size(); i++) {
      System.out.println(a.get(i));
    }
  }
}
