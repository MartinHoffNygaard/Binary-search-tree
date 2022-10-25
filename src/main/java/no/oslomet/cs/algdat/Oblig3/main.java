package no.oslomet.cs.algdat.Oblig3;

import java.util.ArrayList;
import java.util.Comparator;

public class main {
    public static void main(String[] args) {
        SBinTre<Integer> tre =
                new SBinTre<>(Comparator.naturalOrder());
        int[] a = {10, 14, 6, 8, 1, 12, 7, 3, 11, 9, 13, 5, 2, 4};
        for (int verdi : a) { tre.leggInn(verdi); }

        tre.fjern(6);
    }
}
