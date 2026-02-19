package StringProblems;

public class StringRotation {
    public static boolean isStringRotation(String s1, String s2){
        String combined= s2+s2;//we can add the s1 also here
        return combined.contains(s1);
    }
    public static void main(String[] args) {
        System.out.println("===================");
        boolean result= StringRotation.isStringRotation("waterbottle", "bottlewater");
        if(result) System.out.println("Given String is a rotation...");
        else System.out.println("It's not a rotation");
    }
}
