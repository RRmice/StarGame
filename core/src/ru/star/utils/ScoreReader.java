package ru.star.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreReader {

    private Integer[] score = new Integer[3];

    public ScoreReader(){
        try {

            File file = new File("settings/score.txt");
            FileReader reader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(reader);

            String line = bufReader.readLine();

            for(int i = 0; i < score.length; i++){
                score[i] = Integer.parseInt(line);

                line = bufReader.readLine();
            }

            bufReader.close();

        } catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public StringBuffer[] getArrayScore(){

        StringBuffer[] scoreToReturn = new StringBuffer[3];

       for (int i = 0; i < score.length; i++){

            scoreToReturn[i] = new StringBuffer(score[i].toString());

            while (scoreToReturn[i].length() < 5){
                scoreToReturn[i].insert(0, "0");
            }
       }

        return scoreToReturn;
    }

    public boolean inNewTop(Integer newTop){

        boolean result = false;

         for (int i = 0; i < score.length; i++){

            if(score[i] < newTop){
                result = true;

                int buf = score[i];

                score[i] = newTop;
                this.inNewTop(buf);

                return result;
            }

        }

        return result;
    }

    public void WriteRecord(){

        try {
            File file = new File("settings/score.txt");
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (Integer top: score){
                bufferedWriter.write(top + "\n");
            }

            bufferedWriter.close();

        } catch (FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


