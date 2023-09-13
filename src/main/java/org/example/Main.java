package org.example;


import org.example.utils.ConfigManager;
import org.example.utils.commands.MessageManager;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static long idObject;
    private final static String PATHRESOURCE = System.getProperty("user.dir") + "\\src\\main\\resources\\";

    private static DiscordApi api;
    private static ConfigManager configManager;
    
    public static void main(String[] args) {

        idObject = 1;

        configManager = new ConfigManager(new File(System.getProperty("user.dir"), "config.toml")); // recupere les config dans le fichier config

        api = new DiscordApiBuilder()
                .setToken(configManager.getToml().getString("bot.token")) // set le token enregistrer dans le fichier config
                .setAllIntents()
                .login()  // connecte le bot au token
                .join();  // lance le bot

        api.addMessageCreateListener(MessageManager::create);

        System.out.println("Pret a usage");

    }

    public static long getIdObject() {
        return idObject;
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

    public static DiscordApi getApi() {
        return api;
    }

    public static String getPATHRESOURCE() {
        return PATHRESOURCE;
    }
}