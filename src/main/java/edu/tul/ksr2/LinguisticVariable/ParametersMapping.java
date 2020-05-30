package edu.tul.ksr2.LinguisticVariable;

import java.util.HashMap;
import java.util.Map;


public class ParametersMapping {
    public static Map<String, String> ParametersMapper = new HashMap<>() {{
//        put("gameId", "gameId");
        put("gameDuraton", "Duration");
        put("blueDragonKills", "DragonKills");
        put("redDragonKills", "DragonKills");
        put("blueTowerKills", "TowerKills");
        put("redTowerKills", "TowerKills");
        put("blueInhibitorKills", "InhibitorKills");
        put("redInhibitorKills", "InhibitorKills");
        put("blueWardPlaced", "WardPlaced");
        put("redWardPlaced", "WardPlaced");
        put("blueWardkills", "WardKills");
        put("redWardkills", "WardKills");
        put("blueKills", "KillsAndDeaths");
        put("redKills", "KillsAndDeaths");
        put("blueDeath", "KillsAndDeaths");
        put("redDeath", "KillsAndDeaths");
        put("blueAssist", "Assists");
        put("redAssist", "Assists");
        put("blueChampionDamageDealt", "ChampionDamageDealt");
        put("redChampionDamageDealt", "ChampionDamageDealt");
        put("blueTotalGold", "TotalGold");
        put("redTotalGold", "TotalGold");
        put("blueTotalMinionKills", "TotalMinionKills");
        put("redTotalMinionKills", "TotalMinionKills");
        put("blueTotalLevel", "TotalLevel");
        put("redTotalLevel", "TotalLevel");
//        put("blueAvgLevel", "AvgLevel");
//        put("redAvgLevel", "AvgLevel");
        put("blueJungleMinionKills", "JungleMinionKills");
        put("redJungleMinionKills", "JungleMinionKills");
        put("blueKillingSpree", "KillingSpree");
        put("redKillingSpree", "KillingSpree");
        put("blueTotalHeal", "TotalHeal");
        put("redTotalHeal", "TotalHeal");
        put("blueObjectDamageDealt", "ObjectDamageDealt");
        put("redObjectDamageDealt", "ObjectDamageDealt");
    }};


    public static Map<String, Double> maxValueForParameter = new HashMap<>() {{
//        put("gameId", "gameId");
        put("Duration", 8000.0);
        put("DragonKills", 9.0);
        put("TowerKills", 11.0);
        put("InhibitorKills", 13.0);
        put("WardPlaced", 280.0);
        put("WardKills", 180.0);
        put("KillsAndDeaths", 140.0);
        put("Assists", 265.0);
        put("ChampionDamageDealt", 420000.0);
        put("TotalGold", 160000.0);
        put("TotalMinionKills", 1600.0);
        put("TotalLevel", 170.0);
        put("JungleMinionKills", 500.0);
        put("KillingSpree", 36.0);
        put("TotalHeal", 289000.0);
        put("ObjectDamageDealt", 210000.0);
        put("AmountOfGames", 199925.0);
    }};
}
