package blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HierarchicalTree {

    private Employee root;
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public static void main(String[] args) {
        String[] lines = {
                "1 Rob Choi 6",
                "2 Paul Marmolejo 5",
                "3 Lois Lemer 6",
                "4 Christie Jacobs 5",
                "5 Moises Medina 6",
                "6 Joseph Grant",
                "7 Andy Zuckeman 1",
                "8 Melaney Partner 3",
                "9 Cliff Gannett 5",
                "10 Mark O'Donnell 1"
        };

        HierarchicalTree tree = new HierarchicalTree();
        tree.readDataAndCreateMap(lines);
        tree.buildHierarchy(tree.root);
        tree.printHierarchy(tree.root, 0);
    }

    public void readDataAndCreateMap(String[] lines) {
        for (String line : lines) {
            String[] empData = line.split(" ");
            Employee emp;
            if (empData.length == 4)
                emp = new Employee(empData[0], empData[1] + " " + empData[2], empData[3]);
            else {
                emp = new Employee(empData[0], empData[1] + " " + empData[2], "0");
                this.root = emp;
            }
            employeeMap.put(emp.id, emp);
        }
    }

    public List<Employee> getSubs(int managerId) {
        List<Employee> subs =  new ArrayList();
        for (Employee emp : employeeMap.values()) {
            if (emp.managerId == managerId)
                subs.add(emp);
        }
        return subs;
    }

    public void buildHierarchy(Employee root) {
        List<Employee> subs = getSubs(root.id);
        root.subs = subs;
        if (subs.size() == 0)
            return;
        for (Employee emp : subs) {
            buildHierarchy(emp);
        }
    }

    public void printHierarchy(Employee root, int level) {
        for (int i=0; i<level; i++) {
            System.out.print("\t");
        }
        System.out.println(root.name);
        for (Employee emp : root.subs) {
            printHierarchy(emp, level + 1);
        }
    }
}

class Employee {
    int id;
    String name;
    int managerId;
    List<Employee> subs;

    public Employee(String id, String name, String managerId) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.managerId = Integer.parseInt(managerId);
    }
}
