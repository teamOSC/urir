package in.tosc.urir;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.Toast;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CCPointSize;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor4B;

/**
 * Created by sauravtom on 16/7/14.
 */
public class GameLayer extends CCColorLayer {
    private CCPointSize p;
    private CCSprite player;
    public Context context;
    public CGSize winSize;

    protected GameLayer(ccColor4B color)
    {
        super(color);
        this.setIsTouchEnabled(true);
        this.context = context;

        winSize = CCDirector.sharedDirector().displaySize();
        player = CCSprite.sprite("b1.png");
        player.setScaleX(0.6f);
        player.setScaleY(0.6f);

        player.setPosition(CGPoint.ccp(winSize.width / 2.0f, winSize.height / 2.0f));

        addChild(player);
    }

    public static CCScene scene()
    {
        CCScene scene = CCScene.node();
        //CCLayer layer = new GameLayer();
        CCColorLayer layer = new GameLayer(ccColor4B.ccc4(255, 255, 255, 255));
        scene.addChild(layer);

        return scene;
    }

    public boolean ccTouchesBegan(MotionEvent e)
    {
        Log.d("touch_event",e.getX()+"");
        CGPoint player_coord = player.getPosition();

        if (e.getX() > winSize.width/2){
            player_coord.x += 10;
            player.setPosition(player_coord);
        }
        else{
            player_coord.x -=10;
            player.setPosition(player_coord);
        }

        return true;
    }
}
