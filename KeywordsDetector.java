public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < keywords. length; j++) {
                if (contains(lowerCase(sentences[i]), keywords[j])) {
                    System.out.println(sentences[i]);
                    break; 
                }
            }
        }
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str1.indexOf(str2) == -1) {
            return false; 
        } 
        return true; 
    }

    public static String lowerCase(String str) {
        char[] lowerCaseArr = new char[str.length()]; 
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i); 
            if ((int) x >= 65 && (int) x <= 90) {
                x = (char) ((int) x + 32); 
            }
            lowerCaseArr[i] = x; 
        }
        String output = ""; 
        for (int i = 0; i < lowerCaseArr.length; i++) {
            output += lowerCaseArr[i]; 
        }
        return output;
    }
}
