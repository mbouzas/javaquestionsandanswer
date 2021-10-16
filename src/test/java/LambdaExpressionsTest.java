 import static org.junit.Assert.*;

import java.math.BigDecimal;
import org.apache.commons.lang3.ArrayUtils;

 import java.sql.SQLSyntaxErrorException;
 import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class LambdaExpressionsTest {

	@Test
	public void sumOfOddNumbers_Usual() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);

		int sum = 0;

		for (int number : numbers)
			if (number % 2 != 0)
				sum += number;

		assertEquals(11, sum);
	}

	@Test
	public void sumOfOddNumbers_UsualManu() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 9, 7);
 		int sum = numbers.stream().filter(s-> s % 2!=0).reduce(0,Integer::sum);
 		assertEquals(20,sum);
	}


	//No changes to state
	@Test
	public void sumOfOddNumbers_FunctionalProgrammingExample() {

		List<Integer> integerList = Arrays.asList(1, 3, 4, 6, 2, 7);

		int sum = integerList.stream().filter(LambdaExpressionsTest::isOdd).reduce(0, Integer::sum);

		// number -> (number % 2 != 0) => Lambda Expression
		// Integer::sum => Method Reference
		// What is Functional Interface

		assertEquals(11, sum);
	}

	public static boolean isOdd(Integer number) {
		if (number % 2 != 0) {
			return true;
		}
		return false;
	}

	@Test
	public void lambdaExpression_predicate() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		numbers.stream()
				.filter((number) -> (number % 2 != 0)) //Predicate
				.forEach(number -> System.out.print(number)); //Consumer
		// 137
	}

	static boolean isOdd(int number) {
		return number % 2 != 0;
	}

	int i = 1_000_000;
	//.map(String::toLowerCase)
	//.map(s -> String.toLowerCase(s))

/*	• Step I : Creating an array as a stream
• Step II : Use Lambda Expression to create a filter
• Step III : Use map function to invoke a String function
}
}

		Java Interview Questions and Answers – www.in28Minutes.com 10 5
		• Step IV : Use sorted function to sort the array
		• Step V : Print the array using forEach*/


	@Test
	public void arrayAsStream() {
		Arrays.stream(new String[]{"Ram", "Robert", "Rahim"
		}).filter(s -> s.contains("hi")).map(s -> s.concat("hola")).sorted().forEach(System.out::println);

	}

	@Test
	public void arrayAsStream2() {
		Arrays.stream(new String[]{"Ram", "Robert", "Rahim"
		}).filter(s->s.startsWith("Ro")).map(s -> s.concat("hola")).sorted().forEach(System.out::print);

	}

	/*
		Distinct Example
	*/
	@Test
	public void streamExample_Distinct() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 6, 2, 3);
		numbers.stream().distinct().forEach(System.out::println);
	}


	/*
		Distinct Example
	*/
	@Test
	public void streamExample_DistinctManu() {
		List<Integer> numbers = Arrays.asList(1, 1, 2, 6, 2, 3);
		numbers.stream().distinct().sorted().forEach(System.out::print);

	}

	/*
        Distinct Example
    */
	@Test
	public void streamExample_() {
		List<String> persons = Arrays.asList("Manu", "Isa", "Isa", "Isa", "Paco");
		persons.stream().distinct().map(s -> s.contains("Manu") ? s.concat(" bouzas") : s.concat(" lema")).map(String::toUpperCase).forEach(System.out::println);
	}

	@Test
	public void primosTest21() {
		List<Integer> integerList = Arrays.asList(7, 4, 21, 32, 16, 54, 5);
		integerList.stream().map(LambdaExpressionsTest::primo).forEach(System.out::println);
	}
	@Test
	public void primosTest() {
		List<Integer> integerList = Arrays.asList(7, 4, 21, 32, 16, 54, 5);
		integerList.stream().filter(LambdaExpressionsTest::primo).collect(Collectors.toList()).forEach(System.out::println);
	}

	@Test
	public void primosTest2() {
		List<Integer> integerList = Arrays.asList(7, 4, 21, 32, 16, 54, 5);
		integerList.stream().filter(LambdaExpressionsTest::primo).forEach(System.out::print);
		}




	public static boolean primo(Integer n) {
		int contador = n - 1;
		while (contador > 1) {
			if (n % contador == 0)
				return false;
			contador--;
		}
		return true;
	}

	@Test
	public void sumOfOddNumbers_FunctionalProgramming2() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);
		System.out.println(numbers.stream().filter(LambdaExpressionsTest::isOdd).reduce(0,Integer::sum));

	}

	@Test
	public void sumOfOddNumbers_FunctionalProgramming() {
		List<Integer> numbers = Arrays.asList(1, 3, 4, 6, 2, 7);

		int sum = numbers.stream().filter(s -> s % 2 != 0).reduce(0, Integer::sum);
		System.out.println(sum);
		int i = Integer.sum(1, 2);
		System.out.println(i);

	}

