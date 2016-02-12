/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testslick;
import org.newdawn.slick.*;
/**
 *
 * @author Apache
 */
public class Personnage {
    private float x,y;
    private boolean goingRight,moving;
    private Animation[] animations;
    private SpriteSheet spriteSheet;
    private final int FRAME_DURATION = 80;
    private final float speed;
    
    public Personnage()throws SlickException{
        x = 50;
        y = 75;
        goingRight = false;
        moving = false;
        speed = 0.15f;
        animations = new Animation[20];
        spriteSheet = new SpriteSheet("images/sprites/Space_Pirate_Fusion.png",73,58);
        
        animations[0] = loadAnimation(spriteSheet,false,0,7,0);
        animations[1] = loadAnimation(spriteSheet,true,0,7,0);
        animations[2] = loadAnimation(spriteSheet,false,0,3,1,200);
        animations[3] = loadAnimation(spriteSheet,true,0,3,1,200);
        animations[4] = loadAnimation(spriteSheet,false,0,1,2);
        animations[5] = loadAnimation(spriteSheet,true,0,1,2);
        animations[6] = loadAnimation(spriteSheet,false,0,11,3);
        animations[7] = loadAnimation(spriteSheet,true,0,11,3);
        animations[8] = loadAnimation(spriteSheet,false,0,10,4);
        animations[9] = loadAnimation(spriteSheet,true,0,10,4);
        animations[10] = loadAnimation(spriteSheet,false,0,3,5);
        animations[11] = loadAnimation(spriteSheet,true,0,3,5);
        animations[12] = loadAnimation(spriteSheet,false,0,1,6);
        animations[13] = loadAnimation(spriteSheet,true,0,1,6);
        animations[14] = loadAnimation(spriteSheet,false,0,1,7);
        animations[15] = loadAnimation(spriteSheet,true,0,1,7);
        animations[16] = loadAnimation(spriteSheet,false,0,2,8,200);
        animations[17] = loadAnimation(spriteSheet,true,0,2,8,200);
        animations[18] = loadAnimation(spriteSheet,false,0,2,9,200);
        animations[19] = loadAnimation(spriteSheet,true,0,2,9,200);
        
        
        
        
        
    }
    private Animation loadAnimation(SpriteSheet ss,boolean invert,int startX,int endX,int y,int frameDur){
        Animation anim = new Animation();
        for(int i = startX;i<endX+1;i++){
            anim.addFrame(ss.getSprite(i, y).getFlippedCopy(invert, false), frameDur);
        }
        return anim;
    }
    private Animation loadAnimation(SpriteSheet ss,boolean invert,int startX,int endX,int y){
        return loadAnimation(ss,invert,startX,endX,y,FRAME_DURATION);
    }
    public Animation[] getAninmations(){
        return animations;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public boolean isMoving(){
        return moving;
    }
    public boolean isGoingRight(){
        return goingRight;
    }
    public void addX(float nb){
        x+=nb;
    }
    public void addY(float nb){
        y+=nb;
    }
    public void setMoving(boolean b){
        moving = b;
    }
    public void setGoingRight(boolean r){
        goingRight = r;
    }
    public float getSpeed(){
        return speed;
    }
    
}
