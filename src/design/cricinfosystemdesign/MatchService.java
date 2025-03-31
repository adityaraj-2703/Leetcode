package design.cricinfosystemdesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchService {
    private static MatchService instance;
    private final Map<String, Match> matches;

    private MatchService() {
        matches = new HashMap<>();
    }

    public static synchronized MatchService getInstance() {
        if (instance == null) {
            instance = new MatchService();
        }
        return instance;
    }

    public void addMatch(Match match) {
        this.matches.put(match.getId(), match);
    }

    public Match getMatch(String matchId) {
        return matches.get(matchId);
    }

    public List<Match> getAllMatches() {
        return new ArrayList<>(matches.values());
    }

    public void updateMatchStatus(String matchId, MatchStatus matchStatus) {
        Match match = matches.get(matchId);
        if (match != null) {
            match.setMatchStatus(matchStatus);
        }

    }

}
