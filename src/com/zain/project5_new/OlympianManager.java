package com.zain.project5_new;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//this class used to load olympians from file and store them in an array of type Olympian
public class OlympianManager {
    String path= "C:\\\\Users\\\\Zain\\\\IdeaProjects\\\\cmpt_project3\\\\src\\\\com\\\\cmpt220\\\\project3\\\\olympians.lgoo";
    ArrayList<Olympian> olympian = new ArrayList<Olympian>();
    public OlympianManager() throws IOException {

        FileReader fr = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fr);


        if (!textReader.readLine().equals("LGOO")){
            System.out.println("Error, this file is corrupt!");
        }
        String line;

        while((line=textReader.readLine())!=null)
        {


            //"name,M,18"
            String[] splittedData = line.split(",");
            //determine sex of each line
            Sex sextemp;
            if (splittedData[1].equals("M")) {
                sextemp = Sex.MALE;

            }
            else {
                sextemp = Sex.FEMALE;
            }
            // format string data into olympian data


            Olympian splittedOlymps= new Olympian(splittedData[0],sextemp,Integer.parseInt(splittedData[2]));
            olympian.add(splittedOlymps);
        }

        textReader.close();
    }



    Olympian[] getOlympians()
    {
        Olympian[] array=new Olympian[olympian.size()];
        for(int i=0;i<olympian.size();i++)
            array[i]=olympian.get(i);
        return array;

    }
}

