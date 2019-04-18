package com.example.usuario.MagicQuiz;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

public class Repository {

    static Repository repository;

    //Keyboard codes
    public static final int Code0 = 0;
    public static final int Code1 = 1;
    public static final int Code2 = 2;
    public static final int Code3 = 3;
    public static final int Code4 = 4;
    public static final int Code5 = 5;
    public static final int Code6 = 6;
    public static final int Code7 = 7;
    public static final int Code8 = 8;
    public static final int Code9 = 9;
    public static final int CodeSign = -1;
    public static final int CodeDelete = -5;
    public static final int CodeCancel = -100;
    public static final int CodeOk = 100;

    //Oracle
    public static HashMap<String, Card> cards;
    public static ArrayList<Set> sets;
    public static HashMap<String, String> setsMap;

    //Documents
    public static Tree<TypedText> ComprehensiveRules;
    public static Tree<TypedText> JudgingAtRegular;
    public static Tree<TypedText> AnnotatedInfractionProcedureGuide;
    public static Tree<TypedText> AnnotatedMagicTournamentRules;
    public static Tree<TypedText> DisqualificationProcess;
    public static Tree<TypedText> BannedAndRestricted;

    //Others
    public static Tree<Quiz> IPGTree;
    public static ArrayList<Quiz> Quiz;

    //Load everything
    public static void createRepository(Context context) {
        repository = new Repository();
        cards = Read.loadCardDatabase(context);
        sets = Read.loadSets(context);
        setsMap = Set.toHashMap(sets);
        ComprehensiveRules = Read.readXMLDocument(context.getResources().getXml(R.xml.cr));
        JudgingAtRegular = Read.readXMLDocument(context.getResources().getXml(R.xml.jar));
        AnnotatedInfractionProcedureGuide = Read.readXMLDocument(context.getResources().getXml(R.xml.aipg));
        AnnotatedMagicTournamentRules = Read.readXMLDocument(context.getResources().getXml(R.xml.amtr));
        DisqualificationProcess = Read.readXMLDocument(context.getResources().getXml(R.xml.dq));
        BannedAndRestricted = Read.readXMLDocument(context.getResources().getXml(R.xml.banned));
        IPGTree = Read.readXMLTree(context.getResources().getXml(R.xml.ipg_tree));
        Quiz = Read.readXMLQuiz(context.getResources().getXml(R.xml.quiz));
    }

    //To get all loaded information
    public static Repository getInstance() {
        return repository;
    }
}