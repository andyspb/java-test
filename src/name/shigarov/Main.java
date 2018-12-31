package name.shigarov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

  public static void find(ArrayList<String[]> res, String ex) {
    int c1 = 0;
    int c2 = 0;
    int mx = 0;
    String ans1 = "";
    String ans2 = "";
    while (c2 < res.size()) {
      int start = Integer.parseInt(res.get(c1)[0].replace(":", "").replace(".", ""));
      int finish = Integer.parseInt(res.get(c2)[0].replace(":", "").replace(".", ""));
      if (finish - start < 1000) {
        if (c2 - c1 + 1 >= mx) {
          mx = c2 - c1 + 1;
          ans1 = res.get(c1)[0];
          ans2 = res.get(c2)[0];
        }
        c2++;
      } else {
        c1++;
      }
    }
    System.out.println(String.format(
        "Maximum num of trades in one second between %s and %s. There was %s num of trades. Exchange %s",
        ans1, ans2, mx, ex));

  }

  public static void main(String[] args) throws IOException {
    String filename = "TRD2.csv";
    BufferedReader fp = new BufferedReader(new FileReader(filename));

    String[] hdr = fp.readLine().split(",");
    ArrayList<String[]> full = new ArrayList<>();
    String[] cols;
    HashMap<String, ArrayList<String[]>> exch = new HashMap<>();
    while (fp.ready()) {
      cols = fp.readLine().split(",");
      if (!exch.containsKey(cols[cols.length - 1])) {
        exch.put(cols[cols.length - 1], new ArrayList<>());
      }
      exch.get(cols[cols.length - 1]).add(cols);
      full.add(cols);
    }
    fp.close();
    find(full, "all");
    for (String key : exch.keySet()) {
      find(exch.get(key), key);
    }

  }
}
