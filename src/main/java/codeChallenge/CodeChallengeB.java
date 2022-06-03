package codeChallenge;

public class CodeChallengeB {
	public static void main(String[] args) {
	
	
	
//	partition an array into one element true or false
	int[] firstPartitionArray = { 2, 8, 4, 1 };
	int[] secondPartitionArray = { -6, -55, 1, -5, 30 };
	int[] thirdPartitionArray = { -7, -12, 8, -3, 9, -4 };
	
	System.out.println(canPartition(firstPartitionArray));
	System.out.println(canPartition(secondPartitionArray));
	System.out.println(canPartition(thirdPartitionArray));
	
}
	public static boolean canPartition(int[] inputArray) {
		boolean partionable = false;

		for (int i = 0; i < inputArray.length; i++) {
			int currentNumber = inputArray[i];
			int currentMultiply = 1;

			for (int k = 0; k < inputArray.length; k++) {
				if (k == i) {
					continue;
				}

				currentMultiply *= inputArray[k];
			}

			if (currentMultiply == currentNumber) {
				partionable = true;
				break;
			}
		}

		return partionable;
	}
}