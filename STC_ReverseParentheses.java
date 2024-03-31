import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class STC_ReverseParentheses {

	public static String reverseParentheses(String s, int[] openingParenthesesIndices,int[] closingParenthesesIndices) {
		// Method implementation remains the same
		Stack<Integer> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '(') {
				stack.push(i);
			} else if (chars[i] == ')') {
				int start = stack.pop();
				reverseSubstring(chars, start + 1, i - 1);
			}
		}

		StringBuilder result = new StringBuilder();
		for (char c : chars) {
			if (c != '(' && c != ')') {
				result.append(c);
			}
		}

		// Check if both opening and closing parentheses are found before inserting them
		for (int i = 0; i < openingParenthesesIndices.length; i++) {
			if (openingParenthesesIndices[i] != -1 && closingParenthesesIndices[i] != -1) {
				result.insert(openingParenthesesIndices[i], "(");
				result.insert(closingParenthesesIndices[i], ")");
			}
		}
		return result.toString();
	}

	private static void reverseSubstring(char[] chars, int start, int end) {
		while (start < end) {
			char temp = chars[start];
			chars[start] = chars[end];
			chars[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		String[] testCases = { "abd(jnb)asdf", "abdjnbasdf", "dd(df)a(ghhh)" };
		for (String test : testCases) {
			System.out.println("Input: " + test);

			// Find all occurrences of indices for opening parentheses
			List<Integer> openingParenthesesIndicesList = new ArrayList<>();
			for (int i = 0; i < test.length(); i++) {
				if (test.charAt(i) == '(') {
					openingParenthesesIndicesList.add(i);
				}
			}
			int[] openingParenthesesIndices = openingParenthesesIndicesList.stream().mapToInt(Integer::intValue)
					.toArray();

			// Find all occurrences of indices for closing parentheses
			List<Integer> closingParenthesesIndicesList = new ArrayList<>();
			for (int i = 0; i < test.length(); i++) {
				if (test.charAt(i) == ')') {
					closingParenthesesIndicesList.add(i);
				}
			}
			int[] closingParenthesesIndices = closingParenthesesIndicesList.stream().mapToInt(Integer::intValue)
					.toArray();
			System.out.println(
					"Output: " + reverseParentheses(test, openingParenthesesIndices, closingParenthesesIndices));
		}
	}

}
