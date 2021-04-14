package fr.CARPENTIER.test.controllers;

public class SettingsUtility {
    private static String aUsername = null ;
    private static int aNumberOfQuestions = 1;
    private static String aCategory = null ;
    private static String aDifficulty = null ;
    private static String aType = null ;


    public static String getUsername() {
        return aUsername;
    }

    public static int getaNumberOfQuestions() {
        return aNumberOfQuestions;
    }

    public static String getaCategory() {
        return aCategory;
    }

    public static String getaDifficulty() {
        return aDifficulty;
    }

    public static String getaType() {
        return aType;
    }

    public static void setUsername(final String username) {
        aUsername = username;
    }

    public static void setNumberOfQuestions(final int numberOfQuestions) {
        aNumberOfQuestions = numberOfQuestions;
    }

    public static void setCategory(final String category) {
        aCategory = category;
    }

    public static void setDifficulty(final String difficulty) {
        aDifficulty = difficulty;
    }

    public static void setType(final String type) {
        aType = type;
    }



}
