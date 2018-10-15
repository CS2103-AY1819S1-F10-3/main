package seedu.address.model.account;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountList represents the entire list of accounts that were created
 * and stored in the local database. Currently, all username and password are
 * stored locally in a xml file without encryption.
 */
public class AccountList {
    private List<Account> accountList;

    public AccountList() {
        accountList = new ArrayList<>();
    }

    public List<Account> getList() {
        return accountList;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    public int indexOfAccount(Account account) {
        requireNonNull(account);
        return accountList.indexOf(account);
    }

    public boolean hasAccount(Account account) {
        requireNonNull(account);
        return indexOfAccount(account) != -1;
    }
}
