package Main;

public class ChunLi extends Character{
    public ChunLi(){
        this.HP=900;
        this.movesno = 26;
        this.MaxHP = 900;
        this.name="Chun Li";
        int i = 0;
        while (i<=29){
            moves[i] = new Move();
            ++i;
        }
      //block
        this.moves[0].name="Block";
        this.moves[0].damage=0;
        this.moves[0].userMovement=0;
        this.moves[0].enemyMovement=0;
        this.moves[0].superGainUse=0;
        this.moves[0].superGainHit=0;
        this.moves[0].startup=0;
        this.moves[0].range=0;
        this.moves[0].hitsGround=false;
        this.moves[0].isAir=false;
        this.moves[0].hitsAir=false;
        this.moves[0].armored=false;
        this.moves[0].armorBreak=false;
        this.moves[0].isProjectile=false;
        this.moves[0].projectileImmune=false;
        this.moves[0].isThrow=false;
        //this is for focus
        this.moves[1].name="Focus";
        this.moves[1].damage=0;
        this.moves[1].userMovement=0;
        this.moves[1].enemyMovement=0;
        this.moves[1].superGainUse=0;
        this.moves[1].superGainHit=0;
        this.moves[1].startup=0;
        this.moves[1].range=0;
        this.moves[1].hitsGround=false;
        this.moves[1].isAir=false;
        this.moves[1].hitsAir=false;
        this.moves[1].armored=true;
        this.moves[1].armorBreak=false;
        this.moves[1].isProjectile=false;
        this.moves[1].projectileImmune=false;
        this.moves[1].isThrow=false;
        //this is for forward dash
        this.moves[2].name="Forward Dash";
        this.moves[2].damage=0;
        this.moves[2].userMovement=1;
        this.moves[2].enemyMovement=0;
        this.moves[2].superGainUse=0;
        this.moves[2].superGainHit=0;
        this.moves[2].startup=0;
        this.moves[2].range=0;
        this.moves[2].hitsGround=false;
        this.moves[2].isAir=false;
        this.moves[2].hitsAir=false;
        this.moves[2].armored=false;
        this.moves[2].armorBreak=false;
        this.moves[2].isProjectile=false;
        this.moves[2].projectileImmune=false;
        this.moves[2].isThrow=false;
        //this is for backdash
        this.moves[3].name="Backdash";
        this.moves[3].damage=0;
        this.moves[3].userMovement=-1;
        this.moves[3].enemyMovement=0;
        this.moves[3].superGainUse=0;
        this.moves[3].superGainHit=0;
        this.moves[3].startup=0;
        this.moves[3].range=0;
        this.moves[3].hitsGround=false;
        this.moves[3].isAir=true;
        this.moves[3].hitsAir=false;
        this.moves[3].armored=false;
        this.moves[3].armorBreak=false;
        this.moves[3].isProjectile=false;
        this.moves[3].projectileImmune=false;
        this.moves[3].isThrow=false;
        //this is for forward jump
        this.moves[4].name="Forward Jump";
        this.moves[4].damage=0;
        this.moves[4].userMovement=1;
        this.moves[4].enemyMovement=0;
        this.moves[4].superGainUse=0;
        this.moves[4].superGainHit=0;
        this.moves[4].startup=0;
        this.moves[4].range=0;
        this.moves[4].hitsGround=false;
        this.moves[4].isAir=true;
        this.moves[4].hitsAir=false;
        this.moves[4].armored=false;
        this.moves[4].armorBreak=false;
        this.moves[4].isProjectile=false;
        this.moves[4].projectileImmune=false;
        this.moves[4].isThrow=false;
        //this is for neutral jump
        this.moves[5].name="Neutral Jump";
        this.moves[5].damage=0;
        this.moves[5].userMovement=0;
        this.moves[5].enemyMovement=0;
        this.moves[5].superGainUse=0;
        this.moves[5].superGainHit=0;
        this.moves[5].startup=0;
        this.moves[5].range=0;
        this.moves[5].hitsGround=false;
        this.moves[5].isAir=true;
        this.moves[5].hitsAir=false;
        this.moves[5].armored=false;
        this.moves[5].armorBreak=false;
        this.moves[5].isProjectile=false;
        this.moves[5].projectileImmune=false;
        this.moves[5].isThrow=false;
        //this is for backward jump
        this.moves[6].name="Backward Jump";
        this.moves[6].damage=0;
        this.moves[6].userMovement=-1;
        this.moves[6].enemyMovement=0;
        this.moves[6].superGainUse=0;
        this.moves[6].superGainHit=0;
        this.moves[6].startup=0;
        this.moves[6].range=0;
        this.moves[6].hitsGround=false;
        this.moves[6].isAir=true;
        this.moves[6].hitsAir=false;
        this.moves[6].armored=false;
        this.moves[6].armorBreak=false;
        this.moves[6].isProjectile=false;
        this.moves[6].projectileImmune=false;
        this.moves[6].isThrow=false;
        //throw
        this.moves[7].name="Throw";
        this.moves[7].damage=140;
        this.moves[7].userMovement=0;
        this.moves[7].enemyMovement=1;
        this.moves[7].superGainUse=0;
        this.moves[7].superGainHit=40;
        this.moves[7].startup=3;
        this.moves[7].range=0;
        this.moves[7].hitsGround=true;
        this.moves[7].isAir=false;
        this.moves[7].hitsAir=false;
        this.moves[7].armored=false;
        this.moves[7].armorBreak=true;
        this.moves[7].isProjectile=false;
        this.moves[7].projectileImmune=false;
        this.moves[7].isThrow=true;
        //SUPER
        this.moves[8].name="SUPER";
        this.moves[8].damage=340;
        this.moves[8].userMovement=2;
        this.moves[8].enemyMovement=1;
        this.moves[8].superGainUse=-1000;
        this.moves[8].superGainHit=0;
        this.moves[8].startup=1;
        this.moves[8].range=2;
        this.moves[8].hitsGround=true;
        this.moves[8].isAir=false;
        this.moves[8].hitsAir=false;
        this.moves[8].armored=false;
        this.moves[8].armorBreak=true;
        this.moves[8].isProjectile=false;
        this.moves[8].projectileImmune=true;
        this.moves[8].isThrow=false;
        //ULTRA
        this.moves[9].name="ULTRA";
        this.moves[9].damage=460;
        this.moves[9].userMovement=3;
        this.moves[9].enemyMovement=2;
        this.moves[9].superGainUse=0;
        this.moves[9].superGainHit=0;
        this.moves[9].startup=7;
        this.moves[9].range=3;
        this.moves[9].hitsGround=true;
        this.moves[9].isAir=false;
        this.moves[9].hitsAir=false;
        this.moves[9].armored=false;
        this.moves[9].armorBreak=true;
        this.moves[9].isProjectile=false;
        this.moves[9].projectileImmune=true;
        this.moves[9].isThrow=false;
        //L Lightning Legs
        this.moves[10].name="L Lightning Legs";
        this.moves[10].damage=105;
        this.moves[10].userMovement=0;
        this.moves[10].enemyMovement=0;
        this.moves[10].superGainUse=20;
        this.moves[10].superGainHit=10;
        this.moves[10].startup=4;
        this.moves[10].range=0;
        this.moves[10].hitsGround=true;
        this.moves[10].isAir=false;
        this.moves[10].hitsAir=true;
        this.moves[10].armored=false;
        this.moves[10].armorBreak=true;
        this.moves[10].isProjectile=false;
        this.moves[10].projectileImmune=false;
        this.moves[10].isThrow=false;
        //M Lightning Legs
        this.moves[11].name="M Lightning Legs";
        this.moves[11].damage=145;
        this.moves[11].userMovement=0;
        this.moves[11].enemyMovement=0;
        this.moves[11].superGainUse=20;
        this.moves[11].superGainHit=10;
        this.moves[11].startup=7;
        this.moves[11].range=0;
        this.moves[11].hitsGround=true;
        this.moves[11].isAir=false;
        this.moves[11].hitsAir=true;
        this.moves[11].armored=false;
        this.moves[11].armorBreak=true;
        this.moves[11].isProjectile=false;
        this.moves[11].projectileImmune=false;
        this.moves[11].isThrow=false;
        //H Lightning Legs
        this.moves[12].name="H Lightning Legs";
        this.moves[12].damage=160;
        this.moves[12].userMovement=0;
        this.moves[12].enemyMovement=0;
        this.moves[12].superGainUse=20;
        this.moves[12].superGainHit=10;
        this.moves[12].startup=7;
        this.moves[12].range=0;
        this.moves[12].hitsGround=true;
        this.moves[12].isAir=false;
        this.moves[12].hitsAir=true;
        this.moves[12].armored=false;
        this.moves[12].armorBreak=true;
        this.moves[12].isProjectile=false;
        this.moves[12].projectileImmune=false;
        this.moves[12].isThrow=false;
        //EX Lightning Legs
        this.moves[13].name="EX Lightning Legs";
        this.moves[13].damage=180;
        this.moves[13].userMovement=1;
        this.moves[13].enemyMovement=1;
        this.moves[13].superGainUse=-250;
        this.moves[13].superGainHit=0;
        this.moves[13].startup=4;
        this.moves[13].range=1;
        this.moves[13].hitsGround=true;
        this.moves[13].isAir=false;
        this.moves[13].hitsAir=true;
        this.moves[13].armored=false;
        this.moves[13].armorBreak=true;
        this.moves[13].isProjectile=false;
        this.moves[13].projectileImmune=false;
        this.moves[13].isThrow=false;
        //L Kikoken
        this.moves[14].name="L Kikoken";
        this.moves[14].damage=50;
        this.moves[14].userMovement=0;
        this.moves[14].enemyMovement=0;
        this.moves[14].superGainUse=20;
        this.moves[14].superGainHit=20;
        this.moves[14].startup=14;
        this.moves[14].range=3;
        this.moves[14].hitsGround=true;
        this.moves[14].isAir=false;
        this.moves[14].hitsAir=false;
        this.moves[14].armored=false;
        this.moves[14].armorBreak=false;
        this.moves[14].isProjectile=true;
        this.moves[14].projectileImmune=false;
        this.moves[14].isThrow=false;
        //M Kikoken
        this.moves[15].name="M Kikoken";
        this.moves[15].damage=60;
        this.moves[15].userMovement=0;
        this.moves[15].enemyMovement=0;
        this.moves[15].superGainUse=20;
        this.moves[15].superGainHit=20;
        this.moves[15].startup=12;
        this.moves[15].range=2;
        this.moves[15].hitsGround=true;
        this.moves[15].isAir=false;
        this.moves[15].hitsAir=false;
        this.moves[15].armored=false;
        this.moves[15].armorBreak=false;
        this.moves[15].isProjectile=true;
        this.moves[15].projectileImmune=false;
        this.moves[15].isThrow=false;
        //H Kikoken
        this.moves[16].name="H Kikoken";
        this.moves[16].damage=70;
        this.moves[16].userMovement=0;
        this.moves[16].enemyMovement=0;
        this.moves[16].superGainUse=20;
        this.moves[16].superGainHit=20;
        this.moves[16].startup=10;
        this.moves[16].range=2;
        this.moves[16].hitsGround=true;
        this.moves[16].isAir=false;
        this.moves[16].hitsAir=false;
        this.moves[16].armored=false;
        this.moves[16].armorBreak=false;
        this.moves[16].isProjectile=true;
        this.moves[16].projectileImmune=false;
        this.moves[16].isThrow=false;
        //EX Kikoken
        this.moves[17].name="EX Kikoken";
        this.moves[17].damage=100;
        this.moves[17].userMovement=0;
        this.moves[17].enemyMovement=0;
        this.moves[17].superGainUse=-250;
        this.moves[17].superGainHit=0;
        this.moves[17].startup=10;
        this.moves[17].range=3;
        this.moves[17].hitsGround=true;
        this.moves[17].isAir=false;
        this.moves[17].hitsAir=false;
        this.moves[17].armored=false;
        this.moves[17].armorBreak=true;
        this.moves[17].isProjectile=true;
        this.moves[17].projectileImmune=false;
        this.moves[17].isThrow=false;
        //L Hazanshu
        this.moves[18].name="L Hazanshu";
        this.moves[18].damage=90;
        this.moves[18].userMovement=1;
        this.moves[18].enemyMovement=0;
        this.moves[18].superGainUse=30;
        this.moves[18].superGainHit=40;
        this.moves[18].startup=23;
        this.moves[18].range=1;
        this.moves[18].hitsGround=true;
        this.moves[18].isAir=true;
        this.moves[18].hitsAir=true;
        this.moves[18].armored=false;
        this.moves[18].armorBreak=true;
        this.moves[18].isProjectile=false;
        this.moves[18].projectileImmune=false;
        this.moves[18].isThrow=false;
        //M Hazanshu
        this.moves[19].name="M Hazanshu";
        this.moves[19].damage=110;
        this.moves[19].userMovement=1;
        this.moves[19].enemyMovement=0;
        this.moves[19].superGainUse=30;
        this.moves[19].superGainHit=40;
        this.moves[19].startup=25;
        this.moves[19].range=1;
        this.moves[19].hitsGround=true;
        this.moves[19].isAir=true;
        this.moves[19].hitsAir=true;
        this.moves[19].armored=false;
        this.moves[19].armorBreak=true;
        this.moves[19].isProjectile=false;
        this.moves[19].projectileImmune=false;
        this.moves[19].isThrow=false;
        //H Hazanshu
        this.moves[20].name="H Hazanshu";
        this.moves[20].damage=130;
        this.moves[20].userMovement=2;
        this.moves[20].enemyMovement=0;
        this.moves[20].superGainUse=30;
        this.moves[20].superGainHit=40;
        this.moves[20].startup=26;
        this.moves[20].range=2;
        this.moves[20].hitsGround=true;
        this.moves[20].isAir=true;
        this.moves[20].hitsAir=true;
        this.moves[20].armored=false;
        this.moves[20].armorBreak=true;
        this.moves[20].isProjectile=false;
        this.moves[20].projectileImmune=false;
        this.moves[20].isThrow=false;
        //EX Hazanshu
        this.moves[21].name="EX Hazanshu";
        this.moves[21].damage=170;
        this.moves[21].userMovement=2;
        this.moves[21].enemyMovement=0;
        this.moves[21].superGainUse=-250;
        this.moves[21].superGainHit=0;
        this.moves[21].startup=26;
        this.moves[21].range=2;
        this.moves[21].hitsGround=true;
        this.moves[21].isAir=true;
        this.moves[21].hitsAir=true;
        this.moves[21].armored=false;
        this.moves[21].armorBreak=true;
        this.moves[21].isProjectile=false;
        this.moves[21].projectileImmune=true;
        this.moves[21].isThrow=false;
        //L Spinning Bird Kick
        this.moves[22].name="L Spinning Bird Kick";
        this.moves[22].damage=160;
        this.moves[22].userMovement=1;
        this.moves[22].enemyMovement=0;
        this.moves[22].superGainUse=20;
        this.moves[22].superGainHit=10;
        this.moves[22].startup=13;
        this.moves[22].range=1;
        this.moves[22].hitsGround=true;
        this.moves[22].isAir=true;
        this.moves[22].hitsAir=true;
        this.moves[22].armored=false;
        this.moves[22].armorBreak=true;
        this.moves[22].isProjectile=false;
        this.moves[22].projectileImmune=false;
        this.moves[22].isThrow=false;
        //M Spinning Bird Kick
        this.moves[23].name="M Spinning Bird Kick";
        this.moves[23].damage=180;
        this.moves[23].userMovement=2;
        this.moves[23].enemyMovement=0;
        this.moves[23].superGainUse=20;
        this.moves[23].superGainHit=10;
        this.moves[23].startup=14;
        this.moves[23].range=2;
        this.moves[23].hitsGround=true;
        this.moves[23].isAir=true;
        this.moves[23].hitsAir=true;
        this.moves[23].armored=false;
        this.moves[23].armorBreak=true;
        this.moves[23].isProjectile=false;
        this.moves[23].projectileImmune=false;
        this.moves[23].isThrow=false;
        //H Spinning Bird Kick
        this.moves[24].name="H Spinning Bird Kick";
        this.moves[24].damage=270;
        this.moves[24].userMovement=3;
        this.moves[24].enemyMovement=0;
        this.moves[24].superGainUse=20;
        this.moves[24].superGainHit=10;
        this.moves[24].startup=22;
        this.moves[24].range=3;
        this.moves[24].hitsGround=true;
        this.moves[24].isAir=true;
        this.moves[24].hitsAir=true;
        this.moves[24].armored=false;
        this.moves[24].armorBreak=true;
        this.moves[24].isProjectile=false;
        this.moves[24].projectileImmune=false;
        this.moves[24].isThrow=false;
        //EX Hazanshu
        this.moves[25].name="EX Spinning Bird Kick";
        this.moves[25].damage=180;
        this.moves[25].userMovement=0;
        this.moves[25].enemyMovement=3;
        this.moves[25].superGainUse=-250;
        this.moves[25].superGainHit=0;
        this.moves[25].startup=6;
        this.moves[25].range=1;
        this.moves[25].hitsGround=true;
        this.moves[25].isAir=true;
        this.moves[25].hitsAir=true;
        this.moves[25].armored=false;
        this.moves[25].armorBreak=true;
        this.moves[25].isProjectile=false;
        this.moves[25].projectileImmune=true;
        this.moves[25].isThrow=false;
    }
    
}