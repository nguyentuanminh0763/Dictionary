package Common;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Input {
    Scanner sc = new Scanner(System.in);

    public String getString() {
        while (true) {
            String res = sc.nextLine().trim();

            if (!res.isEmpty()) {
                return res;
            } else {
                System.out.println("you cannot enter empty!");
            }
        }
    }

    public int getInt(String message, int min, int max) {
        int number = 0;

        while (true) {
            System.out.println(message);
            try {
                number = Integer.parseInt(getString());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Number out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number invalid!");
            }
        }
    }

    public String getEmail() {
        while (true) {
            Pattern p16 = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
            String email = getString();
            if (p16.matcher(email).find()) {
                return email;
            } else {
                System.out.println("Enter Email: with format <account name>@<domain>");
            }
        }
    }

    public String getPhoneNumber() {
        while (true) {
            Pattern case2 = Pattern.compile("^\\([0-9]{3}\\)(-[0-9]{3})(-[0-9]{4})( (x|ext)[0-9]{4})?");
            Pattern case3 = Pattern.compile("^[0-9]{3}((.| )?[0-9]{3})((.| )?[0-9]{4})");
            String phonenumber = getString();
            if (case2.matcher(phonenumber).find() || case3.matcher(phonenumber).find()) {
                System.out.println("Successful");
                return phonenumber;
            } else {
                System.out.println("Please input Phone flow\n" +
                        "• 1234567890\n" +
                        "• 123-456-7890 \n" +
                        "• 123-456-7890 x1234\n" +
                        "• 123-456-7890 ext1234\n" +
                        "• (123)-456-7890\n" +
                        "• 123.456.7890\n" +
                        "• 123 456 7890\n" +
                        "");
            }
        }
    }

    public String getName() {
        while (true) {
            Pattern pname = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)?$");
            String name = getString();
            if (pname.matcher(name).find()) {
                return name;
            } else {
                System.out.println("format 'Name Name'");
            }
        }
    }

    // public int getID(HashMap<String, Doctor> d) {
    //     if (contactList.isEmpty()) {
    //         return 1;
    //     }
    //     return contactList.get(contactList.size() - 1).getIdContact() + 1;
    // }

}
