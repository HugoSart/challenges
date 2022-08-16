package com.hsartori.challenges.interviews;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

class TotalVotes {

    private static final String URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=<cityName>&estimated_cost=<estimatedCost>";

    /*
     * Complete the 'getVoteCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING cityName
     *  2. INTEGER estimatedCost
     *  https://jsonmock.hackerrank.com/api/food_outlets?city=<cityName>&estimated_cost=<estimatedCost>
     */

    public static int getVoteCount(String cityName, int estimatedCost) {
        try {

            // Make HTTP Request
            // TODO: Replace with proper URL Builder
            final String parsedURL = URL.replace("<cityName>", cityName)
                    .replace("<estimatedCost>", String.valueOf(estimatedCost));

            // Which HTTP library should I use in hackerrank?
            final URL url = new URL(parsedURL);
            final URLConnection conn = url.openConnection();
            final InputStream in = conn.getInputStream();
            final java.util.Scanner scanner = new java.util.Scanner(in).useDelimiter("\\A");
            final String json = scanner.hasNext() ? scanner.next() : "";

            // Find votes with for loop because JSON library is not available here
            final char[] chars = json.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                final char c = chars[i];

                // Check if is in field
                if (c == '"' && chars[i + 1] == 'v' && chars[i + 2] == 'o' && chars[i + 3] == 't' && chars[i + 4] == 'e' && chars[i + 5] == 's' && chars[i + 6] == '"') {

                    // Extract number
                    String num = "";
                    for (int j = i + 8; j < chars.length; j++) {
                        if (chars[j] == ' ' || Character.isDigit(chars[j])) {
                            num += chars[j];
                        } else {
                            break;
                        }
                    }

                    return Integer.parseInt(num);

                }


            }

            return -1;

        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }

    }

}