/*	Write a method that returns the index of the first occurrence of given integer in a list.
	Assume that the index of the first element in the list is zero.
	If the number does not exist return -1.*/


	@Test
	public void index() {
		Integer[] list = {7, 4, 21, 32, 16, 54, 5};
		int seach1 = search(4, list);
		System.out.println("Postion: " + seach1);

	}

	@Test
	public void reverseString() {
		String reverse = "isabel lema caeiro";

		//Stream <Character> c = IntStream.range(0,reverse.toCharArray().length).mapToObj(i-> reverse.)


		Stream<Character> cStream = IntStream.range(0, reverse.toCharArray().length)
				.mapToObj(i -> reverse.toCharArray()[(reverse.toCharArray().length - 1) - i]);

		cStream.forEach(System.out::print);


	}

	public int search(Integer n, Integer[] list) {
		return IntStream
				.range(0, list.length)
				.filter(i -> list[i] == n)
				.findFirst().orElse(-1);
	}

	@Test
	public void maximum() {
		System.out.println("Max: " + Collections.max(Arrays.asList(new Integer[]{1112, 5, 6, 17, 119})));
	}

	@Test
	public void maximum2() {
		System.out.println(Collections.max(Arrays.asList(new Integer[]{111, 112, 1})));
	}

	@Test
	public void average2() {
		List<Integer> list = Arrays.asList(1, 10, 3);
		Double media = list.stream().mapToDouble(n->n).average().getAsDouble();
	}

	@Test
	public void average() {
		List<Integer> list = Arrays.asList(1, 10, 3);
		Double ave = list.stream().mapToDouble(n -> n).average().getAsDouble();
		System.out.print(ave);
	}

	@Test
	public void upperCase() {
		List<String> list = Arrays.asList("hola");
		list.stream().map(s -> s.toUpperCase()).forEach(System.out::print);

	}

	/*
		Write a method that returns th nth element of a list. If the index of the element exceeds the list size, then return -1.
	*/
	@Test
	public void getElement() {
		List<Integer> list = Arrays.asList(1, 10, 3);
		int n = 10;
		Integer element = IntStream
				.range(0, list.size())
				.filter(i ->  list.get(i) == n).findFirst().orElse(-1);
		System.out.println(element);
	}

	@Test
	public void transformShouldConvertCollectionElementsToUpperCase() {
		List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
		List<String> expected = Arrays.asList("MY", "NAME", "IS", "JOHN", "DOE");
		System.out.println(assertThat(transform(collection), expected));
	}

	private boolean assertThat(List<String> collection, List<String> expected) {
		return collection.equals(expected);

	}

	public static List<String> transform(List<String> collection) {

		return collection.stream().map(String::toUpperCase).collect(Collectors.toList());
	}

	@Test
	public void transform() {
		List<String> collection = Arrays.asList("My", "name", "is", "John", "Doe");
		collection.stream().map(String::toUpperCase).forEach(System.out::print);;
	}

	/*Given a sorted linked list, delete all duplicates such that each element appear only once.

	For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.

	NOTE: You only need to implement the given function. Do not read input, instead use the arguments to the function. Do not print the output, instead return values as specified. Still have a doubt? Checkout Sample Codes for more details.
*/


	@Test
	public void callDuplicates() {
		ListNode listNode = new ListNode(5);
		ListNode listNode2 = new ListNode(5);
		ListNode listNode3 = new ListNode(5);
		ListNode listNode4 = new ListNode(9);
		listNode.next = listNode2;
		listNode.next.next = listNode3;
		listNode.next.next.next = listNode4;
		listNode = deleteDuplicates(listNode);
		ListNode cont = listNode;
		while (cont != null) {
			System.out.print(cont.val + "->");
			cont = cont.next;

		}

	}

	@Test
	public void sum2numbers() {
		ListNode listNode = new ListNode(2);
		ListNode listNode2 = new ListNode(4);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(5);
		listNode.next = listNode2;
		listNode.next.next = listNode3;
		listNode.next.next.next = listNode4;

		ListNode listNode11 = new ListNode(5);
		ListNode listNode12 = new ListNode(6);
		ListNode listNode13 = new ListNode(4);
		listNode11.next = listNode12;
		listNode11.next.next = listNode13;

		ListNode listNodeResult = addTwoNumbers(listNode, listNode11);
		/*ListNode cont = listNode;*/
		while (listNodeResult != null) {
			System.out.print(listNodeResult.val + "->");
			listNodeResult = listNodeResult.next;

		} /**/

	}

