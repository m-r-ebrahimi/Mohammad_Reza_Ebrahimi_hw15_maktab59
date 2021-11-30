package q2.front;

import q2.entity.Account;
import q2.entity.Branch;
import q2.entity.Employee;
import q2.service.BranchService;
import q2.service.EmployeeService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int selected = 1;
        System.out.println("Bank System :)\n**********************************\n");
        while (selected != 4) {
            System.out.println("""
                    1) Branch management
                    2) Employee management
                    3) Customers service
                    4) EXIT
                    """);
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                branchMenu();
            }
            if (selected == 2) {
                employeeMenu();
            }
            if (selected == 3) {
                customerMenu();
            }
            if (selected < 1 || selected > 4) {
                System.out.println("Try again");
            }
        }
        System.out.println("Have a good time :)");
    }

    private static void customerMenu() {
        int selected = 1;
        while (selected != 10) {
            System.out.println("""
                    1) add new customer
                    2) update customer
                    3) load customer
                    4) delete customer
                    5) open an account
                    6) update an account
                    7) load an account
                    8) delete an account
                    9) start transaction
                    10) back
                    """);
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                addCustomer();
            } else if (selected == 2) {
                updateCustomer();
            } else if (selected == 3) {
                loadCustomer();
            } else if (selected == 4) {
                deleteCustomer();
            } else if (selected == 5) {
                addAccount();
            } else if (selected == 6) {
                updateAccount();
            } else if (selected == 7) {
                loadAccount();
            } else if (selected == 8) {
                deleteAccount();
            } else if (selected == 9) {
                addTransaction();
            } else if (selected < 1 || selected > 10) {
                System.out.println("Try again");
            }
        }
        System.out.println("**********************************");
    }

    private static void employeeMenu() {
        int selected = 1;
        while (selected != 5) {
            System.out.println("""
                    1) add new employee
                    2) update employee
                    3) load employee
                    4) delete employee
                    5) back
                    """);
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                addEmployee();
            } else if (selected == 2) {
                updateEmployee();
            } else if (selected == 3) {
                loadEmployee();
            } else if (selected == 4) {
                deleteEmployee();
            } else if (selected < 1 || selected > 5) {
                System.out.println("Try again");
            }
        }
        System.out.println("**********************************");
    }

    private static void deleteEmployee() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        new EmployeeService().delete(id);
    }

    private static void loadEmployee() {
        int selected = 0;
        while (selected != 3) {
            System.out.println("""
                    1) load by id
                    2) load all
                    3) back""");
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                loadEmployeeByid();
            } else if (selected == 2) {
                loadEmployeeAll();
            } else if (selected < 1 || selected > 3) {
                System.out.println("try again");
            }
            System.out.println("**********************************");
        }
    }

    private static void loadEmployeeAll() {
        System.out.println(new EmployeeService().loadAll());
    }

    private static void loadEmployeeByid() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(new EmployeeService().loadById(id));
    }

    private static void updateEmployee() {
        Employee employee = new Employee();
        System.out.println("enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter new name");
        String name = scanner.nextLine();
        System.out.println("enter new branch id");
        int branchId = scanner.nextInt();
        scanner.nextLine();
        employee.setId(id);
        employee.setName(name);
        employee.setBranch(new BranchService().loadById(branchId));
        new EmployeeService().saveOrUpdate(employee);
    }

    private static void addEmployee() {
        Employee employee = new Employee();
        System.out.println("enetr name");
        String name = scanner.nextLine();
        System.out.println("enter branch id");
        int branchId = scanner.nextInt();
        scanner.nextLine();
        employee.setName(name);
        employee.setBranch(new BranchService().loadById(branchId));
        new EmployeeService().saveOrUpdate(employee);
    }

    private static void branchMenu() {
        int selected = 1;
        while (selected != 5) {
            System.out.println("""
                    1) add new branch
                    2) update branch
                    3) load branch
                    4) delete branch
                    5) back
                    """);
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                addBranch();
            } else if (selected == 2) {
                updateBranch();
            } else if (selected == 3) {
                loadBranch();
            } else if (selected == 4) {
                deleteBranch();
            } else if (selected < 1 || selected > 5) {
                System.out.println("Try again");
            }
        }
        System.out.println("**********************************");
    }

    private static void deleteBranch() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        new BranchService().delete(id);
    }

    private static void loadBranch() {
        int selected = 0;
        while (selected != 3) {
            System.out.println("""
                    1) load by id
                    2) load all
                    3) back""");
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                loadBranchByid();
            } else if (selected == 2) {
                loadBranchAll();
            } else if (selected < 1 || selected > 3) {
                System.out.println("try again");
            }
            System.out.println("**********************************");
        }
    }

    private static void loadBranchAll() {
        System.out.println(new BranchService().loadAll());
    }

    private static void loadBranchByid() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(new BranchService().loadById(id));
    }

    private static void updateBranch() {
        Branch branch = new Branch();
        System.out.println("Enter branch id:");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter branch code:");
        Integer code = scanner.nextInt();
        scanner.nextLine();
        branch.setId(id);
        branch.setCode(code);
        new BranchService().saveOrUpdate(branch);
    }

    private static void addBranch() {
        Branch branch = new Branch();
        System.out.println("Enter branch code:");
        Integer code = scanner.nextInt();
        scanner.nextLine();
        branch.setCode(code);
        branch.setAccounts(new ArrayList<Account>());
        branch.setEmployees(new ArrayList<Employee>());
        new BranchService().saveOrUpdate(branch);
    }
}
