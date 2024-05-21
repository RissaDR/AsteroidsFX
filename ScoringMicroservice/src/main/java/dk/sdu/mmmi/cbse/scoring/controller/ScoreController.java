package dk.sdu.mmmi.cbse.scoring.controller;

import dk.sdu.mmmi.cbse.scoring.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping
    public int getScore() {
        return scoreService.getScore();
    }

    @PostMapping("/add")
    public void addScore(@RequestParam int points) {
        scoreService.addScore(points);
    }

    @PostMapping("/reset")
    public void resetScore() {
        scoreService.resetScore();
    }
}