/*	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8

			342 + 465 = 807*/


	public static ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode contA = A;
		Stack<Integer> stack = new Stack<>();
		while (contA != null) {
			stack.push(contA.val);
			contA = contA.next;
		}
		ListNode contB = B;
		Stack<Integer> stack2 = new Stack<>();
		while (contB != null) {
			stack2.push(contB.val);
			contB = contB.next;
		}
		int i = 1;
		Integer cont = 0;
		while (stack.size() > 0) {
			cont = cont + stack.pop() * i;
			i = i * 10;
		}

		int j = 1;
		Integer contb = 0;
		while (stack2.size() > 0) {
			contb = contb + stack2.pop() * j;
			j = j * 10;
		}
		Integer sum = cont + contb;
		ListNode result;
		List<Integer> digits = getDigits(sum);
		Collections.reverse(digits);

		ListNode head = new ListNode(digits.get(0));
		ListNode current = head;
		int d = 1;
		while (d < digits.size()) {

			current.next = new ListNode(digits.get(d));
			current = current.next;
			d++;
		}
		return head;
	}


	public static List<Integer> getDigits(int num) {
		List<Integer> digits = new ArrayList<Integer>();
		collectDigits(num, digits);
		return digits;
	}

	private static void collectDigits(int num, List<Integer> digits) {
		if (num / 10 > 0) {
			collectDigits(num / 10, digits);
		}
		digits.add(num % 10);
	}

	public static ListNode deleteDuplicates(ListNode A) {
		if (A == null || A.next == null) {

			return A;
		}
		ListNode B = A;
		while (B != null && B.next != null) {
			if (B.val == B.next.val) {
				B.next = B.next.next;
			} else {
				B = B.next;
			}
		}

		return A;
	}


	public static ListNode findNtoLast(ListNode head, int n) { //changing LinkedListNode to ListNode<String>
		if (head == null || n < 1) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		for (int j = 0; j < n - 1; ++j) {
			if (p2 == null) {
				return null;
			}
			p2 = p2.next;
		}
		if (p2 == null) {
			return null;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}



/*
	Create a function that takes two numbers as arguments (num, length) and returns an array of multiples of num up to length.
	Examples

arrayOfMultiples(7, 5) ➞ [7, 14, 21, 28, 35]

arrayOfMultiples(12, 10) ➞ [12, 24, 36, 48, 60, 72, 84, 96, 108, 120]

arrayOfMultiples(17, 6) ➞ [17, 34, 51, 68, 85, 102]
*/

	public int[] arrayOfMultiples(int num, int length) {

		int[] result = IntStream.range(1, length + 1).map(i -> i * num).toArray();
		//Arrays.asList(result).stream().forEach(System.out::println);

		return result;
	}

	@Test
	public void multiple() {

		int[] ints = arrayOfMultiples(5, 7);
		for (int i : ints) {
			System.out.println(i);
		}
	}

	public static int[] factorize(int num) {
		return IntStream.range(1, num + 1).filter(i -> num % i == 0).toArray();
	}

	@Test
	public void factorize() {

		int[] ints = factorize(12);
		for (int i : ints) {
			System.out.println(i);
		}
	}


	/*Given an array of integers, write a method that returns an array that...

	Has all duplicate elements removed.
	Is sorted from least value to greatest value.
	uniqueSort([1, 2, 4, 3]) ➞ [1, 2, 3, 4]

	uniqueSort([1, 4, 4, 4, 4, 4, 3, 2, 1, 2]) ➞ [1, 2, 3, 4]

uniqueSort([6, 7, 3, 2, 1]) ➞ [1, 2, 3, 6, 7]
	*/

	public static int[] uniqueSort(int[] nums) {

		return Arrays.stream(nums).sorted().distinct().toArray();

	}

	public static Integer[] uniqueSort2(int[] nums) {
		Integer[] boxedArray = Arrays.stream(nums) // IntStream
				.boxed()            // Stream<Integer>
				.toArray(Integer[]::new);
		Set<Integer> integers = new TreeSet<Integer>(Arrays.asList(boxedArray));
		Integer[] result = new Integer[integers.size()];
		result = integers.toArray(result);
		return result;

	}

	@Test
	public void unique() {

		int[] boxed = uniqueSort(new int[]{1, 4, 4, 4, 4, 4, 3, 2, 1, 2});
		for (int i : boxed) {
			System.out.println(i);
		}
		Integer[] boxed2 = uniqueSort2(new int[]{1, 4, 4, 4, 4, 4, 3, 2, 1, 2});

		for (int i : boxed2) {
			System.out.println(i);
		}
	}

	/*Write a function that finds the sum of an array. Make your function recursive.
		sum([1, 2, 3, 4]) ➞ 10

		sum([1, 2]) ➞ 3

		sum([1]) ➞ 1

		sum([]) ➞ 0

	 */

	public static int sum(int[] arr) {

		return Arrays.stream(arr).sum();

	}

	/*Create a function that takes two strings and returns true if the first string ends with the second string; otherwise return false.
	* checkEnding("abc", "bc") ➞ true

	checkEnding("abc", "d") ➞ false

	checkEnding("samurai", "zi") ➞ false

	checkEnding("feminine", "nine") ➞ true

	checkEnding("convention", "tio") ➞ false
	*
	*
	*
	*
	* */

	@Test
	public void checkEndString() {

		Boolean f = checkEnding("hola", "la");
	}

	public static boolean checkEnding(String str1, String str2) {

		return str1.substring(str1.length() - str2.length(), str1.length()).equals(str2);
	}


/*		Given a two digit number, return true if that number contains one even and one odd digit.
		Examples

	oneOddOneEven(12) ➞ true

	oneOddOneEven(55) ➞ false

	oneOddOneEven(22) ➞ false*/

	@Test
	public void oneOddOneEven1() {

		Boolean f = oneOddOneEven(55);
	}

	public static boolean oneOddOneEven(Integer number) {

		String n = String.valueOf(number);
		Integer n1 = n.indexOf(0);
		return false;
	}


	@Test
	public void seven() {

		String f = sevenBoom(new int[]{1, 4, 4, 4, 4, 4, 7, 2, 1, 2});
	}

	public static String sevenBoom(int[] arr) {
		String test = Arrays.toString(arr);
		System.out.println(test);
		return Arrays.toString(arr).contains("7") ? "Boom!"
				: "there is no 7 in the array";

	}

	/*Write a function that adds two numbers. The catch, however, is that the numbers will be strings.
			Examples

	addStrNums("4", "5") ➞ "9"
	addStrNums("abcdefg", "3") ➞ "-1"
	addStrNums("1", "") ➞ "1"
	addStrNums("1874682736267235927359283579235789257", "32652983572985729") ➞ 1874682736267235927391936562808774986

	If there are any non-numerical characters, return "-1".
    If one option is blank the code should still work.
    Your function should be able to add any size number.
    Your function doesn't have to add negative numbers.
    Bonus: Don't use BigInteger or BigDecimal classes.*/

	public static String addStrNums(String num1, String num2) {
		try {
			if (num1.equals("") && num2.equals("")) {
				return "0";
			}
			if (num1.equals(""))
				return num2;
			if (num2.equals(""))
				return num1;

			BigDecimal number1 = new BigDecimal(num1);
			BigDecimal number2 = new BigDecimal(num2);


			BigDecimal result = number1.add(number2);
			return result.toString();
		} catch (NumberFormatException e) {
			return "-1";
		}
	}

	@Test
	public void test1() {
		assertEquals("0", LambdaExpressionsTest.addStrNums("", ""));
	}

	@Test
	public void test2() {
		assertEquals("2", LambdaExpressionsTest.addStrNums("1", "01"));
	}

	@Test
	public void test3() {
		assertEquals("1", LambdaExpressionsTest.addStrNums("1", ""));
	}

	@Test
	public void test4() {
		assertEquals("198548492868763049967194397711865020200936966975607313794081327943206822707399212908284015616104251803151710460793585524786631258662967654803793576863784154372202562981937878837883388807533802081502644157231966815017027363013212273", LambdaExpressionsTest.addStrNums("198547982570192857109283570192837509218375091283750192835710298357019237509125710925710923759012375901275901285701925712035712983571092562945875310962518235712385971230956127856123571209358712905610923587102395716258125612095710298", "510298570192857910827519027510982561875691857120958371029586187585198273501982573091857091875901875809175091659812750918275091875091857918265901265918659816591750981750981759817598175089175891720570129571098758901750917501975"));
	}

	@Test
	public void test5() {
		assertEquals("20007", LambdaExpressionsTest.addStrNums("0000001", "020006"));
	}

	@Test
	public void test6() {
		assertEquals("-1", LambdaExpressionsTest.addStrNums("1325123515s238579875987", "38698592523525325"));
	}

	@Test
	public void test7() {
		assertEquals("123456788654323456543456765432345678843234567150666666666666612735980127350918265309182653091635916258165871265087126121827562875835613875612875360182653127560192756012975608172560817653081760126578132617265192561923051397585261519826512951827401928470192864312873561298357120985710927561287356129857120851235612835712935612385971230598612035912635189273651289357120983571298035612836518237481235098172350891623508912375981206598127539128035619286350913860079316692430135070083545746229910105132529169548059251105934155707345561928216714345785488557882881776650962212910741009493707948652177877984833637483638061960049918284138811057018110547340295146562841027828410250749402417800024669988757747975297553431247669274658461094759253860242961229096131924658044740299", LambdaExpressionsTest.addStrNums("123456788654323456543456765432345678843234567150666666666666612735980127350918265309182653091635916258165871265087126121827562875835613875612875360182653127560192756012975608172560817653081760126578132617265192561923051397585261519826512951827401928470192864312873561298357120985710927561287356129857120851235612835712935612385971230598612035912635189273651289357120983571298035612836518237481235098172350891623508912375981206598127539128035619286350912836509123856710298560918236590138257013257219857182935681923569032656109851629851605109283560192863598126359125710982375918237598125091256012893570128357128935609128350192873501928365019283750129837401928374019283740189237401298374019823740912365012381075109823650912837501923561023650123659812375091862350912735", "1023570192835719836509165309156091653091875309312365123569182365123051235710298365109236501928365019283650291836501928365091256109823560921865091263509126509126350921568091265309128653091263590165309160912653809126510560165016501650650165016835610285172356137845623745623592835692836592837569283756832795693827564"));
	}


	public static boolean paranthesis(char[] s) {
		Stack<String> stack = new Stack<String>();
		//Arrays.asList(s).stream().filter(i -> i.equals('{') || i.equals('(') || i.equals('[')).forEach(j -> stack.push(s[j]));
		return false;
	}


/*

    String[] employeesInput = {
            "1,Richard,Engineering",
            "2,Erlich,HR",
            "3,Monica,Business",
            "4,Dinesh,Engineering",
            "6,Carla,Engineering"
    };

    And this would be considered an acceptable form of output for the adjacency list:

# 1: 2, 3
# 2: 1, 4
# 3: 1
# 4: 2
# 6: None
 */


	public static Map<String, List<String>> splitEmployNumber() {

		String[] employeesInput = {
				"1,Richard,Engineering",
				"2,Erlich,HR",
				"3,Monica,Business",
				"4,Dinesh,Engineering",
				"6,Carla,Engineering"};
		List<String> id = Arrays.asList(employeesInput).stream().map(i -> (i.substring(0, 1))).collect(Collectors.toList());
		for (String i : id) {

			//  System.out.println("id :" + i);
		}

		String[] friendshipsInput = {
				"1,2",
				"1,3",
				"2,4"
		};

		Map<String, List<String>> map = new HashMap<>();
		//List<String> list = new ArrayList<>();
		// map.put("key1", list);
		for (String i : id) {
			boolean find = false;
			List<String> list = new ArrayList<>();
			for (int j = 0; j < friendshipsInput.length; j++) {
				if (friendshipsInput[j].contains(String.valueOf(i))) {
					String[] friendshipsInputCopy = Arrays.copyOf(friendshipsInput, friendshipsInput.length);
					friendshipsInputCopy[j] = friendshipsInputCopy[j].replace(i, "");
					friendshipsInputCopy[j] = friendshipsInputCopy[j].replace(",", "");
					map.put(i, list);
					map.get(i).add(friendshipsInputCopy[j]);
					find = true;
				}

			}
			if (!find) {
				map.put(i, list);
				map.get(i).add("None");
			}
		}
		return map;

	}

	@Test
	public void id() {

		Map<String, List<String>> id = splitEmployNumber();
		System.out.println("result" + id);
	}

	/*Given a string, find its first non-repeating character*/
	@Test
	public void firstNonRepeating() {
		String s = "geeksforgeeks";
		char[] chars1 = new char[s.length()];
		s.getChars(0, s.length(), chars1, 0);
		Map<String, Integer> map1 = new LinkedHashMap<>();
		for (char s1 : chars1) {
			int count = 1;
			if (!map1.containsKey(String.valueOf(s1))) {
				map1.put(String.valueOf(s1), count);
			} else {
				count = map1.get(String.valueOf(s1)) + 1;
				map1.put(String.valueOf(s1), count);
			}
		}
		System.out.println(map1
				.entrySet()
				.stream()
				.filter(e -> Objects.equals(e.getValue(), 1))
				.findFirst()
				.map(Map.Entry::getKey));


	}


	/**
	 * Find all keys matching a value.
	 *
	 * @param value The value to be matched. Can be null.
	 * @return all keys matching the value in the team.
	 */
	private static List<String> getKeys(Integer value) {
		Map<String, Integer> team1 = new HashMap<>();
		team1.put("foo", 1);
		team1.put("isa", 2);
		team1.put("bar", 1);
		return team1.entrySet().stream().filter(s -> s.getValue().equals(value)).map(Map.Entry::getKey).collect(Collectors.toList());
	}

	@Test
	public void matchValue() {
		List<String> keys = LambdaExpressionsTest.getKeys(1);
		keys.stream().forEach(s -> System.out.println(s));
	}


	/**
	 * Find any key matching the value, in the given map.
	 *
	 * @param mapOrNull Any map, null is considered a valid value.
	 * @param value     The value to be searched.
	 * @param <K>       Type of the key.
	 * @param <T>       Type of the value.
	 * @return An optional containing a key, if found.
	 */

	public static <K, T> Optional<K> getKey(Map<K, T> mapOrNull, T value) {

		return Optional.ofNullable(mapOrNull).flatMap(map -> map.entrySet()
				.stream()
				.filter(e -> Objects.equals(e.getValue(), value))
				.map(Map.Entry::getKey)
				.findAny());

	}







	/* Find any key matching a value.
	 *
	 * @param value The value to be matched. Can be null.
	 * @return Any key matching the value in the team.
	 */
	// private Optional<String> getKey(Integer value){

       /* return team1
                .entrySet()
                .stream()
                .filter(e -> Objects.equals(e.getValue(), value))
                .map(Map.Entry::getKey)
                .findAny();*/
	//}


	/*Given a string, find its first non-repeating character*/
	@Test
	public void firstNonRepeating2() {
		String s = "geeksforgeeks";
		char[] chars1 = new char[s.length()];
		s.getChars(0, s.length(), chars1, 0);
		Map<String, Integer> map1 = new HashMap<>();
		for (char s1 : chars1) {
			int count = 1;
			if (!map1.containsKey(String.valueOf(s1))) {
				map1.put(String.valueOf(s1), count);
			} else {
				count = map1.get(String.valueOf(s1)) + 1;
				map1.put(String.valueOf(s1), count);
			}
		}
		System.out.println(map1);
	}

	@Test
	public void test122() {

		//List<Integer> mayorSubArray1 = LambdaExpressionsTest.mayorSubArray(new int []{1, 2, 3, 1, 4, 5, 2, 3, 6},3);
		List<Integer> mayorSubArray1 = LambdaExpressionsTest.mayorSubArray(new int[]{8, 5, 10, 7, 9, 4, 15, 12, 90, 13}, 4);


	}

	public static List<Integer> mayorSubArray(int[] array, int k) {


		List<Integer> result = new ArrayList<>();

		for (int i = 0; i <= array.length - k; i++) {
			Integer maxValue = Collections.max(Arrays.stream(array).boxed().collect(Collectors.toList()).subList(i, i + k));
			result.add(maxValue);
			System.out.println(maxValue);
		}
		return result;
	}


	@Test
	public void rangeLarge() {
		LambdaExpressionsTest.largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6});

	}

	public static int[] largestRange(int[] array) {
		// Write your code here.
		Integer[] what = Arrays.stream(array).boxed().toArray(Integer[]::new);
		TreeSet<Integer> unique = new TreeSet<Integer>(Arrays.asList(what));


		// Create an Iterator over the TreeSet
		Iterator<Integer> iterator = unique.iterator();

		// Loop over the TreeSet values
		// and print the values
		System.out.print("TreeSet: ");
		while (iterator.hasNext())

			//if (unique)
			System.out.print(iterator.next()
					+ ", ");
		//unique.f


		return null;
	}

	/*
	 * Complete the solution function
	 */
	static Integer solution(int[] nums) {
		/*
		 *  Write your solution here !
		 *  You can use the result variable
		 *  below to return your answer
		 */
		Map<Integer, Integer> sortedMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (sortedMap.get(nums[i]) == null) {
				sortedMap.put(nums[i], 1);

			} else {
				sortedMap.put(nums[i], sortedMap.get(nums[i] + 1));

			}
		}


		return sortedMap.entrySet().stream().filter(s -> s.getValue().equals(new Integer(1))).map(Map.Entry::getKey).collect(Collectors.toList()).get(0);


	}



	/*non-matching lines*/

	public static List<String> zap(List<String> lines, String omit){
		return lines.parallelStream().filter(not(omit::equals)).collect(Collectors.toList());


	}
	public static <R> Predicate<R> not(Predicate<R> predicate) {
		return predicate.negate();
	}
	@Test
	public void nonMatching() {
		List<String> lamba =LambdaExpressionsTest.zap(Arrays.asList("My", "name", "is", "John", "Doe"),"is");
		lamba.parallelStream().forEach(s->System.out.println(s));
	}



