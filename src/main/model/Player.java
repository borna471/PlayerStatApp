package model;

import org.json.JSONObject;
import persistence.Writable;

// each individual Player, objects that will be added to compare and player lists
public class Player implements Writable {

    private String name;
    private String cat;
    private String post;
    private Integer gs;
    private Integer ast;
    private Integer mts;
    private Integer npgs;
    private Integer totalShts;
    private Integer shtsOnTrgt;
    private Integer tchsInBox;
    private Integer kypases;
    private Integer drbls;
    private Double gsPer90;
    private Double gsAndAstPer90;
    private Double npgsAndAstPer90;
    private Double drblsPer90;


    // EFFECTS: instantiates a player object
    public Player(String playerName,
                  String category,
                  String position,
                  Integer goals,
                  Integer assists,
                  Integer matches,
                  Integer nonPenaltyGoals,
                  Integer totalShots,
                  Integer shotsOnTarget,
                  Integer touchesInBox,
                  Integer keyPasses,
                  Integer dribbles,
                  Double goalsPer90,
                  Double goalsAndAssistsPer90,
                  Double nonPenaltyGoalsAndAssistsPer90,
                  Double dribblesPer90) {

        name = playerName;
        cat = category;
        post = position;
        mts = matches;
        gs = goals;
        ast = assists;
        npgs = nonPenaltyGoals;
        totalShts = totalShots;
        shtsOnTrgt = shotsOnTarget;
        tchsInBox = touchesInBox;
        kypases = keyPasses;
        drbls = dribbles;
        gsPer90 = goalsPer90;
        gsAndAstPer90 = goalsAndAssistsPer90;
        npgsAndAstPer90 = nonPenaltyGoalsAndAssistsPer90;
        drblsPer90 = dribblesPer90;

    }


    // modeled after JsonSerializationDemo.model.Thingy (as provided for this project)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", cat);
        json.put("position", post);
        json.put("goals", gs);
        json.put("assists", ast);
        json.put("matches", mts);
        return json;
    }

    public String getName() {
        return name;
    }

    // public void setName(String name) {
    //     this.name = name;
    //  }

    public String getCat() {
        return cat;
    }

    // public void setCat(String cat) {
    //     this.cat = cat;
    //  }

    public String getPost() {
        return post;
    }

//    public void setPost(String post) {
//        this.post = post;
//    }

    public Integer getGs() {
        return gs;
    }

//    public void setGs(Integer gs) {
//        this.gs = gs;
//    }

    public Integer getAst() {
        return ast;
    }

//    public void setAst(Integer ast) {
//        this.ast = ast;
//    }

    public Integer getMts() {
        return mts;
    }



//    public void setMts(Integer mts) {
//        this.mts = mts;
//    }
//
//    public Integer getNpgs() {
//        return npgs;
//    }
//
//    public void setNpgs(Integer npgs) {
//        this.npgs = npgs;
//    }
//
//    public Integer getTotalShts() {
//        return totalShts;
//    }
//
//    public void setTotalShts(Integer totalShts) {
//        this.totalShts = totalShts;
//    }
//
//    public Integer getShtsOnTrgt() {
//        return shtsOnTrgt;
//    }
//
//    public void setShtsOnTrgt(Integer shtsOnTrgt) {
//        this.shtsOnTrgt = shtsOnTrgt;
//    }
//
//    public Integer getTchsInBox() {
//        return tchsInBox;
//    }
//
//    public void setTchsInBox(Integer tchsInBox) {
//        this.tchsInBox = tchsInBox;
//    }
//
//    public Double getGsPer90() {
//        return gsPer90;
//    }
//
//    public void setGsPer90(Double gsPer90) {
//        this.gsPer90 = gsPer90;
//    }
//
//    public Double getGsAndAstPer90() {
//        return gsAndAstPer90;
//    }
//
//    public void setGsAndAstPer90(Double gsAndAstPer90) {
//        this.gsAndAstPer90 = gsAndAstPer90;
//    }
//
//    public Double getNpgsAndAstPer90() {
//        return npgsAndAstPer90;
//    }
//
//    public void setNpgsAndAstPer90(Double npgsAndAstPer90) {
//        this.npgsAndAstPer90 = npgsAndAstPer90;
//    }
//
//    public Double getDrblsPer90() {
//        return drblsPer90;
//    }
//
//    public void setDrblsPer90(Double drblsPer90) {
//        this.drblsPer90 = drblsPer90;
//    }
//
//    public Integer getDrbls() {
//        return drbls;
//    }
//
//    public void setDrbls(Integer drbls) {
//        this.drbls = drbls;
//    }
//
//    public Integer getKypases() {
//        return kypases;
//    }
//
//    public void setKypases(Integer kypases) {
//        this.kypases = kypases;
//    }
}
