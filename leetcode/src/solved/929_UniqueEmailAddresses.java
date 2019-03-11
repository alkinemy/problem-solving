/**
 * https://leetcode.com/problems/unique-email-addresses/
 */

class Solution {
	public int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();

		for (String email : emails) {
			String[] localAndDomain = email.split("@");

			String local = localAndDomain[0];
			String domain = localAndDomain[1];

			StringBuilder normalized = new StringBuilder();
			for (int i = 0; i < local.length(); i++) {
				char c = local.charAt(i);
				if (c == '.') {
					continue;
				}
				if (c == '+') {
					break;
				}
				normalized.append(c);
			}
			normalized.append('@').append(domain);
			uniqueEmails.add(normalized.toString());
		}
		return uniqueEmails.size();

	}
}
