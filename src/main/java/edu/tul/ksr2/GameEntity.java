package edu.tul.ksr2;

public class GameEntity {
    public long gameId;
    public int gameDuraton;
    public boolean blueWins;
    public boolean blueFirstBlood;
    public boolean blueFirstTower;
    public boolean blueFirstBaron;
    public boolean blueFirstDragon;
    public boolean blueFirstInhibitor;
    public int blueDragonKills;
    public int blueBaronKills;
    public int blueTowerKills;
    public int blueInhibitorKills;
    public int blueWardPlaced;
    public int blueWardkills;
    public int blueKills;
    public int blueDeath;
    public int blueAssist;
    public int blueChampionDamageDealt;
    public int blueTotalGold;
    public int blueTotalMinionKills;
    public int blueTotalLevel;
    public double blueAvgLevel;
    public int blueJungleMinionKills;
    public int blueKillingSpree;
    public int blueTotalHeal;
    public int blueObjectDamageDealt;
    public boolean redWins;
    public boolean redFirstBlood;
    public boolean redFirstTower;
    public boolean redFirstBaron;
    public boolean redFirstDragon;
    public boolean redFirstInhibitor;
    public int redDragonKills;
    public int redBaronKills;
    public int redTowerKills;
    public int redInhibitorKills;
    public int redWardPlaced;
    public int redWardkills;
    public int redKills;
    public int redDeath;
    public int redAssist;
    public int redChampionDamageDealt;
    public int redTotalGold;
    public int redTotalMinionKills;
    public int redTotalLevel;
    public double redAvgLevel;
    public int redJungleMinionKills;
    public int redKillingSpree;
    public int redTotalHeal;
    public int redObjectDamageDealt;

    public GameEntity(long gameId, int gameDuraton, boolean blueWins, boolean blueFirstBlood, boolean blueFirstTower, boolean blueFirstBaron, boolean blueFirstDragon, boolean blueFirstInhibitor, int blueDragonKills, int blueBaronKills, int blueTowerKills, int blueInhibitorKills, int blueWardPlaced, int blueWardkills, int blueKills, int blueDeath, int blueAssist, int blueChampionDamageDealt, int blueTotalGold, int blueTotalMinionKills, int blueTotalLevel, double blueAvgLevel, int blueJungleMinionKills, int blueKillingSpree, int blueTotalHeal, int blueObjectDamageDealt, boolean redWins, boolean redFirstBlood, boolean redFirstTower, boolean redFirstBaron, boolean redFirstDragon, boolean redFirstInhibitor, int redDragonKills, int redBaronKills, int redTowerKills, int redInhibitorKills, int redWardPlaced, int redWardkills, int redKills, int redDeath, int redAssist, int redChampionDamageDealt, int redTotalGold, int redTotalMinionKills, int redTotalLevel, int redAvgLevel, int redJungleMinionKills, int redKillingSpree, int redTotalHeal, int redObjectDamageDealt) {
        this.gameId = gameId;
        this.gameDuraton = gameDuraton;
        this.blueWins = blueWins;
        this.blueFirstBlood = blueFirstBlood;
        this.blueFirstTower = blueFirstTower;
        this.blueFirstBaron = blueFirstBaron;
        this.blueFirstDragon = blueFirstDragon;
        this.blueFirstInhibitor = blueFirstInhibitor;
        this.blueDragonKills = blueDragonKills;
        this.blueBaronKills = blueBaronKills;
        this.blueTowerKills = blueTowerKills;
        this.blueInhibitorKills = blueInhibitorKills;
        this.blueWardPlaced = blueWardPlaced;
        this.blueWardkills = blueWardkills;
        this.blueKills = blueKills;
        this.blueDeath = blueDeath;
        this.blueAssist = blueAssist;
        this.blueChampionDamageDealt = blueChampionDamageDealt;
        this.blueTotalGold = blueTotalGold;
        this.blueTotalMinionKills = blueTotalMinionKills;
        this.blueTotalLevel = blueTotalLevel;
        this.blueAvgLevel = blueAvgLevel;
        this.blueJungleMinionKills = blueJungleMinionKills;
        this.blueKillingSpree = blueKillingSpree;
        this.blueTotalHeal = blueTotalHeal;
        this.blueObjectDamageDealt = blueObjectDamageDealt;
        this.redWins = redWins;
        this.redFirstBlood = redFirstBlood;
        this.redFirstTower = redFirstTower;
        this.redFirstBaron = redFirstBaron;
        this.redFirstDragon = redFirstDragon;
        this.redFirstInhibitor = redFirstInhibitor;
        this.redDragonKills = redDragonKills;
        this.redBaronKills = redBaronKills;
        this.redTowerKills = redTowerKills;
        this.redInhibitorKills = redInhibitorKills;
        this.redWardPlaced = redWardPlaced;
        this.redWardkills = redWardkills;
        this.redKills = redKills;
        this.redDeath = redDeath;
        this.redAssist = redAssist;
        this.redChampionDamageDealt = redChampionDamageDealt;
        this.redTotalGold = redTotalGold;
        this.redTotalMinionKills = redTotalMinionKills;
        this.redTotalLevel = redTotalLevel;
        this.redAvgLevel = redAvgLevel;
        this.redJungleMinionKills = redJungleMinionKills;
        this.redKillingSpree = redKillingSpree;
        this.redTotalHeal = redTotalHeal;
        this.redObjectDamageDealt = redObjectDamageDealt;
    }

