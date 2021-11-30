package q2.front;

import q2.entity.*;
import q2.service.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
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
        while (selected != 9) {
            System.out.println("""
                    1) add new customer
                    2) update customer
                    3) load customer
                    4) delete customer
                    5) open an account
                    6) update an account
                    7) load an account
                    8) delete an account
                    9) back
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
            } else if (selected < 1 || selected > 9) {
                System.out.println("Try again");
            }
        }
        System.out.println("**********************************");
    }

    private static void updateAccount() {
        int selected = 0;
        while (selected != 4) {
            System.out.println("""
                    1) update account
                    2) update card
                    3) start transaction
                    4) back
                    """);
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                updateAccountById();
            } else if (selected == 2) {
                updateCardOfAccount();
            } else if (selected == 3) {
                startTransaction();
            } else if (selected < 1 || selected > 4) {
                System.out.println("try again");
            }
            System.out.println("**************************************");
        }
    }

    private static void startTransaction() {
        int selected = 0;
        while (selected != 4) {
            System.out.println("""
                    1) add balance to account
                    2) withdraw from bank account
                    3) Money transfer
                    4) back
                    """);
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                addBalanceToAccount();
            } else if (selected == 2) {
                withdrawFromBankAccount();
            } else if (selected == 3) {
                moneyTransfer();
            } else if (selected < 1 || selected > 4) {
                System.out.println("try again");
            }
        }
        System.out.println("*******************************");
    }

    private static void moneyTransfer() {
        Transaction transaction = new Transaction();
        Account accountOrigin = new Account();
        Account accountDest = new Account();

        System.out.println("enter origin card number");
        String originCardNumber = scanner.nextLine();
        System.out.println("enter card second password");
        String password = scanner.nextLine();
        System.out.println("enter destination card number");
        String destinationCardNumber = scanner.nextLine();
        System.out.println("enter money");
        int money = scanner.nextInt();
        scanner.nextLine();
        List<Card> cards = new CardService().loadAll();
        for (Card card : cards) {
            if (card.getCardNumber().equals(destinationCardNumber)) {
                accountDest = card.getAccount();
            }
        }
        for (Card card : cards) {
            if (card.getCardNumber().equals(originCardNumber)) {
                if (card.getSecondPassword().equals(password)) {
                    accountOrigin = card.getAccount();
                }
            }
        }
        transaction.setTime(LocalTime.now());
        transaction.setAmount(money);
        transaction.setOriginAccount(accountOrigin);
        transaction.setDestinationAccount(accountDest);
        new TransactionService().saveOrUpdate(transaction);

        Integer balance = accountOrigin.getBalance();
        balance-=money;
        accountOrigin.setBalance(balance);
        new AccountService().saveOrUpdate(accountOrigin);

        balance = accountDest.getBalance();
        balance+=money;
        accountDest.setBalance(balance);
        new AccountService().saveOrUpdate(accountDest);
    }

    private static void withdrawFromBankAccount() {
        System.out.println("enter card number");
        String cardNumber = scanner.nextLine();
        System.out.println("enter card first password");
        String password = scanner.nextLine();
        System.out.println("enter money");
        int money = scanner.nextInt();
        scanner.nextLine();
        List<Card> cards = new CardService().loadAll();
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                if (card.getFirstPassword().equals(password)) {
                    Account account = card.getAccount();
                    Integer balance = account.getBalance();
                    balance -= money;
                    account.setBalance(balance);
                    new AccountService().saveOrUpdate(account);
                } else {
                    System.out.println("you entered wrong password");
                }
            }
        }
    }

    private static void addBalanceToAccount() {
        System.out.println("enter card number");
        String cardNumber = scanner.nextLine();
        System.out.println("enter money");
        int money = scanner.nextInt();
        scanner.nextLine();
        List<Card> cards = new CardService().loadAll();
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                Account account = card.getAccount();
                Integer balance = account.getBalance();
                balance += money;
                account.setBalance(balance);
                new AccountService().saveOrUpdate(account);
            }
        }
    }

    private static void updateCardOfAccount() {
        Card card = new Card();
        System.out.println("enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append((int) (Math.random() * 10));
        }
        StringBuilder cardcvv2 = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            cardcvv2.append((int) (Math.random() * 10));
        }
        String expiration = new Date().getYear() + 1904 + "/" + new Date().getMonth() + "/" + new Date().getDate();
        System.out.println("enter new first password for card");
        String firstPassword = scanner.nextLine();
        System.out.println("enter new second password for card");
        String secondPassword = scanner.nextLine();
        System.out.println("enter new account id");
        int accountId = scanner.nextInt();
        scanner.nextLine();
        card.setId(id);
        card.setCardNumber(cardNumber.toString());
        card.setCvv2(Integer.parseInt(cardcvv2.toString()));
        card.setExpiration(expiration);
        card.setFirstPassword(firstPassword);
        card.setSecondPassword(secondPassword);
        card.setAccount(new AccountService().loadById(accountId));
        new CardService().saveOrUpdate(card);
    }

    private static void updateAccountById() {
        Account account = new Account();
        System.out.println("enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter new branch id");
        int branchId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter new customer id");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        account.setId(id);
        account.setBalance(new AccountService().loadById(id).getBalance());
        account.setBranch(new BranchService().loadById(branchId));
        account.setCustomer(new CustomerService().loadById(customerId));
        new AccountService().saveOrUpdate(account);
    }

    private static void deleteAccount() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();

        List<Card> cards = new CardService().loadAll();
        for (Card card : cards) {
            if (card.getAccount().getId() == id) {
                new CardService().delete(card.getId());
                break;
            }
        }
        new AccountService().delete(id);
    }

    private static void loadAccount() {
        int selected = 0;
        while (selected != 4) {
            System.out.println("""
                    1) load account by id
                    2) load all accounts
                    3) load card by account
                    4) back""");
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                loadAccountByid();
            } else if (selected == 2) {
                loadAccountAll();
            } else if (selected == 3) {
                loadCard();
            } else if (selected < 1 || selected > 4) {
                System.out.println("try again");
            }
            System.out.println("**********************************");
        }
    }

    private static void loadCard() {
        System.out.println("enter account id");
        int id = scanner.nextInt();
        scanner.nextLine();
        List<Card> cards = new CardService().loadAll();
        for (Card card : cards) {
            if (card.getAccount().getId() == id) {
                System.out.println(card);
                break;
            }
        }
    }

    private static void loadAccountAll() {
        System.out.println(new AccountService().loadAll());
    }

    private static void loadAccountByid() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(new AccountService().loadById(id));
    }

    private static void addAccount() {
        Account account = new Account();
        System.out.println("enter balance");
        int balance = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter branch id");
        int branchId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter customer id");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        account.setBalance(balance);
        account.setBranch(new BranchService().loadById(branchId));
        account.setCustomer(new CustomerService().loadById(customerId));
        new AccountService().saveOrUpdate(account);

        //**********************************************
        Card card = new Card();
        StringBuilder cardNumber = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            cardNumber.append((int) (Math.random() * 10));
        }

        StringBuilder cardcvv2 = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            cardcvv2.append((int) (Math.random() * 10));
        }
        String expiration = new Date().getYear() + 1904 + "/" + new Date().getMonth() + "/" + new Date().getDate();
        System.out.println("enter first password for card");
        String firstPassword = scanner.nextLine();
        System.out.println("enter second password for card");
        String secondPassword = scanner.nextLine();

        card.setCardNumber(cardNumber.toString());
        card.setCvv2(Integer.parseInt(cardcvv2.toString()));
        card.setExpiration(expiration);
        card.setFirstPassword(firstPassword);
        card.setSecondPassword(secondPassword);
        card.setAccount(new AccountService().loadById(account.getId()));
        new CardService().saveOrUpdate(card);
    }

    private static void deleteCustomer() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        new CustomerService().delete(id);
    }

    private static void loadCustomer() {
        int selected = 0;
        while (selected != 3) {
            System.out.println("""
                    1) load by id
                    2) load all
                    3) back""");
            selected = scanner.nextInt();
            scanner.nextLine();
            if (selected == 1) {
                loadCustomerByid();
            } else if (selected == 2) {
                loadCustomerAll();
            } else if (selected < 1 || selected > 3) {
                System.out.println("try again");
            }
            System.out.println("**********************************");
        }
    }

    private static void loadCustomerAll() {
        System.out.println(new CustomerService().loadAll());
    }

    private static void loadCustomerByid() {
        System.out.println("Enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(new CustomerService().loadById(id));
    }

    private static void updateCustomer() {
        Customer customer = new Customer();
        System.out.println("enter id");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter new name");
        String name = scanner.nextLine();
        System.out.println("enter new national id");
        String nationalId = scanner.nextLine();
        customer.setId(id);
        customer.setName(name);
        customer.setNationalId(nationalId);
        new CustomerService().saveOrUpdate(customer);
    }

    private static void addCustomer() {
        Customer customer = new Customer();
        System.out.println("enter name");
        String name = scanner.nextLine();
        System.out.println("enter national id");
        String nationalId = scanner.nextLine();
        customer.setName(name);
        customer.setNationalId(nationalId);
        new CustomerService().saveOrUpdate(customer);
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
        new BranchService().saveOrUpdate(branch);
    }
}
