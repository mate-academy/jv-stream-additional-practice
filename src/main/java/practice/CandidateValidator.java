package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator {
    public static final String NATIONALITY = "Ukrainian";
    public static final int PERIOD = 10;

    public static boolean predicate(Candidate candidate) {
        Predicate<Candidate> p = x -> x.getAge() >= 35
                && x.isAllowedToVote()
                && x.getNationality().equals(NATIONALITY)
                && isInPeriod(x.getPeriodsInUkr());
        return p.test(candidate);
    }

    private static boolean isInPeriod(String period) {
        String[] arr = period.split("-");
        return (Integer.parseInt(arr[1]) - Integer.parseInt(arr[0])) >= PERIOD;
    }
}
