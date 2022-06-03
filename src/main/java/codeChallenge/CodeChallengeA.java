package codeChallenge;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class CodeChallengeA {
	public static void main(String[] args) {

//		array based on ascending (asc) or descending (desc) order
		int[] firstReorderArray = { 234, 567, 33, 345 };
		int[] secondReorderArray = { 83737, 49474 };
		int[] thirdReorderArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		System.out.println(Arrays.toString(reorderDigits(firstReorderArray, "asc")));
		System.out.println(Arrays.toString(reorderDigits(firstReorderArray, "desc")));
		System.out.println(Arrays.toString(reorderDigits(secondReorderArray, "asc")));
		System.out.println(Arrays.toString(reorderDigits(secondReorderArray, "desc")));
		System.out.println(Arrays.toString(reorderDigits(thirdReorderArray, "asc")));
		System.out.println(Arrays.toString(reorderDigits(thirdReorderArray, "desc")));



	}
	
	public static int[] reorderDigits(int[] inputArray, String orderMethod) {
	
		int[] outputArray = new int[inputArray.length];

		if (orderMethod.equals("asc")) {
			for (int i = 0; i < inputArray.length; i++) {
				StringBuilder newNumber = new StringBuilder();
				String currentNumber = String.valueOf(inputArray[i]);
				char[] currentNumberAsArray = new char[currentNumber.length()];

				for (int k = 0; k < currentNumber.length(); k++) {
					currentNumberAsArray[k] = currentNumber.charAt(k);
				}
				int lowestNumber = 10;
				int lowestIndex = 0;
				int startingLength = currentNumberAsArray.length;

				for (int z = 0; z < startingLength; z++) {
					for (int c = 0; c < currentNumberAsArray.length; c++) {
						if (Integer.parseInt(String.valueOf(currentNumberAsArray[c])) < lowestNumber) {
							lowestNumber = Integer.parseInt(String.valueOf(currentNumberAsArray[c]));
							lowestIndex = c;
						}
					}
					newNumber.append(lowestNumber);
					currentNumberAsArray = ArrayUtils.remove(currentNumberAsArray, lowestIndex);
					lowestNumber = 10;
				}

				outputArray[i] = Integer.parseInt(String.valueOf(newNumber));

			}

		} else if (orderMethod.equals("desc")) {
			for (int i = 0; i < inputArray.length; i++) {
				StringBuilder newNumber = new StringBuilder();
				String currentNumber = String.valueOf(inputArray[i]);
				char[] currentNumberAsArray = new char[currentNumber.length()];

				for (int k = 0; k < currentNumber.length(); k++) {
					currentNumberAsArray[k] = currentNumber.charAt(k);
				}
				int highestNumber = 0;
				int highestIndex = 0;
				int startingLength = currentNumberAsArray.length;

				for (int z = 0; z < startingLength; z++) {
					for (int c = 0; c < currentNumberAsArray.length; c++) {
						if (Integer.parseInt(String.valueOf(currentNumberAsArray[c])) > highestNumber) {
							highestNumber = Integer.parseInt(String.valueOf(currentNumberAsArray[c]));
							highestIndex = c;
						}
					}
					newNumber.append(highestNumber);
					currentNumberAsArray = ArrayUtils.remove(currentNumberAsArray, highestIndex);
					highestNumber = 0;
				}

				outputArray[i] = Integer.parseInt(String.valueOf(newNumber));
			
			}

		} else {
			return null;
		}

		return outputArray;
	}

}