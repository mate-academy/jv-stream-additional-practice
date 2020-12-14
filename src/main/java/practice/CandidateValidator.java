package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String NATIONALITY_UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && (candidate.getNationality()).equals(NATIONALITY_UKRAINIAN)
                && (Integer.parseInt(years[1]) - Integer.parseInt(years[0]) > 10);
    }
}