/*	This is a demo task.

	Write a function:

	class Solution { public int solution(int[] A); }

	that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

	For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

	Given A = [1, 2, 3], the function should return 4.

	Given A = [−1, −3], the function should return 1.

	Write an efficient algorithm for the following assumptions:

	N is an integer within the range [1..100,000];
	each element of array A is an integer within the range [−1,000,000..1,000,000].*/

	public static int solution2(int[] A) {
		// write your code in Java SE 8
		Set <Integer> order = new TreeSet<>();
		for (int a : A){

			order.add(a);
		}
		for (int i=1; i<=A.length;i++){
			if (!order.contains(i)){
				return i;
			}
		}
		return 1;
	}
	public static int solution3(int[] A) {
		// write your code in Java SE 8
		Set <Integer> order = new TreeSet<>();
		for (int a : A){

			order.add(a);
		}
		for (int i=1; i<=A.length;i++){
			if (!order.contains(i)){
				return i;
			}
		}
		return 1;
	}

	@Test
	public void minor(){
		LambdaExpressionsTest.solution2(new int[]{1, 2, 3});

	}



/*	Examples

	happy(203) ➞ true

	happy(11) ➞ false

	happy(107) ➞ false*/


	public static boolean happy(int num) {

		List<Integer> list = new ArrayList<>();
		if (num==1){

			return true;
		}
		if (num==4){
			return false;
		}

		int cont= 0;
		LinkedList<Integer> stack = new LinkedList<>();

				stack =LambdaExpressionsTest.separateNumber(num);
		while (!stack.isEmpty()){

			cont += Math.pow(stack.pop(),2);


		}
		return happy(cont);

	}

	@Test
	public void test11() {
		assertEquals(true, LambdaExpressionsTest.happy(100));
	}

	@Test
	public void test222() {
		assertEquals(false, LambdaExpressionsTest.happy(101));
	}



   public static LinkedList<Integer>  separateNumber(int number) {
	   LinkedList<Integer> stack = new LinkedList<Integer>();
	   while (number > 0) {
		   stack.push(number % 10);
		   number = number / 10;
	   }

	  return stack;
   }

  @Test
  public void printNumber(){

		System.out.println(LambdaExpressionsTest.happy(203));
	  System.out.println(LambdaExpressionsTest.happy(11));
	  System.out.println(LambdaExpressionsTest.happy(107));
	  System.out.println(LambdaExpressionsTest.happy(100));
	  System.out.println(LambdaExpressionsTest.happy(101));
  }

}

