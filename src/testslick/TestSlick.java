/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testslick;
import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author Apache
 */
public class TestSlick extends BasicGame {
    GameContainer container;
    TiledMap map;
    Personnage perso;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException {
       new AppGameContainer(new TestSlick(),320,320,false).start();
    }
    
    public TestSlick()throws SlickException{
        super("Test slick N°1"); 
        
   }
    
    public void init(GameContainer gc)throws SlickException{
        container=gc;
        map = new TiledMap("images/maps/metroid.tmx");
        perso = new Personnage();
        
    }
    
    public void render(GameContainer gc, Graphics g){
        map.render(0, 0);
        g.drawAnimation(perso.getAninmations()[16], 150, 200);
        //g.drawAnimation(perso.getAninmations()[19], 150+48, 200);
        if(perso.isMoving()){
            if(perso.isGoingRight()){
                g.drawAnimation(perso.getAninmations()[1], perso.getX(), perso.getY());
            }
            else{
                g.drawAnimation(perso.getAninmations()[0], perso.getX(), perso.getY());
            }
        }
        else{ 
            if(perso.isGoingRight()){
                g.drawAnimation(perso.getAninmations()[3],perso.getX(),perso.getY());
            }
            else{
                g.drawAnimation(perso.getAninmations()[2],perso.getX(),perso.getY());
            }
        }
        
            
        
        
    }
    
    public void update(GameContainer gc,int delta){
        if(perso.isMoving())
            if(perso.isGoingRight())
                perso.addX(perso.getSpeed()*delta);
            else
                perso.addX(-perso.getSpeed()*delta);
    }
    public void keyReleased(int key,char c){
        if(Input.KEY_ESCAPE==key)
            this.container.exit();
        if(Input.KEY_Q==key&&!perso.isGoingRight())
            perso.setMoving(false);
        if(key==Input.KEY_D&&perso.isGoingRight())
            perso.setMoving(false);
            
        
    }
    public void keyPressed(int key,char c){
        if(key==Input.KEY_Q){
            perso.setGoingRight(false);
            perso.setMoving(true);
        }
        if(key==Input.KEY_D){
            perso.setGoingRight(true);
            perso.setMoving(true);
        }
    }
    private Animation invertAnimation(Animation anim){
        Animation result = new Animation();
        int nbFrame = anim.getFrameCount();
        for(int i = 0;i<nbFrame;i++){
            result.addFrame(anim.getImage(i).getFlippedCopy(true, false), 100);
            result.getImage(i).draw(50*i, 150);
        }
        return result;
    }
}
