package in.tosc.urir;

import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor4B;

/**
 * Created by sauravtom on 16/7/14.
 */
public class GameLayer extends CCColorLayer {

    protected GameLayer(ccColor4B color)
    {
        super(color);
        
        CGSize winSize = CCDirector.sharedDirector().displaySize();
        CCSprite player = CCSprite.sprite("Player.png");

        player.setPosition(CGPoint.ccp(player.getContentSize().width / 2.0f, winSize.height / 2.0f));

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
}
