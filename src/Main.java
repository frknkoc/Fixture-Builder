import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        System.out.println("Fikstür Oluşturucuya hoş geldiniz!\n");
        System.out.println("Kaç takım girmek istediğinizi giriniz :");
        Scanner input = new Scanner(System.in);
        int numberOfTeams = input.nextInt();
        String teamName;
        List<String> teamList = new ArrayList<>();
        for (int i = 0; i < numberOfTeams; i++) {
            System.out.println("Takım giriniz :");
            teamName = input.nextInt() + ". Takım";
            teamList.add(teamName);
        }
        System.out.println("\nTakımların listesi : " + teamList);
        System.out.println("Takım sayısı : " + teamList.size() + "\n");

        if (teamList.size() % 2 == 1) {
            teamList.add("Bay");
        } else {
            System.out.println("\nGirilen takım sayısı çift olduğu için Bay hafta olmayacak\n");
        }
        System.out.println("\nTakımların listesi : " + teamList);
        System.out.println("Takım sayısı : " + teamList.size() + "\n");
        Collections.shuffle(teamList); // Takımları karıştırarak rastgele sıralama yapın
        generateFixture(teamList);
    }
    public static void generateFixture(List<String> teams) {
        int totalTeams = teams.size();
        int rounds = (totalTeams - 1) * 2; // Toplam tur sayısı
        for (int round = 0; round < rounds; round++) {
            System.out.println("\nRound " + (round + 1) + ":");
            List<String> homeTeams = new ArrayList<>();
            List<String> awayTeams = new ArrayList<>(); // Ev sahibi ve deplasman takımlarını belirlendi
            for (int i = 0; i < totalTeams / 2; i++) {
                homeTeams.add(teams.get(i));
                awayTeams.add(teams.get(totalTeams - 1 - i));
            } // Maçları eşleştirildi
            for (int i = 0; i < homeTeams.size(); i++) {
                System.out.println(homeTeams.get(i) + " : " + (int) (Math.random() * 5) + " VS " + (int) (Math.random() * 3) + " : "  + awayTeams.get(i));
            } // Takımları döndürerek farklı eşleşmeler oluşturuldu
            Collections.rotate(teams, 1);
        }
    }
}