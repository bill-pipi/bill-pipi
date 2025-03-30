/*
ID: bill.pi1
LANG: JAVA
PROG: ride
*/

import java.io.*;

class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

        String a = f.readLine();
        String b = f.readLine();

        String ref = "0ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int apro = 1, bpro = 1;

        for (int i = 0; i < a.length(); i++) apro *= ref.indexOf(a.charAt(i));
        for (int i = 0; i < b.length(); i++) bpro *= ref.indexOf(b.charAt(i));

        if (apro % 47 == bpro % 47) out.println("GO"); else out.println("STAY");
        out.close();
        System.exit(0);
    }
}