    public GameEntity(String gameId, String gameDuraton, String blueWins, String blueFirstBlood, String blueFirstTower, String blueFirstBaron, String blueFirstDragon, String blueFirstInhibitor, String blueDragonKills, String blueBaronKills, String blueTowerKills, String blueInhibitorKills, String blueWardPlaced, String blueWardkills, String blueKills, String blueDeath, String blueAssist, String blueChampionDamageDealt, String blueTotalGold, String blueTotalMinionKills, String blueTotalLevel, String blueAvgLevel, String blueJungleMinionKills, String blueKillingSpree, String blueTotalHeal, String blueObjectDamageDealt, String redWins, String redFirstBlood, String redFirstTower, String redFirstBaron, String redFirstDragon, String redFirstInhibitor, String redDragonKills, String redBaronKills, String redTowerKills, String redInhibitorKills, String redWardPlaced, String redWardkills, String redKills, String redDeath, String redAssist, String redChampionDamageDealt, String redTotalGold, String redTotalMinionKills, String redTotalLevel, String redAvgLevel, String redJungleMinionKills, String redKillingSpree, String redTotalHeal, String redObjectDamageDealt) {
        this.gameId = Long.parseLong(gameId);
        this.gameDuraton = Integer.parseInt(gameDuraton);
        this.blueWins = Boolean.parseBoolean(blueWins);
        this.blueFirstBlood = Boolean.parseBoolean(blueFirstBlood);
        this.blueFirstTower = Boolean.parseBoolean(blueFirstTower);
        this.blueFirstBaron = Boolean.parseBoolean(blueFirstBaron);
        this.blueFirstDragon = Boolean.parseBoolean(blueFirstDragon);
        this.blueFirstInhibitor = Boolean.parseBoolean(blueFirstInhibitor);
        this.blueDragonKills = Integer.parseInt(blueDragonKills);
        this.blueBaronKills = Integer.parseInt(blueBaronKills);
        this.blueTowerKills = Integer.parseInt(blueTowerKills);
        this.blueInhibitorKills = Integer.parseInt(blueInhibitorKills);
        this.blueWardPlaced = Integer.parseInt(blueWardPlaced);
        this.blueWardkills = Integer.parseInt(blueWardkills);
        this.blueKills = Integer.parseInt(blueKills);
        this.blueDeath = Integer.parseInt(blueDeath);
        this.blueAssist = Integer.parseInt(blueAssist);
        this.blueChampionDamageDealt = Integer.parseInt(blueChampionDamageDealt);
        this.blueTotalGold = Integer.parseInt(blueTotalGold);
        this.blueTotalMinionKills = Integer.parseInt(blueTotalMinionKills);
        this.blueTotalLevel = Integer.parseInt(blueTotalLevel);
        this.blueAvgLevel = Double.parseDouble(blueAvgLevel);
        this.blueJungleMinionKills = Integer.parseInt(blueJungleMinionKills);
        this.blueKillingSpree = Integer.parseInt(blueKillingSpree);
        this.blueTotalHeal = Integer.parseInt(blueTotalHeal);
        this.blueObjectDamageDealt = Integer.parseInt(blueObjectDamageDealt);
        this.redWins = Boolean.parseBoolean(redWins);
        this.redFirstBlood = Boolean.parseBoolean(redFirstBlood);
        this.redFirstTower = Boolean.parseBoolean(redFirstTower);
        this.redFirstBaron = Boolean.parseBoolean(redFirstBaron);
        this.redFirstDragon = Boolean.parseBoolean(redFirstDragon);
        this.redFirstInhibitor = Boolean.parseBoolean(redFirstInhibitor);
        this.redDragonKills = Integer.parseInt(redDragonKills);
        this.redBaronKills = Integer.parseInt(redBaronKills);
        this.redTowerKills = Integer.parseInt(redTowerKills);
        this.redInhibitorKills = Integer.parseInt(redInhibitorKills);
        this.redWardPlaced = Integer.parseInt(redWardPlaced);
        this.redWardkills = Integer.parseInt(redWardkills);
        this.redKills = Integer.parseInt(redKills);
        this.redDeath = Integer.parseInt(redDeath);
        this.redAssist = Integer.parseInt(redAssist);
        this.redChampionDamageDealt = Integer.parseInt(redChampionDamageDealt);
        this.redTotalGold = Integer.parseInt(redTotalGold);
        this.redTotalMinionKills = Integer.parseInt(redTotalMinionKills);
        this.redTotalLevel = Integer.parseInt(redTotalLevel);
        this.redAvgLevel = Double.parseDouble(redAvgLevel);
        this.redJungleMinionKills = Integer.parseInt(redJungleMinionKills);
        this.redKillingSpree = Integer.parseInt(redKillingSpree);
        this.redTotalHeal = Integer.parseInt(redTotalHeal);
        this.redObjectDamageDealt = Integer.parseInt(redObjectDamageDealt);
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "gameId=" + gameId +
                ", gameDuraton=" + gameDuraton +
                ", blueWins=" + blueWins +
                ", blueFirstBlood=" + blueFirstBlood +
                ", blueFirstTower=" + blueFirstTower +
                ", blueFirstBaron=" + blueFirstBaron +
                ", blueFirstDragon=" + blueFirstDragon +
                ", blueFirstInhibitor=" + blueFirstInhibitor +
                ", blueDragonKills=" + blueDragonKills +
                ", blueBaronKills=" + blueBaronKills +
                ", blueTowerKills=" + blueTowerKills +
                ", blueInhibitorKills=" + blueInhibitorKills +
                ", blueWardPlaced=" + blueWardPlaced +
                ", blueWardkills=" + blueWardkills +
                ", blueKills=" + blueKills +
                ", blueDeath=" + blueDeath +
                ", blueAssist=" + blueAssist +
                ", blueChampionDamageDealt=" + blueChampionDamageDealt +
                ", blueTotalGold=" + blueTotalGold +
                ", blueTotalMinionKills=" + blueTotalMinionKills +
                ", blueTotalLevel=" + blueTotalLevel +
                ", blueAvgLevel=" + blueAvgLevel +
                ", blueJungleMinionKills=" + blueJungleMinionKills +
                ", blueKillingSpree=" + blueKillingSpree +
                ", blueTotalHeal=" + blueTotalHeal +
                ", blueObjectDamageDealt=" + blueObjectDamageDealt +
                ", redWins=" + redWins +
                ", redFirstBlood=" + redFirstBlood +
                ", redFirstTower=" + redFirstTower +
                ", redFirstBaron=" + redFirstBaron +
                ", redFirstDragon=" + redFirstDragon +
                ", redFirstInhibitor=" + redFirstInhibitor +
                ", redDragonKills=" + redDragonKills +
                ", redBaronKills=" + redBaronKills +
                ", redTowerKills=" + redTowerKills +
                ", redInhibitorKills=" + redInhibitorKills +
                ", redWardPlaced=" + redWardPlaced +
                ", redWardkills=" + redWardkills +
                ", redKills=" + redKills +
                ", redDeath=" + redDeath +
                ", redAssist=" + redAssist +
                ", redChampionDamageDealt=" + redChampionDamageDealt +
                ", redTotalGold=" + redTotalGold +
                ", redTotalMinionKills=" + redTotalMinionKills +
                ", redTotalLevel=" + redTotalLevel +
                ", redAvgLevel=" + redAvgLevel +
                ", redJungleMinionKills=" + redJungleMinionKills +
                ", redKillingSpree=" + redKillingSpree +
                ", redTotalHeal=" + redTotalHeal +
                ", redObjectDamageDealt=" + redObjectDamageDealt +
                '}';
    }

