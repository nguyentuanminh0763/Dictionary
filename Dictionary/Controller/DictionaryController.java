package Controller;

import Common.Input;
import Repo.DictionaryRepo;
import View.Menu;

public class DictionaryController extends Menu<String> {
    DictionaryRepo dictionaryRepo = new DictionaryRepo();
    Input input = new Input();

    static String[] mc = { "Add Word ", "Remove Word", "Search Word", "Exit" };

    public DictionaryController() {
        super("-----------------DICTIONARY-----------------", mc);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                dictionaryRepo.addWord();
                break;
            }
            case 2: {
                dictionaryRepo.removeWord();
                break;
            }
            case 3: {
                dictionaryRepo.search();
                break;
            }
            case 4: {
                System.exit(0);
            }
        }
    }

}