// Linked list class
class ListNode {
     public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }



/*Write a Java program to test if a binary tree is a subtree of another binary tree.*/
  class  Solution {
	/**
	 * @param T1, T2: The roots of binary tree.
	 * @return: True if T2 is a subtree of T1, or false.
	 */
	public static boolean is_Subtree(TreeNode T1, TreeNode T2) {
		if (T2 == null) return true;
		if (T1 == null) return false;
		if (is_Same(T1, T2)) return true;
		if (is_Subtree(T1.left, T2) || is_Subtree(T1.right, T2)) return true;
		return false;

	}

	public static boolean is_Same(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) {
			return t1 == t2;
		} else if (t1.val != t2.val) {
			return false;
		} else {
			return is_Same(t1.left, t2.left) && is_Same(t1.right, t2.right);
		}
	}


	/* Driver program to test above functions */
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left  = t2;
		t1.right = t3;

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		n1.left  = n2;
		n1.right = n3;

		System.out.println(is_Subtree(t1, n1));
	}







}


class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}






  }

  class Solution2 {



	static String[] part_1 = new String[]{" 9: dog ", " 2 :quick ","4: fox", " 7: the ", "5: jumps"} ;
	static String[] part_2 = new String[]{"3 :brown", " 1 : the", " 6:over", "8 :lazy","10: this"," 11 : morning" } ;

	public static void main (String [] args){
		Solution2.printSentence();

	}


	public  static void printSentence(){
		Map <Integer, String> sentence = new TreeMap<>();
		part_1 = ArrayUtils.addAll (part_1, part_2);
		for (String s : part_1){
			sentence.put(Integer.valueOf(s.substring(0,s.indexOf(":")).trim()),s.substring(s.indexOf(":")+1, s.length()).trim());
		}
		sentence.entrySet().forEach(entry-> {
					if (entry.getKey().equals(((TreeMap<Integer, String>) sentence).lastEntry().getKey())) {
						System.out.print(entry.getValue() + ".");
					} else {
						System.out.print(entry.getValue() + " ");
					}
				}
		);
	}





}
