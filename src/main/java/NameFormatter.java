public class NameFormatter {
    private NameFormatter() {
    }


    public static String format(String firstName, String lastName) {
        return lastName + " " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        return lastName + ", " + prefix + " " + firstName + " " + middleName + ", " + suffix;
    }

    public static String format(String fullName) {
        // Step 1: Prepare variables
        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String suffix = "";

        // Step 2: Split suffix (if comma exists)
        String[] commaSplit = fullName.split(",");

//        commaSplit[0] = "Dr. Mel B Johnson"
//        commaSplit[1] = " PhD"

        String namePart = commaSplit[0].trim();

//        " PhD" → "PhD"
//         suffix = "PhD"

        if (commaSplit.length > 1) {
            suffix = commaSplit[1].trim();
        }

        // Step 3: Split the main name into words
        String[] words = namePart.split(" ");

        // Step 4: Check if first word is a prefix (Dr., Mr., etc.)
        int currentIndex = 0;

        if (words[0].contains(".")) {
            prefix = words[0];
            currentIndex++;
        }

        // Step 5: Assign first name
        firstName = words[currentIndex];
        currentIndex++;

        // Step 6: Check if there is a middle name
        if (currentIndex < words.length - 1) {
            middleName = words[currentIndex];
            currentIndex++;
        }

        // Step 7: Last name is always last
        lastName = words[currentIndex];

        // Step 8: Build the formatted result
        String formattedName = lastName + ", ";

        if (!prefix.isEmpty()) {
            formattedName += prefix + " ";
        }

        formattedName += firstName;

        if (!middleName.isEmpty()) {
            formattedName += " " + middleName;
        }

        if (!suffix.isEmpty()) {
            formattedName += ", " + suffix;
        }

        return formattedName;
    }
}

