package StringProblems;

import java.io.Serializable;

//Marker interfaces are replaced by the annotations which can accept the parameters as well like @Table(name="employee")
interface PermissionToAccess{} //This is the marker interface
class ConfidentialData implements PermissionToAccess{
    public void display(){
        System.out.println("Hello from the ConfidentialData...");
    }
}  // implementing with the class
public class MarkerInterFace implements Serializable{
    public static void main(String[] args) {
        ConfidentialData cd= new ConfidentialData();
        if(cd instanceof PermissionToAccess){
            System.out.println("Access Granted..");
        }
        cd.display();
    }
}
