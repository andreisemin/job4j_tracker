package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя состоит из менее трех символов");
        }
                return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Андрей", true)
        };
        try {
            User user = findUser(users, "Андрей");
            if (validate(user)) {
                System.out.println("У этого пользователя есть доступ");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
  }

