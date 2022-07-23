package co.com.randomapi.persistence.entity;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum SubjectDifficulty {
    EASY("EASY"),
    MEDIUM("MEDIUM"),
    ADVANCED("ADVANCED");

    public final String difficulty;

    SubjectDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
