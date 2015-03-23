import java.util.ArrayList;
import java.util.List;

public class CountMaxNumOfPplAlive {

	private static final int START_YEAR = 1900;
	private static final int END_YEAR = 2000;

	class Person {
		int birthYear;
		int deathYear;

		public Person(int birthYear, int deathYear) {
			this.birthYear = birthYear;
			this.deathYear = deathYear;
		}
	}

	public static void main(String[] args) {
		List<Person> persons = createPersons();
		bruteForceFind(persons);
		algo1(persons);
	}

	private static void algo1(List<Person> persons) {
		int[] popChanges = new int[2000 - 1900];
		for (Person person : persons) {
			popChanges[person.birthYear - 1900] += 1;
			popChanges[person.deathYear - 1900] -= 1;
		}

		int max_pop = 0;
		int max_pop_index = 0;
		int pop = 0;
		for (int popChangeIdx = 0; popChangeIdx < popChanges.length; popChangeIdx++) {
			pop += popChanges[popChangeIdx];
			if (pop > max_pop) {
				max_pop = pop;
				max_pop_index = popChangeIdx;
			}
		}

		System.out.println("Algo1, Max Count: " + max_pop + ", Year: "
				+ (1900 + max_pop_index));
	}

	private static void bruteForceFind(List<Person> persons) {
		int maxCount = 0;
		int maxCountYear = 0;
		for (int year = START_YEAR; year <= END_YEAR; year++) {
			int yearCount = 0;
			for (Person person : persons) {
				if (year >= person.birthYear && year < person.deathYear) {
					yearCount++;
				}
			}

			if (yearCount == persons.size()) {
				maxCount = persons.size();
				maxCountYear = year;
				break;
			}

			if (yearCount > maxCount) {
				maxCount = yearCount;
				maxCountYear = year;
			}
		}

		System.out.println("Brute force, Max count: " + maxCount + ", Year: "
				+ maxCountYear);
	}

	private static List<Person> createPersons() {
		CountMaxNumOfPplAlive countMaxNumOfPplAlive = new CountMaxNumOfPplAlive();
		List<Person> persons = new ArrayList<CountMaxNumOfPplAlive.Person>();
		persons.add(countMaxNumOfPplAlive.new Person(1905, 1955));
		persons.add(countMaxNumOfPplAlive.new Person(1968, 1998));
		persons.add(countMaxNumOfPplAlive.new Person(1945, 1972));
		persons.add(countMaxNumOfPplAlive.new Person(1901, 1980));
		persons.add(countMaxNumOfPplAlive.new Person(1920, 1960));
		return persons;
	}
}
