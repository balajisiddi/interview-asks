package StringProblems;

public class StringRotation {
    public static boolean isStringRotation(String s1, String s2){
        boolean result = false;
        if(s1.length()==s2.length() || s1 !=null || s2 != null){
            String combined= s2+s2;//we can add the s1 also here
            result = combined.contains(s1);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("===================");
        boolean result= StringRotation.isStringRotation("waterbottle", "bottlewater");
        if(result) System.out.println("Given String is a rotation...");
        else System.out.println("It's not a rotation");
        System.out.println(StringRotation.isStringRotation("12345", "34512"));
        System.out.println(StringRotation.isStringRotation("!$%&#", "%&#!$"));
    }
}
