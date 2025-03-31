package design.cricinfosystemdesign;

import java.time.LocalDateTime;
import java.util.List;

public class Match {
    private final String id;
    private final String title;
    private final String venue;
    private final LocalDateTime startTime;
    private final List<Team> teams;
    private MatchStatus matchStatus;
    private Scorecard scorecard;

    public Match(String id, String title, String venue, LocalDateTime startTime, List<Team> teams) {
        this.id = id;
        this.title = title;
        this.venue = venue;
        this.teams = teams;
        this.startTime = startTime;
        this.matchStatus = MatchStatus.SCHEDULED;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

}
