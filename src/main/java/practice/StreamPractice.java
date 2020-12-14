package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Candidate;
import model.People;

public class StreamPractice {

    /**
     * Given List of strings where each element represents persons' age and name:
     * {"099:Johny", "120:Brad", ...} return the age of the oldest person
     */
    public long getOldestPersonAge(List<String> peoples) {
        return peoples.stream()
                .map(string -> string.split(":"))
                .map(strings -> Long.parseLong(strings[0]))
                .max(Long::compare)
                .get();
    }

    /**
     * Given a map with the following view : "company name" - "monthly income delta"(String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200},
     * {"Clarity": 0.00}, {"Odyssey": 9_640};
     * Output : {"Sun.ltd", "Odyssey"}
     */
    public List<String> getCompanies(Map<String, Integer> input) {
        return input.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */
    public String charsIncrementation(String string, int increment) {
        return string.chars()
                .map(character -> character + increment)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
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
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.joining("],\n[", "[", "]"));
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
        return records.stream()
                .distinct()
                .map(record -> record.split(" - "))
                .filter(strings -> Integer.parseInt(strings[1]) == year)
                .count();
    }

    /**
     * Given list of strings where each element contains 1+ number:
     * input = {"5,30,100", "0, 22, 7", ...}
     * return min integer value. One more thing - we're interested in even numbers.
     * If there is no needed data throw RuntimeException with message
     * "Can't get min value from list"
     */
    public int findMinEvenNumber(List<String> numbers) {
        return numbers.stream()
                .flatMap((number) -> Arrays.stream(number.split(",")))
                .map(Integer::parseInt)
                .filter(number -> (number & 1) == 0)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't get min value from list"));
    }

    /**
     * Your help with an election is needed. Given the list of candidates, where each element
     * has Candidate.class type. Check which candidates are eligible to apply for president
     * position and return their names sorted alphabetically. The requirements are: person
     * should be older than 35 y, should be allowed to vote, have nationality - 'Ukrainian'
     * and live in ukr for 10 years. For the last requirement use field periodsInUkr, which
     * has following view: "2002-2015" For now we don't care if that was last 10 or not. We
     * want to reuse our validation in future, so let's write our own impl of
     * Predicate< Candidate> in CandidateValidator.
     */
    public List<String> validateCandidates(List<Candidate> candidates) {
        CandidateValidator candidateValidator = new CandidateValidator();
        return candidates.stream()
                .filter(candidateValidator)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Given a list of random strings, group all of them by the last letter from the
     * string. If last numbers is not a letter skip the word.
     */
    public Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
        return words.stream()
                .filter(string -> Character.isAlphabetic(string.charAt(string.length() - 1)))
                .collect(Collectors.groupingBy((string) -> string.charAt(string.length() - 1)));
    }

    /**
     * We want to gather some statistics: we have list of people and we want to know
     * distribution among the age of women who have cats and are older than 18
     * Result should have the following view: Map.of(19 - List.of(person1, person2, ...),
     * 21 - List.of(person3, person7, ...);
     */
    public Map<Integer, List<People>> groupByAge(List<People> people) {
        return people.stream()
                .filter(person -> person.getAge() >= 18
                        && (person.getSex()).equals(People.Sex.WOMEN)
                        && person.getCatList().size() > 0)
                .collect(Collectors.groupingBy(People::getAge));
    }

    /**
     * Given array of numbers, your task is to sort them in the reverse order and return only those
     * numbers that can be divided by 5 without a remainder.
     */
    public List<Integer> filterAndReverse(int[] inputNumbers) {
        return Arrays.stream(inputNumbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .filter(number -> number % 5 == 0)
                .collect(Collectors.toList());
    }
}
