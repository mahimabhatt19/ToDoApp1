package com.example.todoapp1;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class FileHelper2 {

    public static final String FILENAME="listinfo2.dat";

    public static void writeData(ArrayList<String> items1 , Context context){
        try {
            FileOutputStream fos1 = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(items1);
            oos1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<String> readData(Context context){
        ArrayList<String> itemslist1 = null;
        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            itemslist1 = (ArrayList<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            itemslist1=new ArrayList<>();
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return itemslist1;
    }


}
