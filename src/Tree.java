import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree {
    private AMZNode root;


    public Tree() {
        root = new AMZNode(new Person("Aprodite"), null);
    }

    public void changeParent(String name, String parentName) {
        getObj(name).changeParent(getObj(parentName));
    }

    public void addPerson(String name, String parentName) {
        if (!contains(parentName) && contains(name) && !(parentName.equals("Aprodite"))) {
            addPersonH(new Person(parentName), getObj(name).getParent().getName(), getObj(name).getParent());
            changeParent(name, parentName);
        } else if (contains(name)) {
            System.out.println("Name existed, new name please");
        } else {
            if(getObj(parentName)==null){
                addPersonH(new Person(name), parentName, root);
            } else {
                addPersonH(new Person(name), parentName, getObj(parentName));
            }
        }
    }


    private void addPersonH(Person person, String parentName,
                            AMZNode node) {
        if ((parentName.equals(node.getName()))) {
            node.addChild(new AMZNode(person, node));
        }
    }

    private AMZNode getObj(String name) {
        return getObjHelper(root, name);
    }

    private AMZNode getObjHelper(AMZNode node, String name){
        if(node.getName().equals(name)) return node;
        List<AMZNode> children = node.getChildren();
        AMZNode temp = null;
        Iterator<AMZNode> itr = children.iterator();
        while(itr.hasNext()&&temp==null){
            temp = getObjHelper(itr.next(), name);
        }
        return temp;
    }

    Person getPerson(String name) {
        if(name==null)throw new IllegalArgumentException();
        Person temp = getObj(name).getPerson();
        return temp;
    }

    public void getChildrenName(String name){
        AMZNode p = getObj(name);
        String separator = "";  // separator here is your ","

        for (int i = 0; i < p.getChildren().size(); i++) {
            System.out.print(separator + (p.getChildren().get(i).getName()));
            separator = ", ";
        }
        System.out.println(" ");
    }

    public void getChildrenCount(String name) {
        AMZNode p = getObj(name);
        System.out.println(" ");
        System.out.println(p.getChildren().size());
    }

    public void getParent(String name) {
        AMZNode p = getObj(name);
        System.out.println(p.getParent().getName());
    }

    public ArrayList<String> getAunts(String name) {
        return getSibs(getObj(name).getParent().getName());
    }

    public ArrayList<String> getSibs(String name) {
        AMZNode p = getObj(name);
        ArrayList<String> sibList = new ArrayList<String>();
        List<AMZNode> childList;
        try{
            childList = p.getParent().getChildren();
            for (int i = 0; i < childList.size(); i++) {
                if((!childList.get(i).getName().equals(name))) {
                    sibList.add(childList.get(i).getName());
                }
            }
        } catch(NullPointerException npe) {
            System.out.println("Invalid input");
        }
        return sibList;
    }

    public ArrayList<String> getAncestor(String name) {
        ArrayList<String> ancestorList = new ArrayList<String>();
        AMZNode p = getObj(name);
        while (p != root) {
            ancestorList.add(p.getParent().getName());
            p = getObj(p.getParent().getName());
        }
        return ancestorList;
    }

    public ArrayList<String> getDes(String name) {
        AMZNode p = getObj(name);
        ArrayList<String> desList = new ArrayList<String>();
        List<AMZNode> childList;

        childList = p.getChildren();
        for (int i = 0; i < childList.size(); i++) {
            desList.add(childList.get(i).getName());
            desList.addAll(getDes(childList.get(i).getName()));
        }
        return desList;
    }

//Start of is verb
    public void isParent(String name, String name2) {
        AMZNode p = getObj(name2);
        if (p.getParent().getName().equals(name)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public void isChild(String name, String name2) {
        if (getObj(name2).getChildren().contains(getObj(name))) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public void isAunt(String name, String name2) {
        ArrayList<String> aunts = getAunts(name2);
        if (aunts.contains(name)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }


    public void isSister(String name, String name2) {
        AMZNode p = getObj(name);
        AMZNode p2 = getObj(name2);
        if (p.getParent().equals(p2.getParent())) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public void isDes(String name, String name2) {
        ArrayList<String> des = getDes(name2);
        if (des.contains(name)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public void isAnc(String name, String name2) {
        ArrayList<String> anc = getAncestor(name2);
        if (anc.contains(name)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
//end of is verb

    public boolean contains(String name){
        if(name==null)throw new IllegalArgumentException();
        return containsHelper(root, name);
    }

    private boolean containsHelper(AMZNode node, String name){
        try{
            if(getPerson(name)==null)return false;
            if(node.getName().equals(name)) return true;
            List<AMZNode> children = node.getChildren();
            boolean done = false;
            for(int i=0;i<children.size()&&!done; i++){
                if(containsHelper(children.get(i), name));
                done= true;
            }
            return done;
        }catch(NullPointerException npe){
            return false;
        }
    }
}