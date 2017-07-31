package pl.dawidbasa.luckySort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LuckySorting {

	static int COUNT;

	static void luckySort(ArrayList<String> strings, Comparator<String> comp) {

		// Shuffle to get random list
		Collections.shuffle(strings);

		System.out.println("First shuffle game starts" + strings);
		System.out.println("Expected list: " + strings.stream().sorted(comp).collect(Collectors.toList()));

		COUNT = 0;
		// If list is not sorted as expected - shuffle again
		while (!strings.equals(strings.stream().sorted(comp).collect(Collectors.toList()))) {

			System.out.println("false... shuffling" + strings);
			Collections.shuffle(strings);
			COUNT++;

		}
		System.out.println("Good sequence" + strings);
		System.out.println("Succeeded in: " + COUNT + " attempts");
	}

	// comparator from shortest to longest string
	public static Comparator<String> comparelists() {
		return (s1, s2) -> s1.length() - s2.length();
	}

	public static void main(String args[]) {

		ArrayList<String> list = new ArrayList<>();
		// Be carefull with 9 elements it can take some time to finish sometime 300k attempts :)
		list.add("a");
		list.add("ab");
		list.add("abc");
		list.add("abcd");
		list.add("abcde");
		list.add("abcdef");
		list.add("abcdefg");
		list.add("abcdefgh");
		list.add("abcdefghi");
		
		luckySort(list, comparelists());
	}
}
