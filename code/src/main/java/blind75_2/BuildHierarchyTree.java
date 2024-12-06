package blind75_2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class BuildHierarchyTree {

    private List<Employee> empList = new ArrayList<>();

    private Map<String, Employee> empMap = new HashMap<>();

    private Employee CEO;

    private void printHierarchy(Employee emp, int level) {
        for (int i=0; i<level; i++) {
            System.out.print("\t");
        }
        System.out.println(emp.getName());
        for (Employee employee : emp.getSubordinates()) {
            printHierarchy(employee, level + 1);
        }
    }

    private void buildHierarchy() {
        for (Employee emp : empList) {
            if (emp.getManagerId() != null) {
                List<Employee> subOrdinateList =  empMap.get(emp.getManagerId()).getSubordinates();
                subOrdinateList.add(emp);
            } else {
                CEO = emp;
            }
        }
    }

    private void buildEmpList(String[] lines) {
       for (String str : lines) {
            String[] arr = str.split(" ");
           System.out.println(Arrays.toString(arr));
            Employee emp = new Employee();
            emp.setEmpId(arr[0]);
            emp.setName(arr[1] + " " + arr[2]);
            if (arr.length == 3) {
                emp.setCEO(true);
            } else
            emp.setManagerId(arr[3]);
            empList.add(emp);
            empMap.put(arr[0], emp);
       }
    }

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
        BuildHierarchyTree buildHierarchyTree = new BuildHierarchyTree();
        buildHierarchyTree.buildEmpList(lines);
        buildHierarchyTree.buildHierarchy();
        System.out.println(buildHierarchyTree.empList);
        buildHierarchyTree.printHierarchy(buildHierarchyTree.CEO, 0);
    }
}


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Employee {
    private String name;
    private String empId;
    private String managerId;
    private List<Employee> subordinates = new ArrayList();
    private boolean isCEO;
}