package ReflectionProblems;

import java.lang.reflect.Field;

class SecretAgent{
    private String name = "Bond";
    public SecretAgent(){}
    public String getName(){
        return name;
    }
}
public class ReflectionWorking {
    public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        SecretAgent agent = new SecretAgent();
        
        // 1. Get the Class object
        Class<?> clazz = agent.getClass();

        
        // 2. Access the 'private' field by its name
        Field field = clazz.getDeclaredField("name");
        
        
        // 3. Bypass the 'private' security check
        field.setAccessible(true);
        
        System.out.println("Agent before change::"+field.get(agent));
        // 4. Change the value!
        field.set(agent, "Johnny English");
        
        // Output the modified value
        System.out.println("Agent name is now: " + field.get(agent));
    }
    
}
