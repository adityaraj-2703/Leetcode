package design.cricinfosystemdesign;

import java.util.List;

public class CricInfoSystem {
    private final MatchService ms;
    private final ScoreCardService sc;

    public CricInfoSystem() {
        this.ms = MatchService.getInstance();
        this.sc = ScoreCardService.getInstance();
    }

    public void addMatch(Match m) {
        this.ms.addMatch(m);
    }

    public Match getMatch(String matchId) {
        return this.ms.getMatch(matchId);
    }

    public List<Match> getAllMatches() {
        return this.ms.getAllMatches();
    }

    public void updateMatchStatus(String matchId, MatchStatus status) {
        this.ms.updateMatchStatus(matchId, status);
    }

    public void createScoreCard(Match m) {
        this.sc.createScoreCard(m);
    }

    public Scorecard getScoreCard(String scoreCardId) {
        return this.sc.getScoreCard(scoreCardId);
    }

    public void updateScoreCard(String scoreCardId, String teamId, int score) {
        this.sc.updateScore(scoreCardId, teamId, score);
    }

    public void addInnings(String scoreCardId, Innings innings) {
        this.sc.addInnings(scoreCardId, innings);
    }

}
