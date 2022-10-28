package codeTop;

public class T273 {
    // 最大值是2,147,483,648，读作
    // two billion one hundred and forty seven million four hundred and eighty three thousand six hundred and forty eight
    public String numberToWords(int num) {
        String ans = "";
        int billions = num / (int)Math.pow(10, 9);
        if (billions != 0) {
            ans += " " + translateBelowTwenty(billions) + " Billion";
        }
        String high = translateBelowThousand(num % (int)Math.pow(10, 9) / (int)Math.pow(10, 6));
        if (!high.equals("Zero")) {
            ans += " " + high + " Million";
        }
        String middle = translateBelowThousand(num % (int)Math.pow(10, 6) / 1000);
        if (!middle.equals("Zero")) {
            ans += " " + middle + " Thousand";
        }
        String low = translateBelowThousand(num % 1000);
        if (!low.equals("Zero")) {
            ans += " " + low;
        }
        if (ans.length() == 0) {
            return "Zero";
        } else {
            return ans.substring(1);
        }
    }

    private String translateBelowTwenty(int number) {
        return switch (number) {
            case 0 -> "Zero";
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            case 13 -> "Thirteen";
            case 14 -> "Fourteen";
            case 15 -> "Fifteen";
            case 16 -> "Sixteen";
            case 17 -> "Seventeen";
            case 18 -> "Eighteen";
            case 19 -> "Nineteen";
            default -> "error";
        };
    }

    private String translateBelowHundred(int number) {
        if (number < 20) {
            return translateBelowTwenty(number);
        } else {
            String ans = "";
            int tens = number / 10;
            ans += switch (tens) {
                case 2 -> "Twenty";
                case 3 -> "Thirty";
                case 4 -> "Forty";
                case 5 -> "Fifty";
                case 6 -> "Sixty";
                case 7 -> "Seventy";
                case 8 -> "Eighty";
                case 9 -> "Ninety";
                default -> "error";
            };
            int ones = number % 10;
            if (ones != 0) {
                ans += " " + translateBelowTwenty(ones);
            }
            return ans;
        }
    }

    private String translateBelowThousand(int number) {
        int hundreds = number / 100;
        if (hundreds == 0) {
            return translateBelowHundred(number);
        }
        String ans = translateBelowTwenty(hundreds) + " Hundred";
        String ones = translateBelowHundred(number % 100);
        if (!ones.equals("Zero")) {
            ans += " " + ones;
        }
        return ans;
    }
}
