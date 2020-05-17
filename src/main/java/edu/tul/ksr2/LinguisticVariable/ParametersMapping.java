package edu.tul.ksr2.LinguisticVariable;

import java.util.HashMap;
import java.util.Map;


public class ParametersMapping {
    public static Map<String, String> ParametersMapper = new HashMap<>() {{
        put("gameId", "gameId");
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
        put("blueAvgLevel", "AvgLevel");
        put("redAvgLevel", "AvgLevel");
        put("blueJungleMinionKills", "JungleMinionKills");
        put("redJungleMinionKills", "JungleMinionKills");
        put("blueKillingSpree", "KillingSpree");
        put("redKillingSpree", "KillingSpree");
        put("blueTotalHeal", "TotalHeal");
        put("redTotalHeal", "TotalHeal");
        put("blueObjectDamageDealt", "ObjectDamageDealt");
        put("redObjectDamageDealt", "ObjectDamageDealt");
    }};
}
