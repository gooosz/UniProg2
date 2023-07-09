package Uebung10.Zusatz;

import Uebung10.Aufgabe5.FolgeMitDynArray;
import Uebung7.Aufgabe4.Suchbaum;

public class ProjectEuler {
    public static void main(String[] args) {
        Suchbaum<Integer> folge = new Suchbaum<>();
        for (int a=2; a<=100; a++) {
            for (int b=2; b<=100; b++) {
                int power = power(a, b);
                if (!folge.contains(power)) {
                    folge.insert(power);
                }
            }
        }
        System.out.println(folge);
        System.out.println(folge.size());
    }
    public static int power(int a, int b) {
        return (int)Math.pow(a, b);
    }
}
