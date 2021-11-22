
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Address;
import com.vti.entity.Group;
import com.vti.entity.User;
import com.vti.repository.AccountRepository;
import com.vti.repository.UserRepository;

public class TestManyToMany {
    public static void main(String[] args) {
        AccountRepository accountRepository = new AccountRepository();

        System.out.println("***********GET ALL USERS***********");

        List<Account> accounts = accountRepository.getAllAccounts();

        for (Account account : accounts) {
            System.out.println("Account: " + account.getUsername());
            for (Group group : account.getGroupList()) {
                System.out.println("Group: " + group.getId() + ": " + group.getGroup());
            }
            System.out.println("");
        }
    }
}







