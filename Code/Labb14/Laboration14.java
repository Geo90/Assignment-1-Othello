package laboration14;
import java.util.*;

import javax.swing.*;

import java.awt.*;

import f14.*;

public class Laboration14 {
    public static Maze maze1() {
        Maze maze = new Maze(4, 4);
        maze.setRoom(1, 1, 1, false, false, true, true);
        maze.setRoom(2, 1, 1, true, false, true, false);
        maze.setRoom(3, 1, 1, true, false, true, true);
        maze.setRoom(4, 1, 1, true, false, false, true);
        maze.setRoom(1, 2, 1, false, true, false, false);
        maze.setRoom(2, 2, 1, false, false, true, true);
        maze.setRoom(3, 2, 1, true, true, false, true);
        maze.setRoom(4, 2, 1, false, true, false, true);
        maze.setRoom(1, 3, 1, false, false, true, false);
        maze.setRoom(2, 3, 1, true, true, false, false);
        maze.setRoom(3, 3, 1, false, true, false, true);
        maze.setRoom(4, 3, 1, false, true, false, true);
        maze.setRoom(1, 4, 1, false, false, true, false);
        maze.setRoom(2, 4, 1, true, false, true, false);
        maze.setRoom(3, 4, 1, true, true, false, false);
        maze.setRoom(4, 4, 1, false, true, false, false);
        return maze;
    }

    public static Maze maze2() {
        Maze maze = new Maze(6, 4);
        Random rand = new Random();
        maze.setRoom(1, 1, rand.nextInt(20), false, false, true, true);
        maze.setRoom(2, 1, rand.nextInt(20), true, false, true, true);
        maze.setRoom(3, 1, rand.nextInt(20), true, false, true, true);
        maze.setRoom(4, 1, rand.nextInt(20), true, false, true, false);
        maze.setRoom(5, 1, rand.nextInt(20), true, true, true, true);
        maze.setRoom(6, 1, rand.nextInt(20), true, true, false, true);
        maze.setRoom(1, 2, rand.nextInt(20), false, true, true, true);
        maze.setRoom(2, 2, rand.nextInt(20), true, true, true, true);
        maze.setRoom(3, 2, rand.nextInt(20), false, false, false, false);
        maze.setRoom(4, 2, rand.nextInt(20), false, false, true, false);
        maze.setRoom(5, 2, rand.nextInt(20), true, true, true, true);
        maze.setRoom(6, 2, rand.nextInt(20), true, true, false, true);
        maze.setRoom(1, 3, rand.nextInt(20), false, false, false, false);
        maze.setRoom(2, 3, rand.nextInt(20), true, true, true, true);
        maze.setRoom(3, 3, rand.nextInt(20), true, true, true, true);
        maze.setRoom(4, 3, rand.nextInt(20), true, false, true, false);
        maze.setRoom(5, 3, rand.nextInt(20), true, true, true, true);
        maze.setRoom(6, 3, rand.nextInt(20), true, true, false, true);
        maze.setRoom(1, 4, rand.nextInt(20), false, true, true, false);
        maze.setRoom(2, 4, rand.nextInt(20), true, true, true, false);
        maze.setRoom(3, 4, rand.nextInt(20), true, true, false, false);
        maze.setRoom(4, 4, rand.nextInt(20), false, false, true, false);
        maze.setRoom(5, 4, rand.nextInt(20), true, true, true, true);
        maze.setRoom(6, 4, rand.nextInt(20), true, true, false, true);
        return maze;
    }

    public static Maze maze3(int cols, int rows, boolean shuffle) {
        cols = (cols < 1) ? 1 : cols;
        rows = (rows < 1) ? 1 : rows;
        Maze maze = new Maze(cols, rows);
        Random rand = new Random();
        for (int col = 1; col <= cols; col++)
            for (int row = 1; row <= rows; row++) {
                maze.setRoom(col, row, rand.nextInt(20), true, true, true, true);
            }
        if (shuffle)
            maze.getGraph().shuffleEdges();
        return maze;
    }

    public static void compareSearch(Maze maze, String from, String to) {
        ArrayList<Edge<String>> res1 = maze.depthFirstSearch(from, to);
        ArrayList<Edge<String>> res2 = maze.breadthFirstSearch(from, to);
        ArrayList<Edge<String>> res3 = maze.dijkstraSearch(from, to);
        JFrame frame = new JFrame("Serach: " + from + " -> " + to);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel(new GridLayout(1, 3));
        JPanel southPanel = new JPanel(new GridLayout(1, 3));
        JTextArea text = new JTextArea();
        text.setWrapStyleWord(true);
        text.setLineWrap(true);
        text.append("Depth first search:\n" + from);
        for (Edge<String> edge : res1)
            text.append("--> " + edge.getTo());
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setPreferredSize(new Dimension(100, 150));
        northPanel.add(new JLabel("Depth first", JLabel.CENTER));
        northPanel.add(new JLabel("Breadth first", JLabel.CENTER));
        northPanel.add(new JLabel("Dijkstra", JLabel.CENTER));
        southPanel.add(maze.getMaze(res1));
        southPanel.add(maze.getMaze(res2));
        southPanel.add(maze.getMaze(res3));
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Maze maze = Laboration14.maze1();
        Laboration14.compareSearch(maze, "1,1", "2,4");
//        Maze maze = Laboration14.maze2();
//        Laboration14.compareSearch(maze, "1,1", "6,4");
//        Maze maze = Laboration14.maze3(10,10,true);
//        Laboration14.compareSearch(maze, "1,1", "10,10");
    }

}
