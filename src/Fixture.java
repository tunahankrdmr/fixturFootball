import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fixture {
    private List<Team> teams;
    Random rn=new Random();
    private List<String> firstHalf, secondHalf;
    private static int sc=1;

    public Fixture(List<Team> teams) {
        this.teams = teams;
        if (teams.size()%2!=0){
            teams.add(new Team("BAY"));
        }
        firstHalf=new ArrayList<>();
        secondHalf=new ArrayList<>();
    }

    public void fixtureGenerate(){
        List<Team> teamsCopy=new ArrayList<>();
        teamsCopy.addAll(teams);
        int counter=0;
        int numTeam= teams.size();
        int numRound=numTeam-1;
        while (counter<numRound){
            int sayac=0;
            while (sayac<numTeam/2){
                Team home= teamsCopy.get(rn.nextInt(teamsCopy.size()));
                Team away= teamsCopy.get(rn.nextInt(teamsCopy.size()));
                if (home!=away &&
                        !firstHalf.contains(home.getName() + " vs " + away.getName()) &&
                        !firstHalf.contains(away.getName() + " vs " + home.getName())){
                    teamsCopy.remove(home);
                    teamsCopy.remove(away);
                    firstHalf.add(home.getName() + " vs " + away.getName());
                    secondHalf.add(away.getName() + " vs " + home.getName());
                    sayac++;
                    if (sayac==numTeam/2){
                        teamsCopy.addAll(teams);
                    }
                }
            }
            counter++;
        }
        matches(firstHalf);
        matches(secondHalf);
    }

    public void matches(List<String> matchHalf){
        for (int i = 0; i < matchHalf.size(); i++) {
            if (i % 3 == 0) {
                System.out.println("\n " + sc + ". Round: ");
                sc++;
            }

            System.out.println(matchHalf.get(i));

        }
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
