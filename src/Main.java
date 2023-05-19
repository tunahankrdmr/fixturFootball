import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Team> teams=new ArrayList<>();
        teams.add(new Team("Galatasaray"));
        teams.add(new Team("Bursaspor"));
        teams.add(new Team("Fenerbahçe"));
        teams.add(new Team("Beşiktaş"));
        teams.add(new Team("Başakşehir"));
        Fixture teamFix=new Fixture(teams);
        teamFix.fixtureGenerate();
    }
}
