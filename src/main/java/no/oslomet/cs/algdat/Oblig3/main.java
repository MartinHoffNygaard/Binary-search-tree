package no.oslomet.cs.algdat.Oblig3;

import java.util.ArrayList;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        SBinTre<Integer> tre =
                new SBinTre<>(Comparator.naturalOrder());
        int[] a = {10, 14, 6, 8, 1, 12, 7, 3, 11, 9, 13, 5, 2, 4};
        for (int verdi : a) { tre.leggInn(verdi); }

//Gjør om treet til et array
        ArrayList<Integer> data = tre.serialize();

//Lag nytt tre fra arrayet over
        SBinTre<Integer> tre2 = SBinTre.deserialize(data, Comparator.naturalOrder());

//Utskriften av tre og tre2 skal være identiske
        System.out.println(tre.toStringPostOrder());
        System.out.println(tre2.toStringPostOrder());
    }
}
