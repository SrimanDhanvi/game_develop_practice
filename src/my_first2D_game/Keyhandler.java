package my_first2D_game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyhandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, HitPressed;
	boolean F3 = false;
	
	GamePanel gp;
	
	public Keyhandler(GamePanel gp) {
		this.gp = gp;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
        switch(code) {
        case KeyEvent.VK_W : 
        	upPressed = true;
        	break;
        case KeyEvent.VK_S :
        	downPressed = true;
        	break;
        case KeyEvent.VK_A :
        	leftPressed = true;
        	break;
        case KeyEvent.VK_D :
        	rightPressed = true;
        	break;
        case KeyEvent.VK_UP : 
        	upPressed = true;
        	break;
        case KeyEvent.VK_DOWN :
        	downPressed = true;
        	break;
        case KeyEvent.VK_LEFT :
        	leftPressed = true;
        	break;
        case KeyEvent.VK_RIGHT :
        	rightPressed = true;
        	break;	
        case KeyEvent.VK_SPACE :
        	HitPressed = true;
        	break;
        case KeyEvent.VK_ENTER :
        	gp.ui.dno++;
        	break;
        	
        case KeyEvent.VK_ESCAPE :
        { if (gp.GameState == gp.playState) {
        	gp.GameState = gp.pauseState;
        } else if (gp.GameState == gp.pauseState){
        	gp.GameState = gp.playState;
        }
        }
        break;
        
        	//DEBUG
        case KeyEvent.VK_F3 :
        {
        	if (F3 == false) {
        	F3 = true;
        	} else if (F3 == true) {
        		F3 = false;
        	}
        }
        break;
        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();

        switch(code) {
        case KeyEvent.VK_W : 
        	upPressed = false;
        	break;
        case KeyEvent.VK_S :
        	downPressed = false;
        	break;
        case KeyEvent.VK_A :
        	leftPressed = false;
        	break;
        case KeyEvent.VK_D :
        	rightPressed = false;
        	break;
        case KeyEvent.VK_UP : 
        	upPressed = false;
        	break;
        case KeyEvent.VK_DOWN :
        	downPressed = false;
        	break;
        case KeyEvent.VK_LEFT :
        	leftPressed = false;
        	break;
        case KeyEvent.VK_RIGHT :
        	rightPressed = false;
        	break;	
        case KeyEvent.VK_SPACE  :
        	HitPressed = false;
        break;
        }
		
	}
	
	

}
