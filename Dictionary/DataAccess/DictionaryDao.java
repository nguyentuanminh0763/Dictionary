package DataAccess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Common.Input;

public class DictionaryDao {
    Scanner sc = new Scanner(System.in);
    Input input = new Input();
    HashMap<String, String> dictionaryAV = new HashMap<>();

    private static DictionaryDao instance = null;

    public static DictionaryDao Instance() {
        if (instance == null) {
            synchronized (DictionaryDao.class) {
                if (instance == null) {
                    instance = new DictionaryDao();
                }
            }
        }
        return instance;
    }

    public void readTxt() {
        dictionaryAV.clear();
        try {
            FileReader fr = new FileReader("Data\\dictionary.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                String eng = line.split("-")[0];
                String vn = line.split("-")[1];
                dictionaryAV.put(eng, vn);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeTxt() {
        try {
            FileWriter fw = new FileWriter("Data\\dictionary.txt");
            String dataToTxt = "";

            for (Map.Entry<String, String> entry : dictionaryAV.entrySet()) {
                dataToTxt = dataToTxt + entry.getKey() + "-" + entry.getValue() + "\n";
            }
            fw.write(dataToTxt);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isKeyExist(HashMap<String, String> dictionaryAV, String enWord) {
        readTxt();
        return dictionaryAV.containsKey(enWord);
    }

    public boolean addNewWord(String enWord, String vnWord) throws Exception {
        readTxt();
        if (isKeyExist(dictionaryAV, enWord)) {
            throw new Exception("This word exist.");
        }
        if (isKeyExist(dictionaryAV, enWord)) {
            return false;
        }
        dictionaryAV.put(enWord, vnWord);
        writeTxt();
        return true;
    }

    public boolean removeWord(String enWord) throws Exception {
        readTxt();
        if (!isKeyExist(dictionaryAV, enWord)) {
            throw new Exception("This word does not exist");
        }
        if (!isKeyExist(dictionaryAV, enWord)) {
            return false;
        }

        dictionaryAV.remove(enWord);
        writeTxt();
        return true;
    }

    public String translate(String enWord) throws Exception {
        readTxt();
        if(dictionaryAV.isEmpty()){
            throw new Exception("Empty");
        }

        if (!isKeyExist(dictionaryAV, enWord)) {
            throw new Exception("This word exist.");
        }
        if (!isKeyExist(dictionaryAV, enWord) || dictionaryAV.isEmpty()) {
            return "";
        }

        String vnWord = dictionaryAV.get(enWord);
        return vnWord;
    }

}
