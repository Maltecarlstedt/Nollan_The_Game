package Tasks.taskController;


import Tasks.taskModel.BuildBridgeModel;
import Tasks.taskView.BuildBridgeView;
import org.newdawn.slick.GameContainer;

public class BuildBridgeController {

    private BuildBridgeView bbv;
    private BuildBridgeModel bbm;

    public BuildBridgeController(BuildBridgeModel bbm, BuildBridgeView bbv){
        this.bbm = bbm;
        this.bbv = bbv;
    }

    public void update(GameContainer gc, int delta){

    }
}
