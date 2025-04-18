package design.cricinfosystemdesign;

import java.util.ArrayList;
import java.util.List;

public class Innings {
    private final String id;
    private final String battingTeamId;
    private final String bowlingTeamId;
    private final List<Over> overs;

    public Innings(String id, String bowlerTeamId, String battingTeamId) {
        this.id = id;
        this.bowlingTeamId = bowlerTeamId;
        this.battingTeamId = battingTeamId;
        this.overs = new ArrayList<>();
    }

    public void addOver(Over o) {
        this.overs.add(o);
    }

    public String getId() {
        return id;
    }

    public String getBattingTeamId() {
        return battingTeamId;
    }

    public String getBowlingTeamId() {
        return bowlingTeamId;
    }

    public List<Over> getOvers() {
        return overs;
    }

}
