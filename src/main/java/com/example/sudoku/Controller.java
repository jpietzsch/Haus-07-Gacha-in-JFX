package com.example.sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Node;
import java.util.Arrays;

public class Controller {

    public GridPane getGridPane() {
        return gridPane;
    }


    @FXML
    private GridPane gridPane;


    private int[][] originalSudoku;

    @FXML
    public void initialize() {
        SudokuGenerator sudokuGenerator = new SudokuGenerator();
        originalSudoku = sudokuGenerator.generateSudoku();
        int[][] sudoku = copySudoku(originalSudoku);
        sudokuGenerator.removeElements(sudoku, 20);

        for (int i = 0; i < sudokuGenerator.getGridSize(); i++) {
            for (int j = 0; j < sudokuGenerator.getGridSize(); j++) {
                TextField textField = new TextField();
                textField.setText(sudoku[i][j] == 0 ? "" : String.valueOf(sudoku[i][j]));
                gridPane.add(textField, j, i);
                textField.setDisable(true);
                if (sudoku[i][j] ==0) {
                    textField.setDisable(false);
                }
            }
        }
    }

    private int[][] copySudoku(int[][] sudoku) {
        int[][] copy = new int[sudoku.length][];
        for (int i = 0; i < sudoku.length; i++) {
            copy[i] = Arrays.copyOf(sudoku[i], sudoku[i].length);
        }
        return copy;
    }

    @FXML
    private void handleSolveButtonAction() {
        for (Node node : gridPane.getChildren()) {
            if (node instanceof TextField) {
                TextField textField = (TextField) node;
                int row = GridPane.getRowIndex(node);
                int col = GridPane.getColumnIndex(node);
                int value = Integer.parseInt(textField.getText());

                if (value != originalSudoku[row][col]) {
                    System.out.println("Incorrect");
                    return;
                }
            }
        }
        System.out.println("Correct");
    }
}
