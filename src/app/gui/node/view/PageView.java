package app.gui.node.view;

import app.gui.node.view.graphics.painters.ElementPainter;
import app.gui.view.MainFrame;
import app.observer.ISubscriber;
import app.repository.Document;
import app.repository.Page;
import app.repository.Project;
import app.repository.element.SlotDevice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;


public class PageView extends JPanel implements ISubscriber {

    private Page page;
    private Document document;
    private Project project;
    private String name;
    private JLabel label = new JLabel();
    private static int handlesSize= 8;

    public PageView(Page page) {

        this.page = page;
        this.page.addSubscriber(this);

        name = page.getName();

        this.setPreferredSize(new Dimension(300, 400));
        this.setAlignmentX(1000000);

        label.setText(name);
        this.setBackground(Color.WHITE);
        this.add(label, BorderLayout.NORTH);


        DiagramController c = new DiagramController();
        this.addMouseListener(c);
        this.addMouseMotionListener(c);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));


        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Iterator<SlotDevice> it = page.getDeviceIterator();
        while(it.hasNext()){
            SlotDevice element = it.next();
            ElementPainter painter =  element.getPainter();
            painter.paint(g2, element, (double) 0);


            //Ili radi Lasso ili Open u zavisnosti od if-a ispod


          try {
              if (page.getStateManager().getCurrState().equals(page.getStateManager().getLassoState())) {
                  painter.paintLasso(g2, page.getStateManager().getLassoState().getStartingPoint(), page.getStateManager().getLassoState().getEndingPoint());
              }
          }catch (NullPointerException e){

          }
        }
    }


   /* public void paintSelectionHandles(Graphics2D g2) {

       SlotDevice selectedSlot = page.getSelectedSlot();

            if (selectedSlot instanceof SlotDevice){
                SlotDevice device= selectedSlot;

                g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE,
                        BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
                g2.setPaint(Color.BLACK);

                g2.drawRect((int)device.getPosition().getX(), (int)device.getPosition().getY(),
                        (int)device.getSize().getWidth(), (int)device.getSize().getHeight());

                for(Handles e: Handles.values()){
                    paintSelectionHandle(g2, getHandlePoint(selectedSlot.getPosition(), selectedSlot.getSize(), e));
                }


            }

    }

    private void paintSelectionHandle(Graphics2D g2, Point2D position){
        double size = handlesSize;
        g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2,
                size, size));
    }


    private Point2D getHandlePoint(Point2D topLeft, Dimension size, Handles handlePosition ) {
        double x = 0, y = 0;

        if (handlePosition == Handles.NorthWest || handlePosition == Handles.North || handlePosition == Handles.NorthEast) {
            y = topLeft.getY();
        }

        if (handlePosition == Handles.East || handlePosition == Handles.West) {
            y = topLeft.getY() + size.getHeight() / 2;
        }

        if (handlePosition == Handles.SouthWest || handlePosition == Handles.South || handlePosition == Handles.SouthEast) {
            y = topLeft.getY() + size.getHeight();
        }

        if (handlePosition == Handles.NorthWest || handlePosition == Handles.West || handlePosition == Handles.SouthWest) {
            x = topLeft.getX();
        }

        if (handlePosition == Handles.North || handlePosition == Handles.South) {
            x = topLeft.getX() + size.getWidth() / 2;
        }

        if (handlePosition == Handles.NorthEast || handlePosition == Handles.East || handlePosition == Handles.SouthEast) {
            x = topLeft.getX() + size.getWidth();
        }
            return new Point2D.Double(x, y);

        }



        public void setMouseCursor (Point2D point){
            Handles handle = getDeviceAndHandleForPoint(point);

            if (handle != null) {
                Cursor cursor = null;

                switch (handle) {
                    case North:
                        cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
                        break;
                    case South:
                        cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
                        break;
                    case East:
                        cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
                        break;
                    case West:
                        cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
                        break;
                    case SouthEast:
                        cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
                        break;
                    case NorthWest:
                        cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
                        break;
                    case SouthWest:
                        cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
                        break;
                    case NorthEast:
                        cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
                        break;
                }

                this.setCursor(cursor);

            } else

                this.setCursor(Cursor.getDefaultCursor());
        }


    public Handles getDeviceAndHandleForPoint(Point2D point){
        SlotDevice element;

        element = page.getSelectedSlot();
            return getHandleForPoint(element, point);

    }

    private Handles getHandleForPoint(SlotDevice element, Point2D point){
        for(Handles h: Handles.values()){
            if(isPointInHandle(element, point, h)){
                return h;
            }
        }
        return null;
    }

    private boolean isPointInHandle(SlotDevice element, Point2D point, Handles handle){
        if (element instanceof SlotDevice){
            SlotDevice device= element;
            Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
            return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handlesSize/2) &&
                    (Math.abs(point.getY()-handleCenter.getY())<=(double)handlesSize/2) );
        }else
            return false;
    }

    */

    public void setPage(Page page) {
        this.page = page;
        this.setName(page.getName());
        //this.page.addSubscriber(this);
    }

    public Page getPage() {
        return page;
    }

    private class DiagramController extends MouseAdapter implements MouseMotionListener {

        public void mousePressed(MouseEvent e) { page.getStateManager().getCurrState().mousePressed(e);
        }

        public void mouseReleased(MouseEvent e) { page.getStateManager().getCurrState().mouseReleased(e);
        }

        public void mouseDragged(MouseEvent e ){ page.getStateManager().getCurrState().mouseDragged(e);

        }

    }


    @Override
    public void update(Object notification) {

        if (notification instanceof Page){
            Page newPage = (Page) notification;
            label.setText( newPage.getName());
            return;
        }
        if (notification instanceof SlotDevice){

            ((Project)(getPage().getParent().getParent())).setChanged(true);

            repaint();
        }else{
            repaint();
        }

       Project project = (Project) getPage().getParent().getParent();
       project.setChanged(true);

    }
}
/*
    private class Framework extends JPanel{
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));


            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Iterator<SlotDevice> it = page.getDeviceIterator();
            while(it.hasNext()){
                SlotDevice element = it.next();
                ElementPainter painter =  element.getPainter();
                painter.paint(g2, element);

            }
        }

    }
*/


