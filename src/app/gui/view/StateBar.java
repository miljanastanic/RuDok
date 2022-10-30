package app.gui.view;

import javax.swing.*;
import java.awt.*;

public class StateBar extends JToolBar {

    public StateBar() {
        super(JToolBar.VERTICAL);

        setFloatable(true);
        setBackground(Color.WHITE);

        add(MainFrame.getInstance().getActionManager().getSelectAction());
        add(MainFrame.getInstance().getActionManager().getLassoAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRectangleAction());
        add(MainFrame.getInstance().getActionManager().getTriangleAction());
        add(MainFrame.getInstance().getActionManager().getCircleAction());
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getRotateAction());
        add(MainFrame.getInstance().getActionManager().getResizeAction());
        add(MainFrame.getInstance().getActionManager().getMoveShapeAction());
        add(MainFrame.getInstance().getActionManager().getDeleteShapeAction());

    }
}
