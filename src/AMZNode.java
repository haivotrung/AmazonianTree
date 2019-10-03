import java.util.*;
public class AMZNode {
    private Person person;
    AMZNode parentNode;
    private List<AMZNode> children;

    public AMZNode(Person person, AMZNode parentNode) {
        this.person = person;
        this.parentNode = parentNode;
        children = new ArrayList<AMZNode>();
    }

    public Person getPerson() {
        return person;
    }

    public AMZNode getParent() {
        return parentNode;
    }

    public void changeParent(AMZNode newParent) {
        parentNode = newParent;
    }

    public List<AMZNode> getChildren(){
        return children;
    }

    public void addChild(AMZNode childNode) {
        children.add(childNode);
    }

    public String getName() {
        return person.getName();
    }

}
