package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Класс описывает работу банковского сервиса:
 * - добавление пользователя
 * - удаление пользователя
 * - добавление банковского счета пользователю
 * - перевод средств с одного счета на другой
 * @author Andrei Semin
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение информации о пользователях и их счетах осуществляется
     * в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового пользователя в систему,
     * если пользователь уже существует, не выполняет никаких действий
     * @param user объект класса User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по его паспортным данным,
     * если пользователя не существует, не выполняет никаких действий
     * @param passport номер паспорта пользователя
     */
    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счет пользователю,
     * если счет уже существует у пользователя, не выполняет никаких действий
     * @param passport номер паспорта пользователя
     * @param account объект класса Account
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Выполняет поиск пользователя по паспортным данным,
     * возвращает @param user объекта User, если пользователь найден,
     * иначе возвращает null
     * @param passport номер паспорта пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Выполняет поиск счета пользователя по его паспортным данным и реквизитам,
     * возвращает @param account объект класса Account, если счет найден,
     * иначе возвращает null
     * @param passport номер паспорта пользователя
     * @param requisite номер счета пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Выполняет перевод денежных средств с одного счета на другой,
     * возвращает true, если перевод выполнен успешно,
     * иначе, если счет не найден или не достаточно средств на счете отправителя,
     * возвращает false
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount сумма перевода
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Возвращает список счетов пользователя,
     * если пользователя нет в системе, возвращает пустой список
     * @param user объект класса User
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
