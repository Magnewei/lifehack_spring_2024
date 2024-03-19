package app.controllers;

import app.persistence.ConnectionPool;
import app.persistence.HaikuMapper;
import io.javalin.Javalin;
import io.javalin.http.Context;

public class HaikuController
{
    public static void addRoutes(Javalin app, ConnectionPool connectionPool)
    {
        app.get("/haiku", ctx -> index(ctx, connectionPool));
        app.post("/generatefirstlinenormal", ctx -> generateFirstLineNormal(ctx, connectionPool));
        app.post("/generatesecondlinenormal", ctx -> generateSecondLineNormal(ctx, connectionPool));
        app.post("/generatethirdlinenormal", ctx -> generateThirdLineNormal(ctx, connectionPool));
        app.post("/generatefirstlinebykevin", ctx -> generateFirstLineByKevin(ctx, connectionPool));
        app.post("/generatesecondlinebykevin", ctx -> generateSecondLineByKevin(ctx, connectionPool));
        app.post("/generatethirdlinebykevin", ctx -> generateThirdLineByKevin(ctx, connectionPool));
        app.post("/generatefirstlineaboutkevin", ctx -> generateFirstLineAboutKevin(ctx, connectionPool));
        app.post("/generatesecondlineaboutkevin", ctx -> generateSecondLineAboutKevin(ctx, connectionPool));
        app.post("/generatethirdlineaboutkevin", ctx -> generateThirdLineAboutKevin(ctx, connectionPool));
    }

    private static void index(Context ctx, ConnectionPool connectionPool)
    {
        ctx.render("/haiku/index.html");
    }

    private static void generateFirstLineNormal(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = true; // Assuming this is correct for the first line of a haiku
        boolean madeByKevin = false; // Assuming this is correct for the first line of a haiku
        boolean aboutKevin = false; // Assuming this is correct for the first line of a haiku

        try {
            String firstLine = "Generated first line"; //TODO: Erstat med string fra database.
            ctx.attribute("firstline", firstLine);
            ctx.render("/haiku/index.html");

        } catch (Exception e) {
            // Handle exceptions
            ctx.attribute("message", "Something went wrong. Please try again.");
            ctx.render("/haiku/index.html");
        }
    }

    private static void generateSecondLineNormal(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = false;
        boolean madeByKevin = false;
        boolean aboutKevin = false;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("secondline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateThirdLineNormal(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = true;
        boolean madeByKevin = false;
        boolean aboutKevin = false;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("thirdline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateFirstLineByKevin(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = true;
        boolean madeByKevin = true;
        boolean aboutKevin = false;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("firstline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateSecondLineByKevin(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = false;
        boolean madeByKevin = true;
        boolean aboutKevin = false;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("secondline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateThirdLineByKevin(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = true;
        boolean madeByKevin = true;
        boolean aboutKevin = false;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("thirdline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateFirstLineAboutKevin(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = true;
        boolean madeByKevin = false;
        boolean aboutKevin = true;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("firstline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateSecondLineAboutKevin(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = false;
        boolean madeByKevin = false;
        boolean aboutKevin = true;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("secondline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }

    private static void generateThirdLineAboutKevin(Context ctx, ConnectionPool connectionPool) {
        boolean isFiveSyllables = true;
        boolean madeByKevin = false;
        boolean aboutKevin = true;

        try{
            String haikuText = HaikuMapper.generateHaikuPart(connectionPool,isFiveSyllables,madeByKevin,aboutKevin);
            ctx.attribute("thirdline", haikuText);
            ctx.render("/haiku/index.html");

        } catch (AbstractMethodError e){
            ctx.attribute("message","Noget gik galt prøv igen");
            ctx.render("templates/haiku/index.html");
        }
    }
}