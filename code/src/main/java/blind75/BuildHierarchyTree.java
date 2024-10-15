package blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildHierarchyTree {

//    private Map<Integer, Employee> employeeMap = new HashMap<>();
//    private Employee root;
//
//
//    public static void main(String[] args) {
//        String[] lines = {
//                "1 Rob Choi 6",
//                "2 Paul Marmolejo 5",
//                "3 Lois Lemer 6",
//                "4 Christie Jacobs 5",
//                "5 Moises Medina 6",
//                "6 Joseph Grant",
//                "7 Andy Zuckeman 1",
//                "8 Melaney Partner 3",
//                "9 Cliff Gannett 5",
//                "10 Mark O'Donnell 1"
//        };
//
//        BuildHierarchyTree tree = new BuildHierarchyTree();
//        tree.readDataAndCreateMap(lines);
//        tree.buildHierarchyTree(tree.root);
//        tree.printHierarchyTree(tree.root, 0);
//    }
//
//    public void readDataAndCreateMap(String[] lines) {
//        Employee employee = null;
//        for (String strLine : lines) {
//            String[] values = strLine.split(" ");
//            if (values.length == 4) {
//                employee = new Employee(values[0], values[1] + " " + values[2], values[3]);
//            } else {
//                employee = new Employee(values[0], values[1] + " " + values[2], "0");
//                root = employee;
//            }
//            employeeMap.put(employee.id, employee);
//        }
//    }
//
//    public void buildHierarchyTree(Employee root) {
//        Employee employee = root;
//        List<Employee> subs = getSubsById(employee.id);
//        employee.subordinates = subs;
//        if (subs.size() == 0)
//            return;
//        for (Employee emp : subs)
//            buildHierarchyTree(emp);
//    }
//
//    private List<Employee> getSubsById(int managerId) {
//        List<Employee> subs = new ArrayList();
//        for (Employee emp : employeeMap.values()) {
//            if (emp.managerId == managerId) {
//                subs.add(emp);
//            }
//        }
//        return subs;
//    }
//
//    public void printHierarchyTree(Employee root, int level) {
//        for (int i=0; i<level; i++) {
//            System.out.print("\t");
//        }
//        System.out.println(root.name);
//        for (Employee emp : root.subordinates)
//            printHierarchyTree(emp, level + 1);
//    }
//}
//
//class Employee {
//
//    protected int id;
//    protected int managerId;
//    protected String name;
//    protected List<Employee> subordinates;
//
//    public Employee(String id, String name, String managerId) {
//        this.id = Integer.parseInt(id);
//        this.name = name;
//        this.managerId = Integer.parseInt(managerId);
//    }
//
}
