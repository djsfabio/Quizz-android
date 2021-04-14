package fr.CARPENTIER.test.models;

import java.util.List;

import fr.CARPENTIER.test.models.Question;

public interface QuestionsLoaderInterface {
    void onTaskCompleted(final List<Question> pQuestions);
    void onError(final  Exception e);
}
