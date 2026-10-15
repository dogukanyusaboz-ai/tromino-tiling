import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TrominoFrame extends JFrame {
    private TrominoTiling solver;
    private Map<Integer, Color> colorMap = new HashMap<>();

    public TrominoFrame(int k, int missingRow, int missingCol) {
        this.solver = new TrominoTiling(k, missingRow, missingCol);
        
        setTitle("L-Shape Tromino Tiling Visualizer (" + solver.getSize() + "x" + solver.getSize() + ")");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        BoardPanel boardPanel = new BoardPanel();
        boardPanel.setPreferredSize(new Dimension(640, 640));
        add(boardPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class BoardPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int[][] board = solver.getBoard();
            int n = solver.getSize();
            int cellSize = Math.min(getWidth(), getHeight()) / n;

            Random rand = new Random(42);

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    int val = board[r][c];

                    if (val == -1) {
                        g.setColor(Color.BLACK);
                    } else {
                        if (!colorMap.containsKey(val)) {
                            colorMap.put(val, new Color(
                                60 + rand.nextInt(180),
                                60 + rand.nextInt(180),
                                60 + rand.nextInt(180)
                            ));
                        }
                        g.setColor(colorMap.get(val));
                    }

                    g.fillRect(c * cellSize, r * cellSize, cellSize, cellSize);
                    g.setColor(Color.DARK_GRAY);
                    g.drawRect(c * cellSize, r * cellSize, cellSize, cellSize);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 2^3 = 8x8 boyutunda tahta, eksik kare (2, 4)
        SwingUtilities.invokeLater(() -> new TrominoFrame(3, 2, 4));
    }
}