    public Object get(String tag) {
        switch (tag){
            case "gameId":
                return gameId;
            case "gameDuraton":
                return gameDuraton;
            case "blueWins":
                return blueWins;
            case "blueFirstBlood":
                return blueFirstBlood;
            case "blueFirstTower":
                return blueFirstTower;
            case "blueFirstBaron":
                return blueFirstBaron;
            case "blueFirstDragon":
                return blueFirstDragon;
            case "blueFirstInhibitor":
                return blueFirstInhibitor;
            case "blueDragonKills":
                return blueDragonKills;
            case "blueBaronKills":
                return blueBaronKills;
            case "blueTowerKills":
                return blueTowerKills;
            case "blueInhibitorKills":
                return blueInhibitorKills;
            case "blueWardPlaced":
                return blueWardPlaced;
            case "blueWardkills":
                return blueWardkills;
            case "blueKills":
                return blueKills;
            case "blueDeath":
                return blueDeath;
            case "blueAssist":
                return blueAssist;
            case "blueChampionDamageDealt":
                return blueChampionDamageDealt;
            case "blueTotalGold":
                return blueTotalGold;
            case "blueTotalMinionKills":
                return blueTotalMinionKills;
            case "blueTotalLevel":
                return blueTotalLevel;
            case "blueAvgLevel":
                return blueAvgLevel;
            case "blueJungleMinionKills":
                return blueJungleMinionKills;
            case "blueKillingSpree":
                return blueKillingSpree;
            case "blueTotalHeal":
                return blueTotalHeal;
            case "redWins":
                return redWins;
            case "redFirstBlood":
                return redFirstBlood;
            case "redFirstTower":
                return redFirstTower;
            case "redFirstBaron":
                return redFirstBaron;
            case "redFirstDragon":
                return redFirstDragon;
            case "redFirstInhibitor":
                return redFirstInhibitor;
            case "redDragonKills":
                return redDragonKills;
            case "redBaronKills":
                return redBaronKills;
            case "redTowerKills":
                return redTowerKills;
            case "redInhibitorKills":
                return redInhibitorKills;
            case "redWardPlaced":
                return redWardPlaced;
            case "redWardkills":
                return redWardkills;
            case "redKills":
                return redKills;
            case "redDeath":
                return redDeath;
            case "redAssist":
                return redAssist;
            case "redChampionDamageDealt":
                return redChampionDamageDealt;
            case "redTotalGold":
                return redTotalGold;
            case "redTotalMinionKills":
                return redTotalMinionKills;
            case "redTotalLevel":
                return redTotalLevel;
            case "redAvgLevel":
                return redAvgLevel;
            case "redJungleMinionKills":
                return redJungleMinionKills;
            case "redKillingSpree":
                return redKillingSpree;
            case "redTotalHeal":
                return redTotalHeal;
        }
        return null;
    }
}
