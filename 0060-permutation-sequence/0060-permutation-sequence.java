class Solution {
   	public static String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder("");
		String rv = "";

		for (int i = 1; i <= n; ++i) {
			sb.append(i + "");
		}

		int[] arr = new int[n + 1];
		arr[0] = arr[1] = 1;

		for (int i = 1; i <= n; ++i) {
			arr[i] = i * arr[i - 1];
		}

		while (rv.length() != n) {
			int index = 0;
			while (k > arr[sb.length() - 1]) {
				k -= arr[sb.length() - 1];
				++index;
			}
			rv += sb.charAt(index);
			sb.deleteCharAt(index);
		}

		return rv;
	}
}