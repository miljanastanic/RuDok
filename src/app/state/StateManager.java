package app.state;

import app.gui.controller.RotateAction;
import app.repository.Page;
import app.state.TransformStates.*;

import java.io.Serializable;

public class StateManager implements Serializable {

    private State currState;

    CircleState circleState;
    RectangleState rectangleState;
    TriangleState triangleState;
    SelectState selectState;
    MoveState moveState;
    RotateState rotateState;
    ResizeState resizeState;
    DeleteState deleteState;
    LassoState lassoState;

    public StateManager(Page med) {
        circleState = new CircleState(med);
        rectangleState = new RectangleState(med);
        triangleState = new TriangleState(med);
        selectState=new SelectState(med);
        moveState = new MoveState(med);
        rotateState= new RotateState(med);
        resizeState = new ResizeState(med);
        deleteState = new DeleteState(med);
        lassoState = new LassoState(med);
        currState = selectState;
    }

    public void setCircleState() {
       currState = circleState;
    }

    public void setRectangleState() {
        currState = rectangleState;
    }

    public void setTriangleState() {
        currState = triangleState;
    }

    public void setMoveState() {
        currState = moveState;
    }

    public void setResizeState() {
        currState = resizeState;
    }

    public void setRotateState() { currState = rotateState; }

    public void setSelectState(){ currState = selectState; }

    public void setDeleteState() { currState = deleteState; }

    public void setLassoState(){ currState = lassoState; }

    public CircleState getCircleState() {
        return circleState;
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public void setRectangleState(RectangleState rectangleState) {
        this.rectangleState = rectangleState;
    }

    public void setTriangleState(TriangleState triangleState) {
        this.triangleState = triangleState;
    }

    public RectangleState getRectangleState() {
        return rectangleState;
    }

    public SelectState getSelectState() {
        return selectState;
    }

    public TriangleState getTriangleState() {
        return triangleState;
    }

    public ResizeState getResizeState() {
        return resizeState;
    }

    public RotateState getRotateState() {
        return rotateState;
    }

    public State getCurrState() {
        return currState;
    }

    public DeleteState getDeleteState() { return deleteState; }

    public LassoState getLassoState() {
        return lassoState;
    }
}
