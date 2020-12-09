package practice;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import model.Candidate;
import model.People;

public class StreamPractice {

    /**
     * Given List of strings where each element represents persons' age and name:
     * {"099:Johny", "120:Brad", ...} return the age of the oldest person
     */
    public long getOldestPersonAge(List<String> peoples) {
        return 0;
    }

    /**
     * Given a map with the following view : "company name" - "monthly income delta"(String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200},
     * {"Clarity": 0.00}, {"Odyssey": 9_640};
     * Output : {"Sun.ltd", "Odyssey"}
     */
    public List<String> getCompanies(Map<String, Integer> input) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */
    public String charsIncrementation(String string, int increment) {
        return string;
    }

    /**
     * Given a list of integer numbers, convert each integer into its' binary representation
     * in string format and join all of them into a single string and putting each value into
     * brackets, it should look like this:
     * Input: {1, 20, 33}
     * Output:
     * [1],
     * [10100],
     * [100001]
     */
    public String convertAndModifyNumbers(List<Integer> numbers) {
        return "";
    }

    /**
     * Given list strings representing records of patients' visits to a Hospital
     * {"John Stevenson - 2020", "Andrew Ferguson - 2012", "Andrew Ferguson - 2013"}.
     * Return number of unique persons who have visited hospital during the given year
     * (second input param). Be careful, because one person may visit a hospital several
     * times per year and for each visit new record
     * will be generated. Result shouldn't count duplicates.
     */
    public long getVisitorsPerYear(List<String> records, int year) {
        return 0;
    }

    /**
     * Given list of strings where each element contains 1+ number:
     * input = {"5,30,100", "0, 22, 7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return 0;
    }

    /**
     * Your help with a election is needed. Given the list of candidates, where each element
     * has Candidate.class type. Check which candidates are eligible to apply for president
     * position and return their names sorted alphabetically. The requirements are: person
     * should be older than 35 y, should be allowed to vote, have nationality - 'Ukrainian'
     * and live in urk for 10 years. For the last requirement use field periodsInUkr, which
     * has following view: "2002-2015" For now we don't care if that was last 10 or not. We
     * want to reuse our validation in future, so let's write our own impl of
     * Predicate< Candidate> in CandidateValidator.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        return Collections.EMPTY_LIST;
    }

    /**
     * Given a list of random strings, group all of them by the last letter from the
     * string. If last numbers is not a letter skip the word.
     */
    public Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
        return Collections.EMPTY_MAP;
    }

    /**
     * We want to gather some statistics: we have list of people and we want to know
     * distribution among the age of women who have cats and are older than 18
     * Result should have the following view: Map.of(19 - List.of(person1, person2, ...),
     * 21 - List.of(person3, person7, ...);
     */
    public Map<Integer, List<People>> groupByAge(List<People> people) {
        return Collections.EMPTY_MAP;
    }

    /**
     * Given array of numbers, your task is to sort them in the reverse order and return only those
     * numbers that can be divided by 5 without a remainder.
     */
    public List<Integer> filterAndReverse(int[] inputNumbers) {
        return Collections.EMPTY_LIST;
    }
}
