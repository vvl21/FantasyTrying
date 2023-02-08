import java.util.Random;

public class TeamGenerator {
    private Random random = new Random();
    int wordLength;

    String lowers = "bcdfghgklmnpqrstvwxz";
    String vowels = "aeiouy";

    public TeamGenerator() {
        StringBuilder team = teamName();
        StringBuilder team2 = teamName();
        System.out.println(team + " -VS- " + team2);
    }

    private StringBuilder teamName() {
        boolean gotPrefix = false;
        StringBuilder team = new StringBuilder();
        int pref = random.nextInt(1, 10);
        if (pref < 3) {
            team.append("FC ");
            gotPrefix = true;
        }
        int wordLength = random.nextInt(3, 9);

        int startWith = random.nextInt(1, 4);
        switch (startWith) {
            case 1:
                team.append("ACS".charAt(random.nextInt(0, 2)));
                break;
            case 2:
                team.append("PBFHGE".charAt(random.nextInt(0, 5)));
                break;
            case 3:
            case 4:
                team.append("IKLMNOQRTUVWXYZ".charAt(random.nextInt(0, 15)));
                break;
        }

        for (int i = 1; i < wordLength; ) {
            team.append(lowers.charAt(random.nextInt(lowers.length())));
            i++;
            team.append(vowels.charAt(random.nextInt(vowels.length())));
            if (i < wordLength - 1) i++;
        }
        if (!gotPrefix) {
            int post = random.nextInt(1, 10);
            if (post < 2) {
                team.append(" FC");
            }
        }
        return team;
    }
}
