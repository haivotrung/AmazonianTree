import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree ft = new Tree();
        boolean stop = false;

        while (!stop) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] pr = str.split(" ");
            switch (pr[0]) {

                case "set": {
                    if (pr[2].contentEquals("parent")) {
                        ft.addPerson(pr[3], pr[1]);
                    } else if (pr[2].contentEquals("child")) {
                        ft.addPerson(pr[1], pr[3]);
                    }
                    break;
                }

                case "get": {
                    if (pr[2].contentEquals("parent")) {
                        ft.getParent(pr[1]);
                    } else if (pr[2].contentEquals("child")) {
                        ft.getChildrenName(pr[1]);
                    } else if (pr[2].contentEquals("sister")) {
                        System.out.println(ft.getSibs(pr[1]));
                    } else if (pr[2].contentEquals("aunt")) {
                        System.out.println(ft.getAunts(pr[1]));
                    } else if (pr[2].contentEquals("ancestor")) {
                        System.out.println(ft.getAncestor(pr[1]));
                    } else if (pr[2].contentEquals("descendant")) {
                        System.out.println(ft.getDes(pr[1]));
                    }
                    break;
                }

                case "is": {
                    if (pr[2].contentEquals("parent")) {
                        ft.isParent(pr[1], pr[3]);
                    } else if (pr[2].contentEquals("child")) {
                        ft.isChild(pr[1], pr[3]);
                    } else if (pr[2].contentEquals("sister")) {
                        ft.isSister(pr[1], pr[3]);
                    } else if (pr[2].contentEquals("aunt")) {
                        ft.isAunt(pr[1], pr[3]);
                    } else if (pr[2].contentEquals("ancestor")) {
                        ft.isAnc(pr[1], pr[3]);
                    } else if (pr[2].contentEquals("descendant")) {
                        ft.isDes(pr[1], pr[3]);
                    }
                    break;
                }

                case "count": {
                    if (pr[2].contentEquals("child")) {
                        ft.getChildrenCount(pr[1]);
                    } else if (pr[2].contentEquals("sister")) {
                        System.out.println(ft.getSibs(pr[1]).size());
                    } else if (pr[2].contentEquals("aunt")) {
                        System.out.println(ft.getAunts(pr[1]).size());
                    } else if (pr[2].contentEquals("ancestor")) {
                        System.out.println(ft.getAncestor(pr[1]).size());
                    } else if (pr[2].contentEquals("descendant")) {
                        System.out.println(ft.getDes(pr[1]).size());
                    }
                    break;
                }

                case "exit": {
                    stop = true;
                    break;
                }

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
