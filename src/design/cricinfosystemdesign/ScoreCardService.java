package design.cricinfosystemdesign;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ScoreCardService {
    private static ScoreCardService instance;
    private final Map<String, Scorecard> scorecards;
    private final AtomicInteger scorecardIdCounter;

    private ScoreCardService() {
        this.scorecards = new HashMap<>();
        scorecardIdCounter = new AtomicInteger();
    }

    public static ScoreCardService getInstance() {
        if (instance == null) {
            instance = new ScoreCardService();
        }
        return instance;
    }

    public void createScoreCard(Match match) {
        String scorecardId = generateScoreCardId(match.getId());
        Scorecard scoreCard = new Scorecard(scorecardId, match);
        this.scorecards.put(scorecardId, scoreCard);

    }

    public Scorecard getScoreCard(String scoreCardId) {
        return this.scorecards.get(scoreCardId);
    }

    public Map<String, Scorecard> getScorecards() {
        return scorecards;
    }

    public void updateScore(String scoreCardId, String teamId, int score) {
        Scorecard s = scorecards.get(scoreCardId);
        if (s != null) {
            s.updateScore(teamId, score);
        }

    }

    public void addInnings(String scoreCardId, Innings innings) {
        Scorecard s = scorecards.get(scoreCardId);
        if (s != null) {
            s.addInnnings(innings);
        }
    }

    public String generateScoreCardId(String matchId) {
        int scoreCardId = this.scorecardIdCounter.incrementAndGet();
        return "SC_" + matchId + String.format("%04d", scoreCardId);
    }

}
