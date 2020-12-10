package practice;

import static org.junit.jupiter.api.Assertions.assertThrows;

import model.Candidate;
import model.Cat;
import model.People;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StreamPracticeTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();
    private StreamPractice solution = new StreamPractice();

    @Test
    public void getOldestPersonAge_basicData() {
        List<String> basicInput = List.of("08:John", "119:Anthony", "019:Nicolas",
            "037:Brad", "056:Britney", "043:Annie", "019:Jorge", "001:Bruce");
        long expected = 119;
        Assert.assertEquals(String.format("Incorrect result for input %s", basicInput),
            expected, solution.getOldestPersonAge(basicInput));
    }

    @Test
    public void getOldestPersonAge_biggerData() {
        List<String> basicInput = List.of("090:John", "-005:Anthony", "000:Nicolas",
            "037:Brad", "088:Britney", "007:Annie", "091:Jorge", "-120:Bruce",
            "022:Jasper", "001:Cortney", "050:Emily", "047:Naomi", "090:Leonard");
        long expected = 91;
        Assert.assertEquals(String.format("Incorrect result for input %s\n", basicInput),
            expected, solution.getOldestPersonAge(basicInput));
    }

    @Test
    public void getOldestPersonAge_invalidData() {
        List<String> invalidInput = List.of("Invalid input");
        assertThrows(RuntimeException.class, () -> solution.getOldestPersonAge(invalidInput));
    }

    @Test
    public void getOldestPersonAge_emptyList() {
        List<String> emptyInput = Collections.EMPTY_LIST;
        assertThrows(NoSuchElementException.class, () -> solution.getOldestPersonAge(emptyInput));
    }

    @Test
    public void charsIncrementation_basicData() {
        String letters = "ABCD";
        String expectedOneShift = "BCDE";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            letters, 1), expectedOneShift, solution.charsIncrementation(letters, 1));
        String expectedTwoShifts = "CDEF";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            letters, 2), expectedTwoShifts, solution.charsIncrementation(letters, 2));
        String expectedFiveShifts = "FGHI";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            letters, 5), expectedFiveShifts, solution.charsIncrementation(letters, 5));
    }

    @Test
    public void charsIncrementation_numericAndPunctuationData() {
        String nonLetters = "123..{1}";
        String expectedTwoShifts = "34500}3";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            nonLetters, 2), expectedTwoShifts, solution.charsIncrementation(nonLetters, 2));
        String expectedFourShifts = "56722\u007F5\u0081";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            nonLetters, 4), expectedFourShifts, solution.charsIncrementation(nonLetters, 4));
    }

    @Test
    public void charsIncrementation_mixedData() {
        String mixedSymbols = "1_ABCD_1";
        String expectedThreeShifts = "4bDEFGb4";
        String expectedSevenShifts = "8fHIJKf8";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            mixedSymbols, 3), expectedThreeShifts, solution.charsIncrementation(mixedSymbols, 3));
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            mixedSymbols, 7), expectedSevenShifts, solution.charsIncrementation(mixedSymbols, 7));
    }

    @Test
    public void charsIncrementation_emptyData() {
        String emptyInput = "";
        String expected = "";
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            emptyInput, 3), expected, solution.charsIncrementation(emptyInput, 3));
        Assert.assertEquals(String.format("Incorrect result for input - %s and increment - %d\n",
            emptyInput, 7), expected, solution.charsIncrementation(emptyInput, 7));
    }

    @Test
    public void convertAndModifyNumbers_basicData() {
        List<Integer> positiveNumbers = List.of(1, 3, 5, 8);
        String expected = "[1],\n[11],\n[101],\n[1000]";
        Assert.assertEquals(String.format("Incorrect result for input - %s\n",
            positiveNumbers), expected, solution.convertAndModifyNumbers(positiveNumbers));
    }

    @Test
    public void convertAndModifyNumbers_singleNumber() {
        List<Integer> singleNumber = List.of(1);
        String expected = "[1]";
        Assert.assertEquals(String.format("Incorrect result for input - %s\n",
            singleNumber), expected, solution.convertAndModifyNumbers(singleNumber));
    }

    @Test
    public void convertAndModifyNumbers_complexData() {
        List<Integer> mixedNumbers = List.of(-533, 121, 44, 11, 27, 450);
        String expected = "[11111111111111111111110111101011],\n[1111001],\n[101100],\n"
            + "[1011],\n[11011],\n[111000010]";
        Assert.assertEquals(String.format("Incorrect result for input - %s\n",
            mixedNumbers), expected, solution.convertAndModifyNumbers(mixedNumbers));
    }

    @Test
    public void getVisitorsPerYear_uniqueData() {
        int year = 2018;
        List<String> basicRecords = List.of("John Stevenson - 2020", "Bruce Cage - 2015",
            "Britney Johns - 2005", "Brad Wang - 2005", "Lee Stone - 2011",
            "Rickie Garrison - 2015", "Taras Kozak - 2017", "Bart Swan - 2018", "Brad Wang - 2005");
        long expected = 1;
        Assert.assertEquals(String.format("Incorrect amount for year - %d records - %s\n",
            year, basicRecords), expected, solution.getVisitorsPerYear(basicRecords, year));
    }

    @Test
    public void getVisitorsPerYear_basicData() {
        int year = 2015;
        List<String> basicRecords = List.of("John Stevenson - 2020", "Bruce Cage - 2015",
            "Britney Johns - 2005", "Brad Wang - 2005", "Lee Stone - 2011",
            "Rickie Garrison - 2015", "Taras Kozak - 2017", "John Stevenson - 2015",
            "Bart Swan - 2018", "Brad Wang - 2005", "John Stevenson - 2015");
        long expected = 3;
        Assert.assertEquals(String.format("Incorrect amount for year - %d records - %s\n",
            year, basicRecords), expected, solution.getVisitorsPerYear(basicRecords, year));
    }

    @Test
    public void getVisitorsPerYear_emptyData() {
        int year = 2019;
        List<String> basicRecords = Collections.EMPTY_LIST;
        long expected = 0;
        Assert.assertEquals(String.format("Incorrect amount for year - %d records - %s\n",
            year, basicRecords), expected, solution.getVisitorsPerYear(basicRecords, year));
    }

    @Test
    public void getCompanies_basicData() {
        Map<String, Integer> basicInput = Map.of("Clarity", 2_000, "Oracle", 50_000,
            "MicroSystem", -2_000, "Odyssey", -100, "Jupiter", 200,
            "Infinity", 2_000_000, "Destiny", 0);
        List<String> expected = List.of("Clarity", "Infinity", "Jupiter", "Oracle");
        Assert.assertEquals(String.format("Incorrect result companies for input - %s\n",
            basicInput), expected, solution.getCompanies(basicInput));
    }

    @Test
    public void getCompanies_emptyData() {
        Map<String, Integer> basicInput = Collections.EMPTY_MAP;
        List<String> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result companies for input - %s\n",
            basicInput), expected, solution.getCompanies(basicInput));
    }

    @Test
    public void findMinEvenNumber_basicData() {
        List<String> basicInput = List.of("12,11,5", "1,22,757", "71", "39,31,55,148",
            "3,2,2,5", "27,44,89", "12,11,5", "64,22,757");
        int expected = 2;
        Assert.assertEquals(String.format("Incorrect min value for the input - %s\n",
            basicInput), expected, solution.findMinEvenNumber(basicInput));
    }

    @Test
    public void findMinEvenNumber_negativeData() {
        List<String> basicInput = List.of("8,14,5", "3,-22,800", "-71", "20,98,45,98",
            "1,49,2,5", "27,12,89", "56,3,5", "12,-22,320");
        int expected = -22;
        Assert.assertEquals(String.format("Incorrect min value for the input - %s\n",
            basicInput), expected, solution.findMinEvenNumber(basicInput));
    }

    @Test
    public void findMinEvenNumber_emptyData() {
        List<String> basicInput = Collections.EMPTY_LIST;
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Can't get min value from list");
        solution.findMinEvenNumber(basicInput);
    }

    @Test
    public void validateCandidates_basicData() {
        List<Candidate> basicInput = initCandidateList();
        List<String> expected = List.of("Casey", "Morty", "Philip");
        Assert.assertEquals(String.format("Incorrect result list of names for the input - %s\n",
            basicInput), expected, solution.validateCandidates(basicInput));
    }

    private List<Candidate> initCandidateList() {
        Candidate john = new Candidate(30, "Ukrainian", false, "1985-2020");
        john.setName("John");
        Candidate fred = new Candidate(39, "German", true, "2000-2019");
        fred.setName("Fred");
        Candidate casey = new Candidate(61, "Ukrainian", true, "1988-2000");
        casey.setName("Casey");
        Candidate rick = new Candidate(44, "Ukrainian", false, "1990-2007");
        rick.setName("Rick");
        Candidate morty = new Candidate(35, "Ukrainian", true, "2009-2020");
        morty.setName("Morty");
        Candidate ron = new Candidate(70, "Ukrainian", true, "2015-2020");
        ron.setName("Ron");
        Candidate phil = new Candidate(52, "Ukrainian", true, "1980-2013");
        phil.setName("Philip");
        return List.of(john, fred, rick, morty, casey, ron, phil);
    }

    @Test
    public void validateCandidates_invalidData() {
        List<Candidate> invalidCandidates = initInvalidCandidateList();
        List<String> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result list of names for the input - %s\n",
            invalidCandidates), expected, solution.validateCandidates(invalidCandidates));
    }

    private List<Candidate> initInvalidCandidateList() {
        Candidate john = new Candidate(30, "Ukrainian", false, "1985-2020");
        john.setName("John");
        Candidate fred = new Candidate(39, "German", true, "2000-2019");
        fred.setName("Fred");
        Candidate casey = new Candidate(61, "Ukrainian", true, "2011-2016");
        casey.setName("Casey");
        Candidate rick = new Candidate(44, "Ukrainian", false, "1990-2007");
        rick.setName("Rick");
        Candidate morty = new Candidate(35, "Frenchman", true, "2009-2020");
        morty.setName("Morty");
        Candidate ron = new Candidate(70, "Ukrainian", true, "2015-2020");
        ron.setName("Ron");
        Candidate phil = new Candidate(52, "Ukrainian", false, "1980-2013");
        phil.setName("Philip");
        return List.of(john, fred, rick, morty, casey, ron, phil);
    }

    @Test
    public void validateCandidates_emptyData() {
        List<Candidate> emptyList = Collections.EMPTY_LIST;
        List<String> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result list of names for the input - %s\n",
            emptyList), expected, solution.validateCandidates(emptyList));
    }

    @Test
    public void groupWordsByLastChar_basicData() {
        List<String> basicInput = List.of("g", "gregory", "abcdg", "victory", "dance", "republic",
            "future", "compilation", "convention");
        Map<Character, List<String>> expected = Map.of('g', List.of("g", "abcdg"),
            'y', List.of("gregory", "victory"), 'e', List.of("dance", "future"), 'c', List.of("republic"),
            'n', List.of("compilation", "convention"));
        Assert.assertEquals(String.format("Incorrect result map of words for the input - %s\n",
            basicInput), expected, solution.groupWordsByLastChar(basicInput));
    }

    @Test
    public void groupWordsByLastChar_forbiddenSymbols() {
        List<String> basicInput = List.of("g23", "gregory", "abcdg", "11victory", "_christmas_", "republic16",
            "future!", "compilation", "convention", "exhibition", "fate");
        Map<Character, List<String>> expected = Map.of('g', List.of("abcdg"),
            'y', List.of("gregory", "11victory"), 'e', List.of("fate"),
            'n', List.of("compilation", "convention", "exhibition"));
        Assert.assertEquals(String.format("Incorrect result map of words for the input - %s\n",
            basicInput), expected, solution.groupWordsByLastChar(basicInput));
    }

    @Test
    public void groupWordsByLastChar_emptyData() {
        List<String> basicInput = Collections.EMPTY_LIST;
        Map<Character, List<String>> expected = Collections.EMPTY_MAP;
        Assert.assertEquals(String.format("Incorrect result map of words for the input - %s\n",
            basicInput), expected, solution.groupWordsByLastChar(basicInput));
    }

    @Test
    public void groupByAge_singleData() {
        People becka = new People("Becka", 25, People.Sex.WOMEN, List.of(new Cat("Joe", 1)));
        List<People> basicInput = List.of(becka);
        Map<Integer, List<People>> expected = Map.of(25, List.of(becka));
        Assert.assertEquals(String.format("Incorrect result map of peoples for the input - %s\n",
            basicInput), expected, solution.groupByAge(basicInput));
    }

    @Test
    public void groupByAge_basicData() {
        List<People> basicInput = initPeopleList();
        People jess = new People("Jess", 48, People.Sex.WOMEN, initCatList());
        People susy = new People("Susy", 37, People.Sex.WOMEN, List.of(new Cat("Kitty", 5)));
        People hillary = new People("Hillary", 48, People.Sex.WOMEN, List.of(new Cat("Chris", 13)));
        Map<Integer, List<People>> expected = Map.of(48, List.of(jess, hillary), 37, List.of(susy));
        Assert.assertEquals(String.format("Incorrect result map of peoples for the input - %s\n",
            basicInput), expected, solution.groupByAge(basicInput));
    }

    private List<People> initPeopleList() {
        List<People> peoples = new ArrayList<>();
        People jess = new People("Jess", 48, People.Sex.WOMEN, initCatList());
        peoples.add(jess);
        People nick = new People("Nick", 22, People.Sex.MAN, initCatList());
        peoples.add(nick);
        People joe = new People("Joe", 25, People.Sex.MAN, Collections.EMPTY_LIST);
        peoples.add(joe);
        People marry = new People("Marry", 16, People.Sex.WOMEN, initCatList());
        peoples.add(marry);
        People susy = new People("Susy", 37, People.Sex.WOMEN, List.of(new Cat("Kitty", 5)));
        peoples.add(susy);
        People barry = new People("Barry", 29, People.Sex.MAN, initCatList());
        peoples.add(barry);
        People hillary = new People("Hillary", 48, People.Sex.WOMEN, List.of(new Cat("Chris", 13)));
        peoples.add(hillary);
        return peoples;
    }

    private List<Cat> initCatList() {
        Cat tommy = new Cat("Tommy", 5);
        Cat snow = new Cat("Snow", 2);
        Cat jackie = new Cat("Jackie", 15);
        return List.of(tommy, snow, jackie);
    }

    @Test
    public void filterAndReverse_basicData() {
        int[] basicInput = new int[]{1, 4, 7, 10, 35, 97, 31, 55, 17, 74, 2, 10};
        List<Integer> expected = List.of(55, 35, 10, 10);
        Assert.assertEquals(String.format("Incorrect result list for the array - %s\n",
            Arrays.toString(basicInput)), expected, solution.filterAndReverse(basicInput));
    }

    @Test
    public void filterAndReverse_invalidData() {
        int[] basicInput = new int[]{1, 4, 7, 3, 97, 31, 56, 17, 74, 2, 9, 194, 22};
        List<Integer> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result list for the array - %s\n",
            Arrays.toString(basicInput)), expected, solution.filterAndReverse(basicInput));
    }

    @Test
    public void filterAndReverse_emptyData() {
        int[] basicInput = new int[0];
        List<Integer> expected = Collections.EMPTY_LIST;
        Assert.assertEquals(String.format("Incorrect result list for the array - %s\n",
            Arrays.toString(basicInput)), expected, solution.filterAndReverse(basicInput));
    }
}
