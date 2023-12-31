package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int totalScores = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScores += subject.score();
                totalSubjects++;
            }
        }
        return (double) totalScores / totalSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            int totalSubjects = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            double averageScore = (double) totalScore / totalSubjects;
            averageScores.add(new Label(pupil.name(), averageScore));
        }
        return averageScores;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                subjectScores.merge(subjectName, subject.score(), Integer::sum);
            }
        }
        List<Label> averageScores = new ArrayList<>();
        for (Map.Entry<String, Integer> map : subjectScores.entrySet()) {
            averageScores.add(new Label(map.getKey(), (double) map.getValue() / pupils.size()));
        }
        return averageScores;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestStudent = null;
        int highestTotalScore = 0;
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            if (totalScore > highestTotalScore) {
                highestTotalScore = totalScore;
                bestStudent = new Label(pupil.name(), totalScore);
            }
        }
        return bestStudent;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                subjectScores.merge(subjectName, subject.score(), Integer::sum);
            }
        }
        List<Label> lists = new ArrayList<>();
        for (String subject : subjectScores.keySet()) {
            lists.add(new Label(subject, subjectScores.get(subject)));
        }
        lists.sort(Comparator.naturalOrder());
        return lists.get(lists.size() - 1);
    }
}
