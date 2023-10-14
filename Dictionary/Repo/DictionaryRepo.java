package Repo;

import java.util.Scanner;

import DataAccess.DictionaryDao;

public class DictionaryRepo implements IDictionaryRepo{
    Scanner sc = new Scanner(System.in);

    @Override
    public void addWord() {
        try {
            System.out.println("Enter Eng Word: ");
            String en = sc.nextLine().trim();

            System.out.println("Enter VIE Word: ");
            String vie = sc.nextLine().trim();

            if (DictionaryDao.Instance().addNewWord(en, vie)) {
                System.out.println("ADD SUCCESSFUL!!");
            } else {
                System.out.println("Cant add");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeWord() {
       try {
        System.out.println("Enter Eng Word: ");
        String en = sc.nextLine().trim();

        if (DictionaryDao.Instance().removeWord(en)) {
            System.out.println("REMOVE SUCCESSFUL!!");
        } else {
            System.out.println("Cant remove");
        }
       } catch (Exception e) {
        System.out.println(e);
       }
    }

    @Override
    public void search() {
        try {
            System.out.println("Enter En Word: ");
            String en = sc.nextLine().trim();
            String value = DictionaryDao.Instance().translate(en);

            if (value != "") {
                System.out.println(value);
            } else {
                System.out.println("NOT FOUND");
            }
        } catch (Exception e) {
           System.out.println(e);
        }
    }
    
}
