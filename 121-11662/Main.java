import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

class Pos implements Comparable<Pos> {
  int i;
  int j;

  Pos(int i, int j) {
    this.i = i;
    this.j = j;
  }

  public int compareTo(Pos p) {
    return i == p.i ? j - p.j : i - p.i;
  }
}


public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int di[] = {-1, 0, 1, 0}, dj[] = {0, 1, 0, -1};

  static void log(Object o) {
    System.out.print(o);
  }

  public static void main(String[] args) throws IOException {
    double Ax, Ay, Bx, By, Cx, Cy, Dx, Dy;
    StringTokenizer st = new StringTokenizer(br.readLine());
    Ax = Double.parseDouble(st.nextToken());
    Ay = Double.parseDouble(st.nextToken());
    Bx = Double.parseDouble(st.nextToken());
    By = Double.parseDouble(st.nextToken());
    Cx = Double.parseDouble(st.nextToken());
    Cy = Double.parseDouble(st.nextToken());
    Dx = Double.parseDouble(st.nextToken());
    Dy = Double.parseDouble(st.nextToken());

    double ans = 2e9;
    double ltx1 = Ax, lty1 = Ay, rtx1 = Bx, rty1 = By;
    double ltx2 = Cx, lty2 = Cy, rtx2 = Dx, rty2 = Dy;
    while (Math.abs(ltx1 - rtx1) >= 1e-8) {
      double dx1 = (rtx1 - ltx1) / 3;
      double dy1 = (rty1 - lty1) / 3;
      double dx2 = (rtx2 - ltx2) / 3;
      double dy2 = (rty2 - lty2) / 3;
      if (dis(ltx1 + dx1, lty1 + dy1, ltx2 + dx2, lty2 + dy2) < dis(rtx1 - dx1, rty1 - dy1,
          rtx2 - dx2, rty2 - dy2)) {
        rtx1 -= dx1;
        rty1 -= dy1;
        rtx2 -= dx2;
        rty2 -= dy2;
      } else {
        ltx1 += dx1;
        lty1 += dy1;
        ltx2 += dx2;
        lty2 += dy2;
      }
      ans = Math.min(ans, dis(ltx1, lty1, ltx2, lty2));
    }
    DecimalFormat df = new DecimalFormat("0.000000");
    log(df.format(Math.sqrt(ans)) + "\n");
    // BigDecimal = bd = new BigDecimal(Math.sqrt(ans));
    // log(bd.toPlainString() + "\n");
  }

  static double dis(double x1, double y1, double x2, double y2) {
    return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
  }
}
