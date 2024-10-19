import java.util.HashMap;
import java.util.Scanner;

public class QuickLinkShortener {
    private static HashMap<String, String> urlMap = new HashMap<>();
    private static int counter = 1; // To create unique short URLs

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options: 1. Shorten URL 2. Get Original URL 3. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1: // Shorten URL
                    System.out.println("Enter the original URL: ");
                    String longUrl = scanner.nextLine();
                    String shortUrl = "short.ly/" + counter;
                    urlMap.put(shortUrl, longUrl);
                    counter++;
                    System.out.println("Shortened URL: " + shortUrl);
                    break;

                case 2: // Get Original URL
                    System.out.println("Enter the shortened URL: ");
                    String shortUrlInput = scanner.nextLine();
                    if (urlMap.containsKey(shortUrlInput)) {
                        System.out.println("Original URL: " + urlMap.get(shortUrlInput));
                    } else {
                        System.out.println("Shortened URL not found.");
                    }
                    break;

                case 3: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
