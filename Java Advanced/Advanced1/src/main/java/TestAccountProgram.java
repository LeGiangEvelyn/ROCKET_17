

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class TestAccountProgram {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();

//        System.out.println("***********GET ALL ACCOUNTS***********");
//
//        List<Account> accounts = repository.getAllAccounts();
//
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
//
//        System.out.println("\n\n***********GET Account BY ID***********");
//
//        Account accountById = repository.getAccountByID((short) 2);
//        System.out.println(accountById);
//
//        System.out.println("\n\n***********GET Account BY NAME***********");
//
//        Account accountByName = repository.getAccountByName("Giang");
//        System.out.println(accountByName);
//
//        System.out.println("\n\n***********CREATE Account***********");
//
//        Account accountCreate = new Account();
//        accountCreate.setEmail("zoro@gmail.com");
//        accountCreate.setUsername("zorororonoa");
//        accountCreate.setFirstName("Zoro");
//        accountCreate.setLastName("Roronoa");
//        repository.createAccount(accountCreate);

        System.out.println("\n\n***********UPDATE Account 2***********");

        repository.updateAccount((short) 2, "giang@gmail.com", "giangle", "Giang", "Le");

//        System.out.println("\n\n***********DELETE AccountS***********");
//        repository.deleteAccount((short) 2);

//        System.out.println("***********CHECK Account EXISTS BY ID***********");
//        System.out.println(repository.isAccountExistsByID((short) 1));
//
//        System.out.println("***********CHECK Account EXISTS BY NAME***********");
//        System.out.println(repository.isAccountExistsByName("Luffy"));

    }
}
