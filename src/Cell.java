import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Cell {
    private int id;
    private JLabel label;
    TicTacToeView parent;
    Border raisedbevel, loweredbevel;


    public Cell(TicTacToeView parent, int id){
        this.parent = parent;
        this.id = id;
        label = new JLabel();
        label.setPreferredSize(new Dimension(50, 50));

        //Compound borders
        Border compound;
        raisedbevel = BorderFactory.createRaisedBevelBorder();
        loweredbevel = BorderFactory.createLoweredBevelBorder();

        //This creates a nice frame.
        compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);

        Border RO = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.RED),
                BorderFactory.createLineBorder(Color.ORANGE));
        Border YG = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.YELLOW),
                BorderFactory.createLineBorder(Color.GREEN));
        Border firstCompound = BorderFactory.createCompoundBorder(RO, YG);
        label.setBorder(BorderFactory.createCompoundBorder(firstCompound,
                BorderFactory.createLineBorder(Color.BLUE)));
        //Add a red outline to the frame.
        /*Border blueline = BorderFactory.createLineBorder(Color.red);

        compound = BorderFactory.createCompoundBorder(
                blueline, compound);

        label.setBorder(compound);*/

        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
               parent.cellClicked(id);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });
    }
    public int getId() {
        return id;
    }

    public JLabel getLabel() {
        return label;
    }
}
