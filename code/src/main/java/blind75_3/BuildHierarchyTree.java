package blind75_3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuildHierarchyTree {

    List<Employee> empList = new ArrayList();

    Employee CEO;

    String[] lines;

    Map<String, Employee> map = new HashMap<>();

    public static void main(String[] args) {
        String[] lines = {
                "1 Sunil Kumar 4",
                "2 Prash Nayak 1",
                "3 Joshua Fluke 4",
                "4 Tim Robbins ",
                "5 Pam Brolin 2"
        };
        BuildHierarchyTree buildHierarchyTree = new BuildHierarchyTree();
        buildHierarchyTree.lines = lines;
        buildHierarchyTree.buildEmpList();
        buildHierarchyTree.buildHierarchyTree();
    }

    private void buildEmpList() {
       for (String str : lines) {
            Employee emp = new Employee();
            String[] arr = str.split(" ");
            emp.setEmpId(arr[0]);
            emp.setName(arr[1] + " " + arr[2]);
            if (arr.length == 3) {
                CEO = emp;
            } else
                emp.setManagerId(arr[3]);
            empList.add(emp);
            map.put(emp.getEmpId(), emp);
       }
    }

    private void printTree(Employee emp, int level) {
       for (int i=0; i<level; i++) {
           System.out.print("    ");
       }
        System.out.println(emp.getName());
       for (Employee employee : emp.getSubordinates()) {
           printTree(employee, level + 1);
       }
    }

    private void buildHierarchyTree() {
        for (Employee emp : empList) {
           if (emp.getManagerId() != null) {
               map.get(emp.getManagerId()).getSubordinates().add(emp);
           }
        }
        printTree(CEO, 0);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private String empId;
    private String name;
    private String managerId;
    private List<Employee> subordinates = new ArrayList();
}
