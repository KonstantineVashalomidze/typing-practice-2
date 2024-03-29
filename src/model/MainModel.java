package model;

import controller.Controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainModel
{
    private String[] words; // containing words from text file words.txt
    private int wordsCount; // is length of the lines in words.txt
    private Controller[] controllers; // all controllers on the main frame, is necessary for redirections



    public MainModel(Controller[] controllers)
    {
        this.controllers = controllers;
        wordsCount = 466_550; // file containing this many lines
        // load words from file into array
        loadWords();


    } // end of MainModel()



    private void loadWords()
    {
        words = new String[wordsCount];

        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/data/words.txt"));
            var wordIndex = 0;
            var word = bufferedReader.readLine();
            while (word != null)
            {
                words[wordIndex] = word;
                wordIndex++;
                word = bufferedReader.readLine();
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    } // end of loadWords()

    public Controller[] getControllers()
    {
        return controllers;
    }

    public Controller getControllerByClassName(String className)
    {
        for (Controller controller : controllers)
        {
            if (className.equals(controller.getClass().getSimpleName()))
            {
                return controller;
            }
        }
        return null;
    }

    public String easyRandomMode()
    // constructs random sentence using words with specified length
    {
        var randomSentence = new StringBuilder();
        var length = (int) (Math.random() * 5) + 12; // words will 12 +- 5
        for (int i = 0; i < length; i++)
        {
            if (i < length - 1)
            {
                randomSentence.append(words[(int) (Math.random() * (wordsCount - 1))].toLowerCase()).append(" ");
            }
            else
            {
                randomSentence.append(words[(int) (Math.random() * (wordsCount - 1))].toLowerCase());
            }
        }

        return randomSentence.toString();
    } // end of constructRandomSentenceEasy()

    public String normalRandomMode()
    {
        return null;
    }

    public String hardRandomMode()
    {
        return null;
    }

    public String easySentencesMode()
    {
        return null;
    }

    public String normalSentencesMode()
    {
        return null;
    }

    public String hardSentencesMode()
    {
        return null;
    }

    public String easyInstantDeathMode()
    {
        return null;
    }

    public String normalInstantDeathMode()
    {
        return null;
    }

    public String hardInstantDeathMode()
    {
        return null;
    }



}
