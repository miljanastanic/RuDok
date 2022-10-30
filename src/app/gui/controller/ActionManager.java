package app.gui.controller;

public class ActionManager{

    private ExitButton exitButton;
    private AboutButton aboutButton;
    private AddButton addButton;
    private DeleteButton deleteButton;
    private NewTabButton newTabButton;
    private DoubleClickListener doubleClickListener;
    private ShareButton shareButton;
    private CircleAction circleAction;
    private RectangleAction rectangleAction;
    private TriangleAction triangleAction;
    private MoveShapeAction moveShapeAction;
    private SelectAction selectAction;
    private ResizeAction resizeAction;
    private RotateAction rotateAction;
    private DeleteShapeAction deleteShapeAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private OpenAction openAction;
    private LassoAction lassoAction;
    private DetailsButton detailsButton;
    private RedoAction redoAction;
    private UndoAction undoAction;
    private TextButtonListener textButtonListener;
    private ImageButtonListener imageButtonListener;
    private SwitchWorkspaceAction switchWorkspaceAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitButton= new ExitButton();
        aboutButton = new AboutButton();
        addButton = new AddButton();
        deleteButton = new DeleteButton();
        newTabButton = new NewTabButton();
        doubleClickListener = new DoubleClickListener();
        shareButton = new ShareButton();
        circleAction = new CircleAction();
        rectangleAction = new RectangleAction();
        triangleAction = new TriangleAction();
        moveShapeAction = new MoveShapeAction();
        selectAction = new SelectAction();
        resizeAction = new ResizeAction();
        rotateAction = new RotateAction();
        saveAction = new SaveAction();
        deleteShapeAction = new DeleteShapeAction();
        saveAsAction = new SaveAsAction();
        openAction = new OpenAction();
        lassoAction = new LassoAction();
        detailsButton = new DetailsButton();
        redoAction = new RedoAction();
        undoAction = new UndoAction();
        textButtonListener = new TextButtonListener();
        imageButtonListener = new ImageButtonListener();
        switchWorkspaceAction = new SwitchWorkspaceAction();
    }

    public TextButtonListener getTextButtonListener() {
        return textButtonListener;
    }

    public ImageButtonListener getImageButtonListener() {
        return imageButtonListener;
    }

    public SwitchWorkspaceAction getSwitchWorkspaceAction() {
        return switchWorkspaceAction;
    }

    public DoubleClickListener getDoubleClickListener() {
        return doubleClickListener;
    }

    public DeleteShapeAction getDeleteShapeAction() {
        return deleteShapeAction;
    }

    public DetailsButton getImagesAndTextButton() {
        return detailsButton;
    }

    public OpenAction getOpenAction() {
        return openAction;
    }

    public RotateAction getRotateAction() {
        return rotateAction;
    }

    public ResizeAction getResizeAction() {
        return resizeAction;
    }

    public SelectAction getSelectAction() {
        return selectAction;
    }

    public MoveShapeAction getMoveShapeAction() {
        return moveShapeAction;
    }

    public NewTabButton getNewTabButton(){ return newTabButton; }

    public void setNewTabButton(NewTabButton newTabButton){ this.newTabButton = newTabButton; }

    public ExitButton getExitButton() {
        return exitButton;
    }


    public AboutButton getAboutButton() {
        return aboutButton;
    }

    public AddButton getAddButton() { return addButton; }

    public DeleteButton getDeleteButton() { return deleteButton; }

    public ShareButton getShareButton() {
        return shareButton;
    }

    public CircleAction getCircleAction() {
        return circleAction;
    }

    public RectangleAction getRectangleAction() {
        return rectangleAction;
    }

    public TriangleAction getTriangleAction() {
        return triangleAction;
    }

    public void setTriangleAction(TriangleAction triangleAction) {
        this.triangleAction = triangleAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(SaveAction saveAction) {
        this.saveAction = saveAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public LassoAction getLassoAction() { return lassoAction; }
}
