import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            scanFile();
        } catch (FileNotFoundException e) {//if user put wrong path or file name
            System.out.println("File not found, enter proper file path");
        }
    }
    private static boolean changePossible(String protein1, String protein2) {
        boolean changePossible = false;
        if (protein1.length() != protein2.length()) {
            changePossible = false;
        } else {
            int[] aminoAcidCounter1 = aminoAcidCounter(protein1);
            int[] aminoAcidCounter2 = aminoAcidCounter(protein2);

            for (int i = 0; i < aminoAcidCounter1.length; i++) {

                if (aminoAcidCounter1[i] == aminoAcidCounter2[i]) {
                    changePossible = true;
                } else {
                    changePossible = false;
                    break;
                }
            }
        }
        return changePossible;
    }
    public static int[] aminoAcidCounter(String protein) {
        int[] aminoAcidCounter = new int[20];
        char singleAminoAcid;
        for (int i = 0; i < protein.length(); i++) {
            try {
                singleAminoAcid = protein.charAt(i);
                aminoAcidCounter[singleAminoAcid - 65]++;
            } catch (ArrayIndexOutOfBoundsException e) {//if in amino acid chain has invalid symbol out of range A-T
                System.out.println("Invalid amino acid symbol in chain");
            }
        }
        return aminoAcidCounter;
    }
    private static void scanFile() throws FileNotFoundException {
        System.out.println("Enter file path");
        Scanner pathScanner = new Scanner(System.in);
        String path = pathScanner.nextLine();
        File proteinFile = new File(path);
        Scanner proteinScanner = new Scanner(proteinFile);
        String protein1;
        String protein2;
        while (proteinScanner.hasNext()) {
            protein1 = proteinScanner.next();
            protein2 = proteinScanner.next();
            System.out.println(changePossible(protein1, protein2));
        }
        pathScanner.close();
        proteinScanner.close();
    }
}

