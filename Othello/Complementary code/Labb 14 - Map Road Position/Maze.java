package laboration14;
import javax.swing.*;

import java.awt.*;
import java.util.*;

import f14.*;

public class Maze {
    private Graph<String> graph = new Graph<String>();
    private Room[][] maze;
    private final int WIDTH = 30;

    public Maze(int cols, int rows) {
        cols = (cols <= 0) ? 1 : cols;
        rows = (rows <= 0) ? 1 : rows;
        maze = new Room[cols][rows];
        for (int col = 1; col <= cols; col++) {
            for (int row = 1; row <= rows; row++) {
                graph.addVertex(col + "," + row);
            }
        }
    }

    public void setRoom(int col, int row, int weight, boolean left, boolean up,
            boolean right, boolean down) {
        String name = col + "," + row;

        left = (col >= 2) ? left : false;
        up = (row >= 2) ? up : false;
        right = (col <= maze.length - 1) ? right : false;
        down = (row <= maze[0].length - 1) ? down : false;
        if (graph.containsVertex(name)) {
            if (left) {
                graph.addEdge((col - 1) + "," + row, name, weight);
            }
            if (up) {
                graph.addEdge(col + "," + (row - 1), name, weight);
            }
            if (right) {
                graph.addEdge((col + 1) + "," + row, name, weight);
            }
            if (down) {
                graph.addEdge(col + "," + (row + 1), name, weight);
            }
            maze[col - 1][row - 1] = new Room(weight, left, up, right, down);
        }
    }

    public ArrayList<Edge<String>> depthFirstSearch(String from, String to) {
        return GraphSearch.depthFirstSearch(graph, from, to);
    }

    public ArrayList<Edge<String>> breadthFirstSearch(String from, String to) {
        return GraphSearch.breadthFirstSearch(graph, from, to);
    }

    public ArrayList<Edge<String>> dijkstraSearch(String from, String to) {
        return GraphSearch.dijkstraSearch(graph, from, to);
    }

    public MazePanel getMaze() {
        return new MazePanel();
    }

    public MazePanel getMaze(ArrayList<Edge<String>> path) {
        return new MazePanel(path);
    }

    public void showMaze() {
        showMaze(null);
    }

    public Graph<String> getGraph() {
        return this.graph;
    }

    public void showMaze(ArrayList<Edge<String>> path) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MazePanel(path));
        frame.pack();
        frame.setVisible(true);
    }

    private class MazePanel extends JPanel {

        private MazeLabel[][] labels = new MazeLabel[maze.length][maze[0].length];

        public MazePanel() {
            this(null);
        }

        public MazePanel(ArrayList<Edge<String>> path) {
            int cols = maze.length;
            int rows = maze[0].length;
            setBackground(Color.white);
            setPreferredSize(new Dimension(20 + cols * Maze.this.WIDTH, 20
                    + rows * Maze.this.WIDTH));
            setLayout(new GridLayout(rows, cols));
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (maze[col][row] != null) {
                        labels[col][row] = new MazeLabel(
                                String.valueOf(maze[col][row].getWeight()),
                                maze[col][row].getLeft(),
                                maze[col][row].getUp(),
                                maze[col][row].getRight(),
                                maze[col][row].getDown());
                    } else {
                        labels[col][row] = new MazeLabel("", false, false,
                                false, false);
                    }

                    add(labels[col][row]);
                }

            }
            if (path != null && !path.isEmpty()) {
                mark(path.get(0).getFrom());
                for (Edge<String> edge : path) {
                    mark(edge.getTo());
                }

            }
        }

        private void mark(String name) {
            String[] colRow = name.toString().split(",");
            labels[Integer.parseInt(colRow[0]) - 1][Integer.parseInt(colRow[1]) - 1]
                    .setOpaque(true);
            labels[Integer.parseInt(colRow[0]) - 1][Integer.parseInt(colRow[1]) - 1]
                    .setBackground(Color.CYAN);
        }

        public Insets getInsets() {
            return new Insets(10, 10, 10, 10);
        }
    }

    private class MazeLabel extends JLabel {

        private boolean left, up, right, down;

        public MazeLabel(String weight, boolean left, boolean up,
                boolean right, boolean down) {
            this.left = left;
            this.up = up;
            this.right = right;
            this.down = down;
            if (left || up || right || down) {
                setText(weight);
                setHorizontalAlignment(JLabel.CENTER);
            } else {
                setOpaque(true);
                setBackground(Color.DARK_GRAY);
            }
        }

        public void paintComponent(Graphics g) {
            Color oldColor = g.getColor();
            g.setColor(Color.BLACK);
            super.paintComponent(g);
            if (!left) {
                g.drawLine(0, 0, 0, this.getHeight());
            }
            if (!up) {
                g.drawLine(0, 0, this.getWidth(), 0);
            }
            if (!right) {
                g.drawLine(this.getWidth() - 1, 0, this.getWidth() - 1,
                        this.getHeight());
            }
            if (!down) {
                g.drawLine(0, this.getHeight() - 1, this.getWidth(),
                        this.getHeight() - 1);
            }
            g.setColor(oldColor);
        }
    }
}
