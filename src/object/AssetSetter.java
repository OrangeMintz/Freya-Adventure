package object;

import entity.NPC_OldMan;
import main.GamePanel;
import monster.MON_Bat;
import monster.MON_GreenSlime;
//import monster.MON_GreenSlime;
import monster.MON_RedSlime;

public class AssetSetter {
	
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
		
		
	}
	
	public void setObject() {
		
		int mapNum = 0;
		int i = 0;
		
		// MAP 1
		
		gp.obj[mapNum][0] = new Obj_key(gp);
		gp.obj[mapNum][0].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][0].worldY = 26 * gp.tileSize;
		
		gp.obj[mapNum][1] = new Obj_boots(gp);
		gp.obj[mapNum][1].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][1].worldY = 36 * gp.tileSize;
		
		gp.obj[mapNum][2] = new Obj_door(gp);
		gp.obj[mapNum][2].worldX = 13 * gp.tileSize;
		gp.obj[mapNum][2].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][3] = new Obj_sword(gp);
		gp.obj[mapNum][3].worldX = 8 * gp.tileSize;
		gp.obj[mapNum][3].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][4] = new Obj_heart(gp);
		gp.obj[mapNum][4].worldX = 36 * gp.tileSize;
		gp.obj[mapNum][4].worldY = 18 * gp.tileSize;
		
		gp.obj[mapNum][5] = new Obj_heart(gp);
		gp.obj[mapNum][5].worldX = 39 * gp.tileSize;
		gp.obj[mapNum][5].worldY = 26 * gp.tileSize;
		
		gp.obj[mapNum][6] = new Obj_potion(gp);
		gp.obj[mapNum][6].worldX = 30 * gp.tileSize;
		gp.obj[mapNum][6].worldY = 31 * gp.tileSize;
		
		gp.obj[mapNum][7] = new Obj_potion(gp);
		gp.obj[mapNum][7].worldX = 10 * gp.tileSize;
		gp.obj[mapNum][7].worldY = 41 * gp.tileSize;
		
		gp.obj[mapNum][9] = new Obj_cave(gp);
		gp.obj[mapNum][9].worldX = 41 * gp.tileSize;
		gp.obj[mapNum][9].worldY = 10 * gp.tileSize;
		
		gp.obj[mapNum][10] = new Obj_potion(gp);
		gp.obj[mapNum][10].worldX = 40 * gp.tileSize;
		gp.obj[mapNum][10].worldY = 31 * gp.tileSize;
		
		// DUNGEON 1
		
		gp.obj[1][11] = new Obj_tent(gp);
		gp.obj[1][11].worldX = 31 * gp.tileSize;
		gp.obj[1][11].worldY = 8 * gp.tileSize;
		
		gp.obj[1][12] = new Obj_potion(gp);
		gp.obj[1][12].worldX = 12 * gp.tileSize;
		gp.obj[1][12].worldY = 9 * gp.tileSize;
		
		gp.obj[1][13] = new Obj_heart_gold(gp);
		gp.obj[1][13].worldX = 42 * gp.tileSize;
		gp.obj[1][13].worldY = 13 * gp.tileSize;
		
		gp.obj[1][14] = new Obj_potion(gp);
		gp.obj[1][14].worldX = 15 * gp.tileSize;
		gp.obj[1][14].worldY = 25 * gp.tileSize;
		
		gp.obj[1][15] = new Obj_heart(gp);
		gp.obj[1][15].worldX = 36 * gp.tileSize;
		gp.obj[1][15].worldY = 26 * gp.tileSize;
		
		gp.obj[1][16] = new Obj_heart(gp);
		gp.obj[1][16].worldX = 36 * gp.tileSize;
		gp.obj[1][16].worldY = 38 * gp.tileSize;
		
		gp.obj[1][17] = new Obj_stairs1(gp);
		gp.obj[1][17].worldX = 15 * gp.tileSize;
		gp.obj[1][17].worldY = 36 * gp.tileSize;
		
		// DUNGEON 2
		
		gp.obj[2][18] = new Obj_stairs(gp);
		gp.obj[2][18].worldX = 11 * gp.tileSize;
		gp.obj[2][18].worldY = 32 * gp.tileSize;
		
		gp.obj[2][19] = new Obj_stairs2(gp);
		gp.obj[2][19].worldX = 13 * gp.tileSize;
		gp.obj[2][19].worldY = 16 * gp.tileSize;
		
		gp.obj[2][20] = new Obj_heart(gp);
		gp.obj[2][20].worldX = 18 * gp.tileSize;
		gp.obj[2][20].worldY = 13 * gp.tileSize;
		
		gp.obj[2][21] = new Obj_door_iron(gp);
		gp.obj[2][21].worldX = 15 * gp.tileSize;
		gp.obj[2][21].worldY = 16 * gp.tileSize;
		
		gp.obj[2][22] = new Obj_key(gp);
		gp.obj[2][22].worldX = 43 * gp.tileSize;
		gp.obj[2][22].worldY = 21 * gp.tileSize;
		
		gp.obj[2][23] = new Obj_heart_gold(gp);
		gp.obj[2][23].worldX = 23 * gp.tileSize;
		gp.obj[2][23].worldY = 7 * gp.tileSize;
		
		gp.obj[2][24] = new Obj_heart(gp);
		gp.obj[2][24].worldX = 17 * gp.tileSize;
		gp.obj[2][24].worldY = 32 * gp.tileSize;
		
		gp.obj[2][25] = new Obj_potion(gp);
		gp.obj[2][25].worldX = 35 * gp.tileSize;
		gp.obj[2][25].worldY = 38 * gp.tileSize;
		
		gp.obj[2][26] = new Obj_heart(gp);
		gp.obj[2][26].worldX = 19 * gp.tileSize;
		gp.obj[2][26].worldY = 19 * gp.tileSize;
			
		gp.obj[2][27] = new Obj_potion(gp);
		gp.obj[2][27].worldX = 21 * gp.tileSize;
		gp.obj[2][27].worldY = 12 * gp.tileSize;
		
		// DUNGEON 3
		
		gp.obj[3][28] = new Obj_door_iron_blue(gp);
		gp.obj[3][28].worldX = 14 * gp.tileSize;
		gp.obj[3][28].worldY = 22 * gp.tileSize;
		
		gp.obj[3][29] = new Obj_door_iron_red(gp);
		gp.obj[3][29].worldX = 37 * gp.tileSize;
		gp.obj[3][29].worldY = 22 * gp.tileSize;
		
		gp.obj[3][30] = new Obj_key_blue(gp);
		gp.obj[3][30].worldX = 11 * gp.tileSize;
		gp.obj[3][30].worldY = 22 * gp.tileSize;
		
		gp.obj[3][31] = new Obj_key_red(gp);
		gp.obj[3][31].worldX = 40 * gp.tileSize;
		gp.obj[3][31].worldY = 22 * gp.tileSize;
		
		gp.obj[3][32] = new Obj_heart(gp);
		gp.obj[3][32].worldX = 22 * gp.tileSize;
		gp.obj[3][32].worldY = 15 * gp.tileSize;
		
		gp.obj[3][33] = new Obj_heart(gp);
		gp.obj[3][33].worldX = 30 * gp.tileSize;
		gp.obj[3][33].worldY = 30 * gp.tileSize;
		
		gp.obj[3][34] = new Obj_door_iron_fin(gp);
		gp.obj[3][34].worldX = 26 * gp.tileSize;
		gp.obj[3][34].worldY = 31 * gp.tileSize;
		
		gp.obj[3][35] = new Obj_sword_gold(gp);
		gp.obj[3][35].worldX = 26 * gp.tileSize;
		gp.obj[3][35].worldY = 16 * gp.tileSize;

		gp.obj[3][36] = new Obj_chest(gp);
		gp.obj[3][36].worldX = 26 * gp.tileSize;
		gp.obj[3][36].worldY = 43 * gp.tileSize;
		
	}
	
	public void setNPC() {
		
		int mapNum = 0;
		int i = 0;
		gp.npc[mapNum][0] = new NPC_OldMan(gp);
		gp.npc[mapNum][0].worldX = 29 * gp.tileSize;
		gp.npc[mapNum][0].worldY = 11 * gp.tileSize;

	}
	
	public void setMonster() {
		int mapNum = 0;
		int i = 0;
		
		// WORLD MAP 1
		
		gp.monster[mapNum][0] = new MON_GreenSlime(gp);
		gp.monster[mapNum][0].worldX = gp.tileSize*35;
		gp.monster[mapNum][0].worldY = gp.tileSize*22;
		
		gp.monster[mapNum][1] = new MON_GreenSlime(gp);
		gp.monster[mapNum][1].worldX = gp.tileSize*38;
		gp.monster[mapNum][1].worldY = gp.tileSize*20;
		
		gp.monster[mapNum][2] = new MON_GreenSlime(gp);
		gp.monster[mapNum][2].worldX = gp.tileSize*37;
		gp.monster[mapNum][2].worldY = gp.tileSize*23;
		
		// DUNGEON 1
		
		gp.monster[1][3] = new MON_GreenSlime(gp);
		gp.monster[1][3].worldX = gp.tileSize*17;
		gp.monster[1][3].worldY = gp.tileSize*10;
		
		gp.monster[1][4] = new MON_RedSlime(gp);
		gp.monster[1][4].worldX = gp.tileSize*27;
		gp.monster[1][4].worldY = gp.tileSize*11;
		
		gp.monster[1][5] = new MON_RedSlime(gp);
		gp.monster[1][5].worldX = gp.tileSize*23;
		gp.monster[1][5].worldY = gp.tileSize*18;
		
		
		gp.monster[1][6] = new MON_GreenSlime(gp);
		gp.monster[1][6].worldX = gp.tileSize*37;
		gp.monster[1][6].worldY = gp.tileSize*13;
		
		
		gp.monster[1][7] = new MON_RedSlime(gp);
		gp.monster[1][7].worldX = gp.tileSize*41;
		gp.monster[1][7].worldY = gp.tileSize*15;
		
		gp.monster[1][8] = new MON_RedSlime(gp);
		gp.monster[1][8].worldX = gp.tileSize*16;
		gp.monster[1][8].worldY = gp.tileSize*23;
		
		gp.monster[1][9] = new MON_RedSlime(gp);
		gp.monster[1][9].worldX = gp.tileSize*18;
		gp.monster[1][9].worldY = gp.tileSize*34;
		
		gp.monster[1][10] = new MON_RedSlime(gp);
		gp.monster[1][10].worldX = gp.tileSize*20;
		gp.monster[1][10].worldY = gp.tileSize*38;
		
		gp.monster[1][11] = new MON_RedSlime(gp);
		gp.monster[1][11].worldX = gp.tileSize*37;
		gp.monster[1][11].worldY = gp.tileSize*11;
		
		gp.monster[1][12] = new MON_RedSlime(gp);
		gp.monster[1][12].worldX = gp.tileSize*35;
		gp.monster[1][12].worldY = gp.tileSize*28;
	
		gp.monster[1][13] = new MON_RedSlime(gp);
		gp.monster[1][13].worldX = gp.tileSize*16;
		gp.monster[1][13].worldY = gp.tileSize*38;
		
		gp.monster[1][14] = new MON_RedSlime(gp);
		gp.monster[1][14].worldX = gp.tileSize*22;
		gp.monster[1][14].worldY = gp.tileSize*39;
		
		gp.monster[1][15] = new MON_RedSlime(gp);
		gp.monster[1][15].worldX = gp.tileSize*25;
		gp.monster[1][15].worldY = gp.tileSize*38;
		
		gp.monster[1][16] = new MON_RedSlime(gp);
		gp.monster[1][16].worldX = gp.tileSize*18;
		gp.monster[1][16].worldY = gp.tileSize*37;
		
		gp.monster[1][17] = new MON_RedSlime(gp);
		gp.monster[1][17].worldX = gp.tileSize*13;
		gp.monster[1][17].worldY = gp.tileSize*36;
		
		gp.monster[1][18] = new MON_GreenSlime(gp);
		gp.monster[1][18].worldX = gp.tileSize*20;
		gp.monster[1][18].worldY = gp.tileSize*40;
		
		// DUNGEON 2
		
		gp.monster[2][19] = new MON_GreenSlime(gp);
		gp.monster[2][19].worldX = gp.tileSize*15;
		gp.monster[2][19].worldY = gp.tileSize*31;
		
		gp.monster[2][20] = new MON_GreenSlime(gp);
		gp.monster[2][20].worldX = gp.tileSize*19;
		gp.monster[2][20].worldY = gp.tileSize*31;
		
		gp.monster[2][21] = new MON_GreenSlime(gp);
		gp.monster[2][21].worldX = gp.tileSize*27;
		gp.monster[2][21].worldY = gp.tileSize*31;
		
		gp.monster[2][22] = new MON_RedSlime(gp);
		gp.monster[2][22].worldX = gp.tileSize*14;
		gp.monster[2][22].worldY = gp.tileSize*31;
		
		gp.monster[2][23] = new MON_RedSlime(gp);
		gp.monster[2][23].worldX = gp.tileSize*16;
		gp.monster[2][23].worldY = gp.tileSize*34;
		
		gp.monster[2][24] = new MON_RedSlime(gp);
		gp.monster[2][24].worldX = gp.tileSize*22;
		gp.monster[2][24].worldY = gp.tileSize*35;
		
		gp.monster[2][25] = new MON_RedSlime(gp);
		gp.monster[2][25].worldX = gp.tileSize*36;
		gp.monster[2][25].worldY = gp.tileSize*37;
		
		gp.monster[2][26] = new MON_RedSlime(gp);
		gp.monster[2][26].worldX = gp.tileSize*43;
		gp.monster[2][26].worldY = gp.tileSize*20;
		
		gp.monster[2][27] = new MON_RedSlime(gp);
		gp.monster[2][27].worldX = gp.tileSize*25;
		gp.monster[2][27].worldY = gp.tileSize*7;
		
		gp.monster[2][28] = new MON_RedSlime(gp);
		gp.monster[2][28].worldX = gp.tileSize*23;
		gp.monster[2][28].worldY = gp.tileSize*17;
		
		gp.monster[2][29] = new MON_RedSlime(gp);
		gp.monster[2][29].worldX = gp.tileSize*16;
		gp.monster[2][29].worldY = gp.tileSize*18;
		
		gp.monster[2][30] = new MON_Bat(gp);
		gp.monster[2][30].worldX = gp.tileSize*20;
		gp.monster[2][30].worldY = gp.tileSize*11;
		
		gp.monster[2][31] = new MON_Bat(gp);
		gp.monster[2][31].worldX = gp.tileSize*26;
		gp.monster[2][31].worldY = gp.tileSize*10;
		
		gp.monster[2][32] = new MON_Bat(gp);
		gp.monster[2][32].worldX = gp.tileSize*31;
		gp.monster[2][32].worldY = gp.tileSize*33;
		
		gp.monster[2][33] = new MON_Bat(gp);
		gp.monster[2][33].worldX = gp.tileSize*20;
		gp.monster[2][33].worldY = gp.tileSize*21;
		
		gp.monster[2][34] = new MON_Bat(gp);
		gp.monster[2][34].worldX = gp.tileSize*24;
		gp.monster[2][34].worldY = gp.tileSize*21;
		
		gp.monster[2][35] = new MON_Bat(gp);
		gp.monster[2][35].worldX = gp.tileSize*18;
		gp.monster[2][35].worldY = gp.tileSize*20;
		
		gp.monster[2][36] = new MON_Bat(gp);
		gp.monster[2][36].worldX = gp.tileSize*26;
		gp.monster[2][36].worldY = gp.tileSize*17;
		
		gp.monster[2][37] = new MON_Bat(gp);
		gp.monster[2][37].worldX = gp.tileSize*23;
		gp.monster[2][37].worldY = gp.tileSize*18;
		
		gp.monster[2][38] = new MON_Bat(gp);
		gp.monster[2][38].worldX = gp.tileSize*32;
		gp.monster[2][38].worldY = gp.tileSize*32;
		
		// DUNGEON 3
		
		gp.monster[3][39] = new MON_Bat(gp);
		gp.monster[3][39].worldX = gp.tileSize*18;
		gp.monster[3][39].worldY = gp.tileSize*17;
		
		gp.monster[3][40] = new MON_Bat(gp);
		gp.monster[3][40].worldX = gp.tileSize*18;
		gp.monster[3][40].worldY = gp.tileSize*19;
		
		gp.monster[3][41] = new MON_Bat(gp);
		gp.monster[3][41].worldX = gp.tileSize*19;
		gp.monster[3][41].worldY = gp.tileSize*19;
		
		gp.monster[3][42] = new MON_Bat(gp);
		gp.monster[3][42].worldX = gp.tileSize*18;
		gp.monster[3][42].worldY = gp.tileSize*25;
		
		gp.monster[3][43] = new MON_Bat(gp);
		gp.monster[3][43].worldX = gp.tileSize*34;
		gp.monster[3][43].worldY = gp.tileSize*19;
		
		gp.monster[3][44] = new MON_Bat(gp);
		gp.monster[3][44].worldX = gp.tileSize*31;
		gp.monster[3][44].worldY = gp.tileSize*19;
		
		gp.monster[3][45] = new MON_Bat(gp);
		gp.monster[3][45].worldX = gp.tileSize*29;
		gp.monster[3][45].worldY = gp.tileSize*25;
		
		gp.monster[3][46] = new MON_Bat(gp);
		gp.monster[3][46].worldX = gp.tileSize*33;
		gp.monster[3][46].worldY = gp.tileSize*30;
			
	}
	
	public void setObject1() {
		gp.obj[3][37] = new Obj_heart(gp);
		gp.obj[3][37].worldX = 17 * gp.tileSize;
		gp.obj[3][37].worldY = 21 * gp.tileSize;
		
		gp.obj[3][38] = new Obj_heart(gp);
		gp.obj[3][38].worldX = 18 * gp.tileSize;
		gp.obj[3][38].worldY = 23 * gp.tileSize;
		
		gp.obj[3][39] = new Obj_potion(gp);
		gp.obj[3][39].worldX = 21 * gp.tileSize;
		gp.obj[3][39].worldY = 22 * gp.tileSize;
		
		gp.obj[3][40] = new Obj_potion(gp);
		gp.obj[3][40].worldX = 25 * gp.tileSize;
		gp.obj[3][40].worldY = 18 * gp.tileSize;
	}
	
	public void setMonster1() {
		gp.monster[3][47] = new MON_RedSlime(gp);
		gp.monster[3][47].worldX = gp.tileSize*16;
		gp.monster[3][47].worldY = gp.tileSize*18;
		
		gp.monster[3][48] = new MON_RedSlime(gp);
		gp.monster[3][48].worldX = gp.tileSize*24;
		gp.monster[3][48].worldY = gp.tileSize*20;
		
		gp.monster[3][49] = new MON_RedSlime(gp);
		gp.monster[3][49].worldX = gp.tileSize*23;
		gp.monster[3][49].worldY = gp.tileSize*25;
		
		gp.monster[3][50] = new MON_RedSlime(gp);
		gp.monster[3][50].worldX = gp.tileSize*34;
		gp.monster[3][50].worldY = gp.tileSize*25;
		
		gp.monster[3][51] = new MON_RedSlime(gp);
		gp.monster[3][51].worldX = gp.tileSize*25;
		gp.monster[3][51].worldY = gp.tileSize*30;
		
		gp.monster[3][52] = new MON_RedSlime(gp);
		gp.monster[3][52].worldX = gp.tileSize*16;
		gp.monster[3][52].worldY = gp.tileSize*19;
		
		gp.monster[3][53] = new MON_RedSlime(gp);
		gp.monster[3][53].worldX = gp.tileSize*28;
		gp.monster[3][53].worldY = gp.tileSize*30;
		
		gp.monster[3][54] = new MON_RedSlime(gp);
		gp.monster[3][54].worldX = gp.tileSize*19;
		gp.monster[3][54].worldY = gp.tileSize*30;
		
		gp.monster[3][55] = new MON_RedSlime(gp);
		gp.monster[3][55].worldX = gp.tileSize*35;
		gp.monster[3][55].worldY = gp.tileSize*20;
		
		gp.monster[3][56] = new MON_RedSlime(gp);
		gp.monster[3][56].worldX = gp.tileSize*20;
		gp.monster[3][56].worldY = gp.tileSize*14;
	
	}

}
