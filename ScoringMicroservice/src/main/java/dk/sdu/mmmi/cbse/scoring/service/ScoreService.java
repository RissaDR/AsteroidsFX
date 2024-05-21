package dk.sdu.mmmi.cbse.scoring.service;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
    }

    public void resetScore() {
        score = 0;
    }
}