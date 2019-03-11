/**
 * https://leetcode.com/problems/encode-and-decode-tinyurl/
 */

//first answer
public class Codec {

    private static final char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	private final Map<Character, Integer> indices;
	private final List<String> urls;

	public Codec() {
		this.urls = new ArrayList<>();
		this.indices = new HashMap<>();
		for (int i = 0; i < BASE62.length; i++) {
			indices.put(BASE62[i], i);
		}
	}

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
		urls.add(longUrl);
		int index = urls.size() - 1;
		StringBuilder shorten = new StringBuilder();
		while(index != 0) {
			shorten.append(BASE62[index % 62]);
			index = index / 62;
		}
		return shorten.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
		int pos = 1;
		int index = 0;
		for(int i = 0; i < shortUrl.length(); i++) {
			int cIndex = indices.get(i);	
			index += cIndex * pos;
			pos *= 16;
		}
		return urls.get(index);
    }
}

//second answer(cheated)
public class Codec {

    private static final char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

	private int counter = 0;
	private final Map<String, String> mappings = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
		int index = counter++;
        StringBuilder shorten = new StringBuilder();
        while(index != 0) {
            shorten.append(BASE62[index % 62]);
            index = index / 62;
        }
		String shortUrl = shorten.toString();
		mappings.put(shortUrl, longUrl);
		return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
		return mappings.get(shortUrl);
    }
}
