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
     * Read from the lists of account and compare the provided account's username with an account stored in the
     * account list that has the same username. If a match is found, return the Role of the account as specified
     * in the account list.
     * @param username The account to get the privilege.
     * @return The role of the username specified in the account list file.
     * @throws IllegalArgumentException If the provided username is not found in the account list.
     */
    public Role getAccountRole(String username) throws IllegalArgumentException {
        for (Account account : accountList) {
            if (account.getUserName().equalsIgnoreCase(username)) {
                return account.getRole();
            }
        }
        throw new IllegalArgumentException("Account not found.");
    }

    /**
     * Update the user associated with the {@code currentAccount} to the given password.
     * @param currentAccount The user to update the password.
     * @param newPassword The password to update the account
     */
    public void updatePassword(Account currentAccount, String newPassword) {
        for (Account account : accountList) {
            if (account.equals(currentAccount)) {
                account.setPassword(newPassword);
            }
        }
    }

    /**
     * Returns the index of the first occurrence of the given account in this accountList,
     * or -1 if accountList does not contain the account.
     * @param account The account to be checked.
     * @return The index of the first occurrence of the account in the list, or -1 if
     * accountList does not contain the account.
     */
    public int indexOfAccount(Account account) {
        requireNonNull(account);
        return accountList.indexOf(account);
    }

    /**
     * Returns true if accountList contains the given account.
     * @param account The account to be checked.
     * @return true if the accountList contains the account, false otherwise.
     */
    public boolean hasAccount(Account account) {
        requireNonNull(account);
        return indexOfAccount(account) != -1;
    }

    /**
     * Check if the accountList contains the username.
     * @param username The username to be checked.
     * @return true if accountList contains the username, false otherwise.
     */
    public boolean hasUserName(String username) {
        requireNonNull(username);
        for (Account account : accountList) {
            if (account.getUserName().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AccountList // instanceof handles nulls
                && accountList.equals(((AccountList) other).accountList));
    }

    @Override
    public int hashCode() {
        return accountList.hashCode();
    }
}
