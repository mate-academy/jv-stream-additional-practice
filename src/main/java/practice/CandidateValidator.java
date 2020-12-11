package practice;

import model.Candidate;

public class CandidateValidator {
    public static boolean validate(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && validPeriod(candidate);
    }

    public static boolean validPeriod(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]) > 10;
    }
}
